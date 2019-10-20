package vo.messagevo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messageID;
	private String userID;
	private LocalDateTime time;
	private String info; // 格式 单据类："： 您的" + 单据编号 + 单据类型 + "审批" + 成功/失败
							// 警告类: 商品名(编号)+"低于警戒值 当前数量："+当前数量+"警戒数量： "+警戒数量
	private boolean hasRead;

	public MessageVO(String messageID, String userID, String info, LocalDateTime time, boolean hasRead) {
		this.setMessageID(messageID);
		this.setUserID(userID);
		this.time = time;
		this.info = info;
		this.hasRead = hasRead;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getInfo() {
		return info;
	}

	public boolean getHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
