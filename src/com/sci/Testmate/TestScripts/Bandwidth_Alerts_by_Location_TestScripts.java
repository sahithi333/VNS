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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;
import com.sun.jndi.cosnaming.IiopUrl.Address;

import junit.framework.Assert;

import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.model.WebElementDataDetails;

public class Bandwidth_Alerts_by_Location_TestScripts {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Bandwidth_Alerts_by_Location.class.getSimpleName());

	static String adress = null;
	static String line = null;
	static String[] lines = null;
	Homepage homePage;
	Bandwidth_Alerts_by_Location bandwidth_Alerts_by_Location;
	LocationToolsTestScript locationToolsTestScript;
	static String address = null;
	ExtentTest ETestReport;
	AppUtil apt = new AppUtil();
	Orders_for_this_LocationTestScripts orders_for_this_LocationTestScripts;

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

		if (homePageWebElementsList == null) {
			homePageWebElementsList = XMLParser.getInstance().getWebElements(Homepage.class.getSimpleName());
		}

	}

	// ==========================================================================

	@SuppressWarnings("unused")
	@Test
	public void bandwidth_Alerts_by_Locationwise() {
		log.info("START of the Method Bandwidth_Alerts_by_LocationWise ");
		homePage = new Homepage();
		String customMessage = null;
		WebDriver driver = null;
		bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
		locationToolsTestScript = new LocationToolsTestScript();

		orders_for_this_LocationTestScripts = new Orders_for_this_LocationTestScripts();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (ext == null) {
					ext = AppUtil.extentReport();
				}
				System.out.println("test");
				ETestReport = ext.startTest("Test the Bandwidth Alerts by Location Wise ");
				if (isExcutingFromTestSuite) {
					if (parentTestReport == null) {
						parentTestReport = ext.startTest("LocationWise Bandwidth Alrets");
					}
					parentTestReport.appendChild(ETestReport);
				}
				if (apt.checkLaunchIsSucess()) {

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
					if(driver.getCurrentUrl().equals("http://localhost:4200/")) {

					// ==========================================================================

					WebElementDetails BandwidthUtilization_Link_obj = homePageWebElementsList.get(1);
					customMessage = "Verify Bandwidth Utilization menu working as expected  ";
					homePage.BandwidthUtilization_Link(BandwidthUtilization_Link_obj).click();
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					}
					// ==========================================================================

					customMessage = " Verify Location Bandwidth bar is working as expected";
					WebElementDetails firstlocation = webElementDetails.get(0);
					bandwidth_Alerts_by_Location.first_Location(firstlocation).click();
					bandwidth_Alerts_by_Location.first_Location(firstlocation).click();
					Assert.assertTrue(driver.findElement(By.id("my-d3-graph-0")).isDisplayed());
					ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					
					// ==========================================================================

					WebElementDetails Secondlocation = webElementDetails.get(1);
					bandwidth_Alerts_by_Location.Seconnd_Location(Secondlocation).click();
					bandwidth_Alerts_by_Location.Seconnd_Location(Secondlocation).click();
					customMessage = "Verify Second location bandwidth bar is working as expected";
					Assert.assertTrue(driver.findElement(By.id("my-d3-graph-1")).isDisplayed());
					ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					// ==========================================================================

					customMessage = "Verify Third location to view bandwidth bar is working as expected";
					WebElementDetails Thirdlocation = webElementDetails.get(2);
					bandwidth_Alerts_by_Location.Third_Location(Thirdlocation).click();
					ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					// ==========================================================================

					customMessage = " Verify Forth location  bandwidth bar is working as expected  ";
					WebElementDetails forthlocation = webElementDetails.get(3);
					bandwidth_Alerts_by_Location.Forth_Location(forthlocation).click();
					ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					// ==========================================================================

					customMessage = " Verify Fifth location  bandwidth bar is working as expected  ";
					WebElementDetails Forthlocation = webElementDetails.get(4);
					bandwidth_Alerts_by_Location.Forth_Location(Forthlocation).click();
					bandwidth_Alerts_by_Location.Forth_Location(Forthlocation).click();
					ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					
					// ==========================================================================

					/*
					 * customMessage = " Verify location  bandwidth bar is working as expected  ";
					 * WebElementDetails Sixthlocation = webElementDetails.get(5);
					 * bandwidth_Alerts_by_Location.Fifth_Location(Sixthlocation).click();
					 * ETestReport.log(LogStatus.PASS, area() + customMessage.replaceFirst("Verify",
					 * "")); Thread.sleep(2000); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * SeventhLocation = webElementDetails.get(6);
					 * bandwidth_Alerts_by_Location.Seventh_Location(SeventhLocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Eigthlocation = webElementDetails.get(7);
					 * bandwidth_Alerts_by_Location.Eighth_Location(Eigthlocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Ninthlocation = webElementDetails.get(8);
					 * bandwidth_Alerts_by_Location.Ninth_Location(Ninthlocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Standardlocation = webElementDetails.get(9);
					 * bandwidth_Alerts_by_Location.Standard_Location(Standardlocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * EleventhLocation = webElementDetails.get(10);
					 * bandwidth_Alerts_by_Location.Standard_Location(EleventhLocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Twelthlocation = webElementDetails.get(11);
					 * bandwidth_Alerts_by_Location.Standard_Location(Twelthlocation).click(); //
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Thirteenthlocation = webElementDetails.get(12);
					 * bandwidth_Alerts_by_Location.Standard_Location(Thirteenthlocation).click();
					 * ETestReport.log(LogStatus.PASS, " Verfify "+ area() + customMessage);
					 * Thread.sleep(2000); //
					 * ==========================================================================
					 * 
					 * customMessage = " Verify location  bandwidth bar is working as expected  ";
					 * WebElementDetails ForteenthLocation = webElementDetails.get(13);
					 * bandwidth_Alerts_by_Location.Standard_Location(ForteenthLocation).click();
					 * ETestReport.log(LogStatus.PASS, " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * FifteenthLocation = webElementDetails.get(14);
					 * bandwidth_Alerts_by_Location.Standard_Location(FifteenthLocation).click();
					 * ETestReport.log(LogStatus.PASS, " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Sixteenthlocation = webElementDetails.get(15);
					 * bandwidth_Alerts_by_Location.Standard_Location(Sixteenthlocation).click();
					 * locationToolsTestScript.locationTools(); ETestReport.log(LogStatus.PASS,
					 * " Verfify "+ area() + customMessage); //
					 * ==========================================================================
					 * 
					 * Thread.sleep(2000); customMessage =
					 * " Verify location  bandwidth bar is working as expected  "; WebElementDetails
					 * Sevententhlocation = webElementDetails.get(16);
					 * bandwidth_Alerts_by_Location.Standard_Location(Sevententhlocation).click();
					 * Assert.assertSame("Test fail", "Test pass"); ETestReport.log(LogStatus.FAIL,
					 * customMessage.replace(customMessage,
					 * "Seventeenth  location  bandwidth bar is not working"));
					 */
				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage);
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			ETestReport.log(LogStatus.FAIL, customMessage + " Failed");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method bandwidth Alerts by Location Location  <<<<<===============");

	}

	public String area() {
		WebDriver driver;
		String line = null;
		driver = JWebDriver.getInstance().getWebDriver();

		List<WebElement> Address = driver.findElements(By.tagName("address"));
		for (int i = 0; i < Address.size(); i++) {

			String adress = Address.get(i).getText();

			String[] lines = adress.split("\\n");

			line = lines[1];
			// System.out.println(line);

		}
		return line;

	}
}
