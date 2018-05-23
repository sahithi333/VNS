package com.sci.Testmate.TestSuites;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.junit.Test;

import com.sci.Testmate.Email.MailProjectClass;
import com.sci.Testmate.TestScripts.Inventory_For_this_Location;
import com.sci.Testmate.TestScripts.Inventory_Tables_Check_Ascending_DecendingOrders;


public class Inventory_For_This_LocationTestSuite {
	
	Inventory_For_this_Location inventory_For_this_Location;
	
	@Test
	public void test() {
		
		try {
			
			isExcutingFromTestSuite = true;
			inventory_For_this_Location = new Inventory_For_this_Location();
			
			inventory_For_this_Location.Inventory_Funtionality();
			inventory_For_this_Location.Check_Ascending_Order_of_Tablesdata();

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
