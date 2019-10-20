package presentation.salestockstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import vo.membervo.MemberVO;
import vo.uservo.UserVO;

/**
 * 用于客户管理的界面的控制器
 * 
 * @author 潘星宇
 *
 */

public class MemberManageController extends SaleStockStaffController {

	MemberBLService service = new MemberController();
	ObservableList<MemberVO> list = FXCollections.observableArrayList();
	ObservableList<String> classList = FXCollections.observableArrayList(MemberCategory.RETAILER.value,
			MemberCategory.SUPPLIER.value, MemberCategory.BOTH.value);
	ObservableList<String> levelList = FXCollections.observableArrayList(MemberLevel.LEVEL1.value,
			MemberLevel.LEVEL2.value, MemberLevel.LEVEL3.value, MemberLevel.LEVEL4.value, MemberLevel.LEVEL5.value);
	@FXML
	protected ChoiceBox<String> findChoice;
	@FXML
	protected TextField findingField;
	@FXML
	protected Label idLabel;
	@FXML
	protected ChoiceBox<String> classChoice;
	@FXML
	protected ChoiceBox<String> levelChoice;
	@FXML
	protected TextField nameField;
	@FXML
	protected TextField phoneField;
	@FXML
	protected TextField addressField;
	@FXML
	protected TextField zipcodeField;
	@FXML
	protected TextField emailField;
	@FXML
	protected TextField amountField;
	@FXML
	protected TextField receiveField;
	@FXML
	protected TextField payField;
	@FXML
	protected TextField operatorField;

	@FXML
	protected TableView<MemberVO> table;
	@FXML
	protected TableColumn<MemberVO, String> tableID;
	@FXML
	protected TableColumn<MemberVO, String> tableCategory;
	@FXML
	protected TableColumn<MemberVO, String> tableLevel;
	@FXML
	protected TableColumn<MemberVO, String> tableName;
	@FXML
	protected TableColumn<MemberVO, String> tablePhone;
	@FXML
	protected TableColumn<MemberVO, String> tableAddress;
	@FXML
	protected TableColumn<MemberVO, String> tableZipcode;
	@FXML
	protected TableColumn<MemberVO, String> tableEmail;
	@FXML
	protected TableColumn<MemberVO, String> tableAmount;
	@FXML
	protected TableColumn<MemberVO, String> tableReceive;
	@FXML
	protected TableColumn<MemberVO, String> tablePay;
	@FXML
	protected TableColumn<MemberVO, String> tableOperator;
	@FXML
	protected TableColumn<MemberVO, String> tableDelete;

