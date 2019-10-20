package data.userdata;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import po.userpo.UserPO;
import dataenum.findtype.FindUserType;
import dataenum.UserRole;
import dataenum.ResultMessage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UserDataServiceImplTest</code> contains tests for the class
 * <code>{@link UserDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:27
 * @author asus
 * @version $Revision: 1.0 $
 */
public class UserDataServiceImplTest {
	/**
	 * Run the UserDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUserDataServiceImpl_1() throws Exception {

		UserDataServiceImpl result = new UserDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteUser(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testDeleteUser_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteUser(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.userdata.UserData.delete(UserData.java:77)
		// at
		// data.userdata.UserDataServiceImpl.deleteUser(UserDataServiceImpl.java:52)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<UserPO> findUser(String,FindUserType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testFindUser_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String info = "";
		FindUserType type = FindUserType.ID;

		ArrayList<UserPO> result = fixture.findUser(info, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.userdata.UserData.find(UserData.java:96)
		// at
		// data.userdata.UserDataServiceImpl.findUser(UserDataServiceImpl.java:104)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertUser(UserPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testInsertUser_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		UserPO po = new UserPO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ResultMessage result = fixture.insertUser(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.userdata.UserData.insert(UserData.java:43)
		// at
		// data.userdata.UserDataServiceImpl.insertUser(UserDataServiceImpl.java:47)
		assertNotNull(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_2() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_3() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_4() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_5() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_6() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_7() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_8() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_9() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_10() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_11() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_12() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_13() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_14() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
	}

	/**
	 * Run the boolean login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testLogin_15() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		String id = "";
		String password = "";

		boolean result = fixture.login(id, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		assertTrue(result);
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

		UserDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		// at
		// data.userdata.UserDataServiceImpl.main(UserDataServiceImpl.java:42)
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

		UserDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		// at
		// data.userdata.UserDataServiceImpl.main(UserDataServiceImpl.java:42)
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

		UserDataServiceImpl.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.userdata.UserDataServiceImpl.login(UserDataServiceImpl.java:72)
		// at
		// data.userdata.UserDataServiceImpl.main(UserDataServiceImpl.java:42)
	}

	/**
	 * Run the ArrayList<UserPO> showUser() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testShowUser_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();

		ArrayList<UserPO> result = fixture.showUser();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.userdata.UserData.show(UserData.java:157)
		// at
		// data.userdata.UserDataServiceImpl.showUser(UserDataServiceImpl.java:62)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateUser(UserPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:27
	 */
	@Test
	public void testUpdateUser_1() throws Exception {
		UserDataServiceImpl fixture = new UserDataServiceImpl();
		UserPO po = new UserPO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ResultMessage result = fixture.updateUser(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.userdata.UserData.update(UserData.java:139)
		// at
		// data.userdata.UserDataServiceImpl.updateUser(UserDataServiceImpl.java:57)
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
		new org.junit.runner.JUnitCore().run(UserDataServiceImplTest.class);
	}
}