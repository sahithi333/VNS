package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Orders_for_this_Location;
import com.sci.Testmate.Pageobjects.User_Groups_at_this_Location;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

public class User_Groups_at_this_Location_TestScripts {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> userGropsWebElementsList = null;
	
	private List<WebElementDetails> homePageWebElementsList = null;

	
	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(User_Groups_at_this_Location.class.getSimpleName());
	

	static String adress = null;
	static String line = null;
	static String[] lines = null;
	Homepage homePage;
	User_Groups_at_this_Location user_Groups_at_this_Location;
	JavascriptExecutor javascriptExecutor;
	Bandwidth_Alerts_by_Location bandwidth_Alerts_by_Location;


	static String address = null;
	ExtentTest ETestReport;
	AppUtil apt = new AppUtil();

	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		System.out.println("<<<<<<<<<<<<< Beforemethod  >>>>>>>>>>>>");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	@SuppressWarnings("unused")
	private void setPrerequisites() throws InterruptedException {

		if (userGropsWebElementsList == null) {
			userGropsWebElementsList = XMLParser.getInstance().getWebElements(User_Groups_at_this_Location.class.getSimpleName());
		}

	}

	// ==========================================================================

	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void addUser_Groups_at_this_Location() {
		log.info("START of the Method User Groups at this location ");
		homePage = new Homepage();
		bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
		String customMessage = null;
		WebDriver driver = null;
		user_Groups_at_this_Location  = new User_Groups_at_this_Location();

		try {
			setPrerequisites();
			if (userGropsWebElementsList != null && userGropsWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("User Groups at this location - add user group at this location");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Add user group at this location");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					Thread.sleep(3000);			

					if(driver.getCurrentUrl().equals("localhost:4200/network")) {
						customMessage = "Verify User groups  menu is working as expeected";
						WebElementDetails UserGroupsmenu_obj = webElementDetails.get(1);
							user_Groups_at_this_Location.UserGroups(UserGroupsmenu_obj).click();
						driver.findElement(By.xpath(".//*[@ng-reflect-icon='remind-me'] ")).click();
							ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
							Thread.sleep(2000);
						
					}
					
						
					
					customMessage = "Verify Bandwidth utilization menu is working as expected";
					WebElementDetails Bandwidth_obj = webElementDetails.get(5);
					user_Groups_at_this_Location.Bandwidth(Bandwidth_obj).click();
	
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

					
					customMessage = "Verify First Bar Graph menu is working as expeected";
					WebElementDetails Fistbargraph_obj = webElementDetails.get(0);
					user_Groups_at_this_Location.UserGroups(Fistbargraph_obj).click();
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify User groups  menu is working as expeected";
				WebElementDetails UserGroupsmenu_obj = webElementDetails.get(1);
					user_Groups_at_this_Location.UserGroups(UserGroupsmenu_obj).click();
				driver.findElement(By.xpath(".//*[@ng-reflect-icon='remind-me'] ")).click();
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					
			
				
					Actions action = new Actions(driver);
					action.sendKeys(Keys.PAGE_DOWN).build().perform();

					customMessage = "Verify Add Applications Functionality at this location working as expected";
					WebElementDetails AddUserGroupBtn_obj = userGropsWebElementsList.get(2);
					user_Groups_at_this_Location.UserGroups(AddUserGroupBtn_obj).click();
					Thread.sleep(2000);
					

					WebElementDetails Grouopname_obj = userGropsWebElementsList.get(3);
					user_Groups_at_this_Location.NewGroupName(Grouopname_obj).clear();
					
					user_Groups_at_this_Location.NewGroupName(Grouopname_obj)
							.sendKeys("Test Application1");

					WebElementDetails Description_obj = userGropsWebElementsList.get(3);
					user_Groups_at_this_Location.Description(Description_obj).clear();
					user_Groups_at_this_Location.Description(Description_obj).sendKeys("Test Description1");

					Thread.sleep(2000);

					WebElementDetails Type_obj = userGropsWebElementsList.get(3);
					user_Groups_at_this_Location.Type(Type_obj).clear();
					user_Groups_at_this_Location.Type(Type_obj).sendKeys("abcd");
					Thread.sleep(2000);

					WebElementDetails Address_obj = userGropsWebElementsList.get(3);
					user_Groups_at_this_Location.Address(Address_obj).clear();
					user_Groups_at_this_Location.Address(Address_obj).sendKeys("address domain");
					Thread.sleep(2000);

					WebElementDetails savebtn_obj = userGropsWebElementsList.get(4);
					user_Groups_at_this_Location.UserGroups(savebtn_obj).click();
					Thread.sleep(2000);
					
					
					WebElementDetails Addresstype_obj = userGropsWebElementsList.get(6);
					int noofrows = user_Groups_at_this_Location.Address_type(Addresstype_obj).size();
					Thread.sleep(2000);
					System.out.println("TEXT IS " + noofrows);
				String saved_data =	user_Groups_at_this_Location.Address_type(Addresstype_obj).get(noofrows-1).findElements(By.cssSelector(".text-input.p.form-control")).get(2).getText();
					Assert.assertTrue(saved_data.contains("abcd"));
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));

				
				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage + "--- Failed ");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			System.out.println(" fail test");
			e.printStackTrace();
			ETestReport.log(LogStatus.FAIL, customMessage + "Failed"); 
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method ------<<<<<===============");

	}


