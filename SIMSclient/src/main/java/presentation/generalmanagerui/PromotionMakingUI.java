package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.PromotionMakingController;
import vo.uservo.UserVO;

public class PromotionMakingUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PromotionMakingUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PromotionMakingController controller = loader.<PromotionMakingController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
