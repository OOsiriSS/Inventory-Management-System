package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.CheckReceiveBillController;
import vo.uservo.UserVO;

public class CheckReceiveBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckReceiveBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		CheckReceiveBillController controller = loader.<CheckReceiveBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
