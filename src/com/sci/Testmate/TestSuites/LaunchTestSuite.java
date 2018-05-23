package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.TestScripts.LaunchTestScript;

public class LaunchTestSuite {

	LaunchTestScript launchTestScript;

	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			launchTestScript=new LaunchTestScript();
			launchTestScript.launchbrowser();
			
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