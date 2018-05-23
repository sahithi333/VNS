package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.JWebElement;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Locations_TestScript {
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
		log.info("START of the method Before Test");
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
	public void locationwise_tools() {
		log.info("START of the Method locationTools ");
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
					ETestReport = ext.startTest("Bandwidth_Alerts_by_LocationWise ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Bandwidth_Alerts_by_LocationWise");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					WebElementDetails locationsObj = homePageWebElementsList.get(1);
					customMessage = " Locations";
					Thread.sleep(2000);
					
					
					customMessage = " Locations"+area() + " is clicked";
					List<WebElement> Address = driver.findElements(By.tagName("address"));
					for(int i=0; i<Address.size(); i++){

					System.out.println(Address.size());
					Thread.sleep(2000);
					Address.get(i).click();
					Thread.sleep(2000);
					locationToolsTestScript.locationTools();
					ETestReport.log(LogStatus.INFO, customMessage);

					
					}
					
					
					
					

				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage);
			new TestMateException().handleException(e, customMessage,
					AppUtil.getMethodName(), ETestReport);
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
		log.info("END of the method bandwidth_Alerts_by_Location_FirstLocation");

	}

	public String area() {
		WebDriver driver;

		driver = JWebDriver.getInstance().getWebDriver();

		String str = driver.findElement(By.tagName("address")).getText();
		String[] lines = str.split("\\n");

		String address = lines[1];

		return address;

	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


