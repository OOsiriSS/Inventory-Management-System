package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineReceiveBillController;
import vo.uservo.UserVO;

public class ExamineReceiveBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ExamineReceiveBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ExamineReceiveBillController controller = loader.<ExamineReceiveBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
