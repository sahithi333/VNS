package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.TestScripts.User_Groups_at_this_Location_TestScripts;


public class User_Groups_at_this_Location_TestSuite {
	
	User_Groups_at_this_Location_TestScripts user_Groups_at_this_Location_TestScripts;
	
	@Test
	public void test() {
		try {
			isExcutingFromTestSuite = true;
			
			user_Groups_at_this_Location_TestScripts = new User_Groups_at_this_Location_TestScripts();
			
			
			user_Groups_at_this_Location_TestScripts.addUser_Groups_at_this_Location();
			//user_Groups_at_this_Location_TestScripts.editUser_Groups_at_this_Location();
		//	user_Groups_at_this_Location_TestScripts.removeUser_Groups_at_this_Location();
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
