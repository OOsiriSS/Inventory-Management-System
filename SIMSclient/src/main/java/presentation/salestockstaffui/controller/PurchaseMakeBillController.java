package presentation.salestockstaffui.controller;

import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogic.memberbl.MemberController;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindCommodityType;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.CommodityVO;
import vo.uservo.UserVO;

public class PurchaseMakeBillController extends MakeReceiptController {

	PurchaseBLService service = new PurchaseController();
	MemberBLService memberService = new MemberController();
	CommodityBLService commodityService = new CommodityController();
	ObservableList<CommodityItemVO> list = FXCollections.observableArrayList();

	@FXML
	Label typeLabel;

	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> memberChoice;
	@FXML
	ChoiceBox<String> warehouseChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;

	@FXML
	TableView<CommodityItemVO> table;
	@FXML
	TableColumn<CommodityItemVO, String> tableID;
	@FXML
	TableColumn<CommodityItemVO, String> tableName;
	@FXML
	TableColumn<CommodityItemVO, String> tableModel;
	@FXML
	TableColumn<CommodityItemVO, Integer> tableNumber;
	@FXML
	TableColumn<CommodityItemVO, Double> tablePrice;
	@FXML
	TableColumn<CommodityItemVO, Double> tableMoney;
	@FXML
	TableColumn<CommodityItemVO, String> tableNote;
	@FXML
	TableColumn<CommodityItemVO, String> tableDelete;

	@FXML
	Label commodityIDLabel;
	@FXML
	ComboBox<String> nameChoice;
	@FXML
	ChoiceBox<String> modelChoice;
	@FXML
	TextField numberField;
	@FXML
	TextField priceField;
	@FXML
	Label moneyLabel;
	@FXML
	TextArea remarkArea;

	@FXML
	TextArea noteArea;

	@FXML
	public void insert() {
		if (nameChoice.getValue() == null || modelChoice.getValue() == null || numberField.getText() == null
				|| priceField.getText() == null || remarkArea.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有信息");
			warning.showAndWait();
		} else {
			CommodityItemVO vo = new CommodityItemVO(commodityIDLabel.getText(), nameChoice.getValue(),
					modelChoice.getValue(), Integer.parseInt(numberField.getText()),
					Double.parseDouble(priceField.getText()), remarkArea.getText());
			list.add(vo);
			table.setItems(list);
			double result = Double.parseDouble(moneyLabel.getText()) + Double.parseDouble(sumLabel.getText());
			sumLabel.setText(String.valueOf(result));
			commodityIDLabel.setText(null);
			nameChoice.setValue(null);
			modelChoice.setValue(null);
			numberField.setText(null);
			priceField.setText(null);
			moneyLabel.setText("0.0");
			remarkArea.setText(null);
		}
	}

