package bussinesslogic.accountbookbl;

import java.util.ArrayList;
import vo.accountvo.AccountVO;
import vo.membervo.MemberVO;
import bussinesslogic.memberbl.MemberTransition;
import bussinesslogic.accountbl.AccountTransition;
import vo.commodityvo.CommodityVO;
import po.accountbookpo.AccountBookPO;
import po.accountpo.AccountPO;
import po.commoditypo.CommodityPO;

import org.junit.*;

import po.memberpo.MemberPO;
import vo.accountbookvo.AccountBookVO;
import bussinesslogic.commoditybl.CommodityTransiton;
import static org.junit.Assert.*;

/**
 * The class <code>AccountBookTransitionTest</code> contains tests for the class
 * <code>{@link AccountBookTransition}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:20
 * @author asus
 * @version $Revision: 1.0 $
 */
public class AccountBookTransitionTest {
	/**
	 * Run the AccountBookTransition() constructor test.
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testAccountBookTransition_1() throws Exception {
		AccountBookTransition result = new AccountBookTransition();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the AccountBookVO POtoVO(AccountBookPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testPOtoVO_1() throws Exception {
		AccountBookTransition fixture = new AccountBookTransition();
		fixture.commodityTransiton = new CommodityTransiton();
		fixture.memberTransition = new MemberTransition();
		fixture.accountTransition = new AccountTransition();
		AccountBookPO accountBookPO = new AccountBookPO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		AccountBookVO result = fixture.POtoVO(accountBookPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbookbl.AccountBookTransition
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
	 * Run the AccountBookVO POtoVO(AccountBookPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testPOtoVO_2() throws Exception {
		AccountBookTransition fixture = new AccountBookTransition();
		fixture.commodityTransiton = new CommodityTransiton();
		fixture.memberTransition = new MemberTransition();
		fixture.accountTransition = new AccountTransition();
		AccountBookPO accountBookPO = new AccountBookPO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		AccountBookVO result = fixture.POtoVO(accountBookPO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbookbl.AccountBookTransition
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
	 * Run the AccountBookPO VOtoPO(AccountBookVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testVOtoPO_1() throws Exception {
		AccountBookTransition fixture = new AccountBookTransition();
		fixture.commodityTransiton = new CommodityTransiton();
		fixture.memberTransition = new MemberTransition();
		fixture.accountTransition = new AccountTransition();
		AccountBookVO accountBookVO = new AccountBookVO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		AccountBookPO result = fixture.VOtoPO(accountBookVO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbookbl.AccountBookTransition
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
	 * Run the AccountBookPO VOtoPO(AccountBookVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:20
	 */
	@Test
	public void testVOtoPO_2() throws Exception {
		AccountBookTransition fixture = new AccountBookTransition();
		fixture.commodityTransiton = new CommodityTransiton();
		fixture.memberTransition = new MemberTransition();
		fixture.accountTransition = new AccountTransition();
		AccountBookVO accountBookVO = new AccountBookVO("", "", new ArrayList(), new ArrayList(), new ArrayList());

		AccountBookPO result = fixture.VOtoPO(accountBookVO);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException:
		// bussinesslogic.accountbookbl.AccountBookTransition
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
		new org.junit.runner.JUnitCore().run(AccountBookTransitionTest.class);
	}
}