package presentation.usermanagerui;

import presentation.usermanagerui.controller.UserManagerController;

import vo.uservo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserManagerUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/UserManagerUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		UserManagerController controller = loader.<UserManagerController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