	/**
	 * 增加一个会员
	 * 
	 * @throws RemoteException
	 */
	@FXML
	public void insert() throws RemoteException {
		if (idLabel.getText() == null || classChoice.getValue() == null || levelChoice.getValue() == null
				|| nameField.getText() == null || phoneField.getText() == null || addressField.getText() == null
				|| zipcodeField.getText() == null || emailField.getText() == null || amountField.getText() == null
				|| receiveField.getText() == null || payField.getText() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好所有信息");
			warning.showAndWait();
		} else {
			MemberVO vo = new MemberVO(idLabel.getText(), MemberCategory.getCategory(classChoice.getValue()),
					MemberLevel.getLevel(levelChoice.getValue()), nameField.getText(), phoneField.getText(),
					addressField.getText(), zipcodeField.getText(), emailField.getText(), amountField.getText(),
					receiveField.getText(), payField.getText(), operatorField.getText());
			ResultMessage message = service.insert(vo);
			Platform.runLater(new Runnable() {
				public void run() {
					try {
						switch (message) {
						case EXISTED:
							Alert existed = new Alert(Alert.AlertType.WARNING, "该客户已存在");
							existed.showAndWait();
							break;
						case SUCCESS:
							list.add(vo);
							table.setItems(list);
							initInsert();
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
		}
	}

	@FXML
	public void find() throws RemoteException {
		if (findingField.getText() == null || findChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<MemberVO> list = service.find(findingField.getText(),
					FindMemberType.getMemberType(findChoice.getValue()));
			if (list.size() == 0) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
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

	public void initInsert() throws RemoteException {
		if (service.getId() != null)
			idLabel.setText(service.getId());
		else
			idLabel.setText("000001");
		classChoice.setValue(null);
		levelChoice.setValue(null);
		nameField.setText(null);
		phoneField.setText(null);
		addressField.setText(null);
		zipcodeField.setText(null);
		emailField.setText(null);
		amountField.setText(null);
		receiveField.setText(null);
		payField.setText(null);
	}

	/**
	 * 可编辑初始化
	 */

	public void edit() {
		Callback<TableColumn<MemberVO, String>, TableCell<MemberVO, String>> cellFactory = (
				TableColumn<MemberVO, String> p) -> new EditingCell<MemberVO>();

		Callback<TableColumn<MemberVO, String>, TableCell<MemberVO, String>> choiceFactory = (
				TableColumn<MemberVO, String> p) -> new EditingCellChoice<MemberVO>(levelList);

		tablePhone.setCellFactory(cellFactory);
		tablePhone.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setCellNumber(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tableAddress.setCellFactory(cellFactory);
		tableAddress.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tableZipcode.setCellFactory(cellFactory);
		tableZipcode.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPost(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tableEmail.setCellFactory(cellFactory);
		tableEmail.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tableOperator.setCellFactory(cellFactory);
		tableOperator.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSaleMan(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tableLevel.setCellFactory(choiceFactory);
		tableLevel.setOnEditCommit((CellEditEvent<MemberVO, String> t) -> {
			if (t.getNewValue() == null) {
				Alert warning = new Alert(Alert.AlertType.WARNING, "请填写你所需要修改的信息");
				warning.showAndWait();
			} else {
				((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLevel(t.getNewValue());
				try {
					service.update((MemberVO) t.getTableView().getItems().get(t.getTablePosition().getRow()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}

	public void manageInit() {
		tableID.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("ID"));
		tableCategory.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("categoryStr"));
		tableLevel.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("levelString"));
		tableName.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("name"));
		tablePhone.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("cellNumber"));
		tableAddress.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("address"));
		tableZipcode.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("post"));
		tableEmail.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("email"));
		tableAmount.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("receivableLimit"));
		tableReceive.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("receivable"));
		tablePay.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("payable"));
		tableOperator.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("saleMan"));
		deleteInit();
		classChoice.setItems(classList);
		levelChoice.setItems(levelList);
		findChoice.setItems(FXCollections.observableArrayList(FindMemberType.ID.value, FindMemberType.NAME.value,
				FindMemberType.KIND.value, FindMemberType.ADDRESS.value, FindMemberType.EMAIL.value,
				FindMemberType.LEVEL.value, FindMemberType.PHONE.value, FindMemberType.POST.value,
				FindMemberType.PAYABLE.value, FindMemberType.RECEIVABLE.value, FindMemberType.RECEIVABLELIMIT.value,
				FindMemberType.SALESMAN.value));
	}

	public void deleteInit() {
		tableDelete.setCellFactory((col) -> {
			TableCell<MemberVO, String> cell = new TableCell<MemberVO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);

					if (!empty) {
						Button delBtn = new Button("删除");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							MemberVO clickedUser = this.getTableView().getItems().get(this.getIndex());
							try {
								if (Double.parseDouble(clickedUser.getReceivable()) != 0
										|| Double.parseDouble(clickedUser.getPayable()) != 0) {
									Alert warning = new Alert(AlertType.WARNING, "该客户尚有应收应付，无法删除");
									warning.showAndWait();
								} else {
									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setContentText("确认删除？");
									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										service.delete(clickedUser.getID());
										list.remove(clickedUser);
										table.setItems(list);
									}
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

	public void initData(UserVO user) throws Exception {
		operatorField.setText(readUser().getName());
		list.clear();
		judgeMessage();
		try {
			list.addAll(service.show());
			initInsert();
			initFind();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setItems(list);
		edit();
		manageInit();
	}

}
