package presentation.financialstaffui.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbookbl.AccountBookController;
import bussinesslogicservice.accountbookblservice.AccountBookBLService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.accountbookvo.AccountBookVO;
import vo.accountvo.AccountVO;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;
import vo.uservo.UserVO;

/**
 * 期初建账界面
 *
 * @author 潘星宇
 *
 */
public class InitAccountController extends FinancialStaffController {

	AccountBookBLService service = new AccountBookController();
	ObservableList<CommodityVO> commodityList = FXCollections.observableArrayList();
	ObservableList<MemberVO> memberList = FXCollections.observableArrayList();
	ObservableList<AccountVO> accountList = FXCollections.observableArrayList();
	@FXML
	ComboBox<Integer> yearChoice;
	// 商品
	@FXML
	protected TableView<CommodityVO> commodity;
	@FXML
	protected TableColumn<CommodityVO, String> commodityName;
	@FXML
	protected TableColumn<CommodityVO, String> commodityModel;
	@FXML
	protected TableColumn<CommodityVO, String> commodityClass;
	@FXML
	protected TableColumn<CommodityVO, Double> commodityPurPrice;
	@FXML
	protected TableColumn<CommodityVO, Double> commodityRetailedPrice;
	@FXML
	protected TableColumn<CommodityVO, Double> commodityRecPurPrice;
	@FXML
	protected TableColumn<CommodityVO, Double> commodityRecRetailedPrice;
	// 会员
	@FXML
	protected TableView<MemberVO> member;
	@FXML
	protected TableColumn<MemberVO, String> memberCategory;
	@FXML
	protected TableColumn<MemberVO, String> memberName;
	@FXML
	protected TableColumn<MemberVO, String> memberPhone;
	@FXML
	protected TableColumn<MemberVO, String> memberReceive;
	@FXML
	protected TableColumn<MemberVO, String> memberPay;
	// 账户
	@FXML
	protected TableView<AccountVO> account;
	@FXML
	protected TableColumn<AccountVO, String> accountName;
	@FXML
	protected TableColumn<AccountVO, Double> accountMoney;

	public void manageInit() {
		// 商品
		commodityName.setCellValueFactory(new PropertyValueFactory<CommodityVO, String>("name"));
		commodityModel.setCellValueFactory(new PropertyValueFactory<CommodityVO, String>("model"));
		commodityClass.setCellValueFactory(
				(TableColumn.CellDataFeatures<CommodityVO, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getClassification()));
		commodityPurPrice.setCellValueFactory(new PropertyValueFactory<CommodityVO, Double>("purPrice"));
		commodityRetailedPrice.setCellValueFactory(new PropertyValueFactory<CommodityVO, Double>("retailedPrice"));
		commodityRecPurPrice.setCellValueFactory(new PropertyValueFactory<CommodityVO, Double>("recentPurPrice"));
		commodityRecRetailedPrice
				.setCellValueFactory(new PropertyValueFactory<CommodityVO, Double>("recentRetailedPrice"));
		// 会员

		memberCategory.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("categoryStr"));
		memberName.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("name"));
		memberPhone.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("cellNumber"));
		memberReceive.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("receivable"));
		memberPay.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("payable"));
		// 账户
		accountName.setCellValueFactory(new PropertyValueFactory<AccountVO, String>("name"));
		accountMoney.setCellValueFactory(new PropertyValueFactory<AccountVO, Double>("money"));

	}

	@FXML
	public void check() {
		commodityList.clear();
		memberList.clear();
		accountList.clear();
		AccountBookVO book = service.choseByYear(yearChoice.getValue());
		if (book != null) {
			commodityList.addAll(book.getCommodityVOs());
			memberList.addAll(book.getMemeberVOs());
			accountList.addAll(book.getAccountVOs());
			commodity.setItems(commodityList);
			member.setItems(memberList);
			account.setItems(accountList);
		}

	}

	@FXML
	public void init() {
		if (yearChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择年份");
			warning.showAndWait();
		}
		ArrayList<CommodityVO> commoditylist = new ArrayList<>();
		ArrayList<MemberVO> memberlist = new ArrayList<>();
		ArrayList<AccountVO> accountlist = new ArrayList<>();
		commoditylist.addAll(commodityList);
		memberlist.addAll(memberList);
		accountlist.addAll(accountList);
		AccountBookVO vo = new AccountBookVO(String.valueOf(yearChoice.getValue()), user.getName(), commoditylist,
				memberlist, accountlist);
		service.newBuild(vo);
	}

	public void initData(UserVO user) {
		this.user = user;
		judgeMessage();
		ObservableList<Integer> list = FXCollections.observableArrayList();
		for (int i = LocalDate.now().getYear(); i >= 2000; i--)
			list.add(i);
		yearChoice.setItems(list);
		manageInit();
	}

}
