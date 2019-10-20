package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.GeneralManagerController;
import vo.uservo.UserVO;

public class GeneralManagerUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/GeneralManagerUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		GeneralManagerController controller = loader.<GeneralManagerController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
