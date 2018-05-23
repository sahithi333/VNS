package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.Email.MailProjectClass;
import com.sci.Testmate.TestScripts.Orders_for_this_LocationTestScripts;

public class Orders_for_this_LocationTestSuite {

	Orders_for_this_LocationTestScripts orders_for_this_LocationTestScripts;

	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;

			orders_for_this_LocationTestScripts = new Orders_for_this_LocationTestScripts();
			orders_for_this_LocationTestScripts.orders_For_this_Location();
			orders_for_this_LocationTestScripts.orders_searchFunctionality();
			orders_for_this_LocationTestScripts.filter_Funtionality_Based_on_ServiceType();
			orders_for_this_LocationTestScripts.filter_Funtionality_Based_on_Status();
			afterTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void afterTest() {
		ext.endTest(parentTestReport);
		ext.flush();
		ext.close();
		parentTestReport = null;
		ext = null;

	}

}
