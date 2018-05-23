package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Common.Constants;
import com.sci.Testmate.Pageobjects.Launch;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.TestmateExceptions.TestMateException;

// ==========================================================================

public class LaunchTestScript {
	protected transient final Log log = LogFactory.getLog(getClass());
	ExtentTest EReport;
	AppUtil apt = new AppUtil();
	ExtentTest ETestReport;


	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		System.out.println("<<<<<<<<<<<<< Beforemethod  >>>>>>>>>>>>");
		log.info("END of the method beforeTest");
	}

	// =========================================================================

	@SuppressWarnings("unused")
	@Test
	public void launchbrowser() {
		log.info("START of the method Launch Browser");
		Launch launch = new Launch();
		String customMessage = null;
		WebDriver driver = null;
		customMessage = "Launching Browser";


		try {
			if (ext == null) {
				ext = AppUtil.extentReport();
			}
			ETestReport = ext.startTest("Launch Browser");
			if (isExcutingFromTestSuite) {
				if (parentTestReport == null) {
					parentTestReport = ext.startTest("Launch Browser");
				}
				parentTestReport.appendChild(ETestReport);
			}

			driver = JWebDriver.getInstance().getWebDriver();
			driver.manage().window().maximize();
			Thread.sleep(10000);
			if (driver.getCurrentUrl().contains("http://localhost:4200/")) {
				ETestReport.log(LogStatus.PASS, customMessage + "Test Passed");
				Constants.isLaunchSuccess =  true;
		      } else {
		          log.info(" Unable to execute the script ");
		        }

		} catch (java.lang.AssertionError e) {
			e.printStackTrace();
			ETestReport.log(LogStatus.FAIL, customMessage + " Test Failed ");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			ETestReport.log(LogStatus.FAIL, customMessage + " Test Failed");
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("END of the method deleteDatabaseRecord");
	}

	// ==========================================================================

	@AfterTest
	public void afterTest() {

		log.info("START of the method afterTest");
		log.info("END of the method afterTest");
	}

	// ==========================================================================

}
