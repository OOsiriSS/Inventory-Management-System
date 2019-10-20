package presentation.usermanagerui.controller;

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
import presentation.mainui.LoginController;
import presentation.mainui.MainUI;
import presentation.usermanagerui.UserManagerUI;
import presentation.usermanagerui.UserManagingUI;
import presentation.usermanagerui.UserMessageUI;
import vo.uservo.UserVO;

public class UserManagerController extends LoginController {

	UtilityBLService utilityService = new UtilityBL();
	public static final String mainID = "UserManagerUI";
	static String previous;
	static String current;
	static Stack<String> stack;

	UserVO user;

	@FXML
	protected AnchorPane pane;
	@FXML
	protected ImageView image;

	@FXML
	public void returnLast() throws Exception {
		startUI(previous);
		if (!stack.isEmpty()) {
			stack.pop();
			current = previous;
		}
		if (stack.size() > 1)
			previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception {
		changeStage(mainID);

	}

	@FXML
	public void fresh() throws Exception {
		startUI(current);
	}

	@FXML
	public void message() throws Exception {
		changeStage("UserMessageUI");
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
	public void manage() throws Exception {
		changeStage("UserManagingUI");
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

	public void changeStage(String currentID) throws Exception {

		startUI(currentID);
		previous = current;
		current = currentID;
		stack.push(current);
	}

	public void startUI(String currentID) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (currentID) {
					case mainID:
						new UserManagerUI().start(user);
						break;
					case "UserManagingUI":
						new UserManagingUI().start(user);
						break;
					case "UserMessageUI":
						new UserMessageUI().start(user);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

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
