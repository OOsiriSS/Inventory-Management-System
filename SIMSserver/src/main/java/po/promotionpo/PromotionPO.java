package po.promotionpo;

import java.io.Serializable;
import java.time.LocalDate;
import dataenum.PromotionType;

/**
 *
 * @author ≈À–«”Ó
 * @date 2017ƒÍ12‘¬27»’
 */
public class PromotionPO implements Serializable {

	protected static final long serialVersionUID = -7961034019548242635L;
	protected String id;
	protected LocalDate beginDate;
	protected LocalDate endDate;
	protected PromotionType type;
	protected String typeString;

	public PromotionPO(String id, LocalDate beginDate, LocalDate endDate, PromotionType type) {
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.setType(type);
		this.typeString = type.value;
	}

	public String getId() {
		return id;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public PromotionType getType() {
		return type;
	}

	public void setType(PromotionType type) {
		this.type = type;
	}

	public String getTypeString() {
		return typeString;
	}

}
