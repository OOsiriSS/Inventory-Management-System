package presentation.inventorymanagerui;

import presentation.inventorymanagerui.controller.InventoryManagerController;
import vo.uservo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InventoryManagerUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/InventoryManagerUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		InventoryManagerController controller = loader.<InventoryManagerController>getController();
		controller.initData(user);
		primaryStage.show();

	}
}
