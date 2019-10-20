package bussinesslogic.commoditybl;

import org.junit.*;

import po.commoditypo.CommodityPO;
import vo.commodityvo.CommodityVO;
import static org.junit.Assert.*;

/**
 * The class <code>CommodityTransitonTest</code> contains tests for the class
 * <code>{@link CommodityTransiton}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:20
 * @author asus
 * @version $Revision: 1.0 $
 */
public class CommodityTransitonTest {
	/**
	 * Run the CommodityVO POtoVO(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testPOtoVO_1() throws Exception {
		CommodityTransiton fixture = new CommodityTransiton();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		CommodityVO result = fixture.POtoVO(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.commoditybl.CommodityTransiton
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
	 * Run the CommodityPO VOtoPO(CommodityVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testVOtoPO_1() throws Exception {
		CommodityTransiton fixture = new CommodityTransiton();
		CommodityVO vo = new CommodityVO("", "", "", "", 1, 1.0, 1.0, 1);
		vo.setPurPrice(1.0);
		vo.setRecentRetailedPrice(1.0);

		CommodityPO result = fixture.VOtoPO(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: vo.commodityvo.CommodityVO
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
		// com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.execute(InstanceCreationExpression.java:425)
		// at
		// com.instantiations.eclipse.analysis.expression.model.VariableAccessExpression.assign(VariableAccessExpression.java:295)
		// at
		// com.instantiations.eclipse.analysis.expression.model.AssignmentExpression.execute(AssignmentExpression.java:200)
		// at
		// com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:316)
		// at
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		// at
		// com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		// at java.lang.Thread.run(Thread.java:745)
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
		new org.junit.runner.JUnitCore().run(CommodityTransitonTest.class);
	}
}