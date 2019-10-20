package presentation.salestockstaffui;

import java.io.IOException;
import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.SalesMakeBillController;
import vo.billvo.salesbillvo.SalesVO;
import vo.uservo.UserVO;

public class SalesMakeBillUI {

	public void start(UserVO user, BillType type, SalesVO sales) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SalesMakeBillUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		SalesMakeBillController controller = loader.<SalesMakeBillController>getController();
		try {
			controller.initData(user, type, sales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		primaryStage.show();

	}

}
