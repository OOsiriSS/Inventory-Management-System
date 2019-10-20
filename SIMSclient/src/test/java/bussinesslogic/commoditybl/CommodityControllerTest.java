package bussinesslogic.commoditybl;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityVO;
import dataenum.ResultMessage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CommodityControllerTest</code> contains tests for the class
 * <code>{@link CommodityController}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:20
 * @author asus
 * @version $Revision: 1.0 $
 */
public class CommodityControllerTest {
	/**
	 * Run the CommodityController() constructor test.
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testCommodityController_1() throws Exception {
		CommodityController result = new CommodityController();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the ArrayList<CommodityCheckVO> check(LocalDate,LocalDate) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testCheck_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		LocalDate start = LocalDate.MAX;
		LocalDate end = LocalDate.MAX;

		ArrayList<CommodityCheckVO> result = fixture.check(start, end);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.commoditybl.CommodityController
		// at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		// at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		// at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		// at
		// com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		// at
		// com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		// at
		// com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		// at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage delete(CommodityVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testDelete_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		CommodityVO vo = new CommodityVO("", "", "", "", 1, 1.0, 1.0, 1);

		ResultMessage result = fixture.delete(vo);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage delete(CommodityVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testDelete_2() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		CommodityVO vo = new CommodityVO("", "", "", "", 1, 1.0, 1.0, 1);

		ResultMessage result = fixture.delete(vo);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void exportReport(ArrayList<CommodityStockVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testExportReport_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		ArrayList<CommodityStockVO> commodityStockVOs = new ArrayList();

		fixture.exportReport(commodityStockVOs);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.commoditybl.CommodityController
		// at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		// at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		// at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		// at
		// com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		// at
		// com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		// at
		// com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		// at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the ArrayList<CommodityVO> find(String,FindCommodityType) method
	 * test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testFind_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		String info = "";
		FindCommodityType properties = FindCommodityType.CLASSIFICATION;

		ArrayList<CommodityVO> result = fixture.find(info, properties);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<String> getAllChildrenClass() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testGetAllChildrenClass_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();

		ArrayList<String> result = fixture.getAllChildrenClass();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<String> getAllChildrenClass() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testGetAllChildrenClass_2() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();

		ArrayList<String> result = fixture.getAllChildrenClass();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getID(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testGetID_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		String name = "";

		String result = fixture.getID(name);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<String> getIDandName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testGetIDandName_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();

		ArrayList<String> result = fixture.getIDandName();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage insert(CommodityVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testInsert_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		CommodityVO vo = new CommodityVO("", "", "", "", 1, 1.0, 1.0, 1);

		ResultMessage result = fixture.insert(vo);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<CommodityVO> show() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testShow_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();

		ArrayList<CommodityVO> result = fixture.show();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<CommodityStockVO> stock() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testStock_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();

		ArrayList<CommodityStockVO> result = fixture.stock();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage update(CommodityVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test(expected = java.lang.ClassNotFoundException.class)
	public void testUpdate_1() throws Exception {
		CommodityController fixture = new CommodityController();
		fixture.commodityBL = new CommodityBL();
		CommodityVO vo = new CommodityVO("", "", "", "", 1, 1.0, 1.0, 1);

		ResultMessage result = fixture.update(vo);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
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
	 * @generatedBy CodePro at 18-1-12 下午9:20
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
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CommodityControllerTest.class);
	}
}