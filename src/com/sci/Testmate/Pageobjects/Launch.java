package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Launch{
	// ==================================================================================	
	  public WebElement url(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
		// ==================================================================================


}
