package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogic.promotionbl.PromotionSpecialBL;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCellDate;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.uservo.UserVO;

public class PromotionSpecialController extends PromotionMakingController {
	PromotionBLService<PromotionPricePacksVO> service = new PromotionSpecialBL();
	CommodityBLService commodityservice = new CommodityController();
	ObservableList<PromotionPricePacksVO> list = FXCollections.observableArrayList();
	ObservableList<GiftVO> commodityList = FXCollections.observableArrayList();
	ObservableList<String> commodityChoiceList = FXCollections.observableArrayList();
	UserVO user;
	PromotionPricePacksVO currentPromotion;
	PromotionType type = PromotionType.PRICEPACKS;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<PromotionPricePacksVO> table;
	@FXML
	TableColumn<PromotionPricePacksVO, String> tableID;
	@FXML
	TableColumn<PromotionPricePacksVO, Double> tableAllowance;

	@FXML
	TableColumn<PromotionPricePacksVO, LocalDate> tableStart;
	@FXML
	TableColumn<PromotionPricePacksVO, LocalDate> tableEnd;
	@FXML
	TableColumn<PromotionPricePacksVO, String> tableCheck;
	@FXML
	TableColumn<PromotionPricePacksVO, String> tableDelete;

	@FXML
	TableView<GiftVO> commodityTable;
	@FXML
	TableColumn<GiftVO, String> tableName;
	@FXML
	TableColumn<GiftVO, Integer> tableNumber;
	@FXML
	TableColumn<GiftVO, String> tableDeleteCommodity;

	@FXML
	Label idLabel;
	@FXML
	TextField allowanceField;
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> commodityChoice;
	@FXML
	TextField numberField;

