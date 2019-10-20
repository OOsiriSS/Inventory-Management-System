package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.ReceiveCheckBillController;
import vo.uservo.UserVO;

public class ReceiveCheckBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ReceiveCheckBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ReceiveCheckBillController controller = loader.<ReceiveCheckBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
