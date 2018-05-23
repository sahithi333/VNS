package com.sci.Testmate.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Policy_CreateCustom_Application_Mappings{
	//===========================================================================================
	  
	  public List<WebElement>  Policy_menu(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElements(webElementDetails);
	  }

		//========================================================================================
	  
	  //.col-4.content-dashed-border

	  public WebElement  Create_Custom_Application_Mappings(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(1);
		  }
			//========================================================================================

	  
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
}
