package data.purchasedata;

import java.util.ArrayList;
import org.junit.*;

import po.commoditypo.CommodityItemPO;
import po.purchasepo.PurchasePO;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataenum.BillType;
import dataenum.BillState;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>PurchaseDataServiceImplTest</code> contains tests for the
 * class <code>{@link PurchaseDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PurchaseDataServiceImplTest {
	/**
	 * Run the PurchaseDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testPurchaseDataServiceImpl_1() throws Exception {

		PurchaseDataServiceImpl result = new PurchaseDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deletePurchase(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeletePurchase_1() throws Exception {
		PurchaseDataServiceImpl fixture = new PurchaseDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deletePurchase(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.purchasedata.PurchaseData.delete(PurchaseData.java:86)
		// at
		// data.purchasedata.PurchaseDataServiceImpl.deletePurchase(PurchaseDataServiceImpl.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PurchasePO> findPurchase(String,FindSalesType) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindPurchase_1() throws Exception {
		PurchaseDataServiceImpl fixture = new PurchaseDataServiceImpl();
		String keyword = "";
		FindSalesType type = FindSalesType.ID;

		ArrayList<PurchasePO> result = fixture.findPurchase(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.purchasedata.PurchaseData.find(PurchaseData.java:116)
		// at
		// data.purchasedata.PurchaseDataServiceImpl.findPurchase(PurchaseDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertPurchase(PurchasePO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertPurchase_1() throws Exception {
		PurchaseDataServiceImpl fixture = new PurchaseDataServiceImpl();
		PurchasePO po = new PurchasePO("", "", "", Warehouse.WAREHOUSE1, "", new ArrayList(), "", 1.0,
				BillType.INVENTORYGIFTBILL, BillState.COMMITED);

		ResultMessage result = fixture.insertPurchase(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.purchasedata.PurchaseData.insert(PurchaseData.java:53)
		// at
		// data.purchasedata.PurchaseDataServiceImpl.insertPurchase(PurchaseDataServiceImpl.java:29)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PurchasePO> showPurchase() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowPurchase_1() throws Exception {
		PurchaseDataServiceImpl fixture = new PurchaseDataServiceImpl();

		ArrayList<PurchasePO> result = fixture.showPurchase();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.purchasedata.PurchaseData.show(PurchaseData.java:168)
		// at
		// data.purchasedata.PurchaseDataServiceImpl.showPurchase(PurchaseDataServiceImpl.java:44)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updatePurchase(PurchasePO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdatePurchase_1() throws Exception {
		PurchaseDataServiceImpl fixture = new PurchaseDataServiceImpl();
		PurchasePO po = new PurchasePO("", "", "", Warehouse.WAREHOUSE1, "", new ArrayList(), "", 1.0,
				BillType.INVENTORYGIFTBILL, BillState.COMMITED);

		ResultMessage result = fixture.updatePurchase(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.purchasedata.PurchaseData.update(PurchaseData.java:100)
		// at
		// data.purchasedata.PurchaseDataServiceImpl.updatePurchase(PurchaseDataServiceImpl.java:39)
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
		new org.junit.runner.JUnitCore().run(PurchaseDataServiceImplTest.class);
	}
}