package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineSalesBillController;
import vo.uservo.UserVO;

public class ExamineSalesBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ExamineSalesBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ExamineSalesBillController controller = loader.<ExamineSalesBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
