package data.paymentbilldata;

import java.util.ArrayList;
import org.junit.*;

import dataenum.BillType;
import dataenum.findtype.FindAccountBillType;
import po.financialbillpo.EntryPO;
import po.financialbillpo.PaymentBillPO;
import dataenum.BillState;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>PaymentBillDataServiceImplTest</code> contains tests for the
 * class <code>{@link PaymentBillDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PaymentBillDataServiceImplTest {
	/**
	 * Run the PaymentBillDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testPaymentBillDataServiceImpl_1() throws Exception {

		PaymentBillDataServiceImpl result = new PaymentBillDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deletePaymentBill(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeletePaymentBill_1() throws Exception {
		PaymentBillDataServiceImpl fixture = new PaymentBillDataServiceImpl();
		String id = "";

		ResultMessage result = fixture.deletePaymentBill(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.paymentbilldata.PaymentBillData.delete(PaymentBillData.java:83)
		// at
		// data.paymentbilldata.PaymentBillDataServiceImpl.deletePaymentBill(PaymentBillDataServiceImpl.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PaymentBillPO>
	 * findPaymentBill(String,FindAccountBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindPaymentBill_1() throws Exception {
		PaymentBillDataServiceImpl fixture = new PaymentBillDataServiceImpl();
		String keyword = "";
		FindAccountBillType type = FindAccountBillType.BILLID;

		ArrayList<PaymentBillPO> result = fixture.findPaymentBill(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.paymentbilldata.PaymentBillData.find(PaymentBillData.java:100)
		// at
		// data.paymentbilldata.PaymentBillDataServiceImpl.findPaymentBill(PaymentBillDataServiceImpl.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertPaymentBill(PaymentBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertPaymentBill_1() throws Exception {
		PaymentBillDataServiceImpl fixture = new PaymentBillDataServiceImpl();
		PaymentBillPO po = new PaymentBillPO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYGIFTBILL, BillState.COMMITED, "");

		ResultMessage result = fixture.insertPaymentBill(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.paymentbilldata.PaymentBillData.insert(PaymentBillData.java:46)
		// at
		// data.paymentbilldata.PaymentBillDataServiceImpl.insertPaymentBill(PaymentBillDataServiceImpl.java:26)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PaymentBillPO> showPaymentBill() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowPaymentBill_1() throws Exception {
		PaymentBillDataServiceImpl fixture = new PaymentBillDataServiceImpl();

		ArrayList<PaymentBillPO> result = fixture.showPaymentBill();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.paymentbilldata.PaymentBillData.show(PaymentBillData.java:164)
		// at
		// data.paymentbilldata.PaymentBillDataServiceImpl.showPaymentBill(PaymentBillDataServiceImpl.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updatePaymentBill(PaymentBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdatePaymentBill_1() throws Exception {
		PaymentBillDataServiceImpl fixture = new PaymentBillDataServiceImpl();
		PaymentBillPO po = new PaymentBillPO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYGIFTBILL, BillState.COMMITED, "");

		ResultMessage result = fixture.updatePaymentBill(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.paymentbilldata.PaymentBillData.update(PaymentBillData.java:146)
		// at
		// data.paymentbilldata.PaymentBillDataServiceImpl.updatePaymentBill(PaymentBillDataServiceImpl.java:36)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PaymentBillDataServiceImplTest.class);
	}
}