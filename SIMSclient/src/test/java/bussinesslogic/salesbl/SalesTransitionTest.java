package bussinesslogic.salesbl;

import java.util.ArrayList;
import vo.billvo.salesbillvo.SalesVO;
import po.commoditypo.CommodityItemPO;
import po.commoditypo.GiftPO;
import po.salespo.SalesPO;
import dataenum.BillType;
import vo.commodityvo.GiftVO;
import dataenum.BillState;

import org.junit.*;
import dataenum.Warehouse;
import vo.commodityvo.CommodityItemVO;

import static org.junit.Assert.*;

/**
 * The class <code>SalesTransitionTest</code> contains tests for the class
 * <code>{@link SalesTransition}</code>.
 *
 * @generatedBy CodePro at 18-1-12 下午9:21
 * @author asus
 * @version $Revision: 1.0 $
 */
public class SalesTransitionTest {
	/**
	 * Run the SalesVO POtoVO(SalesPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testPOtoVO_1() throws Exception {
		SalesPO po = new SalesPO("", "", "", "", "", Warehouse.WAREHOUSE1, new ArrayList(), new ArrayList(), 1.0, 1.0,
				1.0, 1.0, "", BillType.INVENTORYBILL, BillState.COMMITED);
		po.setGifts(new ArrayList());

		SalesVO result = SalesTransition.POtoVO(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: po.sales.SalesPO
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
	 * Run the SalesVO POtoVO(SalesPO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testPOtoVO_2() throws Exception {
		SalesPO po = new SalesPO("", "", "", "", "", Warehouse.WAREHOUSE1, new ArrayList(), new ArrayList(), 1.0, 1.0,
				1.0, 1.0, "", BillType.INVENTORYBILL, BillState.COMMITED);
		po.setGifts(new ArrayList());

		SalesVO result = SalesTransition.POtoVO(po);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: po.sales.SalesPO
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
	 * Run the SalesPO VOtoPO(SalesVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testVOtoPO_1() throws Exception {
		SalesVO vo = new SalesVO("", "", "", "", Warehouse.WAREHOUSE1, new ArrayList(), new ArrayList(),
				new Double(1.0), new Double(1.0), new Double(1.0), new Double(1.0), "", BillState.COMMITED,
				BillType.INVENTORYBILL);
		vo.setGifts(new ArrayList());
		vo.setWarehouse(Warehouse.WAREHOUSE1);
		vo.setCommodity(new ArrayList());
		vo.setSaleMan("");
		vo.setAllowance(new Double(1.0));
		vo.setBeforePrice(new Double(1.0));
		vo.setRetailerID("");
		vo.setRetailer("");
		vo.setOperator("");
		vo.setAfterPrice(new Double(1.0));
		vo.setVoucher(new Double(1.0));

		SalesPO result = SalesTransition.VOtoPO(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: vo.billvo.salesbillvo.SalesVO
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
	 * Run the SalesPO VOtoPO(SalesVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 下午9:21
	 */
	@Test
	public void testVOtoPO_2() throws Exception {
		SalesVO vo = new SalesVO("", "", "", "", Warehouse.WAREHOUSE1, new ArrayList(), new ArrayList(),
				new Double(1.0), new Double(1.0), new Double(1.0), new Double(1.0), "", BillState.COMMITED,
				BillType.INVENTORYBILL);
		vo.setGifts(new ArrayList());
		vo.setWarehouse(Warehouse.WAREHOUSE1);
		vo.setCommodity(new ArrayList());
		vo.setSaleMan("");
		vo.setAllowance(new Double(1.0));
		vo.setBeforePrice(new Double(1.0));
		vo.setRetailerID("");
		vo.setRetailer("");
		vo.setOperator("");
		vo.setAfterPrice(new Double(1.0));
		vo.setVoucher(new Double(1.0));

		SalesPO result = SalesTransition.VOtoPO(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ClassNotFoundException: vo.billvo.salesbillvo.SalesVO
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
		new org.junit.runner.JUnitCore().run(SalesTransitionTest.class);
	}
}