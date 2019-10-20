package bussinesslogic.accountbillbl;

import java.util.ArrayList;
import org.junit.*;
import vo.billvo.financialbillvo.PaymentBillVO;
import dataenum.BillType;
import po.financialbillpo.EntryPO;
import po.financialbillpo.PaymentBillPO;
import vo.billvo.financialbillvo.EntryVO;
import dataenum.BillState;
import static org.junit.Assert.*;

/**
 * The class <code>PaymentBillTransitionTest</code> contains tests for the class
 * <code>{@link PaymentBillTransition}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:20
 * @author asus
 * @version $Revision: 1.0 $
 */
public class PaymentBillTransitionTest {
	/**
	 * Run the PaymentBillVO POtoVO(PaymentBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testPOtoVO_1() throws Exception {
		PaymentBillTransition fixture = new PaymentBillTransition();
		fixture.entryVO = new EntryVO("", new Double(1.0), "");
		fixture.entryPO = new EntryPO("", 1.0, "");
		PaymentBillPO paymentBillPO = new PaymentBillPO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYBILL, BillState.COMMITED, "");

		PaymentBillVO result = fixture.POtoVO(paymentBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbillbl.PaymentBillTransition
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
	 * Run the PaymentBillVO POtoVO(PaymentBillPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testPOtoVO_2() throws Exception {
		PaymentBillTransition fixture = new PaymentBillTransition();
		fixture.entryVO = new EntryVO("", new Double(1.0), "");
		fixture.entryPO = new EntryPO("", 1.0, "");
		PaymentBillPO paymentBillPO = new PaymentBillPO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYBILL, BillState.COMMITED, "");

		PaymentBillVO result = fixture.POtoVO(paymentBillPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbillbl.PaymentBillTransition
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
	 * Run the PaymentBillPO VOtoPO(PaymentBillVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testVOtoPO_1() throws Exception {
		PaymentBillTransition fixture = new PaymentBillTransition();
		fixture.entryVO = new EntryVO("", new Double(1.0), "");
		fixture.entryPO = new EntryPO("", 1.0, "");
		PaymentBillVO paymentBillVO = new PaymentBillVO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYBILL, BillState.COMMITED, "");

		PaymentBillPO result = fixture.VOtoPO(paymentBillVO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbillbl.PaymentBillTransition
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
	 * Run the PaymentBillPO VOtoPO(PaymentBillVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testVOtoPO_2() throws Exception {
		PaymentBillTransition fixture = new PaymentBillTransition();
		fixture.entryVO = new EntryVO("", new Double(1.0), "");
		fixture.entryPO = new EntryPO("", 1.0, "");
		PaymentBillVO paymentBillVO = new PaymentBillVO("", "", "", "", new ArrayList(), new Double(1.0),
				BillType.INVENTORYBILL, BillState.COMMITED, "");

		PaymentBillPO result = fixture.VOtoPO(paymentBillVO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbillbl.PaymentBillTransition
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
		new org.junit.runner.JUnitCore().run(PaymentBillTransitionTest.class);
	}
}