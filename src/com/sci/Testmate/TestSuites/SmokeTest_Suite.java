package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import javax.mail.MessagingException;

import org.junit.Test;

import com.sci.Testmate.Email.MailProjectClass;
import com.sci.Testmate.TestScripts.Bandwidth_Alerts_by_Location_TestScripts;
import com.sci.Testmate.TestScripts.Homepage_TestScripts;
import com.sci.Testmate.TestScripts.LaunchTestScript;
import com.sci.Testmate.TestScripts.Locations_TestScript;
import com.sci.Testmate.TestScripts.Policy_Setup_your_UserGroups_TestScripts;

public class SmokeTest_Suite {
	LaunchTestScript launchTestScript;
	Bandwidth_Alerts_by_Location_TestScripts bandwidth_Alerts_by_Location_TestScripts;
	Locations_TestScript locations_TestScript;
	Homepage_TestScripts homepage_TestScripts;

	LaunchTestSuite launchTestSuite;
	Homepage_TestSuite homepage_TestSuite;
	Bandwidth_Alerts_by_Location_TestSuite bandwidth_Alerts_by_Location_TestSuite;
	Policy_user_groups_TestSuite policy_TestSuite;
	Orders_for_this_LocationTestSuite orders_for_this_LocationTestSuite;
	User_Groups_at_this_Location_TestSuite user_Groups_at_this_Location_TestSuite;
	
	Inventory_For_This_LocationTestSuite inventory_For_This_LocationTestSuite;
	
	Applications_At_this_Location_TestSuite applications_At_this_Location_TestSuite;
	
	
	@Test
	public void test() { 
		try {
			isExcutingFromTestSuite = true;
			
			launchTestSuite  = new LaunchTestSuite();
			launchTestSuite.test();
			
			orders_for_this_LocationTestSuite = new Orders_for_this_LocationTestSuite();
			orders_for_this_LocationTestSuite.test();
			
/*			inventory_For_This_LocationTestSuite = new Inventory_For_This_LocationTestSuite();
			inventory_For_This_LocationTestSuite.test();

			policy_TestSuite = new Policy_user_groups_TestSuite();
			policy_TestSuite.test();
*/			
		//	afterTest();
			
/*			bandwidth_Alerts_by_Location_TestSuite = new Bandwidth_Alerts_by_Location_TestSuite();
			bandwidth_Alerts_by_Location_TestSuite.test();
			
		    applications_At_this_Location_TestSuite = new Applications_At_this_Location_TestSuite();
			applications_At_this_Location_TestSuite.test();

			
			user_Groups_at_this_Location_TestSuite = new User_Groups_at_this_Location_TestSuite();
			user_Groups_at_this_Location_TestSuite.test();		
*/				
			



		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void afterTest() throws MessagingException {
		MailProjectClass.sendmail();	
	}

	
	
	
	

}
