package com.sci.Testmate.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class User_Groups_at_this_Location {
	
	  public WebElement UserGroups(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================

	  public WebElement NewGroupName(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(0);
		  }
			//========================================================================================

	  public WebElement Description(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(1);
		  }
			//========================================================================================

	  public WebElement Type(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(2);
		  }
			//========================================================================================
	  public WebElement Address(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(3);
		  }
			//========================================================================================

	  public WebElement Bandwidth(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(1);
		  }
			//========================================================================================

	  public List<WebElement> Address_type(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================

	  public WebElement edit_button(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(3);
		  }
			//========================================================================================

	  public WebElement delete_button(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(6);
		  }
			//========================================================================================

}