	@FXML
	public void find() throws RemoteException {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PromotionPricePacksVO> promotionList = service.find(findingField.getText(),
					FindPromotionType.getType(findChoice.getValue()));
			if (list == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(promotionList);
				table.setItems(list);
				initFind();
			}
		}
	}

	@FXML
	public void insert() throws RemoteException {
		if (startPicker.getValue() == null || endPicker.getValue() == null || allowanceField.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有的信息");
			warning.showAndWait();
		} else {
			ArrayList<GiftVO> gifts = new ArrayList<>();
			gifts = null;
			PromotionPricePacksVO vo = new PromotionPricePacksVO(idLabel.getText(), startPicker.getValue(),
					endPicker.getValue(), Double.parseDouble(allowanceField.getText()), gifts);
			ResultMessage message = service.insert(vo);
			Platform.runLater(new Runnable() {
				public void run() {
					try {
						switch (message) {
						case EXISTED:
							Alert existed = new Alert(Alert.AlertType.WARNING, "该策略已存在");
							existed.showAndWait();
							break;
						case SUCCESS:
							list.add(vo);
							table.setItems(list);
							initInsert();
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
		}
	}

	@FXML
	public void insertGift() {
		if (commodityChoice.getValue() == null || numberField.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有的信息");
			warning.showAndWait();
		} else if (currentPromotion == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请点击查看赠品列表选择需要赠品的策略");
			warning.showAndWait();
		} else {
			GiftVO vo = new GiftVO(commodityChoice.getValue(), Integer.parseInt(numberField.getText()));
			commodityList.add(vo);
			commodityTable.setItems(commodityList);
			updateGiftList();
			commodityChoice.setValue(null);
			numberField.setText(null);
		}
	}

	public void initFind() {
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert() throws RemoteException {
		idLabel.setText(service.getID());
		allowanceField.setText(null);
		startPicker.setValue(null);
		endPicker.setValue(null);
	}

	public void initData(UserVO user) throws Exception {
		judgeMessage();
		this.user = user;
		choiceInit();
		promotionChoice.setValue(type.value);
		list.clear();
		list.addAll(service.getPromotionList());
		table.setItems(list);
		initInsert();
		initFind();
		checkInit();
		deleteInit();
		deleteGiftInit();
		commodityChoiceList.addAll(commodityservice.getIDandName());
		commodityChoice.setItems(commodityChoiceList);

		findChoice.setItems(
				FXCollections.observableArrayList(FindPromotionType.ID.value, FindPromotionType.TIMEINTERVAL.value));
		edit();
		manageInit();
	}

	public void edit() {
		Callback<TableColumn<PromotionPricePacksVO, Double>, TableCell<PromotionPricePacksVO, Double>> cellFactoryDouble = (
				TableColumn<PromotionPricePacksVO, Double> p) -> new EditingCellDouble<PromotionPricePacksVO>();

		Callback<TableColumn<GiftVO, Integer>, TableCell<GiftVO, Integer>> cellFactoryInteger = (
				TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

		Callback<TableColumn<PromotionPricePacksVO, LocalDate>, TableCell<PromotionPricePacksVO, LocalDate>> dateFactory = (
				TableColumn<PromotionPricePacksVO, LocalDate> p) -> new EditingCellDate<PromotionPricePacksVO>();

		tableAllowance.setCellFactory(cellFactoryDouble);
		tableAllowance.setOnEditCommit((CellEditEvent<PromotionPricePacksVO, Double> t) -> {
			((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(t.getNewValue());
			try {
				service.update((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});
		tableStart.setCellFactory(dateFactory);
		tableStart.setOnEditCommit((CellEditEvent<PromotionPricePacksVO, LocalDate> t) -> {
			((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setBeginDate(t.getNewValue());
			try {
				service.update((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

		tableEnd.setCellFactory(dateFactory);
		tableEnd.setOnEditCommit((CellEditEvent<PromotionPricePacksVO, LocalDate> t) -> {
			((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setEndDate(t.getNewValue());
			try {
				service.update((PromotionPricePacksVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

		tableNumber.setCellFactory(cellFactoryInteger);
		tableNumber.setOnEditCommit((CellEditEvent<GiftVO, Integer> t) -> {
			((GiftVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumber(t.getNewValue());
			updateGiftList();

		});

	}

	public void manageInit() throws Exception {
		tableID.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, String>("id"));
		tableStart.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, LocalDate>("beginDate"));
		tableEnd.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, LocalDate>("endDate"));
		tableAllowance.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, Double>("discount"));
		tableName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
	}

	public void checkInit() {

		tableCheck.setCellFactory((col) -> {
			TableCell<PromotionPricePacksVO, String> cell = new TableCell<PromotionPricePacksVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看商品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionPricePacksVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							currentPromotion = clickedItem;
							commodityList.clear();
							if (clickedItem.getPricePacks() != null)
								commodityList.addAll(clickedItem.getPricePacks());
							commodityTable.setItems(commodityList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<PromotionPricePacksVO, String> cell = new TableCell<PromotionPricePacksVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionPricePacksVO clickedUser = this.getTableView().getItems().get(this.getIndex());
							try {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setContentText("确认删除？");
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									service.delete(clickedUser);
									list.remove(clickedUser);
									table.setItems(list);
								}
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						});
					}
				}

			};
			return cell;
		});

	}

	public void deleteGiftInit() {

		tableDeleteCommodity.setCellFactory((col) -> {
			TableCell<GiftVO, String> cell = new TableCell<GiftVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							GiftVO clickedUser = this.getTableView().getItems().get(this.getIndex());
							commodityList.remove(clickedUser);
							commodityTable.setItems(commodityList);
							updateGiftList();
						});
					}
				}

			};
			return cell;
		});
	}

	public void updateGiftList() {
		PromotionPricePacksVO promotion = currentPromotion;
		ArrayList<GiftVO> gifts = new ArrayList<>();
		gifts.addAll(commodityList);
		promotion.setPricePacks(gifts);
		try {
			service.update(promotion);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
