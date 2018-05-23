package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Homepage_TestScripts {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Bandwidth_Alerts_by_Location.class.getSimpleName());

	Homepage homePage;
	Bandwidth_Alerts_by_Location bandwidth_Alerts_by_Location;
	LocationToolsTestScript locationToolsTestScript;
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

		if (homePageWebElementsList == null) {
			homePageWebElementsList = XMLParser.getInstance().getWebElements(Homepage.class.getSimpleName());
		}

	}

	// ==========================================================================

	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void Homepage_links_Verification() {
		log.info("START of the Method Bandwidth_Alerts_by_LocationWise ");
		homePage = new Homepage();
		String customMessage = null;
		WebDriver driver = null;
		bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
		locationToolsTestScript = new LocationToolsTestScript();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("Test the Homepage links all are working as expected ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Homepage links Verification");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					WebElementDetails locationsobj = homePageWebElementsList.get(0);
					customMessage = " Verify Locations link Working as expected ";
					homePage.Locations_Link(locationsobj).click();
					Assert.assertEquals("http://localhost:4200/locations", driver.getCurrentUrl());
					ETestReport.log(LogStatus.PASS, customMessage);
					Thread.sleep(3000);

					
					Thread.sleep(3000);
					WebElementDetails Bandwidthobj = homePageWebElementsList.get(1);
					customMessage = " Verify BandwidthUtilization link Working as expected ";
					homePage.BandwidthUtilization_Link(Bandwidthobj).click();
					Assert.assertEquals("http://localhost:4200/network", driver.getCurrentUrl());
					ETestReport.log(LogStatus.PASS, customMessage);
					driver.get("http://localhost:4200");
					Thread.sleep(3000);
					
					
					
					WebElementDetails ApplicationHealth_obj = homePageWebElementsList.get(2);
					customMessage = " Application Health link is not working";
					homePage.ApplicationHealth_link(ApplicationHealth_obj).click();
					Assert.assertEquals("http://localhost:4200/network", driver.getCurrentUrl());
					ETestReport.log(LogStatus.FAIL, customMessage);

				
/*					WebElementDetails Matrix_view_obj = homePageWebElementsList.get(3);
					customMessage = " Verify MatrixView link Working as expected ";
					homePage.MatrixView_link(Matrix_view_obj).click();
					Assert.assertEquals("http://localhost:4200/network", driver.getCurrentUrl());
					ETestReport.log(LogStatus.PASS, customMessage);
*/
					
					
				}

			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage);
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			System.out.println(" fail test");
			e.printStackTrace();
			ETestReport.log(LogStatus.FAIL, customMessage);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method Homeapage links verification  <<<<<===============");

	}
}
