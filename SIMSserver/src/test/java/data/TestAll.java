package data;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 18-1-12 обнГ9:28
 * @author asus
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ DBManagerTest.class, data.accountbookdata.TestAll.class, data.accountdata.TestAll.class,
		data.billdata.TestAll.class, data.classificationdata.TestAll.class, data.commoditydata.TestAll.class,
		data.databaseutility.TestAll.class, data.datafactory.TestAll.class, data.memberdata.TestAll.class,
		data.messagedata.TestAll.class, data.paymentbilldata.TestAll.class, data.promotiondata.TestAll.class,
		data.purchasedata.TestAll.class, data.receiptbilldata.TestAll.class, data.salesdata.TestAll.class,
		data.userdata.TestAll.class, })
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 18-1-12 обнГ9:28
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
