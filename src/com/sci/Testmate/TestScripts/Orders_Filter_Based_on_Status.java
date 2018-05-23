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
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Orders_for_this_Location;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Orders_Filter_Based_on_Status{
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Orders_for_this_Location.class.getSimpleName());

	static String adress = null;
	static String line = null;
	static String[] lines = null;
	Homepage homePage;
	Bandwidth_Alerts_by_Location bandwidth_Alerts_by_Location;
	LocationToolsTestScript locationToolsTestScript;
	Orders_for_this_Location orders_for_this_Location;
	JavascriptExecutor javascriptExecutor;

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

	
	@SuppressWarnings("deprecation")
	public void filter_Funtionality_Based_on_Status() {

		log.info("START of the Method filter Funtionality Based on Status ");
		homePage = new Homepage();
		String customMessage = null;
		WebDriver driver = null;
		bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
		locationToolsTestScript = new LocationToolsTestScript();
		orders_for_this_Location = new Orders_for_this_Location();

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("Filter Orders Based on Status");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Filter Orders ");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					customMessage = "Verify Filter button is working as expected";
					WebElementDetails Filter_obj = webElementDetails.get(3);
					orders_for_this_Location.Filter(Filter_obj).click();
					orders_for_this_Location.Filter(Filter_obj).click();
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Clear button is working as expected";
					WebElementDetails Clear_obj = webElementDetails.get(9);
					orders_for_this_Location.Clear(Clear_obj).click();
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Orders Completed Checkbox Functionality is working as expected";
					WebElementDetails completed_obj = webElementDetails.get(10);
					orders_for_this_Location.Status(completed_obj).click();
					Thread.sleep(1000);
					WebElementDetails Apply_obj = webElementDetails.get(8);
					orders_for_this_Location.Apply(Apply_obj).click();
					Assert.assertTrue(driver.findElement(By.xpath(".//*[@ng-reflect-label=\'COMPLETED\']")).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Orders Pending Checkbox Functionality is working as expected";
					orders_for_this_Location.Filter(Filter_obj).click();
					Thread.sleep(1000);
					orders_for_this_Location.Clear(Clear_obj).click();
					Thread.sleep(1000);
					WebElementDetails Pending_obj = webElementDetails.get(11);
					orders_for_this_Location.Status(Pending_obj).click();
					Thread.sleep(1000);
					orders_for_this_Location.Apply(Apply_obj).click();
					Thread.sleep(1000);
					Assert.assertTrue(driver.findElement(By.xpath(".//*[@ng-reflect-label=\'PENDING']")).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(3000);

					customMessage = "Verify Orders Failed Checkbox Functionality is working as expected";
					orders_for_this_Location.Filter(Filter_obj).click();
					Thread.sleep(1000);
					orders_for_this_Location.Clear(Clear_obj).click();
					Thread.sleep(1000);
					WebElementDetails Failed_obj = webElementDetails.get(12);
					orders_for_this_Location.Status(Failed_obj).click();
					Thread.sleep(1000);
					orders_for_this_Location.Apply(Apply_obj).click();
					Thread.sleep(1000);
					Assert.assertTrue(driver.findElement(By.xpath(".//*[@ng-reflect-label=\'FAILED']")).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);


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
		log.info("=======>>>>>>  END of the method - Search orders by Status --<<<<<===============");

	}

	

}
