package data.memberdata;

import java.util.ArrayList;
import org.junit.*;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.findtype.FindMemberType;
import po.memberpo.MemberPO;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>MemberDataServiceImplTest</code> contains tests for the class
 * <code>{@link MemberDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:27
 * @author asus
 * @version $Revision: 1.0 $
 */
public class MemberDataServiceImplTest {
	/**
	 * Run the MemberDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testMemberDataServiceImpl_1() throws Exception {

		MemberDataServiceImpl result = new MemberDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteMember(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testDeleteMember_1() throws Exception {
		MemberDataServiceImpl fixture = new MemberDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteMember(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.memberdata.MemberData.delete(MemberData.java:74)
		// at
		// data.memberdata.MemberDataServiceImpl.deleteMember(MemberDataServiceImpl.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<MemberPO> findMember(String,FindMemberType) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testFindMember_1() throws Exception {
		MemberDataServiceImpl fixture = new MemberDataServiceImpl();
		String keyword = "";
		FindMemberType type = FindMemberType.ADDRESS;

		ArrayList<MemberPO> result = fixture.findMember(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.memberdata.MemberData.find(MemberData.java:108)
		// at
		// data.memberdata.MemberDataServiceImpl.findMember(MemberDataServiceImpl.java:55)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertMember(MemberPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testInsertMember_1() throws Exception {
		MemberDataServiceImpl fixture = new MemberDataServiceImpl();
		MemberPO po = new MemberPO("", MemberCategory.BOTH, MemberLevel.LEVEL1, "", "", "", "", "", 1.0, "");

		ResultMessage result = fixture.insertMember(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.memberdata.MemberData.insert(MemberData.java:40)
		// at
		// data.memberdata.MemberDataServiceImpl.insertMember(MemberDataServiceImpl.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<MemberPO> showMember() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowMember_1() throws Exception {
		MemberDataServiceImpl fixture = new MemberDataServiceImpl();

		ArrayList<MemberPO> result = fixture.showMember();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.memberdata.MemberData.show(MemberData.java:198)
		// at
		// data.memberdata.MemberDataServiceImpl.showMember(MemberDataServiceImpl.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateMember(MemberPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdateMember_1() throws Exception {
		MemberDataServiceImpl fixture = new MemberDataServiceImpl();
		MemberPO po = new MemberPO("", MemberCategory.BOTH, MemberLevel.LEVEL1, "", "", "", "", "", 1.0, "");

		ResultMessage result = fixture.updateMember(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.memberdata.MemberData.update(MemberData.java:90)
		// at
		// data.memberdata.MemberDataServiceImpl.updateMember(MemberDataServiceImpl.java:43)
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
		new org.junit.runner.JUnitCore().run(MemberDataServiceImplTest.class);
	}
}