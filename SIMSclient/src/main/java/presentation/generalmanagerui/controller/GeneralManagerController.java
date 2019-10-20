package presentation.generalmanagerui.controller;

import java.util.Stack;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import presentation.generalmanagerui.BussinessProcessTableUI;
import presentation.generalmanagerui.BussinessSituationTableUI;
import presentation.generalmanagerui.CheckInventoryBillUI;
import presentation.generalmanagerui.CheckPaymentBillUI;
import presentation.generalmanagerui.CheckPurchaseBillUI;
import presentation.generalmanagerui.CheckReceiveBillUI;
import presentation.generalmanagerui.CheckSalesBillUI;
import presentation.generalmanagerui.SaleDetailTableUI;
import presentation.generalmanagerui.ExamineBillUI;
import presentation.generalmanagerui.ExamineInventoryBillUI;
import presentation.generalmanagerui.ExaminePaymentBillUI;
import presentation.generalmanagerui.ExaminePurchaseBillUI;
import presentation.generalmanagerui.ExamineReceiveBillUI;
import presentation.generalmanagerui.ExamineSalesBillUI;
import presentation.generalmanagerui.FinanceTableUI;
import presentation.generalmanagerui.GeneralManagerUI;
import presentation.generalmanagerui.PromotionMakingUI;
import presentation.generalmanagerui.PromotionMemberUI;
import presentation.generalmanagerui.PromotionSpecialUI;
import presentation.generalmanagerui.PromotionSumUI;
import presentation.mainui.LoginController;
import presentation.mainui.MainUI;
import presentation.generalmanagerui.UserMessageUI;
import vo.uservo.UserVO;

public class GeneralManagerController extends LoginController {

	UtilityBLService utilityService = new UtilityBL();
	public static final String mainID = "GeneralManagerUI";
	static String previous;
	static String current;
	static Stack<String> stack;
	protected BillType billType;
	protected UserVO user;

	@FXML
	protected AnchorPane pane;
	@FXML
	protected ImageView image;

	@FXML
	public void returnLast() throws Exception {
		startUI(previous, user, billType);
		if (!stack.isEmpty()) {
			stack.pop();
			current = previous;
		}
		if (stack.size() > 1)
			previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception {
		changeStage(mainID, user, billType);

	}

	@FXML
	public void fresh() throws Exception {
		startUI(current, user, billType);
	}

	@FXML
	public void message() throws Exception {
		changeStage("UserMessageUI", user, billType);
	}

	@FXML
	public void logout() {
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					new MainUI().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void checkBill() throws Exception {
		changeStage("ExamineBillUI", user, billType);
	}

	@FXML
	public void checkTable() throws Exception {
		changeStage("FinanceTableUI", user, billType);
	}

	@FXML
	public void makePromotion() throws Exception {
		changeStage("PromotionMakingUI", user, billType);
	}

	public void initData(UserVO user) throws Exception {
		stack = new Stack<>();
		previous = current = mainID;
		stack.push(mainID);
		this.user = user;
		writeUser(user);
		judgeMessage();
		// image = user.getImage();
	}

	/**
	 * 切换fxml
	 * 
	 * @param currentID
	 *            当前fxml
	 * @param user
	 *            当前登录用户
	 * @param type
	 *            单据类型
	 * @throws Exception
	 */

	public void changeStage(String currentID, UserVO user, BillType type) throws Exception {
		startUI(currentID, user, type);
		previous = current;
		current = currentID;
		stack.push(current);
	}

	public void startUI(String currentID, UserVO user, BillType bill) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (currentID) {
					case mainID:
						new GeneralManagerUI().start(user);
						break;
					case "PromotionMakingUI":
						new PromotionMakingUI().start(user);
						break;
					case "PromotionMemberUI":
						new PromotionMemberUI().start(user);
						break;
					case "PromotionSpecialUI":
						new PromotionSpecialUI().start(user);
						break;
					case "PromotionSumUI":
						new PromotionSumUI().start(user);
						break;
					case "ExamineBillUI":
						new ExamineBillUI().start(user);
						break;
					case "ExamineInventoryBillUI":
						new ExamineInventoryBillUI().start(user);
						break;
					case "ExaminePaymentBillUI":
						new ExaminePaymentBillUI().start(user);
						break;
					case "ExaminePurchaseBillUI":
						new ExaminePurchaseBillUI().start(user);
						break;
					case "ExamineReceiveBillUI":
						new ExamineReceiveBillUI().start(user);
						break;
					case "ExamineSalesBillUI":
						new ExamineSalesBillUI().start(user);
						break;
					case "UserMessageUI":
						new UserMessageUI().start(user);
						break;
					case "BussinessProcessTableUI":
						new BussinessProcessTableUI().start(user);
						break;
					case "BussinessSituationTableUI":
						new BussinessSituationTableUI().start(user);
						break;
					case "SaleDetailTableUI":
						new SaleDetailTableUI().start(user);
						break;
					case "CheckInventoryBillUI":
						new CheckInventoryBillUI().start(user);
						break;
					case "CheckPaymentBillUI":
						new CheckPaymentBillUI().start(user);
						break;
					case "CheckPurchaseBillUI":
						new CheckPurchaseBillUI().start(user);
						break;
					case "CheckReceiveBillUI":
						new CheckReceiveBillUI().start(user);
						break;
					case "CheckSalesBillUI":
						new CheckSalesBillUI().start(user);
						break;
					case "FinanceTableUI":
						new FinanceTableUI().start(user);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * 判断是否有新信息
	 */
	public void judgeMessage() {
		if (utilityService.hasMessage(readUser())) {
			Circle circle = new Circle();
			circle.setCenterX(0);
			circle.setCenterY(0);
			circle.setLayoutX(377);
			circle.setLayoutY(16);
			circle.setRadius(7);
			circle.setFill(Paint.valueOf("#ff1f1f"));
			pane.getChildren().add(circle);
		}
	}

}
