package vo.messagevo;

import java.time.LocalDateTime;

public class MessageWarmingVO extends MessageVO {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */

	private String name; // 商品名(商品ID)
	private Integer warmingNumber;
	private Integer currentNumber;

	public MessageWarmingVO(String messageID, String userID, LocalDateTime time, boolean hasRead, String name,
			int currentNumber, int warmingNumber) {
		super(messageID, userID, getFormatInfo(name, currentNumber, warmingNumber), time, hasRead);
		this.name = name;
		this.warmingNumber = warmingNumber;
		this.currentNumber = currentNumber;
	}

	public static String getFormatInfo(String name, Integer currentNumber, Integer warmingNumber) {
		return name + "低于警戒值 当前数量：" + String.valueOf(currentNumber) + " 警戒数量： " + String.valueOf(warmingNumber);
	}

	public String getName() {
		return name;
	}

	public Integer getCurrentNumber() {
		return currentNumber;
	}

	public Integer getWarmingNumber() {
		return warmingNumber;
	}
}
