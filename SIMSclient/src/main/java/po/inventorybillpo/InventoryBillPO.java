package po.inventorybillpo;

import java.io.Serializable;
import java.util.ArrayList;
import dataenum.BillState;
import dataenum.BillType;
import po.billpo.BillPO;
import po.commoditypo.GiftPO;

public class InventoryBillPO extends BillPO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String note;
	private ArrayList<GiftPO> gifts;
	private String operator;

	public InventoryBillPO(String id, ArrayList<GiftPO> gifts, String operator, BillType billType, BillState billState,
			String note) {
		super(billType, billState);
		this.setOperator(operator);
		this.setId(id);
		this.setNote(note);
		this.setGifts(gifts);
	}

	public ArrayList<GiftPO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
