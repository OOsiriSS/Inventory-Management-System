package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import dataenum.BillType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

/**
 * 经营历程表选择要查看的单据表格界面
 * 
 * @author 潘星宇 2017-12-24
 */

public class BussinessProcessTableController extends FinanceTableController {

	@FXML
	protected ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception {
		if (receiptChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要查看的单据");
			warning.showAndWait();
		} else {
			BillType type = BillType.getType(receiptChoice.getValue());
			switch (type) {
			case PURCHASEBILL:
				changeStage("CheckPurchaseBillUI", user, null);
				break;
			case INVENTORYBILL:
				changeStage("CheckInventoryBillUI", user, null);
				break;
			case SALESBILL:
				changeStage("CheckSalesBillUI", user, null);
				break;
			case SKD:
				changeStage("CheckReceiveBillUI", user, null);
				break;
			case XJFYD:
				changeStage("CheckPaymentBillUI", user, null);
				break;
			default:
				break;
			}
		}
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		tableChoiceInit();
		choiceInit();
	}

	public void choiceInit() throws RemoteException {
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,
				BillType.INVENTORYBILL.value, BillType.SALESBILL.value, BillType.SKD.value, BillType.XJFYD.value));
	}
}
