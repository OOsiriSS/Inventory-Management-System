package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BusinessHistorySchedulePaymentBL;
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
	TableColumn<PaymentBillVO, CheckBox> tableRed;

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
	public void red() {
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PaymentBillVO> paymentList = service.writeOff(result);
		if (paymentList != null) {
			list.addAll(paymentList);
			table.setItems(list);
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "已红冲");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "红冲失败");
			alert.showAndWait();
		}

	}

	/**
	 * 红冲并复制
	 */

	@FXML
	public void redCopy() {
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PaymentBillVO> copy = service.writeOffAndCopy(result);
		if (copy != null) {
			list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
			itemList.setEditable(true);
			try {
				edit();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "已红冲，请编辑单据信息");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "红冲失败");
			alert.showAndWait();
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
		tableRed.setCellValueFactory(new PropertyValueFactory<PaymentBillVO, CheckBox>("red"));
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
							bill = clickedItem;
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

	/**
	 * 账户总额和单据备注可编辑
	 *
	 * @throws RemoteException
	 */

	public void edit() throws RemoteException {

		Callback<TableColumn<PaymentBillVO, String>, TableCell<PaymentBillVO, String>> cellFactory = (
				TableColumn<PaymentBillVO, String> p) -> new EditingCell<PaymentBillVO>();

		tableRemark.setCellFactory(cellFactory);
		tableRemark.setOnEditCommit((CellEditEvent<PaymentBillVO, String> t) -> {
			String tmp = t.getOldValue();
			((PaymentBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			PaymentBillVO newVO = ((PaymentBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				if (!update(newVO)) {
					((PaymentBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		Callback<TableColumn<EntryVO, String>, TableCell<EntryVO, String>> cellFactoryItem = (
				TableColumn<EntryVO, String> p) -> new EditingCell<EntryVO>();
		Callback<TableColumn<EntryVO, Double>, TableCell<EntryVO, Double>> cellFactoryDouble = (
				TableColumn<EntryVO, Double> p) -> new EditingCellDouble<EntryVO>();

		tableItem.setCellFactory(cellFactoryItem);
		tableItem.setOnEditCommit((CellEditEvent<EntryVO, String> t) -> {
			String tmp = t.getOldValue();
			((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEntryName(t.getNewValue());
			EntryVO accountVO = ((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			entryList.set(t.getTablePosition().getRow(), accountVO);
			PaymentBillVO newVO = bill;
			ArrayList<EntryVO> entryVO = new ArrayList<>();
			entryVO.addAll(entryList);
			newVO.setEntryListVO(entryVO);
			try {
				if (!update(newVO)) {
					((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEntryName(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		tableMoney.setCellFactory(cellFactoryDouble);
		tableMoney.setOnEditCommit((CellEditEvent<EntryVO, Double> t) -> {
			Double tmp = t.getOldValue();
			((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setTransferAmount(t.getNewValue());
			EntryVO accountVO = ((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			entryList.set(t.getTablePosition().getRow(), accountVO);
			PaymentBillVO newVO = bill;
			ArrayList<EntryVO> entryVO = new ArrayList<>();
			entryVO.addAll(entryList);
			newVO.setEntryListVO(entryVO);
			newVO.setTotal(newVO.getTotal() - tmp + t.getNewValue());
			try {
				if (!update(newVO)) {
					((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTransferAmount(tmp);
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

		tableNote.setCellFactory(cellFactoryItem);
		tableNote.setOnEditCommit((CellEditEvent<EntryVO, String> t) -> {
			String tmp = t.getOldValue();
			((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			EntryVO accountVO = ((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			entryList.set(t.getTablePosition().getRow(), accountVO);
			PaymentBillVO newVO = bill;
			ArrayList<EntryVO> accountListVO = new ArrayList<>();
			accountListVO.addAll(entryList);
			newVO.setEntryListVO(accountListVO);
			try {
				if (!update(newVO)) {
					((EntryVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

	public boolean update(PaymentBillVO vo) throws RemoteException {
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
						;
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
