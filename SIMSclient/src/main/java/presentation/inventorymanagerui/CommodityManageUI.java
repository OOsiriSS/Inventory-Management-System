package presentation.inventorymanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.controller.CommodityManageController;
import vo.uservo.UserVO;

public class CommodityManageUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CommodityManageUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		CommodityManageController controller = loader.<CommodityManageController>getController();
		controller.initData(user);
		primaryStage.show();

	}

}
