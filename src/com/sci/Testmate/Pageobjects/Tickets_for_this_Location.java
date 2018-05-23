package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Tickets_for_this_Location {
	
	//===========================================================================================
	  
	  public WebElement Applications(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElement(webElementDetails);
	  }
		//========================================================================================


}
