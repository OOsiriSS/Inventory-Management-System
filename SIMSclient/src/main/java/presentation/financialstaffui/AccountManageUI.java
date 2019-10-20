package presentation.financialstaffui;

import presentation.financialstaffui.controller.AccountManageController;
import vo.uservo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AccountManageUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/AccountManageUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		AccountManageController controller = loader.<AccountManageController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
