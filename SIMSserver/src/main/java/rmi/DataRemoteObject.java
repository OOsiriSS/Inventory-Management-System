package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import data.accountbookdata.AccountBookDataServiceImpl;
import data.accountdata.AccountDataServiceMySqlImpl;
import data.billdata.BillDataServiceImpl;
import data.classificationdata.ClassificationDataServiceImpl;
import data.commoditydata.CommodityDataServiceMySqlImpl;
import data.memberdata.MemberDataServiceImpl;
import data.messagedata.MessageDataServiceImpl;
import data.paymentbilldata.PaymentBillDataServiceImpl;
import data.promotiondata.PromotionMemberDataServiceImpl;
import data.promotiondata.PromotionSpecialDataServiceImpl;
import data.promotiondata.PromotionSumDataServiceImpl;
import data.purchasedata.PurchaseDataServiceImpl;
import data.receiptbilldata.ReceiptDataServiceImpl;
import data.salesdata.SalesDataServiceImpl;
import data.userdata.UserDataServiceImpl;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindAccountBookType;
import dataenum.findtype.FindAccountType;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindInventoryBillType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindPromotionType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import dataservice.accountbookdataservice.AccountBookDataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.billdataservice.BillDataService;
import dataservice.classificationdataservice.ClassificationDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.promotiondataservice.PromotionMemberDataService;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import dataservice.promotiondataservice.PromotionSumDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.userdataservice.UserDataService;
import po.accountbookpo.AccountBookPO;
import po.accountpo.AccountPO;
import po.classificationvpo.ClassificationVPO;
import po.commoditypo.CommodityPO;
import po.financialbillpo.PaymentBillPO;
import po.financialbillpo.ReceiptBillPO;
import po.inventorybillpo.InventoryBillPO;
import po.memberpo.MemberPO;
import po.messagepo.MessagePO;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPricePacksPO;
import po.promotionpo.PromotionTotalPO;
import po.purchasepo.PurchasePO;
import po.salespo.SalesPO;
import po.userpo.UserPO;

/**
 *
 * @author 王灿灿
 * @version 2017-11-28
 */

