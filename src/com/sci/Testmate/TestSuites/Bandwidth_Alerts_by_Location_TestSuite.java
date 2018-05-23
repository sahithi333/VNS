package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import javax.mail.MessagingException;

import org.junit.Test;

import com.sci.Testmate.Email.MailProjectClass;
import com.sci.Testmate.TestScripts.Bandwidth_Alerts_by_Location_TestScripts;
import com.sci.Testmate.TestScripts.LaunchTestScript;

public class Bandwidth_Alerts_by_Location_TestSuite {
	LaunchTestScript launchTestScript;
	Bandwidth_Alerts_by_Location_TestScripts bandwidth_Alerts_by_Location_TestScripts;
	MailProjectClass mailProjectClass;

	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
					
			

		bandwidth_Alerts_by_Location_TestScripts = new Bandwidth_Alerts_by_Location_TestScripts();
		bandwidth_Alerts_by_Location_TestScripts.bandwidth_Alerts_by_Locationwise();		


			afterTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void afterTest() throws MessagingException {
	ext.endTest(parentTestReport);
		ext.flush();
		ext.close();
		parentTestReport = null;
		ext = null;		
		
	
	}

}










