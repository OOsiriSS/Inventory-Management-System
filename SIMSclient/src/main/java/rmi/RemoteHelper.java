package rmi;

import java.rmi.Remote;
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

/**
 *
 * @author Íõ²Ó²Ó
 * @version 2017-11-26
 *
 */

public class RemoteHelper {

	private Remote remote;

	private static RemoteHelper remoteHelper = new RemoteHelper();

	public static RemoteHelper getInstance() {
		return remoteHelper;

	}

	private RemoteHelper() {
	}

	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	public AccountDataService getAccountDataService() {
		return (AccountDataService) remote;
	}

	public BillDataService getBilldataService() {
		return (BillDataService) remote;
	}

	public ClassificationDataService getClassificationDataService() {
		return (ClassificationDataService) remote;
	}

	public CommodityDataService getCommodityDataService() {
		return (CommodityDataService) remote;
	}

	public MemberDataService getMemeberDataService() {
		return (MemberDataService) remote;
	}

	public ReceiptBillDataService getReceiptDataService() {
		return (ReceiptBillDataService) remote;
	}

	public PaymentBillDataService getPaymentDataService() {
		return (PaymentBillDataService) remote;
	}

	public PromotionMemberDataService getMemberPromotionDataService() {
		return (PromotionMemberDataService) remote;
	}

	public PromotionSpecialDataService getSpecialPromotionDataService() {
		return (PromotionSpecialDataService) remote;
	}

	public PromotionSumDataService getSumPromotionDataService() {
		return (PromotionSumDataService) remote;
	}

	public SalesDataService getSalesDataService() {
		return (SalesDataService) remote;
	}

	public AccountBookDataService getSetUpAccountDataService() {
		return (AccountBookDataService) remote;
	}

	public UserDataService getUserDataService() {
		return (UserDataService) remote;
	}

	public PurchaseDataService getPurchaseDataService() {
		return (PurchaseDataService) remote;
	}

	public MessageDataService getMessageDataService() {
		return (MessageDataService) remote;
	}
}
