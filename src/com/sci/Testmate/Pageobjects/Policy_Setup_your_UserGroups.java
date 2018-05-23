package com.sci.Testmate.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Policy_Setup_your_UserGroups{
	

	
	//===========================================================================================
	  
	  public static WebElement policy_menu(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElement(webElementDetails);
	  }
		//========================================================================================

	  public WebElement ManageUserGroups(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================

	  public static WebElement ManageApplications(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================
	  public WebElement NewPolicy(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================

	  public WebElement AdduserGroup_Button(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================
	  public WebElement userGroupName_Textbox(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElement(webElementDetails);
		  }
			//========================================================================================
	  
	  public WebElement save_btn(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(1);
		  }
			//========================================================================================
	  
	  public List<WebElement> Edit_btn(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================
	  public List<WebElement> Expand_btn(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================

	  public WebElement AddLocationMapping_btn(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(1);
		  }
			//========================================================================================

	  public WebElement Locations_dropdown(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(3);
		  }
			//========================================================================================
	  public List<WebElement> dropdown_list(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================
	  public List<WebElement> Iprange_Textboxes(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================
	  
	  public List<WebElement> Tabledata(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================

	  public List<WebElement> Usergroupname_toVerify(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================
	  public List<WebElement> delete_buttons(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================

	  public List<WebElement> TableRows(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails);
		  }
			//========================================================================================

}