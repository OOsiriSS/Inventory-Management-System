package data.promotiondata;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import po.commoditypo.GiftPO;
import po.promotionpo.PromotionMemberPO;
import org.junit.*;
import dataenum.findtype.FindPromotionType;
import static org.junit.Assert.*;

/**
 * The class <code>PromotionMemberDataServiceImplTest</code> contains tests for
 * the class <code>{@link PromotionMemberDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PromotionMemberDataServiceImplTest {
	/**
	 * Run the PromotionMemberDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testPromotionMemberDataServiceImpl_1() throws Exception {

		PromotionMemberDataServiceImpl result = new PromotionMemberDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteMemberPromotion(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteMemberPromotion_1() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteMemberPromotion(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.delete(PromotionData.java:82)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.deleteMemberPromotion(PromotionMemberDataServiceImpl.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionMemberPO>
	 * findMemberPromotion(String,FindPromotionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindMemberPromotion_1() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();
		String keyword = "";
		FindPromotionType type = FindPromotionType.ID;

		ArrayList<PromotionMemberPO> result = fixture.findMemberPromotion(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.find(PromotionData.java:117)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.findMemberPromotion(PromotionMemberDataServiceImpl.java:59)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertPromotion(PromotionMemberPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertPromotion_1() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();
		PromotionMemberPO po = new PromotionMemberPO("", LocalDate.MAX, LocalDate.MAX, MemberLevel.LEVEL1,
				new Double(1.0), new Double(1.0), new ArrayList());

		ResultMessage result = fixture.insertPromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.insertPromotion(PromotionMemberDataServiceImpl.java:40)
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

		PromotionMemberDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.insertPromotion(PromotionMemberDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.main(PromotionMemberDataServiceImpl.java:29)
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

		PromotionMemberDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.insertPromotion(PromotionMemberDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.main(PromotionMemberDataServiceImpl.java:29)
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

		PromotionMemberDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.insert(PromotionData.java:47)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.insertPromotion(PromotionMemberDataServiceImpl.java:40)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.main(PromotionMemberDataServiceImpl.java:29)
	}

	/**
	 * Run the ArrayList<PromotionMemberPO> showMemberPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowMemberPromotion_1() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();

		ArrayList<PromotionMemberPO> result = fixture.showMemberPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.showMemberPromotion(PromotionMemberDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionMemberPO> showMemberPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowMemberPromotion_2() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();

		ArrayList<PromotionMemberPO> result = fixture.showMemberPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.showMemberPromotion(PromotionMemberDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<PromotionMemberPO> showMemberPromotion() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowMemberPromotion_3() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();

		ArrayList<PromotionMemberPO> result = fixture.showMemberPromotion();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.show(PromotionData.java:158)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.showMemberPromotion(PromotionMemberDataServiceImpl.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updatePromotion(PromotionMemberPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdatePromotion_1() throws Exception {
		PromotionMemberDataServiceImpl fixture = new PromotionMemberDataServiceImpl();
		PromotionMemberPO po = new PromotionMemberPO("", LocalDate.MAX, LocalDate.MAX, MemberLevel.LEVEL1,
				new Double(1.0), new Double(1.0), new ArrayList());

		ResultMessage result = fixture.updatePromotion(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.promotiondata.PromotionData.update(PromotionData.java:98)
		// at
		// data.promotiondata.PromotionMemberDataServiceImpl.updatePromotion(PromotionMemberDataServiceImpl.java:52)
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
		new org.junit.runner.JUnitCore().run(PromotionMemberDataServiceImplTest.class);
	}
}