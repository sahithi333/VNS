package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class LocationToolsPageObjects {
	
	
	private WebElementDetails webElementDetails;

	
	//===========================================================================================
	  
	  public WebElement Applications(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElement(webElementDetails);
	  }
		//========================================================================================

	  
	  public WebElement Diagnostics(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }

		//========================================================================================
 
	  
	  public WebElement Users(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }

		//========================================================================================

	  
	  public WebElement Orders(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }

		//========================================================================================

	  
	  
	  public WebElement Inventory(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }

		//========================================================================================

	  
	  public WebElement Tickets(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }

		//========================================================================================

	  


}
