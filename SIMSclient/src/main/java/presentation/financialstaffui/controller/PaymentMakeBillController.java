package presentation.financialstaffui.controller;

import java.util.ArrayList;

import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class PaymentMakeBillController extends MakeReceiptController {

	PaymentBillBLService service = new PaymentBillController();
	ObservableList<EntryVO> list = FXCollections.observableArrayList();

	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> accountChoice;
	@FXML
	ComboBox<String> memberChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;
	@FXML
	TextArea noteArea;

	@FXML
	TableView<EntryVO> table;
	@FXML
	TableColumn<EntryVO, String> tableItem;
	@FXML
	TableColumn<EntryVO, Double> tableMoney;
	@FXML
	TableColumn<EntryVO, String> tableDescription;
	@FXML
	TableColumn<EntryVO, String> tableDelete;

	@FXML
	TextField itemField;
	@FXML
	TextField moneyField;
	@FXML
	TextArea receiptArea;

	@FXML
	public void insert() {
		if (itemField.getText() == null || moneyField.getText() == null || receiptArea.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有的信息");
			warning.showAndWait();
		} else {
			EntryVO vo = new EntryVO(itemField.getText(), Double.parseDouble(moneyField.getText()), noteArea.getText());
			ResultMessage message = service.judgeLegal(moneyField.getText());
			Platform.runLater(new Runnable() {
				public void run() {
					try {
						switch (message) {
						case SUCCESS:
							list.add(vo);
							table.setItems(list);
							double result = Double.parseDouble(sumLabel.getText())
									+ Double.parseDouble(moneyField.getText());
							sumLabel.setText(String.valueOf(result));
							initInsert();
							break;
						default:
							Alert error = new Alert(Alert.AlertType.ERROR, message.value);
							error.showAndWait();
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@FXML
	public void save() {
		ArrayList<EntryVO> entryList = new ArrayList<>();
		entryList.addAll(list);
		PaymentBillVO vo = new PaymentBillVO(idLabel.getText(), operatorLabel.getText(), memberChoice.getValue(),
				accountChoice.getValue(), entryList, Double.parseDouble(sumLabel.getText()), BillType.XJFYD,
				BillState.DRAFT, noteArea.getText());
		ResultMessage message = service.save(vo);
		if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
			printInfo(ResultMessage.SAVED);
			try {
				fresh();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			printWrong(message);
	}

	@FXML
	public void submit() {
		ArrayList<EntryVO> entryList = new ArrayList<>();
		entryList.addAll(list);
		PaymentBillVO vo = new PaymentBillVO(idLabel.getText(), operatorLabel.getText(), memberChoice.getValue(),
				accountChoice.getValue(), entryList, Double.parseDouble(sumLabel.getText()), BillType.XJFYD,
				BillState.COMMITED, noteArea.getText());
		ResultMessage message = service.commit(vo);
		if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
			printInfo(ResultMessage.COMMITED);
			try {
				fresh();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			printWrong(message);
	}

	public void initInsert() {
		itemField.setText(null);
		moneyField.setText(null);
		receiptArea.setText(null);
	}

	@FXML
	public void checkBefore() throws Exception {
		changeStage("PaymentCheckBillUI", user, null, null);
	}

	public void initData(UserVO user, PaymentBillVO bill) throws Exception {
		this.user = user;
		this.pay = bill;
		judgeMessage();
		if (bill == null) {
			idLabel.setText(service.getId());
			sumLabel.setText("0");
			operatorLabel.setText(readUser().getName());
		} else {
			idLabel.setText(bill.getId());
			sumLabel.setText(String.valueOf(bill.getTotal()));
			list.addAll(bill.getEntryListVO());
			table.setItems(list);
			operatorLabel.setText(bill.getUserID());
			noteArea.setText(bill.getNote());
		}
		choiceInit();
		if (pay != null) {
			accountChoice.setValue(pay.getAccountID());
			noteArea.setText(pay.getNote());
		}
		initInsert();
		edit();
		manageInit();
		deleteInit();
	}

	public void choiceInit() {
		accountChoice.setItems(FXCollections.observableArrayList(service.getAccountList()));
		memberChoice.setItems(FXCollections.observableArrayList(service.getCustomerList()));
		if (pay != null) {
			accountChoice.setValue(pay.getAccountID());
			memberChoice.setValue(pay.getCustomerID());
		}
	}

	/**
	 * 可编辑初始化
	 */

	public void edit() {
		Callback<TableColumn<EntryVO, String>, TableCell<EntryVO, String>> cellFactory = (
				TableColumn<EntryVO, String> p) -> new EditingCell<EntryVO>();

		tableItem.setCellFactory(cellFactory);
		tableItem.setOnEditCommit((CellEditEvent<EntryVO, String> t) -> {
			((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEntryName(t.getNewValue());
		});

		tableDescription.setCellFactory(cellFactory);
		tableDescription.setOnEditCommit((CellEditEvent<EntryVO, String> t) -> {
			((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
		});
	}

	public void manageInit() {
		tableItem.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("entryName"));
		tableMoney.setCellValueFactory(new PropertyValueFactory<EntryVO, Double>("transferAmount"));
		tableDescription.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("note"));
	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<EntryVO, String> cell = new TableCell<EntryVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							EntryVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							list.remove(clickedItem);
							table.setItems(list);
							double tmp = clickedItem.getTransferAmount();
							double result = Double.parseDouble(sumLabel.getText()) - tmp;
							sumLabel.setText(String.valueOf(result));
						});
					}
				}

			};
			return cell;
		});
	}

}
