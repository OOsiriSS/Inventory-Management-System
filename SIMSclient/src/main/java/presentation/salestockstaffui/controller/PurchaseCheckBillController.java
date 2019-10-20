package presentation.salestockstaffui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPurchaseType;
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
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class PurchaseCheckBillController extends SaleStockStaffController {

	PurchaseBLService service = new PurchaseController();
	ObservableList<PurchaseVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();

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
	TableColumn<PurchaseVO, String> tableState;
	@FXML
	TableColumn<PurchaseVO, String> tableSubmit;
	@FXML
	TableColumn<PurchaseVO, String> tableRedo;
	@FXML
	TableColumn<PurchaseVO, String> tableDelete;

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
	public void makePurchaseBill() {
		try {
			changeStage("PurchaseMakeBillUI", user, type, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void find() {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PurchaseVO> purchaseList = service.find(findingField.getText(),
					FindSalesType.getType(findChoice.getValue()));
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

	public void initData(UserVO user, BillType type) {
		this.user = user;
		this.type = type;
		judgeMessage();
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
		initFind();
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
		tableState.setCellValueFactory(new PropertyValueFactory<PurchaseVO, String>("stateString"));
		checkInit();
		submitInit();
		redoInit();
		deleteInit();
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

						});
					}
				}

			};
			return cell;
		});

	}

	public void submitInit() {

		tableSubmit.setCellFactory((col) -> {
			TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT) {
						Button delBtn = new Button("提交"); // 只有草稿状态单据才能提交
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							clickedItem.setState(BillState.COMMITED);
							ResultMessage message = service.submit(clickedItem);
							if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
								this.getTableView().getItems().get(this.getIndex()).setState(BillState.COMMITED);
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
			TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT)) {
						Button delBtn = new Button("重做"); // 只有审批失败和草稿状态单据才能重做
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							try {
								changeStage("PurchaseMakeBillUI", user, clickedItem.getType(), clickedItem, null);
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
			TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL
							|| this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT)) {
						Button delBtn = new Button("删除");// 只有审批失败和草稿状态单据才能被删除
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setContentText("确认删除？");
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								service.delete(clickedItem);
								list.remove(clickedItem);
								table.setItems(list);
							}

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
