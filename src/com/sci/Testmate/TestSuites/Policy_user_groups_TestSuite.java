package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import javax.mail.MessagingException;

import org.junit.Test;

import com.sci.Testmate.Email.EmailManager;
import com.sci.Testmate.TestScripts.Policy_Setup_your_UserGroups_TestScripts;

public class Policy_user_groups_TestSuite {
Policy_Setup_your_UserGroups_TestScripts policy_TestScripts;
	
	
	
	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			policy_TestScripts = new Policy_Setup_your_UserGroups_TestScripts();
			policy_TestScripts.policy_AddUser_Groupname_and_Location();
			policy_TestScripts.policy_editusergroupLoaction();
			policy_TestScripts.policy_deleteusergroupLoaction();
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
