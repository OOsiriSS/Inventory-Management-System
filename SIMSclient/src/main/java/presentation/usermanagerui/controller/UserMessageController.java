package presentation.usermanagerui.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public class UserMessageController extends UserManagerController {

	UtilityBLService service = new UtilityBL();
	ObservableList<MessageVO> list = FXCollections.observableArrayList();
	@FXML
	TableView<MessageVO> messageTable;
	@FXML
	TableColumn<MessageVO, LocalDateTime> time;
	@FXML
	TableColumn<MessageVO, String> messageList;

	public void initData(UserVO user) {
		this.user = user;
		ArrayList<MessageVO> messages = service.getMessage(user);
		if (messages != null) {
			Collections.reverse(messages);
			list.addAll(messages);
		}
		messageTable.setItems(list);
		time.setCellValueFactory(new PropertyValueFactory<MessageVO, LocalDateTime>("time"));
		messageList.setCellValueFactory(new PropertyValueFactory<MessageVO, String>("info"));
	}

}
