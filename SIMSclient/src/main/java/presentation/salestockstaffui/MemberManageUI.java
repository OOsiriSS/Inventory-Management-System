package presentation.salestockstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.MemberManageController;
import vo.uservo.UserVO;

public class MemberManageUI extends SaleStockStaffUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/MemberManageUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		MemberManageController controller = loader.<MemberManageController>getController();
		controller.initData(user);
		primaryStage.show();
	}
}
