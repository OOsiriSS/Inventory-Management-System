package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogic.promotionbl.PromotionMemberBL;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberLevel;
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
import vo.promotionvo.PromotionMemberVO;
import vo.uservo.UserVO;

public class PromotionMemberController extends PromotionMakingController {

	PromotionBLService<PromotionMemberVO> service = new PromotionMemberBL();
	CommodityBLService commodityservice = new CommodityController();
	PromotionType type = PromotionType.LEVEL_PROMOTION;
	ObservableList<PromotionMemberVO> list = FXCollections.observableArrayList();
	ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
	ObservableList<String> giftChoiceList = FXCollections.observableArrayList();
	ObservableList<String> levelList = FXCollections.observableArrayList(MemberLevel.LEVEL1.value,
			MemberLevel.LEVEL2.value, MemberLevel.LEVEL3.value, MemberLevel.LEVEL4.value, MemberLevel.LEVEL5.value);
	UserVO user;
	PromotionMemberVO currentPromotion;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<PromotionMemberVO> table;
	@FXML
	TableColumn<PromotionMemberVO, String> tableID;
	@FXML
	TableColumn<PromotionMemberVO, String> tableLevel;
	@FXML
	TableColumn<PromotionMemberVO, Double> tableAllowance;
	@FXML
	TableColumn<PromotionMemberVO, Double> tableVoucher;
	@FXML
	TableColumn<PromotionMemberVO, LocalDate> tableStart;
	@FXML
	TableColumn<PromotionMemberVO, LocalDate> tableEnd;
	@FXML
	TableColumn<PromotionMemberVO, String> tableCheck;
	@FXML
	TableColumn<PromotionMemberVO, String> tableDelete;

	@FXML
	TableView<GiftVO> giftTable;
	@FXML
	TableColumn<GiftVO, String> tableName;
	@FXML
	TableColumn<GiftVO, Integer> tableNumber;
	@FXML
	TableColumn<GiftVO, String> tableDeleteGift;

	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> levelChoice;
	@FXML
	TextField allowanceField;
	@FXML
	TextField voucherField;
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> giftChoice;
	@FXML
	TextField numberField;

	@FXML
	public void find() throws RemoteException {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<PromotionMemberVO> promotionList = service.find(findingField.getText(),
					FindPromotionType.getType(findChoice.getValue()));
			if (promotionList == null) {
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
		if (startPicker.getValue() == null || endPicker.getValue() == null || levelChoice.getValue() == null
				|| allowanceField.getText() == null || voucherField.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有的信息");
			warning.showAndWait();
		} else {
			ArrayList<GiftVO> gifts = null;
			PromotionMemberVO vo = new PromotionMemberVO(idLabel.getText(), startPicker.getValue(),
					endPicker.getValue(), MemberLevel.getLevel(levelChoice.getValue()),
					Double.parseDouble(allowanceField.getText()), Double.parseDouble(voucherField.getText()), gifts);
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
	public void insertGift() throws RemoteException {
		if (giftChoice.getValue() == null || numberField.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有的信息");
			warning.showAndWait();
		} else if (currentPromotion == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请点击查看赠品列表选择需要赠品的策略");
			warning.showAndWait();
		} else {
			GiftVO vo = new GiftVO(giftChoice.getValue(), Integer.parseInt(numberField.getText()));
			giftList.add(vo);
			giftTable.setItems(giftList);
			updateGiftList();
			giftChoice.setValue(null);
			numberField.setText(null);
		}
	}

	public void initFind() {
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert() throws RemoteException {
		if (service.getID() != null)
			idLabel.setText(service.getID());
		else
			idLabel.setText(null);
		levelChoice.setValue(null);
		allowanceField.setText(null);
		voucherField.setText(null);
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
		edit();
		manageInit();
		checkInit();
		deleteInit();
		deleteGiftInit();
		giftChoiceList.addAll(commodityservice.getIDandName());
		giftChoice.setItems(giftChoiceList);
		levelChoice.setItems(levelList);
		findChoice.setItems(
				FXCollections.observableArrayList(FindPromotionType.ID.value, FindPromotionType.TIMEINTERVAL.value));
	}

	public void edit() {
		Callback<TableColumn<PromotionMemberVO, Double>, TableCell<PromotionMemberVO, Double>> cellFactoryDouble = (
				TableColumn<PromotionMemberVO, Double> p) -> new EditingCellDouble<PromotionMemberVO>();

		Callback<TableColumn<GiftVO, Integer>, TableCell<GiftVO, Integer>> cellFactoryInteger = (
				TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

		Callback<TableColumn<PromotionMemberVO, LocalDate>, TableCell<PromotionMemberVO, LocalDate>> dateFactory = (
				TableColumn<PromotionMemberVO, LocalDate> p) -> new EditingCellDate<PromotionMemberVO>();

		tableAllowance.setCellFactory(cellFactoryDouble);
		tableAllowance.setOnEditCommit((CellEditEvent<PromotionMemberVO, Double> t) -> {
			((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setAllowance(t.getNewValue());
			try {
				service.update((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

		tableVoucher.setCellFactory(cellFactoryDouble);
		tableVoucher.setOnEditCommit((CellEditEvent<PromotionMemberVO, Double> t) -> {
			((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setVoucher(t.getNewValue());
			try {
				service.update((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

		tableStart.setCellFactory(dateFactory);
		tableStart.setOnEditCommit((CellEditEvent<PromotionMemberVO, LocalDate> t) -> {
			((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setBeginDate(t.getNewValue());
			try {
				service.update((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		tableEnd.setCellFactory(dateFactory);
		tableEnd.setOnEditCommit((CellEditEvent<PromotionMemberVO, LocalDate> t) -> {
			((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setEndDate(t.getNewValue());
			try {
				service.update((PromotionMemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

		tableNumber.setCellFactory(cellFactoryInteger);
		tableNumber.setOnEditCommit((CellEditEvent<GiftVO, Integer> t) -> {
			((GiftVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumber(t.getNewValue());
			try {
				updateGiftList();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		});

	}

	public void manageInit() throws Exception {
		tableID.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, String>("id"));
		tableLevel.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, String>("levelString"));
		tableStart.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, LocalDate>("beginDate"));
		tableEnd.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, LocalDate>("endDate"));
		tableAllowance.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, Double>("allowance"));
		tableVoucher.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, Double>("voucher"));

		tableName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
	}

	public void checkInit() {

		tableCheck.setCellFactory((col) -> {
			TableCell<PromotionMemberVO, String> cell = new TableCell<PromotionMemberVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看赠品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionMemberVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							currentPromotion = clickedItem;
							giftList.clear();
							if (clickedItem.getGifts() != null)
								giftList.addAll(clickedItem.getGifts());
							giftTable.setItems(giftList);
						});
					}
				}

			};
			return cell;
		});

	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<PromotionMemberVO, String> cell = new TableCell<PromotionMemberVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionMemberVO clickedUser = this.getTableView().getItems().get(this.getIndex());
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

		tableDeleteGift.setCellFactory((col) -> {
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
							giftList.remove(clickedUser);
							giftTable.setItems(giftList);
							try {
								updateGiftList();
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

	public void updateGiftList() throws RemoteException {
		PromotionMemberVO promotion = currentPromotion;
		ArrayList<GiftVO> gifts = new ArrayList<>();
		gifts.addAll(giftList);
		promotion.setGifts(gifts);
		service.update(promotion);
	}

}