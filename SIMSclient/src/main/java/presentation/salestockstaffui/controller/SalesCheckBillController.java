package presentation.salestockstaffui.controller;

import java.util.ArrayList;
import java.util.Optional;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
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
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class SalesCheckBillController extends SaleStockStaffController {

	SalesBLService service = new SalesController();
	ObservableList<SalesVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

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
	TableColumn<SalesVO, String> tableState;
	@FXML
	TableColumn<SalesVO, String> tableSubmit;
	@FXML
	TableColumn<SalesVO, String> tableRedo;
	@FXML
	TableColumn<SalesVO, String> tableDelete;

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
	public void find() {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<SalesVO> salesList = service.find(findingField.getText(),
					FindSalesType.getType(findChoice.getValue()));
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

	public void initFind() {
		findChoice.setValue(null);
		findingField.setText(null);
	}

	@FXML
	public void makeSalesBill() throws Exception {
		changeStage("SalesMakeBillUI", user, type, null, null);
	}

	public void initData(UserVO user, BillType type) {
		this.user = user;
		this.type = type;
		judgeMessage();
		findChoice.setItems(FXCollections.observableArrayList(FindSalesType.ID.value, FindSalesType.MEMBER.value,
				FindSalesType.OPERATOR.value, FindSalesType.MEMBER.value, FindSalesType.SALEMAN.value,
				FindSalesType.TOTAL.value));
		if (service.show() != null) {
			list.addAll(service.show());
			table.setItems(list);
		}
		initFind();
		manageInit();
		checkInit();
		submitInit();
		redoInit();
		deleteInit();
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
		tableState.setCellValueFactory(new PropertyValueFactory<SalesVO, String>("stateString"));
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

						});
					}
				}

			};
			return cell;
		});

	}

	public void submitInit() {

		tableSubmit.setCellFactory((col) -> {
			TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT) {
						Button delBtn = new Button("提交");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							clickedItem.setState(BillState.COMMITED);
							ResultMessage message = service.submit(clickedItem);
							if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
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
			TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT)) {
						Button delBtn = new Button("重做");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							try {
								changeStage("SalesMakeBillUI", user, clickedItem.getType(), null, clickedItem);
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
			TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT)) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							service.delete(clickedItem);
							list.remove(clickedItem);
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setContentText("确认删除？");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								service.delete(clickedItem);
								list.remove(clickedItem);
								table.setItems(list);
							}
							table.setItems(list);

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

}
