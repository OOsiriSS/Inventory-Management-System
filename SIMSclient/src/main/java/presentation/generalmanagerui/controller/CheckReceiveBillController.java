package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BussinessHistoryScheduleReceiveBL;
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
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;

public class CheckReceiveBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<ReceiptBillVO> service = new BussinessHistoryScheduleReceiveBL();
	ObservableList<ReceiptBillVO> list = FXCollections.observableArrayList();
	ObservableList<AccountListVO> accountVOList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TableView<ReceiptBillVO> table;
	@FXML
	TableColumn<ReceiptBillVO, String> tableID;
	@FXML
	TableColumn<ReceiptBillVO, String> tableMember;
	@FXML
	TableColumn<ReceiptBillVO, Double> tableSum;
	@FXML
	TableColumn<ReceiptBillVO, String> tableOperator;
	@FXML
	TableColumn<ReceiptBillVO, String> tableRemark;
	@FXML
	TableColumn<ReceiptBillVO, String> tableCheck;

	@FXML
	TableView<AccountListVO> accountList;
	@FXML
	TableColumn<AccountListVO, String> tableAccount;
	@FXML
	TableColumn<AccountListVO, Double> tableMoney;
	@FXML
	TableColumn<AccountListVO, String> tableDescription;

	@FXML
	public void printout() {
		ArrayList<ReceiptBillVO> result = new ArrayList<>();
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
			ArrayList<ReceiptBillVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
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
			ArrayList<ReceiptBillVO> receiptList = service.sift(findingField.getText(),
					FindSaleScheduleType.getType(findChoice.getValue()));
			if (receiptList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(receiptList);
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
		initFind();
		initTime();
		manageInit();
		checkInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.MEMBER.value,
				FindSaleScheduleType.OPERATOR.value));
	}

	public void manageInit() throws RemoteException {
		tableID.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("id"));
		tableMember.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("customer"));
		tableSum.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, Double>("total"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("userID"));
		tableRemark.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("note"));
	}

	public void checkInit() {

		tableCheck.setCellFactory((col) -> {
			TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看转账列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							accountVOList.clear();
							accountVOList.addAll(clickedItem.getAccountListVOs());
							accountList.setItems(accountVOList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void listInit() {
		tableAccount.setCellValueFactory(new PropertyValueFactory<AccountListVO, String>("accountID"));
		tableMoney.setCellValueFactory(new PropertyValueFactory<AccountListVO, Double>("money"));
		tableDescription.setCellValueFactory(new PropertyValueFactory<AccountListVO, String>("note"));
	}

}
