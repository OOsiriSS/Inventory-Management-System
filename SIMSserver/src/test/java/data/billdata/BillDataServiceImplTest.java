package data.billdata;

import java.util.ArrayList;
import org.junit.*;
import dataenum.findtype.FindInventoryBillType;
import dataenum.BillType;
import po.commoditypo.GiftPO;
import po.inventorybillpo.InventoryBillPO;
import dataenum.BillState;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>BillDataServiceImplTest</code> contains tests for the class
 * <code>{@link BillDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class BillDataServiceImplTest {
	/**
	 * Run the BillDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testBillDataServiceImpl_1() throws Exception {

		BillDataServiceImpl result = new BillDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteInventoryBill(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteInventoryBill_1() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		String id = "";

		ResultMessage result = fixture.deleteInventoryBill(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.deleteInventoryBill(BillData.java:96)
		// at
		// data.billdata.BillDataServiceImpl.deleteInventoryBill(BillDataServiceImpl.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteInventoryBill(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteInventoryBill_2() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		String id = "";

		ResultMessage result = fixture.deleteInventoryBill(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.deleteInventoryBill(BillData.java:96)
		// at
		// data.billdata.BillDataServiceImpl.deleteInventoryBill(BillDataServiceImpl.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillPO>
	 * findInventoryBill(String,FindInventoryBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindInventoryBill_1() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		String keyword = "";
		FindInventoryBillType type = FindInventoryBillType.ID;

		ArrayList<InventoryBillPO> result = fixture.findInventoryBill(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.findInventoryBill(BillData.java:131)
		// at
		// data.billdata.BillDataServiceImpl.findInventoryBill(BillDataServiceImpl.java:47)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillPO>
	 * findInventoryBill(String,FindInventoryBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindInventoryBill_2() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		String keyword = "";
		FindInventoryBillType type = FindInventoryBillType.ID;

		ArrayList<InventoryBillPO> result = fixture.findInventoryBill(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.findInventoryBill(BillData.java:131)
		// at
		// data.billdata.BillDataServiceImpl.findInventoryBill(BillDataServiceImpl.java:47)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertInventoryBill(InventoryBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertInventoryBill_1() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		InventoryBillPO inventoryBillPO = new InventoryBillPO("", new ArrayList(), "", BillType.INVENTORYGIFTBILL,
				BillState.COMMITED, "");

		ResultMessage result = fixture.insertInventoryBill(inventoryBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.insertInventoryBill(BillData.java:58)
		// at
		// data.billdata.BillDataServiceImpl.insertInventoryBill(BillDataServiceImpl.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertInventoryBill(InventoryBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertInventoryBill_2() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		InventoryBillPO inventoryBillPO = new InventoryBillPO("", new ArrayList(), "", BillType.INVENTORYGIFTBILL,
				BillState.COMMITED, "");

		ResultMessage result = fixture.insertInventoryBill(inventoryBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.insertInventoryBill(BillData.java:58)
		// at
		// data.billdata.BillDataServiceImpl.insertInventoryBill(BillDataServiceImpl.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillPO> showInventoryBill() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowInventoryBill_1() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();

		ArrayList<InventoryBillPO> result = fixture.showInventoryBill();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.showInventoryBill(BillData.java:173)
		// at
		// data.billdata.BillDataServiceImpl.showInventoryBill(BillDataServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillPO> showInventoryBill() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowInventoryBill_2() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();

		ArrayList<InventoryBillPO> result = fixture.showInventoryBill();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.showInventoryBill(BillData.java:173)
		// at
		// data.billdata.BillDataServiceImpl.showInventoryBill(BillDataServiceImpl.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateInventoryBill(InventoryBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdateInventoryBill_1() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		InventoryBillPO inventoryBillPO = new InventoryBillPO("", new ArrayList(), "", BillType.INVENTORYGIFTBILL,
				BillState.COMMITED, "");

		ResultMessage result = fixture.updateInventoryBill(inventoryBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.updateInventoryBill(BillData.java:112)
		// at
		// data.billdata.BillDataServiceImpl.updateInventoryBill(BillDataServiceImpl.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateInventoryBill(InventoryBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdateInventoryBill_2() throws Exception {
		BillDataServiceImpl fixture = new BillDataServiceImpl();
		fixture.billdata = new BillData();
		InventoryBillPO inventoryBillPO = new InventoryBillPO("", new ArrayList(), "", BillType.INVENTORYGIFTBILL,
				BillState.COMMITED, "");

		ResultMessage result = fixture.updateInventoryBill(inventoryBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.billdata.BillData.updateInventoryBill(BillData.java:112)
		// at
		// data.billdata.BillDataServiceImpl.updateInventoryBill(BillDataServiceImpl.java:40)
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
		new org.junit.runner.JUnitCore().run(BillDataServiceImplTest.class);
	}
}