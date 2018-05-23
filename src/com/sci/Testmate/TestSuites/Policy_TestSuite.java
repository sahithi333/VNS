package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.TestScripts.Policy_TestScripts;





public class Policy_TestSuite {
Policy_TestScripts policy_TestScripts;
	
	
	
	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			policy_TestScripts = new Policy_TestScripts();
			policy_TestScripts.policy_method();



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
	


