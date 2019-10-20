package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BusinessHistoryScheduleSalesBL;
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
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class CheckSalesBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<SalesVO> service = new BusinessHistoryScheduleSalesBL();
	ObservableList<SalesVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
	SalesVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TableView<SalesVO> table;
	@FXML
	TableColumn<SalesVO, String> tableID;
	@FXML
	TableColumn<SalesVO, String> tableType;
	@FXML
	TableColumn<SalesVO, String> tableMember;
	@FXML
	TableColumn<SalesVO, String> tableSaleMan;
	@FXML
	TableColumn<SalesVO, String> tableWarehouse;
	@FXML
	TableColumn<SalesVO, Double> tableBefore;
	@FXML
	TableColumn<SalesVO, Double> tableVoucher;
	@FXML
	TableColumn<SalesVO, Double> tableAllowance;
	@FXML
	TableColumn<SalesVO, Double> tableAfter;
	@FXML
	TableColumn<SalesVO, String> tableOperator;
	@FXML
	TableColumn<SalesVO, String> tableNote;
	@FXML
	TableColumn<SalesVO, String> tableList;
	@FXML
	TableColumn<SalesVO, CheckBox> tableRed;

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
		ArrayList<SalesVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<SalesVO> saleList = service.writeOff(result);
		if (saleList != null) {
			list.addAll(saleList);
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
		ArrayList<SalesVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<SalesVO> copy = service.writeOffAndCopy(result);
		if (copy != null) {
			list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
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
		ArrayList<SalesVO> result = new ArrayList<>();
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
			ArrayList<SalesVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
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
			ArrayList<SalesVO> salesList = service.sift(findingField.getText(),
					FindSaleScheduleType.getType(findChoice.getValue()));
			if (salesList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(salesList);
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
		findChoice.setItems(
				FXCollections.observableArrayList(FindSaleScheduleType.NAME.value, FindSaleScheduleType.OPERATOR.value,
						FindSaleScheduleType.MEMBER.value, FindSaleScheduleType.WAREHOUSE.value));
		initTime();
		initFind();
		list.clear();
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		checkInit();
		listInit();
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("id"));
		tableType.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("typeString"));
		tableMember.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("retailer"));
		tableSaleMan.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("saleMan"));
		tableWarehouse.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("warehouseString"));
		tableBefore.setCellValueFactory(new PropertyValueFactory<SalesVO, Double>("beforePrice"));
		tableAllowance.setCellValueFactory(new PropertyValueFactory<SalesVO, Double>("allowance"));
		tableVoucher.setCellValueFactory(new PropertyValueFactory<SalesVO, Double>("voucher"));
		tableAfter.setCellValueFactory(new PropertyValueFactory<SalesVO, Double>("afterPrice"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("operator"));
		tableNote.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("note"));
		tableRed.setCellValueFactory(new PropertyValueFactory<SalesVO, CheckBox>("red"));
	}

	public void checkInit() {

		tableList.setCellFactory((col) -> {
			TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看商品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							commodityList.clear();
							commodityList.addAll(clickedItem.getCommodity());
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
	 * 可对单据备注、代金券以及折让数额进行修改，已经商品价格数量进行修改
	 *
	 * @throws RemoteException
	 */

	public void edit() throws RemoteException {
		// 单据表格层面的edit
		Callback<TableColumn<SalesVO, String>, TableCell<SalesVO, String>> cellFactory = (
				TableColumn<SalesVO, String> p) -> new EditingCell<SalesVO>();

		Callback<TableColumn<SalesVO, Double>, TableCell<SalesVO, Double>> cellFactoryDouble = (
				TableColumn<SalesVO, Double> p) -> new EditingCellDouble<SalesVO>();

		tableVoucher.setCellFactory(cellFactoryDouble);
		tableVoucher.setOnEditCommit((CellEditEvent<SalesVO, Double> t) -> {
			double tmp = t.getOldValue();
			((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setVoucher(t.getNewValue());
			SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			newVO.setAfterPrice(newVO.getBeforePrice() - newVO.getAllowance() - newVO.getVoucher());
			try {
				if (!update(newVO)) {
					((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setVoucher(tmp);
				} else {
					((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setAfterPrice(newVO.getAfterPrice());
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		tableAllowance.setCellFactory(cellFactoryDouble);
		tableAllowance.setOnEditCommit((CellEditEvent<SalesVO, Double> t) -> {
			double tmp = t.getOldValue();
			((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAllowance(t.getNewValue());
			SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			newVO.setAfterPrice(newVO.getBeforePrice() - newVO.getAllowance() - newVO.getVoucher());
			try {
				if (!update(newVO)) {
					((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAllowance(tmp);
				} else {
					((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setAfterPrice(newVO.getAfterPrice());
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		tableNote.setCellFactory(cellFactory);
		tableNote.setOnEditCommit((CellEditEvent<SalesVO, String> t) -> {
			String tmp = t.getOldValue();
			((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				if (!update(newVO)) {
					((SalesVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
		// 商品表格层面的edit
		Callback<TableColumn<CommodityItemVO, Integer>, TableCell<CommodityItemVO, Integer>> cellFactoryInteger = (
				TableColumn<CommodityItemVO, Integer> p) -> new EditingCellInteger<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, Double>, TableCell<CommodityItemVO, Double>> cellFactoryCommodityDouble = (
				TableColumn<CommodityItemVO, Double> p) -> new EditingCellDouble<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, String>, TableCell<CommodityItemVO, String>> cellFactoryNote = (
				TableColumn<CommodityItemVO, String> p) -> new EditingCell<CommodityItemVO>();

		commodityPrice.setCellFactory(cellFactoryCommodityDouble);
		commodityPrice.setOnEditCommit((CellEditEvent<CommodityItemVO, Double> t) -> {
			Double tmp = t.getOldValue();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setPrice(t.getNewValue());
			CommodityItemVO accountVO = ((CommodityItemVO) t.getTableView().getItems()
					.get(t.getTablePosition().getRow()));
			accountVO.setTotal(accountVO.getPrice() - (tmp - t.getNewValue()) * accountVO.getNumber());
			commodityList.set(t.getTablePosition().getRow(), accountVO);
			SalesVO newVO = bill;
			ArrayList<CommodityItemVO> entryVO = new ArrayList<>();
			entryVO.addAll(commodityList);
			newVO.setCommodity(entryVO);
			newVO.setBeforePrice(newVO.getBeforePrice() - (tmp - t.getNewValue()) // 修改之后的总价与折后价的连锁反应
					* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).getNumber());
			newVO.setAfterPrice(newVO.getBeforePrice() - newVO.getAllowance() - newVO.getVoucher());
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
							table.getItems().get(i).setBeforePrice(newVO.getBeforePrice());
							table.getItems().get(i).setAfterPrice(newVO.getAfterPrice());
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
			SalesVO newVO = bill;
			ArrayList<CommodityItemVO> entryVO = new ArrayList<>();
			entryVO.addAll(commodityList);
			newVO.setCommodity(entryVO);
			newVO.setBeforePrice(newVO.getBeforePrice() - (tmp - t.getNewValue()) // 修改之后的总价与折后价的连锁反应
					* ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).getNumber());
			newVO.setAfterPrice(newVO.getBeforePrice() - newVO.getAllowance() - newVO.getVoucher());
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
							table.getItems().get(i).setBeforePrice(newVO.getBeforePrice());
							table.getItems().get(i).setAfterPrice(newVO.getAfterPrice());
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
			SalesVO newVO = bill;
			ArrayList<CommodityItemVO> accountListVO = new ArrayList<>();
			accountListVO.addAll(commodityList);
			newVO.setCommodity(accountListVO);
			try {
				if (!update(newVO)) {
					((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRemark(tmp);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

	}

	public boolean update(SalesVO vo) throws RemoteException {
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
