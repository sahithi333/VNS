package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;
import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Inventory_For_This_Location;
import com.sci.Testmate.Pageobjects.Orders_for_this_Location;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Inventory_For_this_Location {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Inventory_For_This_Location.class.getSimpleName());


	Bandwidth_Alerts_by_Location_TestScripts bandwidth_Alerts_by_Location_TestScripts;

	static String adress = null;
	static String line = null;
	static String[] lines = null;
	Homepage homePage;
	JavascriptExecutor javascriptExecutor;
	Inventory_For_This_Location inventory_For_This_Location;

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

	public void Inventory_Funtionality() {
		bandwidth_Alerts_by_Location_TestScripts = new Bandwidth_Alerts_by_Location_TestScripts();
		inventory_For_This_Location = new Inventory_For_This_Location();

		log.info("START of the Method Inventory_Functionality for this location  ");
		homePage = new Homepage();
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
					ETestReport = ext.startTest("Inventory Functionality  ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Inventory For this location");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					if(driver.getCurrentUrl().equals("http://localhost:4200/network")) {
						WebElementDetails Inventory_obj = webElementDetails.get(0);
						inventory_For_This_Location.Inventory(Inventory_obj).click();
						Thread.sleep(2000);
						Actions actions = new Actions(driver);
						actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					}
					
					if(driver.getCurrentUrl().equals("http://localhost:4200")) {
					customMessage = "Verify Bandwidth utilization menu is working as expeected";
					driver.findElements(By.cssSelector(".title.on-white")).get(1).click();
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					
					driver.findElement(By.id("graphItem0")).click();
					Thread.sleep(2000);

			
					Thread.sleep(2000);
					WebElementDetails Inventory_obj = webElementDetails.get(0);
					inventory_For_This_Location.Inventory(Inventory_obj).click();
					
					}
					
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);


					customMessage = "Verify System is showing Private IP table with data";
					WebElementDetails PrivateIP_obj = webElementDetails.get(1);
					Assert.assertTrue(inventory_For_This_Location.PrivateIP(PrivateIP_obj).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();

					

					customMessage = "Verify System is showing  Virtual Network Services table with data ";
					WebElementDetails VirtualNetworkServices_obj = webElementDetails.get(1);
					Assert.assertTrue(inventory_For_This_Location.VirtualNetworkServices(VirtualNetworkServices_obj).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					
					
					customMessage = "Verify System is showing Secure Cloud Interconnect table with data ";
					WebElementDetails SecureCloudInterconnect_obj = webElementDetails.get(1);
					Assert.assertTrue(inventory_For_This_Location.SecureCloudInterconnect(SecureCloudInterconnect_obj).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);


				}
			}

		} catch (java.lang.AssertionError e) {
			ETestReport.log(LogStatus.FAIL, customMessage + " Failed");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			ETestReport.log(LogStatus.FAIL, customMessage + " Failed");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
				ext = null;
			}
		}
		log.info("END of the method addNewDatabaseRecord");
	}

	
	
	@SuppressWarnings({ "unused", "null" })
	public void Check_Ascending_Order_of_Tablesdata() {
		bandwidth_Alerts_by_Location_TestScripts = new Bandwidth_Alerts_by_Location_TestScripts();
		inventory_For_This_Location = new Inventory_For_This_Location();

		log.info("START of the Method ELAN-ELINE Table Ascending order for this location  ");
		homePage = new Homepage();
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
					ETestReport = ext.startTest("Inventory Page ELAN-ELINE Table Sortng order ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("ELAN-ELINE Table Sortng order");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					Thread.sleep(2000);


					// ====================== Circuit id Ascending order verification
					// ================================================
					
					
					WebElementDetails FirstCircuitID_Data_obj = webElementDetails.get(2);
					String firstrRow_circuit_id		= inventory_For_This_Location.FirstCircuitID_Data(FirstCircuitID_Data_obj).getText();

					WebElementDetails SecondCircuitID_Data_obj = webElementDetails.get(2);
					String SecondRow_circuit_id = inventory_For_This_Location.SecondCircuitID_Data(SecondCircuitID_Data_obj).getText();
					
					
					WebElementDetails ThirdCircuitID_Data_obj = webElementDetails.get(2);
					String ThirdRow_circuit_id = inventory_For_This_Location.ThirdCircuitID_Data(ThirdCircuitID_Data_obj).getText();

					
					WebElementDetails ForthCircuitID_Data_obj = webElementDetails.get(2);
					String ForthRow_circuit_id = inventory_For_This_Location.ForthCircuitID_Data(ForthCircuitID_Data_obj).getText();

					WebElementDetails FifthCircuitID_Data_obj = webElementDetails.get(2);
					String FifthRow_circuit_id = inventory_For_This_Location.FifthCircuitID_Data(FifthCircuitID_Data_obj).getText();


					List<String> stringList = new ArrayList<>();

					stringList.add(firstrRow_circuit_id);
					stringList.add(SecondRow_circuit_id);
					stringList.add(ThirdRow_circuit_id);
					stringList.add(ForthRow_circuit_id);
					stringList.add(FifthRow_circuit_id);

					customMessage = "Verify User able to vew Circuit id in Sortng Order";
					boolean isSorted = true;
					for (int i = 0; i < stringList.size(); i++) {

						System.out.println(" size is " + stringList);

						if (i < stringList.size() - 1
								&& stringList.get(i).compareToIgnoreCase(stringList.get(i + 1)) > 0) {
							isSorted = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", ""));
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == stringList.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", ""));
							System.out.println(" working  as expected");
						}
					}

					// ====================== Vpn name Ascending order verification
					// ================================================
					
					WebElementDetails Vpn_Headder_obj = webElementDetails.get(3);
					 inventory_For_This_Location.VpnName_Headder(Vpn_Headder_obj).click();

					WebElementDetails FirstRowVpn_Data_obj = webElementDetails.get(2);
					String firstRow_Vpn_name		= inventory_For_This_Location.FirstVpnname_Data(FirstRowVpn_Data_obj).getText();


					WebElementDetails SecondRowVpn_Data_obj = webElementDetails.get(2);
					String SecondRow_Vpn_name = inventory_For_This_Location.SecondVpnname_Data(SecondRowVpn_Data_obj).getText();
					
					
					WebElementDetails ThirdRowVpn_Data_obj = webElementDetails.get(2);
					String ThirdRow_Vpn_name = inventory_For_This_Location.ThirdVpnName_Data(ThirdRowVpn_Data_obj).getText();

					
					WebElementDetails ForthRowVpn_Data_obj = webElementDetails.get(2);
					String ForthRow_Vpn_name = inventory_For_This_Location.ForthVpnName_Data(ForthRowVpn_Data_obj).getText();

					WebElementDetails FifthRowVpn = webElementDetails.get(2);
					String FifthRow_Vpn_name = inventory_For_This_Location.FifthVpnName_Data(FifthRowVpn).getText();

					List<String> Vpn_Name_stringList = new ArrayList<>();

					Vpn_Name_stringList.add(firstRow_Vpn_name);
					Vpn_Name_stringList.add(SecondRow_Vpn_name);
					Vpn_Name_stringList.add(ThirdRow_Vpn_name);
					Vpn_Name_stringList.add(ForthRow_Vpn_name);
					Vpn_Name_stringList.add(FifthRow_Vpn_name);

					customMessage = "Verify User able to vew Circuit id in Sortng Order";
					boolean isSorted1 = true;
					for (int i = 0; i < Vpn_Name_stringList.size(); i++) {

						System.out.println(" size is " + Vpn_Name_stringList);

						if (i < Vpn_Name_stringList.size() - 1
								&& Vpn_Name_stringList.get(i).compareToIgnoreCase(Vpn_Name_stringList.get(i + 1)) > 0) {
							isSorted = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", "Faled --"));
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == Vpn_Name_stringList.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", ""));
							System.out.println(" working  as expected");
						}
					}

					// ====================== Current port speed Ascending order verification
					// ================================================

					int firstrRow_Current_portSpeed = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div"))
							.getText().trim());

					int SecondRow_Current_portSpeed = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[3]/div[1]/div[2]/div/div/div/div"))
							.getText().trim());

					int ThirdRow_Current_portSpeed = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[4]/div[1]/div[2]/div/div/div/div"))
							.getText().trim());

					int ForthowRow_Current_portSpeed = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[5]/div[1]/div[2]/div/div/div/div"))
							.getText().trim());

					int FifthRow_Current_portSpeed = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[3]/div[1]/div[2]/div/div/div/div"))
							.getText().trim());

					List<Integer> Current_portSpeed_List = new ArrayList<>();

					Current_portSpeed_List.add(firstrRow_Current_portSpeed);
					Current_portSpeed_List.add(SecondRow_Current_portSpeed);
					Current_portSpeed_List.add(ThirdRow_Current_portSpeed);
					Current_portSpeed_List.add(ForthowRow_Current_portSpeed);
					Current_portSpeed_List.add(FifthRow_Current_portSpeed);

					customMessage = "Verify User able to vew Circuit Port Speed in Sortng Order";
					boolean isSorted2 = true;
					for (int i = 0; i < Current_portSpeed_List.size(); i++) {

						System.out.println(" size is " + Current_portSpeed_List);

						if (i < Current_portSpeed_List.size() - 1 && Current_portSpeed_List.get(i) > Current_portSpeed_List.get(i + 1)) {
							isSorted = false;
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", ""));
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == Current_portSpeed_List
								.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", ""));
							System.out.println(" working  as expected");
						}
					}

					// ====================== Access type Ascending order verification
					// ================================================

					driver.findElement(By.xpath(".//*[@id='inventory-elaneline']/div/div[3]/div[1]/div[4]/div/div/div"))
							.click();
					Thread.sleep(2000);

					int firstrRow_AccessType = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[2]/div[1]/div[4]/div/div/div/div"))
							.getText().replace("Type", "").trim());

					int SecondRow_AccessType = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[3]/div[1]/div[4]/div/div/div/div"))
							.getText().replace("Type", "").trim());

					int ThirdRow_AccessType = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[4]/div[1]/div[4]/div/div/div/div"))
							.getText().replace("Type", "").trim());

					int ForthRow_AccessType = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[5]/div[1]/div[4]/div/div/div/div"))
							.getText().replace("Type", "").trim());
					int FifthRow_AccessType = Integer.parseInt(driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[6]/div[1]/div[4]/div/div/div/div"))
							.getText().replace("Type", "").trim());

					List<Integer> AccessType_List = new ArrayList<>();

					AccessType_List.add(firstrRow_AccessType);
					AccessType_List.add(SecondRow_AccessType);
					AccessType_List.add(ThirdRow_AccessType);
					AccessType_List.add(ForthRow_AccessType);
					AccessType_List.add(FifthRow_AccessType);

					customMessage = "Verify User able to vew Access type in Sortng Order";
					boolean isSorted3 = true;
					for (int i = 0; i < AccessType_List.size(); i++) {

						System.out.println(" size is " + AccessType_List);

						if (i < AccessType_List.size() - 1 && AccessType_List.get(i) > AccessType_List.get(i + 1)) {
							isSorted3 = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", ""));
						new TestMateException().handleMAnualException(customMessage+" Failed", AppUtil.getMethodName(), ETestReport);

							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted3 && i == AccessType_List.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", ""));
							System.out.println(" working  as expected");
						}
					}

				}
			}

		} catch (java.lang.AssertionError e) {
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
		log.info("=======>>>>>>  END of the method - --<<<<<===============");

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
