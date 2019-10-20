package presentation.financialstaffui.controller;

import java.util.ArrayList;

import bussinesslogic.tablebl.BusinessHistoryScheduleInventoryBL;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellInteger;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;
import vo.uservo.UserVO;

public class CheckInventoryBillController extends BussinessProcessTableController {

	BusinessHistoryScheduleBLService<InventoryBillVO> service = new BusinessHistoryScheduleInventoryBL();
	ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
	ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
	InventoryBillVO inv;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TextField findingField;
	@FXML
	ChoiceBox<String> findChoice;

	@FXML
	TableView<InventoryBillVO> table;
	@FXML
	TableColumn<InventoryBillVO, String> tableID;
	@FXML
	TableColumn<InventoryBillVO, String> tableType;
	@FXML
	TableColumn<InventoryBillVO, String> tableOperator;
	@FXML
	TableColumn<InventoryBillVO, String> tableNote;
	@FXML
	TableColumn<InventoryBillVO, String> tableCheck;
	@FXML
	TableColumn<InventoryBillVO, CheckBox> tableRed;

	@FXML
	TableView<GiftVO> giftTable;
	@FXML
	TableColumn<GiftVO, String> tableName;
	@FXML
	TableColumn<GiftVO, Integer> tableNumber;

	@FXML
	public void red() {
		ArrayList<InventoryBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<InventoryBillVO> inventoryList = service.writeOff(result);
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
		ArrayList<InventoryBillVO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<InventoryBillVO> copy = service.writeOffAndCopy(result);
		if (copy != null) {
			list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
			giftList.clear();
			giftTable.setItems(giftList);
			giftTable.setEditable(true);
			edit();
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
		ArrayList<InventoryBillVO> result = new ArrayList<>();
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
			ArrayList<InventoryBillVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
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
			ArrayList<InventoryBillVO> inventoryList = service.sift(findingField.getText(),
					FindSaleScheduleType.getType(findChoice.getValue()));
			if (inventoryList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(inventoryList);
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

	public void initData(UserVO user) {
		this.user = user;
		judgeMessage();
		manageInit();
		checkInit();
		initFind();
		initTime();
		list.addAll(service.show());
		table.setItems(list);
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<InventoryBillVO, String>("id"));
		tableType.setCellValueFactory(new PropertyValueFactory<InventoryBillVO, String>("typeString"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<InventoryBillVO, String>("operator"));
		tableNote.setCellValueFactory(new PropertyValueFactory<InventoryBillVO, String>("note"));
		tableRed.setCellValueFactory(new PropertyValueFactory<InventoryBillVO, CheckBox>("red"));
		tableName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
	}

	public void checkInit() {

		tableCheck.setCellFactory((col) -> {
			TableCell<InventoryBillVO, String> cell = new TableCell<InventoryBillVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看商品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							giftList.clear();
							giftList.addAll(clickedItem.getGifts());
							giftTable.setItems(giftList);
							inv = clickedItem;
						});
					}
				}

			};
			return cell;
		});

	}

	public void edit() {
		Callback<TableColumn<GiftVO, Integer>, TableCell<GiftVO, Integer>> cellFactoryInteger = (
				TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();
		Callback<TableColumn<InventoryBillVO, String>, TableCell<InventoryBillVO, String>> cellFactory = (
				TableColumn<InventoryBillVO, String> p) -> new EditingCell<InventoryBillVO>();

		tableNumber.setCellFactory(cellFactoryInteger);
		tableNumber.setOnEditCommit((CellEditEvent<GiftVO, Integer> t) -> {
			((GiftVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumber(t.getNewValue());
			giftList.set(t.getTablePosition().getRow(),
					((GiftVO) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			ArrayList<GiftVO> tmpGifts = new ArrayList<>();
			tmpGifts.addAll(giftList);
			inv.setGifts(tmpGifts);
			service.updateBill(inv);

		});
		tableNote.setCellFactory(cellFactory);
		tableNote.setOnEditCommit((CellEditEvent<InventoryBillVO, String> t) -> {
			((InventoryBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNote(t.getNewValue());
			list.set(t.getTablePosition().getRow(),
					((InventoryBillVO) t.getTableView().getItems().get(t.getTablePosition().getRow())));
			InventoryBillVO updating = ((InventoryBillVO) t.getTableView().getItems()
					.get(t.getTablePosition().getRow()));
			service.updateBill(updating);

		});

	}

}
