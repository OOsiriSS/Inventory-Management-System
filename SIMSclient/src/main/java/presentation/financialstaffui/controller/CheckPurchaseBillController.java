package presentation.financialstaffui.controller;

import java.rmi.RemoteException;

import java.util.ArrayList;

import bussinesslogic.tablebl.BussinessHistorySchedulePurchaseBL;
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
import presentation.common.EditingCellInteger;
import presentation.financialstaffui.controller.BussinessProcessTableController;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class CheckPurchaseBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<PurchaseVO> service = new BussinessHistorySchedulePurchaseBL();
	ObservableList<PurchaseVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
	PurchaseVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TableView<PurchaseVO> table;
	@FXML
	TableColumn<PurchaseVO, String> tableID;
	@FXML
	TableColumn<PurchaseVO, String> tableType;
	@FXML
	TableColumn<PurchaseVO, String> tableMember;
	@FXML
	TableColumn<PurchaseVO, String> tableWarehouse;
	@FXML
	TableColumn<PurchaseVO, Double> tableSum;
	@FXML
	TableColumn<PurchaseVO, String> tableOperator;
	@FXML
	TableColumn<PurchaseVO, String> tableNote;
	@FXML
	TableColumn<PurchaseVO, String> tableList;
	@FXML
	TableColumn<PurchaseVO, CheckBox> tableRed;

	@FXML
	TableView<CommodityItemVO> commodity;
	@FXML
	TableColumn<CommodityItemVO, String> commodityID;
	@FXML
	TableColumn<CommodityItemVO, String> commodityName;
	@FXML
	TableColumn<CommodityItemVO, String> commodityModel;
	@FXML
	TableColumn<CommodityItemVO, Integer> commodityNumber;
	@FXML
	TableColumn<CommodityItemVO, Double> commodityPrice;
	@FXML
	TableColumn<CommodityItemVO, Double> commodityMoney;
	@FXML
	TableColumn<CommodityItemVO, String> commodityNote;

	@FXML
	public void red() {
		ArrayList<PurchaseVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PurchaseVO> inventoryList = service.writeOff(result);
		if (inventoryList != null) {
			list.addAll(inventoryList);
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
		ArrayList<PurchaseVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PurchaseVO> copy = service.writeOffAndCopy(result);
		if (copy != null) {
			list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
			commodityList.clear();
			commodity.setItems(commodityList);
			commodity.setEditable(true);
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

	/**
	 * 导出表格
	 */

	@FXML
	public void printout() {
		ArrayList<PurchaseVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
		Alert info = new Alert(Alert.AlertType.INFORMATION, "已导出");
		info.showAndWait();
	}

	@FXML
	public void siftTime() {
		if (startPicker.getValue() == null || endPicker.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			list.clear();
			ArrayList<PurchaseVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
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
			ArrayList<PurchaseVO> purchaseList = service.sift(findingField.getText(),
					FindSaleScheduleType.getType(findChoice.getValue()));
			if (purchaseList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(purchaseList);
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
		listInit();
		initFind();
		initTime();
		findChoice.setItems(
				FXCollections.observableArrayList(FindSaleScheduleType.NAME.value, FindSaleScheduleType.MEMBER.value,
						FindSaleScheduleType.OPERATOR.value, FindSaleScheduleType.WAREHOUSE.value));
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("id"));
		tableType.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("typeString"));
		tableMember.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("supplier"));
		tableWarehouse.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("warehouseString"));
		tableSum.setCellValueFactory(new PropertyValueFactory<PurchaseVO, Double>("sum"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("operator"));
		tableNote.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("note"));
		tableRed.setCellValueFactory(new PropertyValueFactory<PurchaseVO, CheckBox>("red"));
		checkInit();
	}

	public void checkInit() {

		tableList.setCellFactory((col) -> {
			TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看商品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							commodityList.clear();
							commodityList.addAll(clickedItem.getCommodities());
							commodity.setItems(commodityList);
							bill = clickedItem;

						});
					}
				}

			};
			return cell;
		});

	}

	public void listInit() {
		commodityID.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("id"));
		commodityName.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("name"));
		commodityModel.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("model"));
		commodityNumber.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Integer>("number"));
		commodityPrice.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("price"));
		commodityMoney.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("total"));
		commodityNote.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("remark"));
	}

	/**
	 * 可对单据备注以及商品数量及金额进行修改
	 * 
	 * @throws RemoteException
	 */

	public void edit() throws RemoteException {
		// 单据表格层面的edit
		Callback<TableColumn<PurchaseVO, String>, TableCell<PurchaseVO, String>> cellFactory = (
				TableColumn<PurchaseVO, String> p) -> new EditingCell<PurchaseVO>();

		tableNote.setCellFactory(cellFactory);
		tableNote.setOnEditCommit((CellEditEvent<PurchaseVO, String> t) -> {
			String tmp = t.getOldValue();
			((PurchaseVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			PurchaseVO newVO = ((PurchaseVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				if (!update(newVO)) {
					((PurchaseVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
		// 商品表格层面的edit
		Callback<TableColumn<CommodityItemVO, Integer>, TableCell<CommodityItemVO, Integer>> cellFactoryInteger = (
				TableColumn<CommodityItemVO, Integer> p) -> new EditingCellInteger<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, Double>, TableCell<CommodityItemVO, Double>> cellFactoryDouble = (
				TableColumn<CommodityItemVO, Double> p) -> new EditingCellDouble<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, String>, TableCell<CommodityItemVO, String>> cellFactoryNote = (
				TableColumn<CommodityItemVO, String> p) -> new EditingCell<CommodityItemVO>();

		commodityPrice.setCellFactory(cellFactoryDouble);
		commodityPrice.setOnEditCommit((CellEditEvent<CommodityItemVO, Double> t) -> {
			Double tmp = t.getOldValue();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setPrice(t.getNewValue());
			CommodityItemVO accountVO = ((CommodityItemVO) t.getTableView().getItems()
					.get(t.getTablePosition().getRow()));
			accountVO.setTotal(accountVO.getPrice() - (tmp - t.getNewValue()) * accountVO.getNumber());
			commodityList.set(t.getTablePosition().getRow(), accountVO);
			PurchaseVO newVO = bill;
			ArrayList<CommodityItemVO> entryVO = new ArrayList<>();
			entryVO.addAll(commodityList);
			newVO.setCommodities(entryVO);
			newVO.setSum(newVO.getSum() - (tmp - t.getNewValue()) // 表格总价的连锁反应
					* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).getNumber());
			try {
				if (!update(newVO)) {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(tmp);
				} else {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setTotal(t.getNewValue()
									* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
											.getNumber());
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getId().equals(newVO.getId())) {
							table.getItems().get(i).setSum(newVO.getSum());
							break;
						}
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		commodityNumber.setCellFactory(cellFactoryInteger);
		commodityNumber.setOnEditCommit((CellEditEvent<CommodityItemVO, Integer> t) -> {
			int tmp = t.getOldValue();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setNumber(t.getNewValue());
			CommodityItemVO accountVO = ((CommodityItemVO) t.getTableView().getItems()
					.get(t.getTablePosition().getRow()));
			accountVO.setTotal(accountVO.getPrice() - (tmp - t.getNewValue()) * accountVO.getPrice());
			commodityList.set(t.getTablePosition().getRow(), accountVO);
			PurchaseVO newVO = bill;
			ArrayList<CommodityItemVO> entryVO = new ArrayList<>();
			entryVO.addAll(commodityList);
			newVO.setCommodities(entryVO);
			newVO.setSum(newVO.getSum() - (tmp - t.getNewValue()) // 表格总价的连锁反应
					* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).getPrice());
			try {
				if (!update(newVO)) {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumber(tmp);
				} else {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setTotal(t.getNewValue()
									* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
											.getPrice());
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getId().equals(newVO.getId())) {
							table.getItems().get(i).setSum(newVO.getSum());
							break;
						}
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		commodityNote.setCellFactory(cellFactoryNote);
		commodityNote.setOnEditCommit((CellEditEvent<CommodityItemVO, String> t) -> {
			String tmp = t.getOldValue();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setRemark(t.getNewValue());
			CommodityItemVO accountVO = ((CommodityItemVO) t.getTableView().getItems()
					.get(t.getTablePosition().getRow()));
			commodityList.set(t.getTablePosition().getRow(), accountVO);
			PurchaseVO newVO = bill;
			ArrayList<CommodityItemVO> accountListVO = new ArrayList<>();
			accountListVO.addAll(commodityList);
			newVO.setCommodities(accountListVO);
			try {
				if (!update(newVO)) {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRemark(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

	}

	public boolean update(PurchaseVO vo) throws RemoteException {
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
