package presentation.financialstaffui.controller;

import dataenum.BillType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class MakeReceiptController extends FinancialStaffController {

	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception {
		if (receiptChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要制作的单据");
			warning.showAndWait();
		} else {
			BillType type = BillType.getType(receiptChoice.getValue());
			switch (type) {
			case SKD:
				changeStage("ReceiveMakeBillUI", user, null, null);
				break;
			case XJFYD:
				changeStage("PaymentMakeBillUI", user, null, null);
				break;
			default:
				break;
			}
		}
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		choiceInit();
	}

	public void choiceInit() {
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.SKD.value, BillType.XJFYD.value));
	}

}
