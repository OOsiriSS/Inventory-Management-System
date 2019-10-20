package presentation.inventorymanagerui.controller;

import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.commodityvo.CommodityStockVO;
import vo.uservo.UserVO;

/**
 * 用于库存盘点的界面
 * 
 * @author 潘星宇 2017-12-18
 */

public class InventoryStockController extends InventoryManagerController {

	CommodityBLService service = new CommodityController();
	ObservableList<CommodityStockVO> list = FXCollections.observableArrayList();

	@FXML
	protected TableView<CommodityStockVO> table;
	@FXML
	protected TableColumn<CommodityStockVO, Integer> tableLine;
	@FXML
	protected TableColumn<CommodityStockVO, String> tableID;
	@FXML
	protected TableColumn<CommodityStockVO, String> tableName;
	@FXML
	protected TableColumn<CommodityStockVO, String> tableModel;

	@FXML
	protected TableColumn<CommodityStockVO, Integer> tableNumber;
	@FXML
	protected TableColumn<CommodityStockVO, Double> tablePurPrice;
	@FXML
	protected TableColumn<CommodityStockVO, Double> tableRetailedPrice;

	@FXML
	public void export() throws Exception {
		ArrayList<CommodityStockVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
		Alert info = new Alert(Alert.AlertType.INFORMATION, "已导出");
		info.showAndWait();
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		list.clear();
		list.addAll(service.stock());
		table.setItems(list);
		manageInit();
	}

	public void manageInit() {
		tableLine.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, Integer>("line"));
		tableID.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, String>("id"));
		tableName.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, String>("name"));
		tableModel.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, String>("model"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, Integer>("number"));
		tablePurPrice.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, Double>("avgRetailedPrice"));
		tableRetailedPrice.setCellValueFactory(new PropertyValueFactory<CommodityStockVO, Double>("avgPurPrice"));
	}

}
