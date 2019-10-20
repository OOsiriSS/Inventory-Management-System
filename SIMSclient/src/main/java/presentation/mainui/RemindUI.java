package presentation.mainui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RemindUI {

	@FXML
	Button button;
	@FXML
	AnchorPane pane;

	@FXML
	public void confirm() {
		exit();
	}

	@FXML
	public void exitKey(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			exit();
	}

	public void exit() {
		Stage stage = (Stage) button.getScene().getWindow();
		stage.close();
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("fxml/Remind.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("提示界面");
		primaryStage.show();
	}

}
