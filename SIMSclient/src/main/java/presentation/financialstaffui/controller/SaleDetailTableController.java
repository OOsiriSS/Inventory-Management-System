package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.tablebl.SaleScheduleBL;
import bussinesslogicservice.tableblservice.SaleScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.tablevo.SaleScheduleVO;
import vo.uservo.UserVO;

public class SaleDetailTableController extends ViewTableController {

	SaleScheduleBLService service = new SaleScheduleBL();
	ObservableList<SaleScheduleVO> list = FXCollections.observableArrayList();

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> siftChoice;
	@FXML
	TextField siftField;

	@FXML
	TableView<SaleScheduleVO> table;
	@FXML
	TableColumn<SaleScheduleVO, LocalDate> tableTime;
	@FXML
	TableColumn<SaleScheduleVO, String> tableName;
	@FXML
	TableColumn<SaleScheduleVO, String> tableModel;
	@FXML
	TableColumn<SaleScheduleVO, Integer> tableNumber;
	@FXML
	TableColumn<SaleScheduleVO, Double> tablePrice;
	@FXML
	TableColumn<SaleScheduleVO, Double> tableSum;

	/**
	 * 导出表格
	 * 
	 * @throws Exception
	 */

	@FXML
	public void printout() throws Exception {
		ArrayList<SaleScheduleVO> saleList = new ArrayList<>();
		saleList.addAll(list);
		service.exportReport(saleList);
		Alert info = new Alert(Alert.AlertType.INFORMATION, "已导出");
		info.showAndWait();
	}

	@FXML
	public void sift() {
		if (siftField.getText() == null || siftChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<SaleScheduleVO> salesList = service.sift(siftField.getText(),
					FindSaleScheduleType.getType(siftChoice.getValue()));
			if (salesList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(salesList);
				table.setItems(list);
				initFind();
			}
		}
	}

	@FXML
	public void siftTime() {
		if (startPicker.getValue() == null || endPicker.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请填写好查询信息");
			warning.showAndWait();
		} else {
			ArrayList<SaleScheduleVO> salesList = service.siftTime(startPicker.getValue(), endPicker.getValue());
			if (salesList == null) {
				Alert error = new Alert(Alert.AlertType.WARNING, ResultMessage.NOTFOUND.value);
				error.showAndWait();
			} else {
				list.clear();
				list.addAll(salesList);
				table.setItems(list);
				initTime();
			}
		}
	}

	public void initTime() {
		startPicker.setValue(null);
		endPicker.setValue(null);
	}

	public void initFind() {
		siftChoice.setValue(null);
		siftField.setText(null);
	}

	public void initData(UserVO user) {
		this.user = user;
		judgeMessage();
		list.clear();
		list.addAll(service.show());
		table.setItems(list);
		try {
			tableChoiceInit();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		manageInit();
		initFind();
		initTime();
		siftChoice.setItems(
				FXCollections.observableArrayList(FindSaleScheduleType.NAME.value, FindSaleScheduleType.MEMBER.value,
						FindSaleScheduleType.OPERATOR.value, FindSaleScheduleType.WAREHOUSE.value));
	}

	public void manageInit() {
		tableTime.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, LocalDate>("date"));
		tableName.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, String>("name"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, Integer>("number"));
		tablePrice.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, Double>("price"));
		tableSum.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, Double>("sum"));
		tableModel.setCellValueFactory(new PropertyValueFactory<SaleScheduleVO, String>("model"));
	}

}
