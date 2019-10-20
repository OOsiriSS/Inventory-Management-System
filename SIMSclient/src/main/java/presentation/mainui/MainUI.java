package presentation.mainui;

import java.rmi.RemoteException;

import bussinesslogic.userbl.UserController;
import bussinesslogicservice.userblservice.UserBLService;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.financialstaffui.FinancialStaffUI;
import presentation.generalmanagerui.GeneralManagerUI;
import presentation.inventorymanagerui.InventoryManagerUI;
import presentation.salestockstaffui.SaleStockStaffUI;
import presentation.usermanagerui.UserManagerUI;
import vo.uservo.UserVO;

public class MainUI extends Application {

	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	AnchorPane pane;

	@FXML
	public void enterButton(ActionEvent event) throws RemoteException {
		login();
	}

	@FXML
	public void enterKey(KeyEvent event) throws RemoteException {
		if (event.getCode() == KeyCode.ENTER)
			login();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void login() throws RemoteException {
		String id = username.getText();
		String passWord = password.getText();
		if (id == null || passWord == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "请输入用户名及密码");
			alert.showAndWait();
		} else {
			UserBLService service = new UserController();

			if (service.login(id, passWord)) {

				Platform.runLater(new Runnable() {
					public void run() {
						try {
							UserVO user = service.find(id, FindUserType.ID).get(0);
							UserRole role = user.getRole();
							switch (role) {
							case GENERAL_MANAGER:
								new GeneralManagerUI().start(user);
								break;
							case FINANCIAL_MANAGER:
								new FinancialStaffUI().start(user);
								break;
							case PUR_SALE_MANAGER:
								new SaleStockStaffUI().start(user);
								break;
							case INVENTORY_MANAGER:
								new InventoryManagerUI().start(user);
								break;
							case USER_MANAGER:
								new UserManagerUI().start(user);
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				Stage stage = (Stage) pane.getScene().getWindow();
				stage.close();
			} else {
				username.setText(null);
				password.setText(null);
				Alert error = new Alert(Alert.AlertType.ERROR, "用户名或者密码错误");
				error.showAndWait();
			}
		}

	}

	public void run(String[] args) {
		launch(args);
	}

}
