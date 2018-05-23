package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Homepage {
	// ===========================================================================================

	public WebElement Locations_Link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	// ========================================================================================

	public WebElement BandwidthUtilization_Link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);

	}
	// =======================================================================================

	public WebElement ApplicationHealth_link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// =======================================================================================

	public WebElement MatrixView_link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ===========================================================================================
	public WebElement SD_WAN_service_link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	
	
	// ===========================================================================================
	public WebElement order_Status_link(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	

}
