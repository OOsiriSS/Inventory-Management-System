package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.SaleDetailTableController;
import vo.uservo.UserVO;

public class SaleDetailTableUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SaleDetailTableUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		SaleDetailTableController controller = loader.<SaleDetailTableController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