	@FXML
	public void save() throws Exception {
		if (memberChoice.getValue() == null || warehouseChoice.getValue() == null || list == null
				|| noteArea.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有信息");
			warning.showAndWait();
		} else {
			ArrayList<CommodityItemVO> commodityList = new ArrayList<>();
			commodityList.addAll(list);
			PurchaseVO vo = new PurchaseVO(idLabel.getText(), memberChoice.getValue(),
					Warehouse.getWarehouse(warehouseChoice.getValue()), operatorLabel.getText(), commodityList,
					noteArea.getText(), Double.parseDouble(sumLabel.getText()), BillType.getType(typeLabel.getText()),
					BillState.DRAFT);
			ResultMessage message = service.save(vo);
			if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
				printInfo(ResultMessage.SAVED);
				fresh();
			}
		}
	}

	@FXML
	public void submit() throws Exception {
		if (memberChoice.getValue() == null || warehouseChoice.getValue() == null || list == null
				|| noteArea.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有信息");
			warning.showAndWait();
		} else {
			ArrayList<CommodityItemVO> commodityList = new ArrayList<>();
			commodityList.addAll(list);
			PurchaseVO vo = new PurchaseVO(idLabel.getText(), memberChoice.getValue(),
					Warehouse.getWarehouse(warehouseChoice.getValue()), operatorLabel.getText(), commodityList,
					noteArea.getText(), Double.parseDouble(sumLabel.getText()), BillType.getType(typeLabel.getText()),
					BillState.COMMITED);
			ResultMessage message = service.submit(vo);
			if (message == ResultMessage.SUCCESS || message == ResultMessage.EXISTED) {
				printInfo(ResultMessage.COMMITED);
				fresh();
			} else
				printWrong(message);
		}
	}

	@FXML
	public void checkBefore() throws Exception {
		changeStage("PurchaseCheckBillUI", user, type, null, null);
	}

	public void initData(UserVO user, BillType type, PurchaseVO purchase) throws Exception {
		this.type = type;
		this.user = user;
		this.purchase = purchase;
		typeLabel.setText(type.value);
		judgeMessage();
		if (purchase == null) {
			if (type == BillType.PURCHASEBILL)
				idLabel.setText(service.getPurchaseID());
			else
				idLabel.setText(service.getPurChaseBackID());
			sumLabel.setText("0.0");
			operatorLabel.setText(readUser().getName());
		} else {
			idLabel.setText(purchase.getId());
			sumLabel.setText(String.valueOf(purchase.getSum()));
			list.addAll(purchase.getCommodities());
			table.setItems(list);
			operatorLabel.setText(purchase.getOperator());

		}
		numberField.setText(null);
		priceField.setText(null);
		remarkArea.setText(null);
		if (purchase == null)
			noteArea.setText(null);
		else
			noteArea.setText(purchase.getNote());

		edit();
		manageInit();
	}

	public void edit() {
		Callback<TableColumn<CommodityItemVO, String>, TableCell<CommodityItemVO, String>> cellFactory = (
				TableColumn<CommodityItemVO, String> p) -> new EditingCell<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, Integer>, TableCell<CommodityItemVO, Integer>> cellFactoryInteger = (
				TableColumn<CommodityItemVO, Integer> p) -> new EditingCellInteger<CommodityItemVO>();
		Callback<TableColumn<CommodityItemVO, Double>, TableCell<CommodityItemVO, Double>> cellFactoryDouble = (
				TableColumn<CommodityItemVO, Double> p) -> new EditingCellDouble<CommodityItemVO>();

		tableNumber.setCellFactory(cellFactoryInteger);
		tableNumber.setOnEditCommit((CellEditEvent<CommodityItemVO, Integer> t) -> {
			Integer tmp = t.getOldValue();
			Double tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.getTotal();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setNumber(t.getNewValue());
			CommodityItemVO newVO = ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			if (!update(newVO))
				(t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumber(tmp);
			else {
				Integer newTmp = newVO.getNumber();
				double result = Double.parseDouble(sumLabel.getText()) - (tmp - newTmp * newVO.getPrice());
				((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTotal(result);
				sumLabel.setText(String.valueOf(Double.parseDouble(sumLabel.getText()) - tmpTotal + result));
			}
		});

		tableMoney.setCellFactory(cellFactoryDouble);
		tableMoney.setOnEditCommit((CellEditEvent<CommodityItemVO, Double> t) -> {
			Double tmp = t.getOldValue();
			Double tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.getTotal();
			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setPrice(t.getNewValue());
			CommodityItemVO newVO = ((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			if (!update(newVO))
				(t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(tmp);
			else {
				Integer newTmp = newVO.getNumber();
				double result = Double.parseDouble(sumLabel.getText()) - (tmp - newTmp) * newVO.getNumber();
				((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTotal(result);
				sumLabel.setText(String.valueOf(Double.parseDouble(sumLabel.getText()) - tmpTotal + result));
			}
		});

		tableNote.setCellFactory(cellFactory);
		tableNote.setOnEditCommit((CellEditEvent<CommodityItemVO, String> t) -> {

			((CommodityItemVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setRemark(t.getNewValue());
		});
	}

	public boolean update(CommodityItemVO vo) {
		ResultMessage message = service.isLegal(vo);
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

	public void manageInit() throws Exception {
		tableID.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("id"));
		tableName.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("name"));
		tableModel.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("model"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Integer>("number"));
		tablePrice.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("price"));
		tableMoney.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, Double>("total"));
		tableNote.setCellValueFactory(new PropertyValueFactory<CommodityItemVO, String>("remark"));
		choiceInit();
		textFieldInit();
		deleteInit();
	}

	/**
	 * 对选择会员、仓库、商品名称按钮的初始化
	 */

	public void choiceInit() throws Exception {
		ObservableList<String> memberList = FXCollections.observableArrayList();
		memberList.addAll(memberService.getIDandName());
		memberChoice.setItems(memberList);
		warehouseChoice
				.setItems(FXCollections.observableArrayList(Warehouse.WAREHOUSE1.value, Warehouse.WAREHOUSE2.value));
		ObservableList<String> commodityList = FXCollections.observableArrayList();
		commodityList.addAll(commodityService.getIDandName());
		nameChoice.setItems(commodityList);
		nameChoice.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends String> cl, String oldValue, String newValue) -> {
					ObservableList<String> modelList = FXCollections.observableArrayList();
					modelList.clear();
					String s = "";
					for (int i = 0; i < newValue.length(); i++)
						if (newValue.charAt(i) == '(') {
							s = newValue.substring(i + 1, newValue.length() - 1);
							break;
						}
					commodityIDLabel.setText(s);
					try {
						priceField.setText(String
								.valueOf(commodityService.find(s, FindCommodityType.ID).get(0).getRecentPurPrice()));

						for (CommodityVO commodity : commodityService.find(s, FindCommodityType.ID))
							modelList.add(commodity.getModel());
					} catch (Exception e) {
						e.printStackTrace();
					}
					modelChoice.setItems(modelList);
				});

		if (purchase != null) {
			memberChoice.setValue(purchase.getSupplier());
			warehouseChoice.setValue(purchase.getWarehouse().value);
		}

	}

	/**
	 * 对商品数量和价格的文字监控
	 */

	public void textFieldInit() {
		numberField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				boolean numberLegal = true, priceLegal = true; // 判断输入值是否合法
				for (int i = 0; i < numberField.getText().length(); i++)
					if (numberField.getText().charAt(i) <= '9' && numberField.getText().charAt(i) >= '0')
						continue;
					else {
						numberLegal = false;
						break;
					}
				if (numberField.getText() == null || priceField.getText() == null)
					moneyLabel.setText("0");
				else {
					for (int i = 0; i < priceField.getText().length(); i++)
						if ((priceField.getText().charAt(i) <= '9' && priceField.getText().charAt(i) >= '0')
								|| priceField.getText().charAt(i) == '.')
							continue;
						else {
							priceLegal = false;
							break;
						}

					if (!priceLegal || !numberLegal)
						moneyLabel.setText("0");
					else
						moneyLabel.setText(String.valueOf(
								Integer.parseInt(numberField.getText()) * Double.parseDouble(priceField.getText())));
				}
			}
		});

		priceField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				boolean numberLegal = true, priceLegal = true;
				if (numberField.getText() == null || priceField.getText() == null)
					moneyLabel.setText("0");
				else {
					for (int i = 0; i < numberField.getText().length(); i++)
						if (numberField.getText().charAt(i) <= '9' && numberField.getText().charAt(i) >= '0')
							continue;
						else {
							numberLegal = false;
							break;
						}
					for (int i = 0; i < priceField.getText().length(); i++)
						if ((priceField.getText().charAt(i) <= '9' && priceField.getText().charAt(i) >= '0')
								|| priceField.getText().charAt(i) == '.')
							continue;
						else {
							priceLegal = false;
							break;
						}

					if (!priceLegal || !numberLegal)
						moneyLabel.setText("0");
					else
						moneyLabel.setText(String.valueOf(
								Integer.parseInt(numberField.getText()) * Double.parseDouble(priceField.getText())));
				}
			}
		});
	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<CommodityItemVO, String> cell = new TableCell<CommodityItemVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							CommodityItemVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							list.remove(clickedItem);
							table.setItems(list);
							double tmp = clickedItem.getTotal();
							double result = Double.parseDouble(sumLabel.getText()) - tmp;
							sumLabel.setText(String.valueOf(result));
						});
					}
				}

			};
			return cell;
		});
	}

}
