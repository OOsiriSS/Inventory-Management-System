package presentation.inventorymanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.controller.InventoryCheckController;
import vo.uservo.UserVO;

public class InventoryCheckUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/InventoryCheckUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		InventoryCheckController controller = loader.<InventoryCheckController>getController();
		controller.initData(user);
		primaryStage.show();

	}

}
