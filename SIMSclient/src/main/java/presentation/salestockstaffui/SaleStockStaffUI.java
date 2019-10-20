package presentation.salestockstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.SaleStockStaffController;
import vo.uservo.UserVO;

public class SaleStockStaffUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SaleStockStaffUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		SaleStockStaffController controller = loader.<SaleStockStaffController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
