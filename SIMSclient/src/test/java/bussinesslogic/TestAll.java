package bussinesslogic;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 18-1-12 обнГ9:21
 * @author asus
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ bussinesslogic.accountbillbl.TestAll.class, bussinesslogic.accountbl.TestAll.class,
		bussinesslogic.accountbookbl.TestAll.class, bussinesslogic.billbl.TestAll.class,
		bussinesslogic.classificationbl.TestAll.class, bussinesslogic.commoditybl.TestAll.class,
		bussinesslogic.common.TestAll.class, bussinesslogic.examinebl.TestAll.class,
		bussinesslogic.memberbl.TestAll.class, bussinesslogic.promotionbl.TestAll.class,
		bussinesslogic.purchasebl.TestAll.class, bussinesslogic.salesbl.TestAll.class,
		bussinesslogic.userbl.TestAll.class, bussinesslogic.utilitybl.TestAll.class, })
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 18-1-12 обнГ9:21
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
