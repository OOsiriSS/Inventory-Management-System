package presentation.inventorymanagerui.controller;

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
import presentation.inventorymanagerui.CheckReceiptUI;
import presentation.inventorymanagerui.ClassManageUI;
import presentation.inventorymanagerui.CommodityManageUI;
import presentation.inventorymanagerui.InventoryCheckUI;
import presentation.inventorymanagerui.InventoryManagerUI;
import presentation.inventorymanagerui.InventoryStockUI;
import presentation.inventorymanagerui.MakeReceiptUI;
import presentation.inventorymanagerui.UserMessageUI;
import presentation.mainui.LoginController;
import presentation.mainui.MainUI;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.uservo.UserVO;

public class InventoryManagerController extends LoginController {

	UtilityBLService utilityService = new UtilityBL();
	public static final String mainID = "InventoryManagerUI";
	static String previous;
	static String current;
	static Stack<String> stack;
	UserVO user;
	BillType type;
	InventoryBillVO inv;

	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;

	@FXML
	public void returnLast() throws Exception {
		startUI(previous, user, type, inv);
		if (!stack.isEmpty()) {
			stack.pop();
			current = previous;
		}
		if (stack.size() > 1)
			previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception {
		changeStage(mainID, user, type, inv);

	}

	@FXML
	public void fresh() throws Exception {
		startUI(current, user, type, inv);
	}

	@FXML
	public void message() throws Exception {
		changeStage("UserMessageUI", user, type, inv);
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
	public void classManage() throws Exception {
		changeStage("ClassManageUI", user, type, inv);
	}

	@FXML
	public void commodityManage() throws Exception {
		changeStage("CommodityManageUI", user, type, inv);
	}

	@FXML
	public void inventoryCheck() throws Exception {
		changeStage("InventoryCheckUI", user, type, inv);
	}

	@FXML
	public void inventoryStock() throws Exception {
		changeStage("InventoryStockUI", user, type, inv);
	}

	@FXML
	public void makeReceipt() throws Exception {
		changeStage("MakeReceiptUI", user, type, inv);
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
	 * 用于切换fxml
	 * 
	 * @param currentID
	 *            新的fxml
	 * @param user
	 *            当前登录用户
	 * @param type
	 *            单据类型
	 * @param inv
	 *            库存单据
	 * @throws Exception
	 */

	public void changeStage(String currentID, UserVO user, BillType type, InventoryBillVO inv) throws Exception {

		startUI(currentID, user, type, inv);
		previous = current;
		current = currentID;
		stack.push(current);
	}

	public void startUI(String currentID, UserVO user, BillType type, InventoryBillVO inv) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (currentID) {
					case mainID:
						new InventoryManagerUI().start(user);
						break;
					case "MakeReceiptUI":
						new MakeReceiptUI().start(user, type, inv);
						break;
					case "CheckReceiptUI":
						new CheckReceiptUI().start(user, type);
						break;
					case "CommodityManageUI":
						new CommodityManageUI().start(user);
						break;
					case "InventoryStockUI":
						new InventoryStockUI().start(user);
						break;
					case "ClassManageUI":
						new ClassManageUI().start(user);
						break;
					case "UserMessageUI":
						new UserMessageUI().start(user);
						break;
					case "InventoryCheckUI":
						new InventoryCheckUI().start(user);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * 判断是否有信息
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
