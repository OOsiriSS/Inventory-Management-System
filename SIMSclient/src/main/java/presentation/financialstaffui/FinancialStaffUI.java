package presentation.financialstaffui;

import presentation.financialstaffui.controller.FinancialStaffController;
import vo.uservo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FinancialStaffUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/FinancialStaffUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		FinancialStaffController controller = loader.<FinancialStaffController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
