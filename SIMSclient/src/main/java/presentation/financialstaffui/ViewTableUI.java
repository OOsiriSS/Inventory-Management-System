package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.ViewTableController;
import vo.uservo.UserVO;

public class ViewTableUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ViewTableUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		ViewTableController controller = loader.<ViewTableController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
