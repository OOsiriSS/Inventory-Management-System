package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BusinessHistorySchedulePaymentBL;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class CheckPaymentBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<PaymentBillVO> service = new BusinessHistorySchedulePaymentBL();
	ObservableList<PaymentBillVO> list = FXCollections.observableArrayList();
	ObservableList<EntryVO> entryList = FXCollections.observableArrayList();
	PaymentBillVO bill;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

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
	TableView<EntryVO> itemList;
	@FXML
	TableColumn<EntryVO, String> tableItem;
	@FXML
	TableColumn<EntryVO, Double> tableMoney;
	@FXML
	TableColumn<EntryVO, String> tableNote;

	@FXML
	public void printout() {
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
		Alert info = new Alert(Alert.AlertType.INFORMATION, "已导出");
		info.showAndWait();
	}

	@FXML
	public void siftTime() {
		if (startPicker.getValue() == null || endPicker.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请输入时间");
			warning.showAndWait();
		} else {
			list.clear();
			ArrayList<PaymentBillVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
			list.addAll(siftList);
			table.setItems(list);
			initTime();
		}
	}

	@FXML
	public void find() {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PaymentBillVO> paymentList = service.sift(findingField.getText(),
					FindSaleScheduleType.getType(findChoice.getValue()));
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

	public void initTime() {
		startPicker.setValue(null);
		endPicker.setValue(null);
	}

	public void initFind() {
		findChoice.setValue(null);
		findingField.setText(null);
	}

	public void initData(UserVO user) throws RemoteException {
		this.user = user;
		judgeMessage();
		list.addAll(service.show());
		table.setItems(list);
		initTime();
		initFind();
		manageInit();
		listInit();
		checkInit();
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.OPERATOR.value));
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("id"));
		tableAccount.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("accountID"));
		tableSum.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, Double>("total"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("userID"));
		tableRemark.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, String>("note"));
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

	public void listInit() {
		tableItem.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("entryName"));
		tableMoney.setCellValueFactory(new PropertyValueFactory<EntryVO, Double>("transferAmount"));
		tableNote.setCellValueFactory(new PropertyValueFactory<EntryVO, String>("note"));
	}

}
