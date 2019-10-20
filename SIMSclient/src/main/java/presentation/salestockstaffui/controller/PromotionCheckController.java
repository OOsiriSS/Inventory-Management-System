package presentation.salestockstaffui.controller;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.salesbl.info.Sale_Promotion;
import bussinesslogicservice.salesblservice.Sale_PromotionInfo;
import dataenum.BillType;
import dataenum.PromotionType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.billvo.salesbillvo.SalesPriceVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
import vo.promotionvo.PromotionVO;
import vo.uservo.UserVO;

/**
 * 用于销售的策略查看界面
 * 
 * @author 潘星宇 2017-12-10
 */
public class PromotionCheckController extends SaleStockStaffController {

	Sale_PromotionInfo service = new Sale_Promotion();
	// 当前的促销策略
	PromotionMemberVO currentMember;
	PromotionPricePacksVO currentSpecial;
	PromotionTotalVO currentSum;
	ObservableList<GiftVO> memberList = FXCollections.observableArrayList();
	ObservableList<GiftVO> specialList = FXCollections.observableArrayList();
	ObservableList<GiftVO> sumList = FXCollections.observableArrayList();
	ObservableList<PromotionVO> choiceList = FXCollections.observableArrayList();
	// 客户等级
	@FXML
	TableView<PromotionMemberVO> member;
	@FXML
	TableColumn<PromotionMemberVO, String> memberID;
	@FXML
	TableColumn<PromotionMemberVO, String> memberLevel;
	@FXML
	TableColumn<PromotionMemberVO, Double> memberAllowance;
	@FXML
	TableColumn<PromotionMemberVO, Double> memberVoucher;
	@FXML
	TableColumn<PromotionMemberVO, LocalDate> memberStart;
	@FXML
	TableColumn<PromotionMemberVO, LocalDate> memberEnd;
	@FXML
	TableColumn<PromotionMemberVO, String> memberCheck;
	@FXML
	TableColumn<PromotionMemberVO, String> memberPromotion;
	@FXML
	TableView<GiftVO> memberGift;
	@FXML
	TableColumn<GiftVO, String> memberName;
	@FXML
	TableColumn<GiftVO, Integer> memberNumber;

	// 特价包
	@FXML
	TableView<PromotionPricePacksVO> special;
	@FXML
	TableColumn<PromotionPricePacksVO, String> specialID;
	@FXML
	TableColumn<PromotionPricePacksVO, Double> specialAllowance;

	@FXML
	TableColumn<PromotionPricePacksVO, LocalDate> specialStart;
	@FXML
	TableColumn<PromotionPricePacksVO, LocalDate> specialEnd;
	@FXML
	TableColumn<PromotionPricePacksVO, String> specialCheck;
	@FXML
	TableColumn<PromotionPricePacksVO, String> specialPromotion;

	@FXML
	TableView<GiftVO> specialCommodity;
	@FXML
	TableColumn<GiftVO, String> specialName;
	@FXML
	TableColumn<GiftVO, Integer> specialNumber;

	// 总价
	@FXML
	TableView<PromotionTotalVO> sum;
	@FXML
	TableColumn<PromotionTotalVO, String> sumID;
	@FXML
	TableColumn<PromotionTotalVO, Double> sumUp;
	@FXML
	TableColumn<PromotionTotalVO, Double> sumVoucher;
	@FXML
	TableColumn<PromotionTotalVO, LocalDate> sumStart;
	@FXML
	TableColumn<PromotionTotalVO, LocalDate> sumEnd;
	@FXML
	TableColumn<PromotionTotalVO, String> sumCheck;
	@FXML
	TableColumn<PromotionTotalVO, String> sumPromotion;

	@FXML
	TableView<GiftVO> sumGift;
	@FXML
	TableColumn<GiftVO, String> sumName;
	@FXML
	TableColumn<GiftVO, Integer> sumNumber;

	// 选择
	@FXML
	TableView<PromotionVO> choice;
	@FXML
	TableColumn<PromotionVO, String> choiceID;
	@FXML
	TableColumn<PromotionVO, String> choiceType;
	@FXML
	TableColumn<PromotionVO, LocalDate> choiceStart;
	@FXML
	TableColumn<PromotionVO, LocalDate> choiceEnd;
	@FXML
	TableColumn<PromotionVO, String> choiceDelete;

	@FXML
	public void confirm() throws Exception {
		ArrayList<PromotionVO> promotionList = new ArrayList<>();
		promotionList.addAll(choiceList);
		SalesPriceVO vo = service.getPromotionPrice(promotionList);
		sale.setAllowance(vo.getAllowance());
		sale.setVoucher(vo.getVoucher());
		sale.setAfterPrice(sale.getBeforePrice() - sale.getAllowance() - sale.getVoucher());
		sale.setGifts(vo.getGifts());
		changeStage("SalesMakeBillUI", user, type, null, sale);
	}

	@FXML
	public void backSales() throws Exception {
		changeStage("SalesMakeBillUI", user, type, null, sale);
	}

	public void initData(UserVO user, BillType type, SalesVO sale) throws RemoteException {
		this.user = user;
		this.type = type;
		this.sale = sale;
		judgeMessage();
		manageMemberInit();
		manageSpecialInit();
		manageSumInit();
		manageChoiceInit();
		ObservableList<PromotionMemberVO> memberTable = FXCollections.observableArrayList();
		ObservableList<PromotionPricePacksVO> specialTable = FXCollections.observableArrayList();
		ObservableList<PromotionTotalVO> sumTable = FXCollections.observableArrayList();
		memberTable.addAll(service.findMemberPromotion(sale.getRetailerID()));
		specialTable.addAll(service.findPricePacksPromotion(sale.getCommodity()));
		sumTable.addAll(service.findTotalPromotion(sale.getBeforePrice()));
		member.setItems(memberTable);
		special.setItems(specialTable);
		sum.setItems(sumTable);

	}

