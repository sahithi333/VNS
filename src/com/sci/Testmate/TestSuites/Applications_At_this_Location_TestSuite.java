package com.sci.Testmate.TestSuites;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.parentTestReport;


import org.junit.Test;

import com.sci.Testmate.TestScripts.Applications_At_This_Location_TestScripts;
import com.sci.Testmate.TestScripts.LaunchTestScript;

public class Applications_At_this_Location_TestSuite {
	LaunchTestScript launchTestScript;
	Applications_At_This_Location_TestScripts applications_At_This_Location_TestScripts;

	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			applications_At_This_Location_TestScripts = new Applications_At_This_Location_TestScripts();

			applications_At_This_Location_TestScripts.addApplication_AtThis_Location();
			applications_At_This_Location_TestScripts.editApplication_AtThis_Location();
		    applications_At_This_Location_TestScripts.delete_Application_AtThis_Location();

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
