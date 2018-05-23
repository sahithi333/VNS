package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.Inventory_For_This_Location;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

import junit.framework.Assert;

public class Inventory_Tables_Check_Ascending_DecendingOrders {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	@SuppressWarnings("unused")
	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(Inventory_For_This_Location.class.getSimpleName());

	private List<WebElementDetails> bandwidthwebElementDetails = XMLParser.getInstance()
			.getWebElements(Bandwidth_Alerts_by_Location.class.getSimpleName());

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
					ETestReport = ext.startTest("Inventory Page ELAN-ELINE Table Ascending order For this location ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("ELAN-ELINE Table Ascending order");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					Thread.sleep(2000);

					WebElement PrivateIP = driver.findElement(By.xpath(
							".//*[@id='main-content']/app-apps-network/app-bandwidth-graph/div[2]/div/div/app-locationcard/app-inventory/h4[1]"));
					Thread.sleep(2000);
					JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", PrivateIP);

					// ====================== Circuit id Ascending order verification
					// ================================================
					

					String firstrRow_circuit_id = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[2]/div[1]/div[1]/div/div/div/div"))
							.getText();

					String SecondRow_circuit_id = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[3]/div[1]/div[1]/div/div/div/div"))
							.getText();

					String ThirdRow_circuit_id = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[4]/div[1]/div[1]/div/div/div/div"))
							.getText();

					String ForthRow_circuit_id = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[5]/div[1]/div[1]/div/div/div/div"))
							.getText();

					String Fifth_circuit_id = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[6]/div[1]/div[1]/div/div/div/div"))
							.getText();

					List<String> stringList = new ArrayList<>();

					stringList.add(firstrRow_circuit_id);
					stringList.add(SecondRow_circuit_id);
					stringList.add(ThirdRow_circuit_id);
					stringList.add(ForthRow_circuit_id);
					stringList.add(Fifth_circuit_id);

					customMessage = "Verify Circuit id Ascending order";
					boolean isSorted = true;
					for (int i = 0; i < stringList.size(); i++) {

						System.out.println(" size is " + stringList);

						if (i < stringList.size() - 1
								&& stringList.get(i).compareToIgnoreCase(stringList.get(i + 1)) > 0) {
							isSorted = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", "") + " is not working as expected");
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == stringList.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", "") + " is working as expected");
							System.out.println(" working  as expected");
						}
					}

					// ====================== Vpn name Ascending order verification
					// ================================================
					

					String firstrRow_Vpn_Name = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[2]/div[1]/div[3]/div/div/div/div"))
							.getText();

					String SecondRow_Vpn_Name = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[3]/div[1]/div[3]/div/div/div/div"))
							.getText();

					String ThirdRow_Vpn_Name = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[4]/div[1]/div[3]/div/div/div/div"))
							.getText();

					String ForthRow_Vpn_Name = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[5]/div[1]/div[3]/div/div/div/div"))
							.getText();

					String Fifth_Vpn_Name = driver
							.findElement(By.xpath(
									".//*[@id='inventory-elaneline']/div/div[3]/div[6]/div[1]/div[3]/div/div/div/div"))
							.getText();

					List<String> Vpn_Name_stringList = new ArrayList<>();

					Vpn_Name_stringList.add(firstrRow_Vpn_Name);
					Vpn_Name_stringList.add(SecondRow_Vpn_Name);
					Vpn_Name_stringList.add(ThirdRow_Vpn_Name);
					Vpn_Name_stringList.add(ForthRow_Vpn_Name);
					Vpn_Name_stringList.add(Fifth_Vpn_Name);

					customMessage = "Verify Vpn name Ascending order";
					boolean isSorted1 = true;
					for (int i = 0; i < Vpn_Name_stringList.size(); i++) {

						System.out.println(" size is " + Vpn_Name_stringList);

						if (i < Vpn_Name_stringList.size() - 1
								&& Vpn_Name_stringList.get(i).compareToIgnoreCase(Vpn_Name_stringList.get(i + 1)) > 0) {
							isSorted = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", "") + " is not working as expected");
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == Vpn_Name_stringList.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", "") + " is working as expected");
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

					customMessage = "Verify Current port speed Ascending order";
					boolean isSorted2 = true;
					for (int i = 0; i < Current_portSpeed_List.size(); i++) {

						System.out.println(" size is " + Current_portSpeed_List);

						if (i < Current_portSpeed_List.size() - 1 && Current_portSpeed_List.get(i) > Current_portSpeed_List.get(i + 1)) {
							isSorted = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", "") + " is not working as expected");
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted && i == Current_portSpeed_List
								.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", "") + " is working as expected");
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

					customMessage = "Verify Access type Ascending order";
					boolean isSorted3 = true;
					for (int i = 0; i < AccessType_List.size(); i++) {

						System.out.println(" size is " + AccessType_List);

						if (i < AccessType_List.size() - 1 && AccessType_List.get(i) > AccessType_List.get(i + 1)) {
							isSorted3 = false;
							ETestReport.log(LogStatus.FAIL,
									customMessage.replace("Verify", "") + " is not working as expected");
							System.out.println(" not working  as expected");
							break;
						}

						if (isSorted3 && i == AccessType_List.size() - 1) {
							ETestReport.log(LogStatus.PASS,
									customMessage.replace("Verify", "") + " is working as expected");
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
