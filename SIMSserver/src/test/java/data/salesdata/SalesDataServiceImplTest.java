package data.salesdata;

import java.util.ArrayList;
import org.junit.*;

import dataenum.findtype.FindSalesType;
import po.salespo.SalesPO;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>SalesDataServiceImplTest</code> contains tests for the class
 * <code>{@link SalesDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:27
 * @author asus
 * @version $Revision: 1.0 $
 */
public class SalesDataServiceImplTest {
	/**
	 * Run the SalesDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testSalesDataServiceImpl_1() throws Exception {

		SalesDataServiceImpl result = new SalesDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getSaleBackID());
		assertEquals(null, result.showSale());
		assertEquals(null, result.getSaleID());
	}

	/**
	 * Run the ResultMessage deleteSale(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testDeleteSale_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteSale(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.salesdata.SalesData.delete(SalesData.java:95)
		// at
		// data.salesdata.SalesDataServiceImpl.deleteSale(SalesDataServiceImpl.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<SalesPO> findSale(String,FindSalesType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testFindSale_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();
		String info = "";
		FindSalesType type = FindSalesType.ID;

		ArrayList<SalesPO> result = fixture.findSale(info, type);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getSaleBackID() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testGetSaleBackID_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();

		String result = fixture.getSaleBackID();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getSaleID() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testGetSaleID_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();

		String result = fixture.getSaleID();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the ResultMessage insertSale(SalesPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testInsertSale_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();
		SalesPO po = new SalesPO();

		ResultMessage result = fixture.insertSale(po);

		// add additional test code here
		assertNotNull(result);
		assertEquals("FAIL", result.name());
		assertEquals("FAIL", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the ArrayList<SalesPO> showSale() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowSale_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();

		ArrayList<SalesPO> result = fixture.showSale();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the ArrayList<SalesPO> showSale() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowSale_2() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();

		ArrayList<SalesPO> result = fixture.showSale();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the ResultMessage updateSale(SalesPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdateSale_1() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();
		SalesPO po = new SalesPO();

		ResultMessage result = fixture.updateSale(po);

		// add additional test code here
		assertNotNull(result);
		assertEquals("FAIL", result.name());
		assertEquals("FAIL", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the ResultMessage updateSale(SalesPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdateSale_2() throws Exception {
		SalesDataServiceImpl fixture = new SalesDataServiceImpl();
		SalesPO po = new SalesPO();

		ResultMessage result = fixture.updateSale(po);

		// add additional test code here
		assertNotNull(result);
		assertEquals("FAIL", result.name());
		assertEquals("FAIL", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
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
	 * @generatedBy CodePro at 18-1-12 下午9:27
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
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SalesDataServiceImplTest.class);
	}
}