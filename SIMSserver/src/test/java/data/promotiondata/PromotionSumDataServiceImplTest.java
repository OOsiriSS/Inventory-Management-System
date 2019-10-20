package data.promotiondata;

import java.time.LocalDate;
import java.util.ArrayList;

import po.commoditypo.GiftPO;
import po.promotionpo.PromotionTotalPO;
import dataenum.ResultMessage;
import org.junit.*;
import dataenum.findtype.FindPromotionType;
import static org.junit.Assert.*;

/**
 * The class <code>PromotionSumDataServiceImplTest</code> contains tests for the
 * class <code>{@link PromotionSumDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PromotionSumDataServiceImplTest {
	/**
	 * Run the PromotionSumDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testPromotionSumDataServiceImpl_1() throws Exception {

		PromotionSumDataServiceImpl result = new PromotionSumDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteSumPromotion(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteSumPromotion_1() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteSumPromotion(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.delete(PromotionData.java:82)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.deleteSumPromotion(PromotionSumDataServiceImpl.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionTotalPO>
	 * findSumPromotion(String,FindPromotionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindSumPromotion_1() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();
		String keyword = "";
		FindPromotionType type = FindPromotionType.ID;

		ArrayList<PromotionTotalPO> result = fixture.findSumPromotion(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.find(PromotionData.java:117)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.findSumPromotion(PromotionSumDataServiceImpl.java:57)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertPromotion(PromotionTotalPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertPromotion_1() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();
		PromotionTotalPO po = new PromotionTotalPO("", LocalDate.MAX, LocalDate.MAX, new Double(1.0), new Double(1.0),
				new ArrayList());

		ResultMessage result = fixture.insertPromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.insertPromotion(PromotionSumDataServiceImpl.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testMain_1() throws Exception {
		String[] args = new String[] {};

		PromotionSumDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.insertPromotion(PromotionSumDataServiceImpl.java:39)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.main(PromotionSumDataServiceImpl.java:32)
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testMain_2() throws Exception {
		String[] args = new String[] {};

		PromotionSumDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.insertPromotion(PromotionSumDataServiceImpl.java:39)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.main(PromotionSumDataServiceImpl.java:32)
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testMain_3() throws Exception {
		String[] args = new String[] {};

		PromotionSumDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.insertPromotion(PromotionSumDataServiceImpl.java:39)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.main(PromotionSumDataServiceImpl.java:32)
	}

	/**
	 * Run the ArrayList<PromotionTotalPO> showSumPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowSumPromotion_1() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();

		ArrayList<PromotionTotalPO> result = fixture.showSumPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.showSumPromotion(PromotionSumDataServiceImpl.java:63)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionTotalPO> showSumPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowSumPromotion_2() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();

		ArrayList<PromotionTotalPO> result = fixture.showSumPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.showSumPromotion(PromotionSumDataServiceImpl.java:63)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionTotalPO> showSumPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowSumPromotion_3() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();

		ArrayList<PromotionTotalPO> result = fixture.showSumPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.showSumPromotion(PromotionSumDataServiceImpl.java:63)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updatePromotion(PromotionTotalPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdatePromotion_1() throws Exception {
		PromotionSumDataServiceImpl fixture = new PromotionSumDataServiceImpl();
		PromotionTotalPO po = new PromotionTotalPO("", LocalDate.MAX, LocalDate.MAX, new Double(1.0), new Double(1.0),
				new ArrayList());

		ResultMessage result = fixture.updatePromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.update(PromotionData.java:98)
		// at
		// data.promotiondata.PromotionSumDataServiceImpl.updatePromotion(PromotionSumDataServiceImpl.java:51)
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
		new org.junit.runner.JUnitCore().run(PromotionSumDataServiceImplTest.class);
	}
}