// ==========================================================================
@SuppressWarnings({ "unused", "deprecation" })
@Test
public void editUser_Groups_at_this_Location() {
	log.info("START of the Method User Groups at this location ");
	homePage = new Homepage();
	bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
	String customMessage = null;
	WebDriver driver = null;
	user_Groups_at_this_Location  = new User_Groups_at_this_Location();

	try {
		setPrerequisites();
		if (userGropsWebElementsList != null && userGropsWebElementsList.size() > 0) {
			if (apt.checkLaunchIsSucess()) {
				if (ext == null) {
					ext = AppUtil.extentReport();
				}
				System.out.println("test");
				ETestReport = ext.startTest("User Groups at this location - edit user group at this location");
				if (isExcutingFromTestSuite) {
					if (parentTestReport == null) {
						parentTestReport = ext.startTest("Edit user group at this location");
					}
					parentTestReport.appendChild(ETestReport);
				}

				driver = JWebDriver.getInstance().getWebDriver();

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				Thread.sleep(3000);			
				customMessage = "Verify edit user group function is working as expected";
				WebElementDetails edit_obj = webElementDetails.get(7);
				user_Groups_at_this_Location.edit_button(edit_obj).click();
				
				
				
				WebElementDetails Type_obj = userGropsWebElementsList.get(3);
				user_Groups_at_this_Location.Type(Type_obj).clear();
				user_Groups_at_this_Location.Type(Type_obj).sendKeys("xyz");
				Thread.sleep(2000);
				
				WebElementDetails savebtn_obj = userGropsWebElementsList.get(4);
				user_Groups_at_this_Location.UserGroups(savebtn_obj).click();
				Thread.sleep(2000);

/*				WebElementDetails Addresstype_obj = userGropsWebElementsList.get(6);
				String Text = user_Groups_at_this_Location.Address_type(Addresstype_obj).getText();
				Thread.sleep(2000);
				System.out.println("TEXT IS " + Text);
				Assert.assertTrue(Text.equalsIgnoreCase("xyz"));
				ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));

*/				
				
				
			}
		}

	}

	catch (java.lang.AssertionError e) {
		System.out.println(">>>>>>>>>>>>>>>>");
		customMessage.replace("Verify Zoom out button is", "Zoom out button is not");
		ETestReport.log(LogStatus.FAIL, customMessage + " Failed ");
		new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
	} catch (Exception e) {
		System.out.println(" fail test");
		e.printStackTrace();
		ETestReport.log(LogStatus.FAIL, customMessage + "Failed"); 
		new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
	} finally {
		ext.endTest(ETestReport);
		ext.flush();
		if (!isExcutingFromTestSuite) {
			ext.close();
		}

	}
	log.info("=======>>>>>>  END of the method -------<<<<<===============");

}



@SuppressWarnings({ "unused", "deprecation" })
@Test
public void removeUser_Groups_at_this_Location() {
	log.info("START of the Method User Groups at this location ");
	homePage = new Homepage();
	bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
	String customMessage = null;
	WebDriver driver = null;
	user_Groups_at_this_Location  = new User_Groups_at_this_Location();

	try {
		setPrerequisites();
		if (userGropsWebElementsList != null && userGropsWebElementsList.size() > 0) {
			if (apt.checkLaunchIsSucess()) {
				if (ext == null) {
					ext = AppUtil.extentReport();
				}
				System.out.println("test");
				ETestReport = ext.startTest("User Groups at this location - Remove user group at this location");
				if (isExcutingFromTestSuite) {
					if (parentTestReport == null) {
						parentTestReport = ext.startTest("Remove user group at this location");
					}
					parentTestReport.appendChild(ETestReport);
				}

				driver = JWebDriver.getInstance().getWebDriver();

				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				Thread.sleep(3000);			
				customMessage = "Verify Remove user group function is working as expected";
				WebElementDetails delete_obj = webElementDetails.get(8);
				user_Groups_at_this_Location.delete_button(delete_obj).click();
				
				List<WebElement> delete_buttons = driver.findElements(By.cssSelector(".cui-sm.close-alt"));
				int size = delete_buttons.size();
				System.out.println(" size is " + size);

				Assert.assertEquals(6, size);
				ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", "") + "-- record removed");




			}
		}

	}

	catch (java.lang.AssertionError e) {
		System.out.println(">>>>>>>>>>>>>>>>");
		customMessage.replace("Verify Zoom out button is", "Zoom out button is not");
		ETestReport.log(LogStatus.FAIL, customMessage + " Failed ");
		new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
	} catch (Exception e) {
		System.out.println(" fail test");
		e.printStackTrace();
		ETestReport.log(LogStatus.FAIL, customMessage + "Failed"); 
		new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
	} finally {
		ext.endTest(ETestReport);
		ext.flush();
		if (!isExcutingFromTestSuite) {
			ext.close();
		}

	}
	log.info("=======>>>>>>  END of the method -- --<<<<<===============");

}
}

