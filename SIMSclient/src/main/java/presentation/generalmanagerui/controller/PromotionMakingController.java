package presentation.generalmanagerui.controller;

import dataenum.PromotionType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class PromotionMakingController extends GeneralManagerController {

	@FXML
	protected ChoiceBox<String> promotionChoice;

	@FXML
	public void choosePromotion() throws Exception {
		if (promotionChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要制作的销售策略");
			warning.showAndWait();
		} else {
			PromotionType type = PromotionType.getType(promotionChoice.getValue());
			switch (type) {
			case LEVEL_PROMOTION:
				changeStage("PromotionMemberUI", user, null);
				break;
			case PRICEPACKS:
				changeStage("PromotionSpecialUI", user, null);
				break;
			case SUM_PROMOTION:
				changeStage("PromotionSumUI", user, null);
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
		promotionChoice.setItems(FXCollections.observableArrayList(PromotionType.LEVEL_PROMOTION.value,
				PromotionType.PRICEPACKS.value, PromotionType.SUM_PROMOTION.value));
	}

}
