package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.ReceiveMakeBillController;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;

public class ReceiveMakeBillUI {

	public void start(UserVO user, ReceiptBillVO bill) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ReceiveMakeBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ReceiveMakeBillController controller = loader.<ReceiveMakeBillController>getController();
		controller.initData(user, bill);
		primaryStage.show();
	}

}
