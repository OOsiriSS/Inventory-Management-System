package data.commoditydata;

import java.util.ArrayList;
import dataenum.findtype.FindCommodityType;
import po.commoditypo.CommodityPO;

import org.junit.*;

import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>CommodityDataServiceMySqlImplTest</code> contains tests for
 * the class <code>{@link CommodityDataServiceMySqlImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:27
 * @author asus
 * @version $Revision: 1.0 $
 */
public class CommodityDataServiceMySqlImplTest {
	/**
	 * Run the CommodityDataServiceMySqlImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testCommodityDataServiceMySqlImpl_1() throws Exception {

		CommodityDataServiceMySqlImpl result = new CommodityDataServiceMySqlImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteCommodity(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testDeleteCommodity_1() throws Exception {
		CommodityDataServiceMySqlImpl fixture = new CommodityDataServiceMySqlImpl();
		String id = "";

		ResultMessage result = fixture.deleteCommodity(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.commoditydata.CommodityData.delete(CommodityData.java:74)
		// at
		// data.commoditydata.CommodityDataServiceMySqlImpl.deleteCommodity(CommodityDataServiceMySqlImpl.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<CommodityPO> findCommodity(String,FindCommodityType)
	 * method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testFindCommodity_1() throws Exception {
		CommodityDataServiceMySqlImpl fixture = new CommodityDataServiceMySqlImpl();
		String keywords = "";
		FindCommodityType type = FindCommodityType.CLASSIFICATION;

		ArrayList<CommodityPO> result = fixture.findCommodity(keywords, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.commoditydata.CommodityData.find(CommodityData.java:108)
		// at
		// data.commoditydata.CommodityDataServiceMySqlImpl.findCommodity(CommodityDataServiceMySqlImpl.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertCommodity(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testInsertCommodity_1() throws Exception {
		CommodityDataServiceMySqlImpl fixture = new CommodityDataServiceMySqlImpl();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		ResultMessage result = fixture.insertCommodity(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.commoditydata.CommodityData.insert(CommodityData.java:48)
		// at
		// data.commoditydata.CommodityDataServiceMySqlImpl.insertCommodity(CommodityDataServiceMySqlImpl.java:21)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<CommodityPO> showCommodity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowCommodity_1() throws Exception {
		CommodityDataServiceMySqlImpl fixture = new CommodityDataServiceMySqlImpl();

		ArrayList<CommodityPO> result = fixture.showCommodity();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.commoditydata.CommodityData.show(CommodityData.java:146)
		// at
		// data.commoditydata.CommodityDataServiceMySqlImpl.showCommodity(CommodityDataServiceMySqlImpl.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateCommodity(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdateCommodity_1() throws Exception {
		CommodityDataServiceMySqlImpl fixture = new CommodityDataServiceMySqlImpl();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		ResultMessage result = fixture.updateCommodity(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.commoditydata.CommodityData.update(CommodityData.java:90)
		// at
		// data.commoditydata.CommodityDataServiceMySqlImpl.updateCommodity(CommodityDataServiceMySqlImpl.java:26)
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(CommodityDataServiceMySqlImplTest.class);
	}
}