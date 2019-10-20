package presentation.inventorymanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.controller.ClassManageController;
import vo.uservo.UserVO;

public class ClassManageUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ClassManageUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ClassManageController controller = loader.<ClassManageController>getController();
		controller.initData(user);
		primaryStage.show();

	}

}
