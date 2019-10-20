package data.receiptbilldata;

import java.util.ArrayList;
import dataenum.ResultMessage;

import org.junit.*;

import dataenum.BillType;
import dataenum.findtype.FindAccountBillType;
import po.financialbillpo.AccountListPO;
import po.financialbillpo.ReceiptBillPO;
import dataenum.BillState;
import static org.junit.Assert.*;

/**
 * The class <code>ReceiptDataServiceImplTest</code> contains tests for the
 * class <code>{@link ReceiptDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:28
 * @author asus
 * @version $Revision: 1.0 $
 */
public class ReceiptDataServiceImplTest {
	/**
	 * Run the ReceiptDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testReceiptDataServiceImpl_1() throws Exception {

		ReceiptDataServiceImpl result = new ReceiptDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteReceiptBill(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testDeleteReceiptBill_1() throws Exception {
		ReceiptDataServiceImpl fixture = new ReceiptDataServiceImpl();
		String id = "";

		ResultMessage result = fixture.deleteReceiptBill(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.receiptbilldata.ReceiptBillData.delete(ReceiptBillData.java:90)
		// at
		// data.receiptbilldata.ReceiptDataServiceImpl.deleteReceiptBill(ReceiptDataServiceImpl.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<ReceiptBillPO>
	 * findReceiptBill(String,FindAccountBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testFindReceiptBill_1() throws Exception {
		ReceiptDataServiceImpl fixture = new ReceiptDataServiceImpl();
		String keyword = "";
		FindAccountBillType type = FindAccountBillType.BILLID;

		ArrayList<ReceiptBillPO> result = fixture.findReceiptBill(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.receiptbilldata.ReceiptBillData.find(ReceiptBillData.java:108)
		// at
		// data.receiptbilldata.ReceiptDataServiceImpl.findReceiptBill(ReceiptDataServiceImpl.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertReceiptBill(ReceiptBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testInsertReceiptBill_1() throws Exception {
		ReceiptDataServiceImpl fixture = new ReceiptDataServiceImpl();
		ReceiptBillPO po = new ReceiptBillPO("", "", "", BillType.INVENTORYGIFTBILL, BillState.COMMITED,
				new ArrayList(), new Double(1.0), "");

		ResultMessage result = fixture.insertReceiptBill(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.receiptbilldata.ReceiptBillData.insert(ReceiptBillData.java:53)
		// at
		// data.receiptbilldata.ReceiptDataServiceImpl.insertReceiptBill(ReceiptDataServiceImpl.java:26)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<ReceiptBillPO> showReceiptBill() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testShowReceiptBill_1() throws Exception {
		ReceiptDataServiceImpl fixture = new ReceiptDataServiceImpl();

		ArrayList<ReceiptBillPO> result = fixture.showReceiptBill();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.receiptbilldata.ReceiptBillData.show(ReceiptBillData.java:174)
		// at
		// data.receiptbilldata.ReceiptDataServiceImpl.showReceiptBill(ReceiptDataServiceImpl.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateReceiptBill(ReceiptBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testUpdateReceiptBill_1() throws Exception {
		ReceiptDataServiceImpl fixture = new ReceiptDataServiceImpl();
		ReceiptBillPO po = new ReceiptBillPO("", "", "", BillType.INVENTORYGIFTBILL, BillState.COMMITED,
				new ArrayList(), new Double(1.0), "");

		ResultMessage result = fixture.updateReceiptBill(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.receiptbilldata.ReceiptBillData.update(ReceiptBillData.java:156)
		// at
		// data.receiptbilldata.ReceiptDataServiceImpl.updateReceiptBill(ReceiptDataServiceImpl.java:36)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
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
	 * @generatedBy CodePro at 18-1-12 下午9:28
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
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ReceiptDataServiceImplTest.class);
	}
}