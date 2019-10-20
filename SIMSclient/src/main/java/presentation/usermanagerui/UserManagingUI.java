package presentation.usermanagerui;

import presentation.usermanagerui.controller.UserManagingController;

import vo.uservo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserManagingUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/UserManagingUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		UserManagingController controller = loader.<UserManagingController>getController();
		controller.initData(user);
		primaryStage.show();
	}
}
