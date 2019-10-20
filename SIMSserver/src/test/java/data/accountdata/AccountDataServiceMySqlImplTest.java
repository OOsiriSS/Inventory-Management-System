package data.accountdata;

import java.util.ArrayList;
import org.junit.*;

import dataenum.findtype.FindAccountType;
import po.accountpo.AccountPO;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>AccountDataServiceMySqlImplTest</code> contains tests for the
 * class <code>{@link AccountDataServiceMySqlImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:28
 * @author asus
 * @version $Revision: 1.0 $
 */
public class AccountDataServiceMySqlImplTest {
	/**
	 * Run the AccountDataServiceMySqlImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testAccountDataServiceMySqlImpl_1() throws Exception {

		AccountDataServiceMySqlImpl result = new AccountDataServiceMySqlImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteAccount(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testDeleteAccount_1() throws Exception {
		AccountDataServiceMySqlImpl fixture = new AccountDataServiceMySqlImpl();
		String id = "";

		ResultMessage result = fixture.deleteAccount(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.accountdata.AccountData.delete(AccountData.java:75)
		// at
		// data.accountdata.AccountDataServiceMySqlImpl.deleteAccount(AccountDataServiceMySqlImpl.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<AccountPO> findAccount(String,FindAccountType) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testFindAccount_1() throws Exception {
		AccountDataServiceMySqlImpl fixture = new AccountDataServiceMySqlImpl();
		String keywords = "";
		FindAccountType type = FindAccountType.ID;

		ArrayList<AccountPO> result = fixture.findAccount(keywords, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.accountdata.AccountData.find(AccountData.java:140)
		// at
		// data.accountdata.AccountDataServiceMySqlImpl.findAccount(AccountDataServiceMySqlImpl.java:29)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertAccount(AccountPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testInsertAccount_1() throws Exception {
		AccountDataServiceMySqlImpl fixture = new AccountDataServiceMySqlImpl();
		AccountPO po = new AccountPO("", "", 1.0);

		ResultMessage result = fixture.insertAccount(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.accountdata.AccountData.insert(AccountData.java:44)
		// at
		// data.accountdata.AccountDataServiceMySqlImpl.insertAccount(AccountDataServiceMySqlImpl.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<AccountPO> showAccount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testShowAccount_1() throws Exception {
		AccountDataServiceMySqlImpl fixture = new AccountDataServiceMySqlImpl();

		ArrayList<AccountPO> result = fixture.showAccount();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.accountdata.AccountData.show(AccountData.java:109)
		// at
		// data.accountdata.AccountDataServiceMySqlImpl.showAccount(AccountDataServiceMySqlImpl.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateAccount(AccountPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:28
	 */
	@Test
	public void testUpdateAccount_1() throws Exception {
		AccountDataServiceMySqlImpl fixture = new AccountDataServiceMySqlImpl();
		AccountPO po = new AccountPO("", "", 1.0);

		ResultMessage result = fixture.updateAccount(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at data.accountdata.AccountData.update(AccountData.java:91)
		// at
		// data.accountdata.AccountDataServiceMySqlImpl.updateAccount(AccountDataServiceMySqlImpl.java:50)
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
		new org.junit.runner.JUnitCore().run(AccountDataServiceMySqlImplTest.class);
	}
}