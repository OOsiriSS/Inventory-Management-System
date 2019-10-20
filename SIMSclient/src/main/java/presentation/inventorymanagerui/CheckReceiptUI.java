package presentation.inventorymanagerui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.controller.CheckReceiptController;
import vo.uservo.UserVO;

public class CheckReceiptUI {

	public void start(UserVO user, BillType type) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckReceiptUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		CheckReceiptController controller = loader.<CheckReceiptController>getController();
		controller.initData(user, type);
		primaryStage.show();

	}

}
