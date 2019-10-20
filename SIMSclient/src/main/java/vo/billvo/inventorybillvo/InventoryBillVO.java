package vo.billvo.inventorybillvo;

import java.util.ArrayList;

import dataenum.BillState;

import dataenum.BillType;
import vo.billvo.BillVO;
import vo.commodityvo.GiftVO;

public class InventoryBillVO extends BillVO {

	private ArrayList<GiftVO> gifts;
	private String operator;

	public InventoryBillVO(String id, ArrayList<GiftVO> gifts, String operator, BillType billType, BillState billState,
			String note) {
		super(id, billType, billState, note);
		this.setOperator(operator);
		this.setGifts(gifts);
	}

	public ArrayList<GiftVO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftVO> gifts) {
		this.gifts = gifts;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
