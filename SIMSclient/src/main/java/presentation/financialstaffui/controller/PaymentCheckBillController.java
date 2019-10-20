package presentation.financialstaffui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class PaymentCheckBillController extends FinancialStaffController {

	PaymentBillBLService service = new PaymentBillController();
	ObservableList<PaymentBillVO> list = FXCollections.observableArrayList();
	ObservableList<EntryVO> entryList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<PaymentBillVO> table;
	@FXML
	TableColumn<PaymentBillVO, String> tableID;
	@FXML
	TableColumn<PaymentBillVO, String> tableAccount;
	@FXML
	TableColumn<PaymentBillVO, Double> tableSum;
	@FXML
	TableColumn<PaymentBillVO, String> tableOperator;
	@FXML
	TableColumn<PaymentBillVO, String> tableRemark;
	@FXML
	TableColumn<PaymentBillVO, String> tableCheck;
	@FXML
	TableColumn<PaymentBillVO, String> tableState;
	@FXML
	TableColumn<PaymentBillVO, String> tableSubmit;
	@FXML
	TableColumn<PaymentBillVO, String> tableRedo;
	@FXML
	TableColumn<PaymentBillVO, String> tableDelete;

	@FXML
	TableView<EntryVO> itemList;
	@FXML
	TableColumn<EntryVO, String> tableItem;
	@FXML
	TableColumn<EntryVO, Double> tableMoney;
	@FXML
	TableColumn<EntryVO, String> tableNote;

	@FXML
	public void makePaymentBill() throws Exception {
		changeStage("PaymentMakeBillUI", user, null, null);
	}

	@FXML
	public void find() {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PaymentBillVO> paymentList = service.find(findingField.getText(),
					FindAccountBillType.getType(findChoice.getValue()));
			if (paymentList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(paymentList);
				table.setItems(list);
				initFind();
			}
		}
	}

	public void initFind() {
		findChoice.setValue(null);
		findingField.setText(null);
	}

	public void initData(UserVO user) {
		this.user = user;
		judgeMessage();
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		checkInit();
		submitInit();
		redoInit();
		deleteInit();
		listInit();
		initFind();
		findChoice.setItems(FXCollections.observableArrayList(FindAccountBillType.BILLID.value,
				FindAccountBillType.CUSTOMER.value, FindAccountBillType.OPERATOR.value));

	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("id"));
		tableAccount.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("accountID"));
		tableSum.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, Double>("total"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("userID"));
		tableRemark.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("note"));
		tableState.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("stateString"));
	}

	public void checkInit() {

		tableCheck.setCellFactory((col) -> {
			TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看条目清单");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							entryList.clear();
							entryList.addAll(clickedItem.getEntryListVO());
							itemList.setItems(entryList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void submitInit() {

		tableSubmit.setCellFactory((col) -> {
			TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT) {
						Button delBtn = new Button("提交"); // 只有草稿状态单据才能提交
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							clickedItem.setState(BillState.COMMITED);
							ResultMessage message = service.commit(clickedItem);
							if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
								this.getTableView().getItems().get(this.getIndex()).setState(BillState.COMMITED);
								submitInit();
								deleteInit();
								redoInit();
							} else
								printWrong(message);
						});
					}
				}
			};
			return cell;
		});

	}

	public void redoInit() {

		tableRedo.setCellFactory((col) -> {
			TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL)) {
						Button delBtn = new Button("重做"); // 只有审批失败或者草稿状态单据才能重做
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							try {
								changeStage("PaymentMakeBillUI", user, clickedItem, null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
					}
				}
			};
			return cell;
		});

	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL)) {
						Button delBtn = new Button("删除"); // 只有审批失败和草稿状态单据才能重做
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							try {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setContentText("确认删除？");
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									service.delete(clickedItem);
									list.remove(clickedItem);
									table.setItems(list);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						});
					}
				}
			};
			return cell;
		});
	}

	public void listInit() {
		tableItem.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("entryName"));
		tableMoney.setCellValueFactory(new PropertyValueFactory<EntryVO, Double>("transferAmount"));
		tableNote.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("note"));
	}

}
