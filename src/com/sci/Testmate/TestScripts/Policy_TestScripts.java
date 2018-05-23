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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Policy;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Policy_TestScripts {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;
	
	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Policy.class.getSimpleName());

	
	
	
	Homepage homePage;
Policy policy;
	
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
		
		if (webElementDetails == null) {
			webElementDetails = XMLParser.getInstance().getWebElements(Policy.class.getSimpleName());
		}


	}

	// ==========================================================================

	@SuppressWarnings("unused")
	@Test
	public void policy_method() {
		log.info("START of the Method Policy ");
		homePage = new Homepage();
		policy = new Policy();
		String customMessage = null;
		WebDriver driver = null;

		try {
			setPrerequisites();
			if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
				if (apt.checkLaunchIsSucess()) {
					if (ext == null) {
						ext = AppUtil.extentReport();
					}
					System.out.println("test");
					ETestReport = ext.startTest("Test the Policy Menu and sub-menus ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Policy Menu and sub-menus");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					customMessage = "Verify policy menu  working as expected";
					WebElementDetails policy_obj = webElementDetails.get(0);
					policy.policy_menu(policy_obj).click();
					Thread.sleep(2000);
                    Assert.assertEquals("http://localhost:4200/policy", driver.getCurrentUrl());
					ETestReport.log(LogStatus.PASS,  customMessage.replaceFirst("Verify", ""));

					
					Thread.sleep(2000);
					customMessage = "Verify Manage User group working as expected";
					WebElementDetails ManageUserGroupsObj = webElementDetails.get(1);
					policy.policy_menu(ManageUserGroupsObj).click();
					Thread.sleep(2000);
					ETestReport.log(LogStatus.PASS,  customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

					
					
					customMessage = "Verify Manage Applications submenu  working as expected";
					WebElementDetails ManageApplicationsObj = webElementDetails.get(2);
					policy.ManageApplications(ManageApplicationsObj).click();
					Thread.sleep(2000);
					ETestReport.log(LogStatus.PASS,  customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					
					
					
					
					customMessage = "Verify New Policy submenu  working as expected";
					WebElementDetails NewPolicyobj = webElementDetails.get(3);
					policy.NewPolicy(NewPolicyobj).click();
					Thread.sleep(2000);
					Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='main-content']/app-apps-policy/div[2]/div/div/app-new-policy-accordion/div/h1")).isDisplayed());
					ETestReport.log(LogStatus.PASS,  customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

	
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
			ETestReport.log(LogStatus.FAIL,  customMessage);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method bandwidth Alerts by Location Location  <<<<<===============");

			
	}	
	


}
