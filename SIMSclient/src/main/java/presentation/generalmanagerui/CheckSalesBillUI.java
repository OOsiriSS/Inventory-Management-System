package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.CheckSalesBillController;
import vo.uservo.UserVO;

public class CheckSalesBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckSalesBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		CheckSalesBillController controller = loader.<CheckSalesBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
