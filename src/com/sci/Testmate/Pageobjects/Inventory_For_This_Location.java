package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Inventory_For_This_Location {
	
	@SuppressWarnings("unused")
	private WebElementDetails webElementDetails;

	
	//===========================================================================================
	  
	  public  WebElement Inventory(WebElementDetails webElementDetails) {
	    return JWebElement.getWebElement(webElementDetails);
	  }
		//========================================================================================

	  public  WebElement PrivateIP(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(0);
		  }
			//========================================================================================

	  public  WebElement VirtualNetworkServices(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(0);
		  }
			//========================================================================================
	  public  WebElement SecureCloudInterconnect(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(2);
		  }
			//========================================================================================
	   
	  public  WebElement FirstCircuitID_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(2);
		  }
			//========================================================================================

	  public  WebElement SecondCircuitID_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(6);
		  }
			//========================================================================================

	  public  WebElement ThirdCircuitID_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(10);
		  }
			//========================================================================================

	  public  WebElement ForthCircuitID_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(14);
		  }
			//========================================================================================

	  public  WebElement FifthCircuitID_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(18);
		  }
			//========================================================================================
	  
	  public  WebElement FirstVpnname_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(4);
		  }
			//========================================================================================

	  public  WebElement SecondVpnname_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(8);
		  }
			//========================================================================================

	  public  WebElement ThirdVpnName_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(12);
		  }
			//========================================================================================

	  public  WebElement ForthVpnName_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(16);
		  }
			//========================================================================================

	  public  WebElement FifthVpnName_Data(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(20);
		  }
			//========================================================================================

	  
	  public  WebElement VpnName_Headder(WebElementDetails webElementDetails) {
		    return JWebElement.getWebElements(webElementDetails).get(4);
		  }
			//========================================================================================


	  

}

