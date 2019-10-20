package presentation.salestockstaffui.controller;

import dataenum.BillType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class MakeReceiptController extends SaleStockStaffController {

	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception {
		if (receiptChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要填写的单据");
			warning.showAndWait();
		} else {
			BillType type = BillType.getType(receiptChoice.getValue());
			switch (type) {
			case PURCHASEBILL:
				changeStage("PurchaseMakeBillUI", user, type, null, null);
				break;
			case PURCHASEBACKBILL:
				changeStage("PurchaseMakeBillUI", user, type, null, null);
				break;
			case SALESBILL:
				changeStage("SalesMakeBillUI", user, type, null, null);
				break;
			case SALESBACKBILL:
				changeStage("SalesMakeBillUI", user, type, null, null);
				break;
			default:
				break;
			}
		}
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		try {
			choiceInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void choiceInit() throws Exception {
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,
				BillType.PURCHASEBACKBILL.value, BillType.SALESBILL.value, BillType.SALESBACKBILL.value));
	}

}
