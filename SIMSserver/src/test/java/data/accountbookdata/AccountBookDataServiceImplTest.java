package data.accountbookdata;

import java.util.ArrayList;
import dataenum.ResultMessage;
import org.junit.*;
import dataenum.findtype.FindAccountBookType;
import po.accountbookpo.AccountBookPO;
import po.accountpo.AccountPO;
import po.commoditypo.CommodityPO;
import po.memberpo.MemberPO;

import static org.junit.Assert.*;

/**
 * The class <code>AccountBookDataServiceImplTest</code> contains tests for the
 * class <code>{@link AccountBookDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class AccountBookDataServiceImplTest {
	/**
	 * Run the AccountBookDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testAccountBookDataServiceImpl_1() throws Exception {

		AccountBookDataServiceImpl result = new AccountBookDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteAccountBook(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteAccountBook_1() throws Exception {
		AccountBookDataServiceImpl fixture = new AccountBookDataServiceImpl();
		String ID = "";

		ResultMessage result = fixture.deleteAccountBook(ID);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.accountbookdata.AccountBookData.delete(AccountBookData.java:67)
		// at
		// data.accountbookdata.AccountBookDataServiceImpl.deleteAccountBook(AccountBookDataServiceImpl.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<AccountBookPO> find(String,FindAccountBookType) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFind_1() throws Exception {
		AccountBookDataServiceImpl fixture = new AccountBookDataServiceImpl();
		String keyword = "";
		FindAccountBookType type = null;

		ArrayList<AccountBookPO> result = fixture.find(keyword, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.accountbookdata.AccountBookData.find(AccountBookData.java:102)
		// at
		// data.accountbookdata.AccountBookDataServiceImpl.find(AccountBookDataServiceImpl.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertAccountBook(AccountBookPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertAccountBook_1() throws Exception {
		AccountBookDataServiceImpl fixture = new AccountBookDataServiceImpl();
		AccountBookPO po = new AccountBookPO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		ResultMessage result = fixture.insertAccountBook(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.accountbookdata.AccountBookData.insert(AccountBookData.java:41)
		// at
		// data.accountbookdata.AccountBookDataServiceImpl.insertAccountBook(AccountBookDataServiceImpl.java:26)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<AccountBookPO> showAccountBook() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShowAccountBook_1() throws Exception {
		AccountBookDataServiceImpl fixture = new AccountBookDataServiceImpl();

		ArrayList<AccountBookPO> result = fixture.showAccountBook();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.accountbookdata.AccountBookData.show(AccountBookData.java:141)
		// at
		// data.accountbookdata.AccountBookDataServiceImpl.showAccountBook(AccountBookDataServiceImpl.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateAccountBook(AccountBookPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdateAccountBook_1() throws Exception {
		AccountBookDataServiceImpl fixture = new AccountBookDataServiceImpl();
		AccountBookPO po = new AccountBookPO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		ResultMessage result = fixture.updateAccountBook(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.accountbookdata.AccountBookData.update(AccountBookData.java:83)
		// at
		// data.accountbookdata.AccountBookDataServiceImpl.updateAccountBook(AccountBookDataServiceImpl.java:36)
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
		new org.junit.runner.JUnitCore().run(AccountBookDataServiceImplTest.class);
	}
}