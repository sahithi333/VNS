package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Policy {
	
	// private WebElementDetails webElementDetails;

	
	//===========================================================================================
	  
	  public WebElement policy_menu(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElement(webElementDetails);
	  }
		//========================================================================================

	  public WebElement ManageUserGroups(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================

	  public WebElement ManageApplications(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================
	  public WebElement NewPolicy(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================


}
