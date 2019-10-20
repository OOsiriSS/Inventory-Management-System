package presentation.inventorymanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.controller.InventoryStockController;
import vo.uservo.UserVO;

public class InventoryStockUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/InventoryStockUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		InventoryStockController controller = loader.<InventoryStockController>getController();
		controller.initData(user);
		primaryStage.show();

	}

}
