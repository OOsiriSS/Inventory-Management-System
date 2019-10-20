package data.classificationdata;

import java.util.ArrayList;
import dataenum.ResultMessage;
import po.classificationvpo.ClassificationVPO;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>ClassificationDataServiceImplTest</code> contains tests for
 * the class <code>{@link ClassificationDataServiceImpl}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:26
 * @author asus
 * @version $Revision: 1.0 $
 */
public class ClassificationDataServiceImplTest {
	/**
	 * Run the ClassificationDataServiceImpl() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testClassificationDataServiceImpl_1() throws Exception {

		ClassificationDataServiceImpl result = new ClassificationDataServiceImpl();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage deleteClassification(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testDeleteClassification_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();
		String id = "";

		ResultMessage result = fixture.deleteClassification(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.delete(ClassificationData.java:103)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.deleteClassification(ClassificationDataServiceImpl.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ClassificationVPO findClassification(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testFindClassification_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();
		String keyword = "";

		ClassificationVPO result = fixture.findClassification(keyword);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.find(ClassificationData.java:133)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.findClassification(ClassificationDataServiceImpl.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_2() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_3() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_4() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_5() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetId_6() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		String result = fixture.getID();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getId(ClassificationDataServiceImpl.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the ClassificationVPO getRoot() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testGetRoot_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		ClassificationVPO result = fixture.getRoot();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationData.getRoot(ClassificationData.java:193)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.getRoot(ClassificationDataServiceImpl.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insertClassification(ClassificationVPO) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testInsertClassification_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();
		ClassificationVPO po = new ClassificationVPO("", "", new Boolean(true), "", new ArrayList(), new ArrayList());

		ResultMessage result = fixture.insertClassification(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.insert(ClassificationData.java:78)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.insertClassification(ClassificationDataServiceImpl.java:25)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<ClassificationVPO> show() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testShow_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();

		ArrayList<ClassificationVPO> result = fixture.show();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.show(ClassificationData.java:167)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.show(ClassificationDataServiceImpl.java:71)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateClassification(ClassificationVPO) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:26
	 */
	@Test
	public void testUpdateClassification_1() throws Exception {
		ClassificationDataServiceImpl fixture = new ClassificationDataServiceImpl();
		ClassificationVPO po = new ClassificationVPO("", "", new Boolean(true), "", new ArrayList(), new ArrayList());

		ResultMessage result = fixture.updateClassification(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// data.classificationdata.ClassificationData.update(ClassificationData.java:117)
		// at
		// data.classificationdata.ClassificationDataServiceImpl.updateClassification(ClassificationDataServiceImpl.java:30)
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
		new org.junit.runner.JUnitCore().run(ClassificationDataServiceImplTest.class);
	}
}