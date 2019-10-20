package presentation.salestockstaffui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.PromotionCheckController;
import vo.billvo.salesbillvo.SalesVO;
import vo.uservo.UserVO;

public class PromotionCheckUI {

	public void start(UserVO user, BillType type, SalesVO sale) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PromotionCheckUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PromotionCheckController controller = loader.<PromotionCheckController>getController();
		controller.initData(user, type, sale);
		primaryStage.show();
	}

}
