package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BussinessHistoryScheduleReceiveBL;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellDouble;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;

public class CheckReceiveBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<ReceiptBillVO> service = new BussinessHistoryScheduleReceiveBL();
	ObservableList<ReceiptBillVO> list = FXCollections.observableArrayList();
	ObservableList<AccountListVO> accountVOList = FXCollections.observableArrayList();
	ReceiptBillVO bill;
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
	TableColumn<ReceiptBillVO, CheckBox> tableRed;

	@FXML
	TableView<AccountListVO> accountList;
	@FXML
	TableColumn<AccountListVO, String> tableAccount;
	@FXML
	TableColumn<AccountListVO, Double> tableMoney;
	@FXML
	TableColumn<AccountListVO, String> tableDescription;

	@FXML
	public void red() {
		ArrayList<ReceiptBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<ReceiptBillVO> receiptList = service.writeOff(result);
		if (receiptList != null) {
			list.addAll(receiptList);
			table.setItems(list);
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "已红冲");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "红冲失败");
			alert.showAndWait();
		}
	}

	@FXML
	public void redCopy() {
		ArrayList<ReceiptBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<ReceiptBillVO> copy = service.writeOffAndCopy(result);
		if (copy != null) {
			list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
			accountList.setEditable(true);
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "已红冲，请编辑单据信息");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "红冲失败");
			alert.showAndWait();
		}
	}

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
		manageInit();
		checkInit();
		listInit();
		initFind();
		initTime();
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.MEMBER.value,
				FindSaleScheduleType.OPERATOR.value));
	}

	public void manageInit() throws RemoteException {
		tableID.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("id"));
		tableMember.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("customer"));
		tableSum.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, Double>("total"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("userID"));
		tableRemark.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, String>("note"));
		tableRed.setCellValueFactory(new PropertyValueFactory<ReceiptBillVO, CheckBox>("red"));
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
							bill = clickedItem;
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

	/**
	 * 可编辑账户数额和备注
	 *
	 * @throws RemoteException
	 */

	public void edit() throws RemoteException {

		Callback<TableColumn<ReceiptBillVO, String>, TableCell<ReceiptBillVO, String>> cellFactory = (
				TableColumn<ReceiptBillVO, String> p) -> new EditingCell<ReceiptBillVO>();

		tableRemark.setCellFactory(cellFactory);
		tableRemark.setOnEditCommit((CellEditEvent<ReceiptBillVO, String> t) -> {
			String tmp = t.getOldValue();
			((ReceiptBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			ReceiptBillVO newVO = ((ReceiptBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				if (!update(newVO)) {
					((ReceiptBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		Callback<TableColumn<AccountListVO, String>, TableCell<AccountListVO, String>> cellFactoryAccount = (
				TableColumn<AccountListVO, String> p) -> new EditingCell<AccountListVO>();
		Callback<TableColumn<AccountListVO, Double>, TableCell<AccountListVO, Double>> cellFactoryAccountListVODouble = (
				TableColumn<AccountListVO, Double> p) -> new EditingCellDouble<AccountListVO>();

		tableMoney.setCellFactory(cellFactoryAccountListVODouble);
		tableMoney.setOnEditCommit((CellEditEvent<AccountListVO, Double> t) -> {
			double tmp = t.getOldValue();
			((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMoney(t.getNewValue());
			AccountListVO accountVO = ((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			accountVOList.set(t.getTablePosition().getRow(), accountVO);
			ReceiptBillVO newVO = bill;
			ArrayList<AccountListVO> entryVO = new ArrayList<>();
			entryVO.addAll(accountVOList);
			newVO.setAccountListVOs(entryVO);
			newVO.setTotal(newVO.getTotal() - tmp + t.getNewValue());
			try {
				if (!update(newVO)) {
					((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMoney(tmp);
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getId().equals(newVO.getId())) {
							table.getItems().get(i).setTotal(newVO.getTotal());
							break;
						}
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		tableDescription.setCellFactory(cellFactoryAccount);
		tableDescription.setOnEditCommit((CellEditEvent<AccountListVO, String> t) -> {
			String tmp = t.getOldValue();
			((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			AccountListVO accountVO = ((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			accountVOList.set(t.getTablePosition().getRow(), accountVO);
			ReceiptBillVO newVO = bill;
			ArrayList<AccountListVO> accountListVO = new ArrayList<>();
			accountListVO.addAll(accountVOList);
			newVO.setAccountListVOs(accountListVO);
			try {
				if (!update(newVO)) {
					((AccountListVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

	public boolean update(ReceiptBillVO vo) throws RemoteException {
		ResultMessage message = service.updateBill(vo);
		Boolean result = message == ResultMessage.SUCCESS ? true : false;
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (message) {
					case SUCCESS:
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
		return result;
	}

}