/**
 *
 * @ClassName: DataRemoteObject
 * @Description: 数据层的增删改查等通用操作
 * @author lijie
 * @date 2017年12月3日 下午7:00:46
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService, MemberDataService,
		SalesDataService, PromotionMemberDataService, PromotionSpecialDataService, PromotionSumDataService,
		PurchaseDataService, AccountBookDataService, AccountDataService, CommodityDataService,
		ClassificationDataService, PaymentBillDataService, ReceiptBillDataService, MessageDataService, BillDataService {

	private static final long serialVersionUID = 1L;

	private UserDataService user;
	private MemberDataService member;
	private SalesDataService sale;
	private PromotionMemberDataService promotionMember;
	private PromotionSpecialDataService promotionSpecial;
	private PromotionSumDataService promotionSum;
	private PurchaseDataService purchase;
	private AccountBookDataService accountbook;
	private AccountDataService account;
	private CommodityDataService commodity;
	private ClassificationDataService classification;
	private PaymentBillDataService paymentbill;
	private ReceiptBillDataService receiprbill;
	private MessageDataService messageData;
	private BillDataService inventoryBill;

	public DataRemoteObject() throws RemoteException {

		user = new UserDataServiceImpl();
		member = new MemberDataServiceImpl();
		sale = new SalesDataServiceImpl();
		promotionMember = new PromotionMemberDataServiceImpl();
		promotionSpecial = new PromotionSpecialDataServiceImpl();
		promotionSum = new PromotionSumDataServiceImpl();
		purchase = new PurchaseDataServiceImpl();
		accountbook = new AccountBookDataServiceImpl();
		account = new AccountDataServiceMySqlImpl();
		commodity = new CommodityDataServiceMySqlImpl();
		classification = new ClassificationDataServiceImpl();
		paymentbill = new PaymentBillDataServiceImpl();
		receiprbill = new ReceiptDataServiceImpl();
		messageData = new MessageDataServiceImpl();
		inventoryBill = new BillDataServiceImpl();
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		return user.insertUser(po);
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		return user.deleteUser(ID);
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		return user.updateUser(po);
	}

	@Override
	public boolean login(String id, String password) throws RemoteException {
		return user.login(id, password);
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		return user.findUser(info, type);
	}

	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		return member.findMember(keyword, type);
	}

	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		return member.insertMember(po);
	}

	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		return member.deleteMember(ID);
	}

	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		return member.updateMember(po);
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		return user.showUser();
	}

	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		return member.showMember();
	}

	@Override
	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException {
		return sale.findSale(info, type);
	}

	@Override
	public ResultMessage insertSale(SalesPO po) throws RemoteException {
		return sale.insertSale(po);
	}

	@Override
	public ResultMessage deleteSale(String ID) throws RemoteException {
		return sale.deleteSale(ID);
	}

	@Override
	public ResultMessage updateSale(SalesPO po) throws RemoteException {
		return sale.updateSale(po);
	}

	@Override
	public ArrayList<SalesPO> showSale() throws RemoteException {
		return sale.showSale();
	}

	@Override
	public String getSaleID() throws RemoteException {
		return sale.getSaleID();
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return sale.getSaleBackID();
	}

	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return purchase.insertPurchase(po);
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return purchase.deletePurchase(ID);
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return purchase.updatePurchase(po);
	}

	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return purchase.findPurchase(keyword, type);
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return purchase.showPurchase();
	}

	@Override
	public ResultMessage insertAccountBook(AccountBookPO po) throws RemoteException {
		return accountbook.insertAccountBook(po);
	}

	@Override
	public ResultMessage deleteAccountBook(String ID) throws RemoteException {
		return accountbook.deleteAccountBook(ID);
	}

	@Override
	public ResultMessage updateAccountBook(AccountBookPO po) throws RemoteException {
		return accountbook.updateAccountBook(po);
	}

	@Override
	public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) throws RemoteException {
		return accountbook.find(keyword, type);
	}

	@Override
	public ArrayList<AccountBookPO> showAccountBook() throws RemoteException {
		return accountbook.showAccountBook();
	}

	@Override
	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException {
		return account.findAccount(keywords, type);
	}

	@Override
	public ArrayList<AccountPO> showAccount() throws RemoteException {
		return account.showAccount();
	}

	@Override
	public ResultMessage insertAccount(AccountPO po) throws RemoteException {
		return account.insertAccount(po);
	}

	@Override
	public ResultMessage deleteAccount(String id) throws RemoteException {
		return account.deleteAccount(id);
	}

	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		return account.updateAccount(po);
	}

	@Override
	public ResultMessage insertCommodity(CommodityPO po) throws RemoteException {
		return commodity.insertCommodity(po);
	}

	@Override
	public ResultMessage updateCommodity(CommodityPO po) throws RemoteException {
		return commodity.updateCommodity(po);
	}

	@Override
	public ResultMessage deleteCommodity(String id) throws RemoteException {
		return commodity.deleteCommodity(id);
	}

	@Override
	public ArrayList<CommodityPO> showCommodity() throws RemoteException {
		return commodity.showCommodity();
	}

	@Override
	public ArrayList<CommodityPO> findCommodity(String keywords, FindCommodityType type) throws RemoteException {
		return commodity.findCommodity(keywords, type);
	}

	@Override
	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException {
		return classification.insertClassification(po);
	}

	@Override
	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException {
		return classification.updateClassification(po);
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		return classification.deleteClassification(id);
	}

	@Override
	public ArrayList<ClassificationVPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return classification.show();
	}

	@Override
	public ClassificationVPO getRoot() throws RemoteException {
		return classification.getRoot();
	}

	@Override
	public ClassificationVPO findClassification(String keyword) throws RemoteException {
		return classification.findClassification(keyword);
	}

	@Override
	public String getID() throws RemoteException {
		// TODO Auto-generated method stub
		return classification.getID();
	}

	@Override
	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException {
		return paymentbill.insertPaymentBill(po);
	}

	@Override
	public ResultMessage deletePaymentBill(String id) throws RemoteException {
		return paymentbill.deletePaymentBill(id);
	}

	@Override
	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException {
		return paymentbill.updatePaymentBill(po);
	}

	@Override
	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException {
		return paymentbill.findPaymentBill(keyword, type);
	}

	@Override
	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException {
		return paymentbill.showPaymentBill();
	}

	@Override
	public ResultMessage insertReceiptBill(ReceiptBillPO po) throws RemoteException {
		return receiprbill.insertReceiptBill(po);
	}

	@Override
	public ResultMessage deleteReceiptBill(String id) throws RemoteException {
		return receiprbill.deleteReceiptBill(id);
	}

	@Override
	public ResultMessage updateReceiptBill(ReceiptBillPO po) throws RemoteException {
		return receiprbill.updateReceiptBill(po);
	}

	@Override
	public ArrayList<ReceiptBillPO> findReceiptBill(String keyword, FindAccountBillType type) throws RemoteException {
		return receiprbill.findReceiptBill(keyword, type);
	}

	@Override
	public ArrayList<ReceiptBillPO> showReceiptBill() throws RemoteException {
		return receiprbill.showReceiptBill();
	}

	@Override
	public ResultMessage save(MessagePO message) throws RemoteException {
		// TODO Auto-generated method stub
		return messageData.save(message);
	}

	@Override
	public ArrayList<MessagePO> getMessage(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return messageData.getMessage(user);
	}

	@Override
	public String getMessageID() throws RemoteException {
		// TODO Auto-generated method stub
		return messageData.getMessageID();
	}

	@Override
	public ResultMessage insertPromotion(PromotionTotalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSum.insertPromotion(po);
	}

	@Override
	public ResultMessage deleteSumPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSum.deleteSumPromotion(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionTotalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSum.updatePromotion(po);
	}

	@Override
	public ResultMessage insertPromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSpecial.insertPromotion(po);
	}

	@Override
	public ResultMessage deleteSpecialPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSpecial.deleteSpecialPromotion(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSpecial.updatePromotion(po);
	}

	@Override
	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionMember.insertPromotion(po);
	}

	@Override
	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionMember.deleteMemberPromotion(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionMember.updatePromotion(po);
	}

	@Override
	public ArrayList<PromotionTotalPO> findSumPromotion(String keyword, FindPromotionType type) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSum.findSumPromotion(keyword, type);
	}

	@Override
	public ArrayList<PromotionTotalPO> showSumPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSum.showSumPromotion();
	}

	@Override
	public ArrayList<PromotionPricePacksPO> findSpecialPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSpecial.findSpecialPromotion(keyword, type);
	}

	@Override
	public ArrayList<PromotionPricePacksPO> showSpecialPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return promotionSpecial.showSpecialPromotion();
	}

	@Override
	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotionMember.findMemberPromotion(keyword, type);
	}

	@Override
	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return promotionMember.showMemberPromotion();
	}

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		return inventoryBill.insertInventoryBill(inventoryBillPO);
	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return inventoryBill.deleteInventoryBill(id);
	}

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		// TODO Auto-generated method stub
		return inventoryBill.updateInventoryBill(inventoryBillPO);
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return inventoryBill.findInventoryBill(keyword, type);
	}

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		// TODO Auto-generated method stub
		return inventoryBill.showInventoryBill();
	}

	@Override
	public ClassificationVPO findClassificationByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return classification.findClassificationByID(id);
	}

}
