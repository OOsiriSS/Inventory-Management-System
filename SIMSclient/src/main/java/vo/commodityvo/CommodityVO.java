package vo.commodityvo;

public class CommodityVO {

	private String id; // 商品编号
	private String name;
	private String model; // 商品型号
	private String classification;
	private Integer number; // 商品数量
	private Double purPrice; // 进价
	private Double retailedPrice; // 零售价
	private Double recentPurPrice; // 最新进价
	private Double recentRetailedPrice; // 最新零售价
	private Integer warmingValue; // 警戒值
	private Integer line;// 行号

	public CommodityVO(String id, String name, String model, String classification, int number, double purPrice,
			double retailedPrice, int warmingValue) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.classification = classification;
		this.number = number;
		this.purPrice = purPrice;
		this.recentPurPrice = purPrice;
		this.retailedPrice = retailedPrice;
		this.recentRetailedPrice = retailedPrice;
		this.warmingValue = warmingValue;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}

	public double getRetailedPrice() {
		return retailedPrice;
	}

	public void setRetailedPrice(double retailedPrice) {
		this.retailedPrice = retailedPrice;
	}

	public double getRecentPurPrice() {
		return recentPurPrice;
	}

	public void setRecentPurPrice(double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}

	public double getRecentRetailedPrice() {
		return recentRetailedPrice;
	}

	public void setRecentRetailedPrice(double recentRetailedPrice) {
		this.recentRetailedPrice = recentRetailedPrice;
	}

	public int getWarmingValue() {
		return warmingValue;
	}

	public void setWarmingValue(int warmingValue) {
		this.warmingValue = warmingValue;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

}
