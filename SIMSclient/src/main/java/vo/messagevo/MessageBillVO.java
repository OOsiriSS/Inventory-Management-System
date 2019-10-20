package vo.messagevo;

import java.time.LocalDateTime;

import dataenum.BillType;
import dataenum.ResultMessage;

public class MessageBillVO extends MessageVO {

	private static final long serialVersionUID = 1L;

	private String name; // 格式 名字(ID)
	private String id; // 单据编号
	private BillType type;
	private ResultMessage result; // 只有成功或者失败
	private String info; // 格式 单据类：时间+"： 您的" + 单据编号 + 单据类型 + "审批" + 成功/失败

	public MessageBillVO(String messageID, String userID, LocalDateTime time, boolean hasRead, String name, String id,
			BillType type, ResultMessage result) {
		super(messageID, userID, getFormatInfo(name, id, type, result), time, hasRead);
		this.name = name;
		this.id = id;
		this.type = type;
		this.result = result;
	}

	public static String getFormatInfo(String name, String id, BillType type, ResultMessage result) {
		return "您的" + id + type.value + "审批" + result.value;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public BillType getType() {
		return type;
	}

	public ResultMessage getResult() {
		return result;
	}

	public String getInfo() {
		return info;
	}

}
