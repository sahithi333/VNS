package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.TestScripts.Bandwidth_Alerts_by_Location_TestScripts;
import com.sci.Testmate.TestScripts.Homepage_TestScripts;
import com.sci.Testmate.TestScripts.LaunchTestScript;

public class Homepage_TestSuite {
	
	
	LaunchTestScript launchTestScript;
	Bandwidth_Alerts_by_Location_TestScripts bandwidth_Alerts_by_Location_TestScripts;
	Homepage_TestScripts homepage_TestScripts;

	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			homepage_TestScripts = new Homepage_TestScripts();
      homepage_TestScripts.Homepage_links_Verification();

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
