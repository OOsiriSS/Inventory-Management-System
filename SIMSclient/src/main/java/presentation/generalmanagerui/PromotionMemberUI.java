package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.PromotionMemberController;
import vo.uservo.UserVO;

public class PromotionMemberUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PromotionMemberUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PromotionMemberController controller = loader.<PromotionMemberController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
