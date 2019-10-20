package bussinesslogic.utilitybl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import bussinesslogic.userbl.UserController;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;
import dataenum.UserRole;
import javafx.scene.image.ImageView;
import org.junit.*;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import po.commoditypo.CommodityPO;
import po.messagepo.MessagePO;

import static org.junit.Assert.*;

/**
 * The class <code>UtilityBLTest</code> contains tests for the class
 * <code>{@link UtilityBL}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:21
 * @author asus
 * @version $Revision: 1.0 $
 */
public class UtilityBLTest {
	/**
	 * Run the UtilityBL() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testUtilityBL_1() throws Exception {

		UtilityBL result = new UtilityBL();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		// com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		// at
		// com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		// at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the UtilityBL getInstance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetInstance_1() throws Exception {

		UtilityBL result = UtilityBL.getInstance();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the ArrayList<MessageVO> getMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetMessage_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ArrayList<MessageVO> result = fixture.getMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the ArrayList<MessageVO> getMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetMessage_2() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ArrayList<MessageVO> result = fixture.getMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the ArrayList<MessageVO> getMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetMessage_3() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ArrayList<MessageVO> result = fixture.getMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the ArrayList<MessageVO> getMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetMessage_4() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		ArrayList<MessageVO> result = fixture.getMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the UtilityBLService getUtilityBLService() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testGetUtilityBLService_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();

		UtilityBLService result = fixture.getUtilityBLService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the boolean hasMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testHasMessage_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		boolean result = fixture.hasMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the boolean hasMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testHasMessage_2() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		boolean result = fixture.hasMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the boolean hasMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testHasMessage_3() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		boolean result = fixture.hasMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the boolean hasMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testHasMessage_4() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		boolean result = fixture.hasMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the boolean hasMessage(UserVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testHasMessage_5() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		UserVO user = new UserVO("", "", "", UserRole.FINANCIAL_MANAGER, new ImageView());

		boolean result = fixture.hasMessage(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the boolean isPrintLegal(ArrayList<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testIsPrintLegal_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		ArrayList<String> list = new ArrayList();

		boolean result = fixture.isPrintLegal(list);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
		assertTrue(result);
	}

	/**
	 * Run the MessageVO poTovo(MessagePO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testPoTovo_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		MessagePO po = new MessagePO("", "", "", LocalDateTime.MAX, true);
		po.setUserID("");
		po.setMessageID("");

		MessageVO result = fixture.poTovo(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: po.messagepo.MessagePO
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
	 * Run the void saveMessage(MessageVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testSaveMessage_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		MessageVO message = new MessageVO("", "", "", LocalDateTime.MAX, true);

		fixture.saveMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void saveMessage(MessageVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testSaveMessage_2() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		MessageVO message = new MessageVO("", "", "", LocalDateTime.MAX, true);

		fixture.saveMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the MessagePO voTopo(MessageVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testVoTopo_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		MessageVO vo = new MessageVO("", "", "", LocalDateTime.MAX, true);
		vo.setUserID("");
		vo.setMessageID("");

		MessagePO result = fixture.voTopo(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: vo.messagevo.MessageVO
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_1() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_2() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_3() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_4() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_5() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Run the void warningMessage(CommodityPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testWarningMessage_6() throws Exception {
		UtilityBL fixture = new UtilityBL();
		fixture.bl = new UserController();
		CommodityPO po = new CommodityPO("", "", "", "", 1, 1.0, 1.0, 1.0, 1.0, 1);

		fixture.warningMessage(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: bussinesslogic.utilitybl.UtilityBL
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
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
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
	 * @generatedBy CodePro at 18-1-12 下午9:21
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
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UtilityBLTest.class);
	}
}