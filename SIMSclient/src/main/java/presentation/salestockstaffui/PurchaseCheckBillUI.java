package presentation.salestockstaffui;

import dataenum.BillType;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.PurchaseCheckBillController;
import vo.uservo.UserVO;

public class PurchaseCheckBillUI {

	public void start(UserVO user, BillType type) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PurchaseCheckBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PurchaseCheckBillController controller = loader.<PurchaseCheckBillController>getController();
		controller.initData(user, type);
		primaryStage.show();
	}

}
