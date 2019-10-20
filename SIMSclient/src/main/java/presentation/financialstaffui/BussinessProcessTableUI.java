package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.BussinessProcessTableController;
import vo.uservo.UserVO;

public class BussinessProcessTableUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/BussinessProcessTableUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		BussinessProcessTableController controller = loader.<BussinessProcessTableController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
