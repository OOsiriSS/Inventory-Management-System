package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.examinebl.ExaminePurchaseBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindPurchaseType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class ExaminePurchaseBillController extends ExamineBillController {

	ExamineBLService<PurchaseVO> service = new ExaminePurchaseBL();
	ObservableList<PurchaseVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
	PurchaseVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

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
	TableColumn<PurchaseVO, CheckBox> tablePass;

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
	public void find() throws RemoteException {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PurchaseVO> purchaseList = service.find(findingField.getText(),
					FindBillType.getType(findChoice.getValue()));
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

	public void initFind() {
		findChoice.setValue(null);
		findingField.setText(null);
	}

	@FXML
	public void success() throws RemoteException {
		ArrayList<PurchaseVO> choiceList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getBox().isSelected()) {
				choiceList.add(list.get(i));
				list.remove(i);
			}
		ResultMessage message = service.passBills(choiceList);
		if (message == ResultMessage.SUCCESS) {
			Alert info = new Alert(Alert.AlertType.INFORMATION, "已审批");
			info.showAndWait();
		} else {
			Alert warning = new Alert(Alert.AlertType.WARNING, message.value);
			warning.showAndWait();
		}
	}

	@FXML
	public void fail() throws RemoteException {
		ArrayList<PurchaseVO> choiceList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getBox().isSelected()) {
				choiceList.add(list.get(i));
				list.remove(i);
			}
		ResultMessage message = service.notPassBills(choiceList);
		if (message == ResultMessage.SUCCESS) {
			Alert info = new Alert(Alert.AlertType.INFORMATION, "已审批");
			info.showAndWait();
		} else {
			Alert warning = new Alert(Alert.AlertType.WARNING, message.value);
			warning.showAndWait();
		}
	}

	public void initData(UserVO user) throws RemoteException {
		this.user = user;
		judgeMessage();
		choiceInit();
		initFind();
		receiptChoice.setValue(BillType.PURCHASEBILL.value);
		list.addAll(service.getCommitedBills());
		table.setItems(list);
		edit();
		manageInit();
		checkInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindPurchaseType.ID.value, FindPurchaseType.MEMBER.value,
				FindPurchaseType.OPERATOR.value, FindPurchaseType.TOTAL.value));
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("id"));
		tableType.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("typeString"));
		tableMember.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("supplier"));
		tableWarehouse.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("warehouseString"));
		tableSum.setCellValueFactory(new PropertyValueFactory<PurchaseVO, Double>("sum"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("operator"));
		tableNote.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("note"));
		tablePass.setCellValueFactory(new PropertyValueFactory<PurchaseVO, CheckBox>("box"));
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

	public void listInit() {
		commodityID.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("id"));
		commodityName.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("name"));
		commodityModel.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("model"));
		commodityNumber.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Integer>("number"));
		commodityPrice.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("price"));
		commodityMoney.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("total"));
		commodityNote.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("remark"));
	}
}
