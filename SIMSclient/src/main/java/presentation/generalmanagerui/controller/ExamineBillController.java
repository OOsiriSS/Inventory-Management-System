package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import dataenum.BillType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

/**
 * 审批单据的选择单据界面
 * 
 * @author 潘星宇 2017-12-17
 */
public class ExamineBillController extends GeneralManagerController {

	@FXML
	protected ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception {
		if (receiptChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要审批的单据");
			warning.showAndWait();
		}
		BillType type = BillType.getType(receiptChoice.getValue());
		switch (type) {
		case PURCHASEBILL:
			changeStage("ExaminePurchaseBillUI", user, type);
			break;
		case INVENTORYBILL:
			changeStage("ExamineInventoryBillUI", user, type);
			break;
		case SALESBILL:
			changeStage("ExamineSalesBillUI", user, type);
			break;
		case SKD:
			changeStage("ExamineReceiveBillUI", user, type);
			break;
		case XJFYD:
			changeStage("ExaminePaymentBillUI", user, type);
			break;
		default:
			break;
		}
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		choiceInit();
	}

	public void choiceInit() throws RemoteException {
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,
				BillType.INVENTORYBILL.value, BillType.SALESBILL.value, BillType.SKD.value, BillType.XJFYD.value));
	}
}
