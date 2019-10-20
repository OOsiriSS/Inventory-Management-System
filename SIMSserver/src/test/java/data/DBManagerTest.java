package data;

import java.sql.Connection;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>DBManagerTest</code> contains tests for the class
 * <code>{@link DBManager}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class DBManagerTest {
	/**
	 * Run the DBManager() constructor test.
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDBManager_1() throws Exception {
		DBManager result = new DBManager();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Connection getConnection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetConnection_1() throws Exception {

		Connection result = DBManager.getConnection();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Connection getConnection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetConnection_2() throws Exception {

		Connection result = DBManager.getConnection();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Connection getConnection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetConnection_3() throws Exception {

		Connection result = DBManager.getConnection();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Connection getConnection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetConnection_4() throws Exception {

		Connection result = DBManager.getConnection();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Connection getConnection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetConnection_5() throws Exception {

		Connection result = DBManager.getConnection();

		// add additional test code here
		assertEquals(null, result);
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
		new org.junit.runner.JUnitCore().run(DBManagerTest.class);
	}
}