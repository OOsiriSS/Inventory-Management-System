package vo.billvo;

import dataenum.BillState;

import dataenum.BillType;
import javafx.scene.control.CheckBox;

public class BillVO {

	protected String id;
	protected String note;
	protected BillType type;// 单据类型
	protected String typeString;
	protected BillState state;// 单据状态
	protected String stateString;
	protected CheckBox box = new CheckBox();
	protected CheckBox red = new CheckBox();

	public BillVO(String id, BillType type, BillState state, String note) {
		this.id = id;
		this.type = type;
		this.state = state;
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public BillType getType() {
		return type;
	}

	public void setType(BillType type) {
		this.type = type;
	}

	public BillState getState() {
		return state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getTypeString() {
		return type.value;
	}

	public String getStateString() {
		return state.value;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public CheckBox getBox() {
		return box;
	}

	public CheckBox getRed() {
		return red;
	}

}
