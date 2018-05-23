package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Policy_Setup_your_UserGroups;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Policy_Setup_your_UserGroups_TestScripts {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Policy_Setup_your_UserGroups.class.getSimpleName());

	Homepage homePage;
	Policy_Setup_your_UserGroups policy_Setup_your_UserGroups;

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
			webElementDetails = XMLParser.getInstance()
					.getWebElements(Policy_Setup_your_UserGroups.class.getSimpleName());
		}

	}

	// ==========================================================================

	@SuppressWarnings("unused")
	@Test
	public void policy_AddUser_Groupname_and_Location() {
		log.info("START of the Method Policy ");
		homePage = new Homepage();
		policy_Setup_your_UserGroups = new Policy_Setup_your_UserGroups();
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
					ETestReport = ext.startTest("Add User Group Name and Add Location at Policy");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Set Up User Groups and Add Locations ");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					customMessage = "Verify policy menu  working as expected";
					WebElementDetails policy_obj = webElementDetails.get(0);
					Policy_Setup_your_UserGroups.policy_menu(policy_obj).click();
					Thread.sleep(2000);
					Assert.assertEquals("http://localhost:4200/policy/user-groups", driver.getCurrentUrl());
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);

					customMessage = "Verify User able to Add a new user group name ";
					WebElementDetails AddUserGroup_button_obj = webElementDetails.get(4);
					policy_Setup_your_UserGroups.AdduserGroup_Button(AddUserGroup_button_obj).click();
					Thread.sleep(2000);

					WebElementDetails UserGroup_Textbox_obj = webElementDetails.get(5);
					policy_Setup_your_UserGroups.userGroupName_Textbox(UserGroup_Textbox_obj).clear();
					policy_Setup_your_UserGroups.userGroupName_Textbox(UserGroup_Textbox_obj).sendKeys("HR");
					Thread.sleep(2000);

					WebElementDetails Savebtn_obj = webElementDetails.get(6);
					policy_Setup_your_UserGroups.save_btn(Savebtn_obj).click();
					Thread.sleep(2000);

					WebElementDetails Usergroupname_toVerify_obj = webElementDetails.get(14);
					int noofUsergroupTables = policy_Setup_your_UserGroups
							.Usergroupname_toVerify(Usergroupname_toVerify_obj).size();
					String searchgroupTableText = policy_Setup_your_UserGroups
							.Usergroupname_toVerify(Usergroupname_toVerify_obj).get(noofUsergroupTables - 2).getText();
					System.out.println("text is " + searchgroupTableText);
					Thread.sleep(2000);
					Assert.assertTrue(policy_Setup_your_UserGroups.Usergroupname_toVerify(Usergroupname_toVerify_obj)
							.get(noofUsergroupTables - 2).getText().contains("HR"));
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

					customMessage = "Verify User able to change user group name ";
					WebElementDetails Editbtn_obj = webElementDetails.get(7);
					int noofeditbuttons = policy_Setup_your_UserGroups.Edit_btn(Editbtn_obj).size();
					policy_Setup_your_UserGroups.Edit_btn(Editbtn_obj).get(noofeditbuttons - 1).click();
					Thread.sleep(2000);

					policy_Setup_your_UserGroups.userGroupName_Textbox(UserGroup_Textbox_obj).clear();
					policy_Setup_your_UserGroups.userGroupName_Textbox(UserGroup_Textbox_obj).sendKeys("Admin");
					Thread.sleep(2000);

					WebElementDetails Editsavebtn_obj = webElementDetails.get(6);
					policy_Setup_your_UserGroups.save_btn(Editsavebtn_obj).click();
					Thread.sleep(2000);
					String searchgroupTableText2 = policy_Setup_your_UserGroups
							.Usergroupname_toVerify(Usergroupname_toVerify_obj).get(noofUsergroupTables - 2).getText();
					System.out.println("text 2 is " + searchgroupTableText2);
					Thread.sleep(2000);
					Assert.assertTrue(policy_Setup_your_UserGroups.Usergroupname_toVerify(Usergroupname_toVerify_obj)
							.get(noofUsergroupTables - 2).getText().contains("Admin"));
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

					customMessage = "Verify User able to Add Locations for user group ";
					WebElementDetails Expandbtn_obj = webElementDetails.get(8);
					int noofExpandbuttons = policy_Setup_your_UserGroups.Expand_btn(Expandbtn_obj).size();
					policy_Setup_your_UserGroups.Expand_btn(Expandbtn_obj).get(noofExpandbuttons - 1).click();
					Thread.sleep(2000);
					policy_Setup_your_UserGroups.Expand_btn(Expandbtn_obj).get(noofExpandbuttons - 1).click();

					WebElementDetails AddLocationMappingbtn_obj = webElementDetails.get(9);
					policy_Setup_your_UserGroups.AddLocationMapping_btn(AddLocationMappingbtn_obj).click();
					Thread.sleep(2000);

					WebElementDetails Locationsdropdown_obj = webElementDetails.get(10);
					policy_Setup_your_UserGroups.Locations_dropdown(Locationsdropdown_obj).click();
					Thread.sleep(2000);

					WebElementDetails dropdownlist_obj = webElementDetails.get(11);
					int noofdropdowns = policy_Setup_your_UserGroups.dropdown_list(dropdownlist_obj).size();
					policy_Setup_your_UserGroups.dropdown_list(dropdownlist_obj).get(noofdropdowns - 5).click();
					Thread.sleep(2000);

					WebElementDetails Iprange_Textbox1_obj = webElementDetails.get(12);
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox1_obj).get(0).clear();
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox1_obj).get(0)
							.sendKeys("192.168.100.20");
					Thread.sleep(2000);

					WebElementDetails Iprange_Textbox2_obj = webElementDetails.get(12);
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox2_obj).get(1).clear();
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox2_obj).get(1)
							.sendKeys("192.168.100.70");
					Thread.sleep(2000);

					policy_Setup_your_UserGroups.save_btn(Savebtn_obj).click();
					Thread.sleep(2000);

					WebElementDetails Tabledata_obj = webElementDetails.get(14);
					int noofTablesdata = policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).size();
					System.out.println(
							policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).get(noofTablesdata - 3).getText());
					Assert.assertTrue(policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).get(noofTablesdata - 3)
							.getText().contains("192.168.100.20"));
					Thread.sleep(2000);
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

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
		log.info("=======>>>>>>  END of the method   <<<<<===============");

	}

	// ==========================================================================

	@SuppressWarnings("unused")
	@Test
	public void policy_editusergroupLoaction() {
		log.info("START of the Method Policy ");
		homePage = new Homepage();
		policy_Setup_your_UserGroups = new Policy_Setup_your_UserGroups();
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
					ETestReport = ext.startTest(" Edit User group Location Iprange at Policy");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest(" Edit User group Iprange at User groups ");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					customMessage = "Verify User able to Edit Location Ip Address for user group ";

					WebElementDetails Editbtn_obj = webElementDetails.get(7);
					int noofeditbuttons = policy_Setup_your_UserGroups.Edit_btn(Editbtn_obj).size();
					policy_Setup_your_UserGroups.Edit_btn(Editbtn_obj).get(noofeditbuttons - 3).click();
					Thread.sleep(2000);

					WebElementDetails Iprange_Textbox1_obj = webElementDetails.get(12);
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox1_obj).get(0).clear();
					policy_Setup_your_UserGroups.Iprange_Textboxes(Iprange_Textbox1_obj).get(0)
							.sendKeys("192.168.100.99");
					Thread.sleep(4000);

					WebElementDetails Savebtn_obj = webElementDetails.get(6);
					policy_Setup_your_UserGroups.save_btn(Savebtn_obj).click();
					Thread.sleep(2000);

					WebElementDetails Tabledata_obj = webElementDetails.get(14);
					int noofTablesdata = policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).size();
					System.out.println(
							policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).get(noofTablesdata - 3).getText());
					Assert.assertTrue(policy_Setup_your_UserGroups.Tabledata(Tabledata_obj).get(noofTablesdata - 3)
							.getText().contains("192.168.100.99"));
					Thread.sleep(2000);
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

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
		log.info("=======>>>>>>  END of the method   <<<<<===============");

	}

	@SuppressWarnings("unused")
	@Test
	public void policy_deleteusergroupLoaction() {
		log.info("START of the Method Policy ");
		homePage = new Homepage();
		policy_Setup_your_UserGroups = new Policy_Setup_your_UserGroups();
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
					ETestReport = ext.startTest(" Delete User group Location at Policy User Groups");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest(" Delete user group location at User Groups ");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

					customMessage = "Verify User able to Delete Locations at user group ";



					WebElementDetails TableRow_obj = webElementDetails.get(13);
					int noofTableRows = policy_Setup_your_UserGroups.TableRows(TableRow_obj).size();
				int lastrowIprange =	policy_Setup_your_UserGroups.TableRows(TableRow_obj).get(noofTableRows-1).findElements(By.cssSelector(".label-content")).size();					
				if(policy_Setup_your_UserGroups.TableRows(TableRow_obj).get(noofTableRows-1).findElements(By.cssSelector(".label-content")).get(lastrowIprange-3).getText().contains("192.168.100.99")) {
				
					WebElementDetails Deletebtn_obj = webElementDetails.get(15);
					int noofDeletetbuttons = policy_Setup_your_UserGroups.delete_buttons(Deletebtn_obj).size();
					policy_Setup_your_UserGroups.delete_buttons(Deletebtn_obj).get(noofDeletetbuttons - 1).click();
					Thread.sleep(2000);

				}
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));

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
		log.info("=======>>>>>>  END of the method   <<<<<===============");

	}

}
