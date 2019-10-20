package bussinesslogic.utilitybl;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bussinesslogic.userbl.UserController;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.commoditypo.CommodityPO;
import po.messagepo.MessagePO;
import po.messagepo.MessageWarmingPO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public class UtilityBL implements UtilityBLService {

	private static UtilityBL utilityBL = new UtilityBL();
	private MessageDataService messageService;
	private UserDataService userService;
	UserController bl = new UserController();

	public UtilityBL() {
		messageService = RemoteHelper.getInstance().getMessageDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
	}

	public static UtilityBL getInstance() {
		return utilityBL;
	}

	public UtilityBLService getUtilityBLService() {
		return (UtilityBLService) utilityBL;
	}

	@Override
	public boolean isPrintLegal(ArrayList<String> list) {
		return false;
	}

	@Override
	public ArrayList<MessageVO> getMessage(UserVO user) {
		UserPO po = bl.voTopo(user);
		ArrayList<MessageVO> messages = new ArrayList<>();
		try {
			ArrayList<MessagePO> messagesData = messageService.getMessage(po);
			if (messagesData == null)
				return null;
			else
				for (MessagePO message : messagesData)
					messages.add(poTovo(message));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public boolean hasMessage(UserVO user) {
		try {
			ArrayList<MessagePO> messages = messageService.getMessage(bl.voTopo(user));
			if (messages != null)
				for (MessagePO message : messages)
					if (message.getHasRead() == false)
						return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public MessagePO voTopo(MessageVO vo) {
		MessagePO po = new MessagePO(vo.getMessageID(), vo.getUserID(), vo.getInfo(), vo.getTime(), vo.getHasRead());
		po.setHasRead(vo.getHasRead());
		return po;
	}

	public MessageVO poTovo(MessagePO po) {
		MessageVO vo = new MessageVO(po.getMessageID(), po.getUserID(), po.getInfo(), po.getTime(), po.getHasRead());
		vo.setHasRead(po.getHasRead());
		return vo;
	}

	@Override
	public void warningMessage(CommodityPO po) throws RemoteException {
		if (po.getNumber() <= po.getWarmingValue()) {
			MessageWarmingPO message = new MessageWarmingPO(messageService.getMessageID(), null, LocalDateTime.now(),
					false, po.getName() + "(" + po.getID() + ")", po.getNumber(), po.getWarmingValue());
			ArrayList<UserPO> inventorymanagers = userService.findUser(UserRole.INVENTORY_MANAGER.value,
					FindUserType.USERROLE);
			for (UserPO user : inventorymanagers) {
				message.setMessageID(user.getID());
				messageService.save(message);
			}
		}
	}

	@Override
	public void saveMessage(MessageVO message) throws RemoteException {
		messageService.save(voTopo(message));

	}

}
