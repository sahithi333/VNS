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
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Applications_AtThis_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Orders_for_this_Location;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import sun.print.PageableDoc;

public class Applications_At_This_Location_TestScripts {

	protected transient final Log log = LogFactory.getLog(getClass());

	private List<WebElementDetails> homePageWebElementsList = null;

	private List<WebElementDetails> ApplicationsWebElementList = null;

	Orders_for_this_Location orders_for_this_Location;
	JavascriptExecutor javascriptExecutor;
	Applications_AtThis_Location applications_AtThis_Location;

	static String address = null;
	ExtentTest ETestReport;
	AppUtil apt = new AppUtil();
	Homepage homepage;
	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		System.out.println("<<<<<<<<<<<<< Beforemethod  >>>>>>>>>>>>");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	private void setPrerequisites() throws InterruptedException {

		if (homePageWebElementsList == null) {
			homePageWebElementsList = XMLParser.getInstance().getWebElements(Homepage.class.getSimpleName());
			ApplicationsWebElementList = XMLParser.getInstance()
					.getWebElements(Applications_AtThis_Location.class.getSimpleName());
		}
	}

	// ==========================================================================

	@SuppressWarnings("deprecation")
	@Test
	public void addApplication_AtThis_Location() {
		log.info("START of the method add new Application ath this location");
		String customMessage = null;
		WebDriver driver = null;
		homepage = new Homepage();
		applications_AtThis_Location = new Applications_AtThis_Location();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("Application functionality - Add Application at this location  ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Add Applications for this Location");
						}
						parentTestReport.appendChild(ETestReport);
					}
					driver = JWebDriver.getInstance().getWebDriver();

					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					if(driver.getCurrentUrl().equals("http://localhost:4200/")) {
					Thread.sleep(2000);
					customMessage = "Verify Bandwidth utilization menu is working as expected";
					WebElementDetails Bandwidth_obj = ApplicationsWebElementList.get(14);
					applications_AtThis_Location.Bandwidth(Bandwidth_obj).click();
					Thread.sleep(3000);
					}
					customMessage = "Verify Bandwidth graph bar is working as expeected";
					WebElementDetails bandwidth_obj = ApplicationsWebElementList.get(0);
					applications_AtThis_Location.BandwidthBar(bandwidth_obj).click();
					Assert.assertTrue((applications_AtThis_Location.BandwidthBar(bandwidth_obj).isDisplayed()));
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Applications menu is working as expeected";
					WebElementDetails Application_obj = ApplicationsWebElementList.get(1);
					applications_AtThis_Location.Appliactions(Application_obj).click();
					Assert.assertTrue((applications_AtThis_Location.Appliactions(Application_obj).isDisplayed()));
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(3000);

					customMessage = "Verify Add Applications Functionality at this location working as expected";
					WebElementDetails AddApplicationBtn_obj = ApplicationsWebElementList.get(2);
					applications_AtThis_Location.AddApplicationBtn(AddApplicationBtn_obj).click();
					Thread.sleep(2000);

					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					
					WebElementDetails Applicationname_obj = ApplicationsWebElementList.get(3);
					applications_AtThis_Location.Applicationname_textbox(Applicationname_obj).clear();
					
					applications_AtThis_Location.Applicationname_textbox(Applicationname_obj)
							.sendKeys("Test Application1");

					WebElementDetails Description_obj = ApplicationsWebElementList.get(3);
					applications_AtThis_Location.Description_textbox(Description_obj).clear();
					applications_AtThis_Location.Description_textbox(Description_obj).sendKeys("Test Description1");

					Thread.sleep(2000);

					WebElementDetails IPaddress_obj = ApplicationsWebElementList.get(3);
					applications_AtThis_Location.Ipaddress_textbox(IPaddress_obj).clear();
					applications_AtThis_Location.Ipaddress_textbox(IPaddress_obj).sendKeys("192.168.100.20");
					Thread.sleep(2000);

					WebElementDetails Port_obj = ApplicationsWebElementList.get(3);
					applications_AtThis_Location.Port_textbox(Port_obj).clear();
					applications_AtThis_Location.Port_textbox(Port_obj).sendKeys("1234");
					Thread.sleep(2000);

					WebElementDetails potocol_obj = ApplicationsWebElementList.get(7);
					applications_AtThis_Location.protocol_textbox(potocol_obj).click();
					Thread.sleep(2000);
					
					WebElementDetails dropdown_obj = ApplicationsWebElementList.get(8);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();",
							applications_AtThis_Location.dropdown(dropdown_obj).findElements(By.cssSelector(".p.on-white.dropdown-item")).get(1));
				Thread.sleep(2000);


					WebElementDetails Save_obj = ApplicationsWebElementList.get(9);
					applications_AtThis_Location.save_btn(Save_obj).click();
					Thread.sleep(2000);

					int nooftables =	driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
					for(int i=0; i<nooftables; i++) {
						if(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).get(i).getText().contains("1234"))
						ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", "") + "-- Application Inserted");
                        break;
                        
                        
                        
                        
                        
					}
					
					ETestReport.log(LogStatus.FAIL, customMessage.replaceFirst("Verify", "") + "-- Application not Inserted");

				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
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
		log.info("=======>>>>>>  END of the method ----<<<<<===============");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void editApplication_AtThis_Location() {
		log.info("START of the method add new Application ath this location");
		String customMessage = null;
		WebDriver driver = null;
		homepage = new Homepage();
		applications_AtThis_Location = new Applications_AtThis_Location();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("Application functionality - Edit Application at this location  ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Edit Applications for this Location");
						}
						parentTestReport.appendChild(ETestReport);
					}
					driver = JWebDriver.getInstance().getWebDriver();

					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					Thread.sleep(3000);

					customMessage = " Verify Edit Functionality Working as Expected ";

					WebElementDetails edit_obj = ApplicationsWebElementList.get(10);
					applications_AtThis_Location.edit_textbox(edit_obj).click();
					Thread.sleep(2000);

					WebElementDetails Port_obj = ApplicationsWebElementList.get(12);
					applications_AtThis_Location.Port_textbox_tochange(Port_obj).clear();
					applications_AtThis_Location.Port_textbox_tochange(Port_obj).sendKeys("1111");
					Thread.sleep(2000);

					
					WebElementDetails Save_obj = ApplicationsWebElementList.get(9);
					applications_AtThis_Location.save_btn(Save_obj).click();
					Thread.sleep(2000);
					
					int nooftables =	driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
					for(int i=0; i<nooftables; i++) {
						if(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).get(i).getText().contains("1111"))
						ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", "") + "-- Application edited");
                        break;
					}
					
					ETestReport.log(LogStatus.FAIL, customMessage.replaceFirst("Verify", "") + "-- Application not edited");


				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
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
		log.info("=======>>>>>>  END of the method ----<<<<<===============");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void delete_Application_AtThis_Location() {
		log.info("START of the method Delete Application ath this location");
		String customMessage = null;
		WebDriver driver = null;
		homepage = new Homepage();
		applications_AtThis_Location = new Applications_AtThis_Location();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest(" Application functionality - Delete Application at this location    ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Delete Application for this Location");
						}
						parentTestReport.appendChild(ETestReport);
					}
					driver = JWebDriver.getInstance().getWebDriver();

					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					Thread.sleep(3000);

					customMessage = " Verify Delete Functionality Working as Expected ";

					WebElementDetails delete_obj = ApplicationsWebElementList.get(13);
					applications_AtThis_Location.delete_button(delete_obj).click();
					Thread.sleep(2000);

					List<WebElement> delete_buttons = driver.findElements(By.cssSelector(".cui-sm.close-alt"));
					int size = delete_buttons.size();
					System.out.println(" size is " + size);

					int nooftables =	driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
					for(int i=0; i<nooftables; i++) {
						if(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).get(i).getText().contains("1111"))
						ETestReport.log(LogStatus.FAIL, customMessage.replaceFirst("Verify", "") + "-- Application not deleted");
                        break;
					}
					
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", "") + "-- Application deleted");

				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
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
		log.info("=======>>>>>>  END of the method ----<<<<<===============");

	}

}
