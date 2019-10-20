package presentation.mainui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import bussinesslogic.userbl.UserController;
import bussinesslogicservice.userblservice.UserBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import javafx.scene.control.Alert;
import vo.uservo.UserVO;

public class LoginController {

	UserBLService userservice = new UserController();

	public boolean writeUser(UserVO user) {
		if (user != null) {
			try {
				BufferedWriter fw = new BufferedWriter(new FileWriter("Login.txt"));

				fw.write(user.getID());
				fw.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return true;
	}

	public UserVO readUser() {
		// TODO Auto-generated method stub
		File path = new File("Login.txt");
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			reader.close();
			return userservice.find(line, FindUserType.ID).get(0);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public void printInfo(ResultMessage message) {
		Alert error = new Alert(Alert.AlertType.INFORMATION, message.value);
		error.showAndWait();
	}

	public void printWrong(ResultMessage message) {
		Alert error = new Alert(Alert.AlertType.WARNING, message.value);
		error.showAndWait();
	}

}
