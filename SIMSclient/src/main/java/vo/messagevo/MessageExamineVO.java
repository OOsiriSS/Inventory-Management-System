package vo.messagevo;

import java.time.LocalDateTime;

import vo.uservo.UserVO;

public class MessageExamineVO extends MessageVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id; // 单据编号
	private UserVO user; // 用户

	public MessageExamineVO(String messageID, LocalDateTime time, boolean hasRead, String id, UserVO user) {
		super(messageID, user.getID(), getFormatInfo(id, user), time, hasRead);
		this.setId(id);
		this.setUser(user);

	}

	public static String getFormatInfo(String id, UserVO user) {
		return user.getName() + "向您提交了单据：" + id + ",请您审批";
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
