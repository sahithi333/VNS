package com.sci.Testmate.Pageobjects;

import org.openqa.selenium.WebElement;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.JWebElement;

public class Applications_AtThis_Location {

	// ===========================================================================================

	public WebElement BandwidthBar(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ========================================================================================
	public WebElement Appliactions(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ========================================================================================
	public WebElement AddApplicationBtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	// ========================================================================================

	public WebElement Applicationname_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(0);
	}

	// ========================================================================================
	public WebElement Description_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(1);
	}
	// ========================================================================================

	public WebElement Ipaddress_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(2);
	}
	// ========================================================================================

	public WebElement Port_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(3);
	}
	// ========================================================================================

	public WebElement protocol_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	// ========================================================================================

	public WebElement dropdown(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	// ========================================================================================

	public WebElement save_btn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
	// ========================================================================================

	public WebElement edit_textbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(3);
	}
	// ========================================================================================

	public WebElement delete_button(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(4);
	}
	// ========================================================================================

	public WebElement Bandwidth(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(1);
	}
	// ========================================================================================
	
	public WebElement Port_textbox_toverify(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(9);
	}
	// ========================================================================================

	
	public WebElement Port_textbox_tochange(WebElementDetails webElementDetails) {
		return JWebElement.getWebElements(webElementDetails).get(1);
	}
	// ========================================================================================

	
}
