package bussinesslogic.purchasebl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.userdataservice.UserDataService;
import po.messagepo.MessageExaminePO;
import po.purchasepo.PurchasePO;
import po.userpo.UserPO;
import rmi.RemoteHelper;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

/**
 * 进出货的业务逻辑层
 * 
 * @author Lijie
 * @date 2017年12月1日
 */
public class PurchaseController implements PurchaseBLService {

	private PurchaseDataService service;
	private String date;

	private UserDataService userDataService;
	private MessageDataService messageDataService;
	private CommodityDataService commodityDataService;

	public PurchaseController() {
		service = RemoteHelper.getInstance().getPurchaseDataService();
		userDataService = RemoteHelper.getInstance().getUserDataService();
		messageDataService = RemoteHelper.getInstance().getMessageDataService();
		commodityDataService = RemoteHelper.getInstance().getCommodityDataService();
	}

	@Override
	public String getPurchaseID() {
		ArrayList<PurchasePO> list = null;
		try {
			list = service.showPurchase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (PurchasePO po : list) {
			id = po.getId();
			String temp[] = id.split("-");

			if (temp[0].equals("JHD")) {
				IDList.add(Long.parseLong(temp[1] + temp[2]));
			}
		}
		Collections.sort(IDList);
		String day = getDate();
		String num = null;
		if (IDList.size() == 0)
			num = getDate() + "00001";
		else
			num = String.valueOf(IDList.get(IDList.size() - 1));
		if (day.equals(String.valueOf(num.substring(0, 8)))) {
			String index = num.substring(8, num.length());
			index = String.valueOf(Integer.parseInt(index) + 1);
			StringBuilder sb = new StringBuilder(index);
			int len = index.length();
			for (int i = 0; i < 5 - len; i++) {
				sb.insert(0, "0");
			}
			id = sb.toString();
		} else {
			id = "00001";
		}
		StringBuilder s = new StringBuilder("JHD-");
		return s.append(day).append("-").append(id).toString();
	}

	@Override
	public String getPurChaseBackID() {
		ArrayList<PurchasePO> list = null;
		try {
			list = service.showPurchase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (PurchasePO po : list) {
			id = po.getId();
			String temp[] = id.split("-");

			if (temp[0].equals("JHTHD")) {
				IDList.add(Long.parseLong(temp[1] + temp[2]));
			}
		}
		Collections.sort(IDList);
		String day = getDate();
		String num = null;
		if (IDList.size() == 0)
			num = getDate() + "00001";
		else
			num = String.valueOf(IDList.get(IDList.size() - 1));
		if (day.equals(String.valueOf(num.substring(0, 8)))) {
			String index = num.substring(8, num.length());
			index = String.valueOf(Integer.parseInt(index) + 1);
			StringBuilder sb = new StringBuilder(index);
			int len = index.length();
			for (int i = 0; i < 5 - len; i++) {
				sb.insert(0, "0");
			}
			id = sb.toString();
		} else {
			id = "00001";
		}
		StringBuilder s = new StringBuilder("JHTHD-");
		return s.append(day).append("-").append(id).toString();
	}

	@Override
	public void delete(PurchaseVO vo) {
		try {
			service.deletePurchase(vo.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage submit(PurchaseVO Info) {
		try {
			if (Info.getType() == BillType.PURCHASEBACKBILL) {
				for (CommodityItemVO commodity : Info.getCommodities()) {
					if (commodityDataService.findCommodity(getTrueName(commodity.getName()), FindCommodityType.NAME)
							.get(0).getNumber() < commodity.getNumber())
						return ResultMessage.LOWNUMBER;
				}
			}

			PurchasePO po = PurchaseTransition.VOtoPO(Info);
			ResultMessage resultMessage = service.insertPurchase(po);
			if (resultMessage == ResultMessage.EXISTED || resultMessage == ResultMessage.SUCCESS) {
				ArrayList<UserPO> generalManagers = userDataService.findUser(UserRole.GENERAL_MANAGER.value,
						FindUserType.USERROLE);
				for (UserPO manager : generalManagers) {
					MessageExaminePO message = new MessageExaminePO(messageDataService.getMessageID(),
							LocalDateTime.now(), false, po.getId(), manager);
					messageDataService.save(message);
				}
			}
			return resultMessage;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage save(PurchaseVO Info) {
		try {
			PurchasePO po = PurchaseTransition.VOtoPO(Info);
			if (service.insertPurchase(po) == ResultMessage.EXISTED) {
				return service.updatePurchase(po);
			} else
				return service.insertPurchase(PurchaseTransition.VOtoPO(Info));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage isLegal(CommodityItemVO vo) {
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> show() {
		ArrayList<PurchaseVO> list = new ArrayList<>();
		ArrayList<PurchasePO> POList = null;
		try {
			POList = service.showPurchase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		PurchaseVO vo = null;
		for (PurchasePO po : POList) {
			vo = PurchaseTransition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
		return this.date;
	}

	@Override
	public ArrayList<PurchaseVO> find(String info, FindSalesType type) {
		ArrayList<PurchaseVO> list = new ArrayList<>();
		ArrayList<PurchasePO> POList = null;
		try {
			POList = service.findPurchase(info, type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		PurchaseVO vo = null;
		for (PurchasePO po : POList) {
			vo = PurchaseTransition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	/**
	 * 商品名的过滤
	 * 
	 * @param name
	 *            显示在单据上的商品名
	 * @return 真实的商品名
	 */
	public String getTrueName(String name) {
		String newName = "";
		for (int m = 0; m < name.length(); m++) {
			if (name.charAt(m) == '(') {
				newName = name.substring(0, m);
				break;
			}
		}
		return newName;
	}

}
