package presentation.usermanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.usermanagerui.controller.UserMessageController;
import vo.uservo.UserVO;

public class UserMessageUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/UserMessageUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		UserMessageController controller = loader.<UserMessageController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