	/**
	 * 各个表格的初始化
	 */

	public void manageMemberInit() {
		memberID.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, String>("id"));
		memberLevel.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, String>("levelString"));
		memberStart.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, LocalDate>("beginDate"));
		memberEnd.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, LocalDate>("endDate"));
		memberAllowance.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, Double>("allowance"));
		memberVoucher.setCellValueFactory(new PropertyValueFactory<PromotionMemberVO, Double>("voucher"));

		memberName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		memberNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
		checkMemberInit();
		promotionMemberInit();
	}

	public void manageSpecialInit() {
		specialID.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, String>("id"));
		specialStart.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, LocalDate>("beginDate"));
		specialEnd.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, LocalDate>("endDate"));
		specialAllowance.setCellValueFactory(new PropertyValueFactory<PromotionPricePacksVO, Double>("discount"));

		specialName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		specialNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
		checkSpecialInit();
		promotionSpecialInit();
	}

	public void manageSumInit() {
		sumID.setCellValueFactory(new PropertyValueFactory<PromotionTotalVO, String>("id"));
		sumUp.setCellValueFactory(new PropertyValueFactory<PromotionTotalVO, Double>("total"));
		sumStart.setCellValueFactory(new PropertyValueFactory<PromotionTotalVO, LocalDate>("beginDate"));
		sumEnd.setCellValueFactory(new PropertyValueFactory<PromotionTotalVO, LocalDate>("endDate"));
		sumVoucher.setCellValueFactory(new PropertyValueFactory<PromotionTotalVO, Double>("voucher"));

		sumName.setCellValueFactory(new PropertyValueFactory<GiftVO, String>("name"));
		sumNumber.setCellValueFactory(new PropertyValueFactory<GiftVO, Integer>("number"));
		checkSumInit();
		promotionSumInit();
	}

	public void manageChoiceInit() {
		choiceID.setCellValueFactory(new PropertyValueFactory<PromotionVO, String>("id"));
		choiceType.setCellValueFactory(new PropertyValueFactory<PromotionVO, String>("typeString"));
		choiceStart.setCellValueFactory(new PropertyValueFactory<PromotionVO, LocalDate>("beginDate"));
		choiceEnd.setCellValueFactory(new PropertyValueFactory<PromotionVO, LocalDate>("endDate"));
		deleteInit();
	}

	public void checkMemberInit() {

		memberCheck.setCellFactory((col) -> {
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
							currentMember = clickedItem;
							memberList.clear();
							memberList.addAll(clickedItem.getGifts());
							memberGift.setItems(memberList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void checkSpecialInit() {
		specialCheck.setCellFactory((col) -> {
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
							currentSpecial = clickedItem;
							specialList.clear();
							specialList.addAll(clickedItem.getPricePacks());
							specialCommodity.setItems(specialList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void checkSumInit() {
		sumCheck.setCellFactory((col) -> {
			TableCell<PromotionTotalVO, String> cell = new TableCell<PromotionTotalVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("查看赠品列表");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionTotalVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							currentSum = clickedItem;
							sumList.clear();
							sumList.addAll(clickedItem.getGifts());
							sumGift.setItems(sumList);

						});
					}
				}

			};
			return cell;
		});

	}

	public void promotionMemberInit() {
		memberPromotion.setCellFactory((col) -> {
			TableCell<PromotionMemberVO, String> cell = new TableCell<PromotionMemberVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("使用策略");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionMemberVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							for (int i = 0; i < choiceList.size(); i++)
								if (choiceList.get(i).getType() == PromotionType.LEVEL_PROMOTION)
									choiceList.remove(i); // 每种策略最多能选一个
							choiceList.add(clickedItem);
							choice.setItems(choiceList);
						});
					}
				}

			};
			return cell;
		});
	}

	public void promotionSpecialInit() {
		specialPromotion.setCellFactory((col) -> {
			TableCell<PromotionPricePacksVO, String> cell = new TableCell<PromotionPricePacksVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("使用策略");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionPricePacksVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							for (int i = 0; i < choiceList.size(); i++)
								if (choiceList.get(i).getType() == PromotionType.PRICEPACKS)
									choiceList.remove(i); // 每种策略最多能选一个
							choiceList.add(clickedItem);
							choice.setItems(choiceList);
						});
					}
				}

			};
			return cell;
		});
	}

	public void promotionSumInit() {
		sumPromotion.setCellFactory((col) -> {
			TableCell<PromotionTotalVO, String> cell = new TableCell<PromotionTotalVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("使用策略");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionTotalVO clickedItem = this.getTableView().getItems().get(this.getIndex());
							for (int i = 0; i < choiceList.size(); i++)
								if (choiceList.get(i).getType() == PromotionType.SUM_PROMOTION)
									choiceList.remove(i); // 每种策略最多能选一个
							choiceList.add(clickedItem);
							choice.setItems(choiceList);
						});
					}
				}

			};
			return cell;
		});
	}

	public void deleteInit() {
		choiceDelete.setCellFactory((col) -> {
			TableCell<PromotionVO, String> cell = new TableCell<PromotionVO, String>() {
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							PromotionVO clickedUser = this.getTableView().getItems().get(this.getIndex());
							choiceList.remove(clickedUser);
							choice.setItems(choiceList);
						});
					}
				}

			};
			return cell;
		});

	}

}
