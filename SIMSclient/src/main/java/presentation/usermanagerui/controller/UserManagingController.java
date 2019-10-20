package presentation.usermanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.userbl.UserController;
import bussinesslogicservice.userblservice.UserBLService;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import vo.uservo.UserVO;

/**
 * 用户管理操作界面控制器
 * 
 * @author 潘星宇
 *
 */

public class UserManagingController extends UserManagerController {

	UserBLService service = new UserController();
	ObservableList<UserVO> list = FXCollections.observableArrayList();
	ObservableList<String> roleList = FXCollections.observableArrayList(UserRole.GENERAL_MANAGER.value,
			UserRole.FINANCIAL_MANAGER.value, UserRole.INVENTORY_MANAGER.value, UserRole.PUR_SALE_MANAGER.value,
			UserRole.USER_MANAGER.value);
	@FXML
	protected TextField idField;
	@FXML
	protected TextField nameField;
	@FXML
	protected TextField passwordField;
	@FXML
	protected TextField findingField;
	@FXML
	protected ChoiceBox<String> roleChoice;
	@FXML
	protected ChoiceBox<String> findChoice;

	@FXML
	protected TableView<UserVO> table;
	@FXML
	protected TableColumn<UserVO, String> tableID;
	@FXML
	protected TableColumn<UserVO, String> tablePassword;
	@FXML
	protected TableColumn<UserVO, String> tableName;
	@FXML
	protected TableColumn<UserVO, String> tableRole;
	@FXML
	protected TableColumn<UserVO, String> tableDelete;

	@FXML
	public void insert() throws RemoteException {
		if (idField.getText() == null || nameField.getText() == null || passwordField.getText() == null
				|| roleChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有信息");
			warning.showAndWait();
		} else {
			UserVO vo = new UserVO(idField.getText(), nameField.getText(), passwordField.getText(),
					UserRole.getRole(roleChoice.getValue()), null);
			ResultMessage message = service.insert(vo);
			Platform.runLater(new Runnable() {
				public void run() {
					try {
						switch (message) {
						case EXISTED:
							Alert existed = new Alert(Alert.AlertType.WARNING, "该用户已存在");
							existed.showAndWait();
						case SUCCESS:
							list.add(vo);
							table.setItems(list);
							initInsert();
							break;
						default:
							Alert error = new Alert(Alert.AlertType.ERROR, message.value);
							error.showAndWait();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@FXML
	public void find() throws RemoteException {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<UserVO> list = service.find(findingField.getText(), FindUserType.getType(findChoice.getValue()));
			if (list == null) {
				Alert error = new Alert(Alert.AlertType.ERROR, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				table.getItems().clear();
				table.getItems().addAll(list);
				initFind();
			}
		}
	}

	public void initFind() {
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert() {
		nameField.setText("admin");
		passwordField.setText("admin");
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		list.clear();
		list.addAll(service.getUserList());
		table.setItems(list);
		initInsert();
		initFind();
		edit();
		manageInit();
	}

	public void edit() {
		Callback<TableColumn<UserVO, String>, TableCell<UserVO, String>> cellFactory = (
				TableColumn<UserVO, String> p) -> new EditingCell<UserVO>();
		Callback<TableColumn<UserVO, String>, TableCell<UserVO, String>> choiceFactory = (
				TableColumn<UserVO, String> p) -> new EditingCellChoice<UserVO>(roleList);

		tableName.setCellFactory(cellFactory);
		tableName.setOnEditCommit((CellEditEvent<UserVO, String> t) -> {
			String tmp = t.getOldValue();
			((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
			UserVO newVO = ((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				if (!update(newVO)) {
					((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(tmp);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		tablePassword.setCellFactory(cellFactory);
		tablePassword.setOnEditCommit((CellEditEvent<UserVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好你所需要修改的信息");
				warning.showAndWait();
			} else {
				String tmp = t.getOldValue();
				((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPassword(t.getNewValue());
				UserVO newVO = ((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				try {
					if (!update(newVO))
						(t.getTableView().getItems().get(t.getTablePosition().getRow())).setPassword(tmp);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		tableRole.setCellFactory(choiceFactory);
		tableRole.setOnEditCommit((CellEditEvent<UserVO, String> t) -> {
			((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRole(t.getNewValue());
			UserVO newVO = ((UserVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
			try {
				service.update(newVO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	public boolean update(UserVO vo) throws RemoteException {
		ResultMessage message = service.update(vo);
		Boolean result = message == ResultMessage.SUCCESS ? true : false;
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					switch (message) {
					case SUCCESS:
						break;
					default:
						Alert error = new Alert(Alert.AlertType.ERROR, message.value);
						error.showAndWait();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return result;
	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<UserVO, String>("ID"));
		tableName.setCellValueFactory(new PropertyValueFactory<UserVO, String>("name"));
		tablePassword.setCellValueFactory(new PropertyValueFactory<UserVO, String>("password"));
		tableRole.setCellValueFactory(new PropertyValueFactory<UserVO, String>("roleName"));
		deleteInit();
		roleChoice.setItems(roleList);
		findChoice.setItems(FXCollections.observableArrayList(FindUserType.ID.value, FindUserType.NAME.value,
				FindUserType.USERROLE.value));
	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<UserVO, String> cell = new TableCell<UserVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							UserVO clickedUser = this.getTableView().getItems().get(this.getIndex());
							try {
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setContentText("确认删除？");
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									service.delete(clickedUser);
									list.remove(clickedUser);
									table.setItems(list);
								}
							} catch (RemoteException e) {
								e.printStackTrace();
							}

						});
					}
				}

			};
			return cell;
		});
	}

	/**
	 * 自动生成新id
	 * 
	 * @param id
	 * @return 新id
	 */
	public String addOne(String id) {
		int tmp = Integer.parseInt(id);
		int n = id.length();
		tmp++;
		String newID = String.valueOf(tmp);
		while (newID.length() < n)
			newID = "0" + newID;
		return newID;
	}

}
