package data.promotiondata;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.ResultMessage;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionPricePacksPO;

import org.junit.*;
import dataenum.findtype.FindPromotionType;
import static org.junit.Assert.*;

/**
 * The class <code>PromotionSpecialDataServiceImplTest</code> contains tests for
 * the class <code>{@link PromotionSpecialDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:27
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PromotionSpecialDataServiceImplTest {
	/**
	 * Run the PromotionSpecialDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testPromotionSpecialDataServiceImpl_1() throws Exception {

		PromotionSpecialDataServiceImpl result = new PromotionSpecialDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteSpecialPromotion(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testDeleteSpecialPromotion_1() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteSpecialPromotion(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.delete(PromotionData.java:82)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.deleteSpecialPromotion(PromotionSpecialDataServiceImpl.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionPricePacksPO>
	 * findSpecialPromotion(String,FindPromotionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testFindSpecialPromotion_1() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();
		String keyword = "";
		FindPromotionType type = FindPromotionType.ID;

		ArrayList<PromotionPricePacksPO> result = fixture.findSpecialPromotion(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.find(PromotionData.java:117)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.findSpecialPromotion(PromotionSpecialDataServiceImpl.java:59)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertPromotion(PromotionPricePacksPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testInsertPromotion_1() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();
		PromotionPricePacksPO po = new PromotionPricePacksPO("", LocalDate.MAX, LocalDate.MAX, new Double(1.0),
				new ArrayList());

		ResultMessage result = fixture.insertPromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.insertPromotion(PromotionSpecialDataServiceImpl.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testMain_1() throws Exception {
		String[] args = new String[] {};

		PromotionSpecialDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.insertPromotion(PromotionSpecialDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.main(PromotionSpecialDataServiceImpl.java:33)
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testMain_2() throws Exception {
		String[] args = new String[] {};

		PromotionSpecialDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.insertPromotion(PromotionSpecialDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.main(PromotionSpecialDataServiceImpl.java:33)
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testMain_3() throws Exception {
		String[] args = new String[] {};

		PromotionSpecialDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.insertPromotion(PromotionSpecialDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.main(PromotionSpecialDataServiceImpl.java:33)
	}

	/**
	 * Run the ArrayList<PromotionPricePacksPO> showSpecialPromotion() method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowSpecialPromotion_1() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();

		ArrayList<PromotionPricePacksPO> result = fixture.showSpecialPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.showSpecialPromotion(PromotionSpecialDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionPricePacksPO> showSpecialPromotion() method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowSpecialPromotion_2() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();

		ArrayList<PromotionPricePacksPO> result = fixture.showSpecialPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.showSpecialPromotion(PromotionSpecialDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionPricePacksPO> showSpecialPromotion() method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowSpecialPromotion_3() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();

		ArrayList<PromotionPricePacksPO> result = fixture.showSpecialPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.showSpecialPromotion(PromotionSpecialDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updatePromotion(PromotionPricePacksPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdatePromotion_1() throws Exception {
		PromotionSpecialDataServiceImpl fixture = new PromotionSpecialDataServiceImpl();
		PromotionPricePacksPO po = new PromotionPricePacksPO("", LocalDate.MAX, LocalDate.MAX, new Double(1.0),
				new ArrayList());

		ResultMessage result = fixture.updatePromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.update(PromotionData.java:98)
		// at
		// data.promotiondata.PromotionSpecialDataServiceImpl.updatePromotion(PromotionSpecialDataServiceImpl.java:52)
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
		new org.junit.runner.JUnitCore().run(PromotionSpecialDataServiceImplTest.class);
	}
}