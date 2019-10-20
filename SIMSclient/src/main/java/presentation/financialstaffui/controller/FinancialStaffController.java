package presentation.financialstaffui.controller;

import java.util.Stack;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import presentation.financialstaffui.AccountManageUI;
import presentation.financialstaffui.BussinessProcessTableUI;
import presentation.financialstaffui.BussinessSituationTableUI;
import presentation.financialstaffui.CheckInventoryBillUI;
import presentation.financialstaffui.CheckPaymentBillUI;
import presentation.financialstaffui.CheckPurchaseBillUI;
import presentation.financialstaffui.CheckReceiveBillUI;
import presentation.financialstaffui.CheckSalesBillUI;
import presentation.financialstaffui.FinancialStaffUI;
import presentation.financialstaffui.InitAccountUI;
import presentation.financialstaffui.MakeReceiptUI;
import presentation.financialstaffui.PaymentCheckBillUI;
import presentation.financialstaffui.PaymentMakeBillUI;
import presentation.financialstaffui.ReceiveCheckBillUI;
import presentation.financialstaffui.ReceiveMakeBillUI;
import presentation.financialstaffui.SaleDetailTableUI;
import presentation.financialstaffui.UserMessageUI;
import presentation.financialstaffui.ViewTableUI;
import presentation.mainui.LoginController;
import presentation.mainui.MainUI;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;

public class FinancialStaffController extends LoginController {

	UtilityBLService utilityService = new UtilityBL();
	public static final String mainID = "FinancialStaffUI";
	static String previous;
	static String current;
	static Stack<String> stack;
	UserVO user;
	PaymentBillVO pay;
	ReceiptBillVO rec;
	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;

	@FXML
	public void returnLast() throws Exception {
		startUI(previous, user, null, null);
		if (!stack.isEmpty()) {
			stack.pop();
			current = previous;
		}
		if (stack.size() > 1)
			previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception {
		changeStage(mainID, user, null, null);

	}

	@FXML
	public void fresh() throws Exception {
		startUI(current, user, null, null);
	}

	@FXML
	public void message() throws Exception {
		changeStage("UserMessageUI", user, null, null);
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
	public void accountManage() throws Exception {
		changeStage("AccountManageUI", user, null, null);
	}

	@FXML
	public void makeReceipt() throws Exception {
		changeStage("MakeReceiptUI", user, null, null);
	}

	@FXML
	public void viewTable() throws Exception {
		changeStage("ViewTableUI", user, null, null);
	}

	@FXML
	public void initAccount() throws Exception {
		changeStage("InitAccountUI", user, null, null);
	}

	public void initData(UserVO user) throws Exception {
		stack = new Stack<>();
		previous = current = mainID;
		stack.push(mainID);
		this.user = user;
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
	 * @param bill1
	 *            付款单
	 * @param bill2
	 *            收款单
	 * @throws Exception
	 */

	public void changeStage(String currentID, UserVO user, PaymentBillVO bill1, ReceiptBillVO bill2) throws Exception {

		startUI(currentID, user, bill1, bill2);
		previous = current;
		current = currentID;
		stack.push(current);
	}

	public void startUI(String currentID, UserVO user, PaymentBillVO bill1, ReceiptBillVO bill2) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (currentID) {
					case mainID:
						new FinancialStaffUI().start(user);
						break;
					case "UserMessageUI":
						new UserMessageUI().start(user);
						break;
					case "AccountManageUI":
						new AccountManageUI().start(user);
						break;
					case "MakeReceiptUI":
						new MakeReceiptUI().start(user);
						break;
					case "PaymentMakeBillUI":
						new PaymentMakeBillUI().start(user, bill1);
						break;
					case "PaymentCheckBillUI":
						new PaymentCheckBillUI().start(user);
						break;
					case "ReceiveMakeBillUI":
						new ReceiveMakeBillUI().start(user, bill2);
						break;
					case "ReceiveCheckBillUI":
						new ReceiveCheckBillUI().start(user);
						break;
					case "ViewTableUI":
						new ViewTableUI().start(user);
						break;
					case "InitAccountUI":
						new InitAccountUI().start(user);
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
