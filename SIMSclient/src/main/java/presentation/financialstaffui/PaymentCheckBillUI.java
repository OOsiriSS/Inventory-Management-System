package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.PaymentCheckBillController;
import vo.uservo.UserVO;

public class PaymentCheckBillUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PaymentCheckBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PaymentCheckBillController controller = loader.<PaymentCheckBillController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
