package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;
import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
import com.sun.javafx.geom.Area;

import junit.framework.Assert;

public class Orders_for_this_LocationTestScripts {
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
	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void orders_For_this_Location() {
		log.info("START of the Method Orders for this Location ");
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
					ETestReport = ext.startTest("Orders at this location");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Orders Functionality  Testing");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					Thread.sleep(4000);

					javascriptExecutor = (JavascriptExecutor) driver;
					javascriptExecutor.executeScript("window.scrollBy(0,250)", "");

					if (driver.getCurrentUrl().equals("http://localhost:4200/")) {
						WebElementDetails Bandwidthmenu_obj = webElementDetails.get(13);
						orders_for_this_Location.Bandwidth_menu(Bandwidthmenu_obj).click();
						Thread.sleep(2000);
					}

					WebElementDetails Bandwidthbar_obj = webElementDetails.get(14);
					orders_for_this_Location.Firstbar_graph(Bandwidthbar_obj).click();
					Thread.sleep(2000);

					WebElementDetails Orders_obj = webElementDetails.get(15);
					orders_for_this_Location.orders_menu(Orders_obj).click();

					customMessage = "Verify Orders menu is navigated to corresponding page";
					WebElementDetails ordersmenu_Verify_obj = webElementDetails.get(16);
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersMenu_Verification(ordersmenu_Verify_obj).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);

					javascriptExecutor = (JavascriptExecutor) driver;
					javascriptExecutor.executeScript("window.scrollBy(0,250)", "");

					customMessage = " Verify Orders table contain OrderId headder column ";
					WebElementDetails OrdersTable_obj = webElementDetails.get(17);
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersTables_colums(OrdersTable_obj).get(0).isDisplayed());
					System.out.println(customMessage.replace(" Verify", ""));

					customMessage = " Verify Orders table contain OrderType headder column ";
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersTables_colums(OrdersTable_obj).get(1).isDisplayed());
					System.out.println(customMessage.replace(" Verify", ""));

					customMessage = " Verify Orders table contain ServiceType headder column ";
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersTables_colums(OrdersTable_obj).get(2).isDisplayed());
					System.out.println(customMessage.replace(" Verify", ""));

					customMessage = " Verify Orders table contain Status headder column ";
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersTables_colums(OrdersTable_obj).get(3).isDisplayed());
					System.out.println(customMessage.replace(" Verify", ""));

					customMessage = " Verify Orders table contain Updated Date headder column ";
					org.testng.Assert.assertTrue(
							orders_for_this_Location.ordersTables_colums(OrdersTable_obj).get(4).isDisplayed());
					System.out.println(customMessage.replace(" Verify", ""));

					customMessage = "Verify System is showing 'Circuit ID,  PortSpeed, Comments, Primary Contact' when we click on expand button";
					WebElementDetails Zoomin_obj = webElementDetails.get(1);
					orders_for_this_Location.Zoom_in_Zomm_out(Zoomin_obj).get(0).click();
					new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);

					WebElementDetails ExpandTables_obj = webElementDetails.get(18);
					WebElementDetails Expand_PrimaryObj = webElementDetails.get(19);

					Assert.assertTrue(orders_for_this_Location.ExpandTables_colums(ExpandTables_obj).get(0)
							.isDisplayed()

							&& orders_for_this_Location.ExpandTables_colums(ExpandTables_obj).get(2).isDisplayed()
							&& orders_for_this_Location.ExpandTables_colums(ExpandTables_obj).get(3).isDisplayed()
							&& orders_for_this_Location.Expand_PrimaryContact(Expand_PrimaryObj).isDisplayed());

					Thread.sleep(2000);
					ETestReport.log(LogStatus.PASS, customMessage.replaceFirst("Verify", ""));
					Thread.sleep(2000);
					new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
					orders_for_this_Location.Zoom_in_Zomm_out(Zoomin_obj).get(0).click();
					Thread.sleep(2000);

				}
			}

		} 	 catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage + " Failed ");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			System.out.println("Automation code fail ");
			e.printStackTrace();
			ETestReport.log(LogStatus.FAIL, customMessage + "Failed");
			new TestMateException().handleException(e, customMessage, AppUtil.getMethodName(), ETestReport);
		}

		finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method -- Orders for this location --<<<<<===============");

	}

	// ==========================================================================

	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void orders_searchFunctionality() {
		log.info("START of the Method orders searchFunctionality ");
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
					ETestReport = ext.startTest("Search Function at orders ");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Search Function at orders");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					Thread.sleep(3000);

					Actions actions = new Actions(driver);

					customMessage = "Verify Orders Search Based on Order id functionality is working as expected";
					WebElement searchbtn = driver.findElement(By.cssSelector(".on-white.float-left"))
							.findElement(By.cssSelector(".text-input.p.form-control"));
					actions.moveToElement(searchbtn);
					actions.click().build().perform();
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					actions.click();
					actions.sendKeys("2105988");
					actions.sendKeys(Keys.ENTER);
					actions.build().perform();
					int noofrows = driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
					Assert.assertTrue(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(noofrows - 1).getText().contains("2105988"));
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Orders Search Based on ServiceType Orders functionality is working as expected";
					actions.moveToElement(searchbtn);
					actions.click().build().perform();
					searchbtn.sendKeys(Keys.CONTROL, "a");
					searchbtn.sendKeys(Keys.DELETE);
					Thread.sleep(2000);
					actions.sendKeys("VNS");
					actions.sendKeys(Keys.ENTER);
					actions.build().perform();
					Assert.assertTrue(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(noofrows - 1).getText().contains("VNS"));
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify Orders Search Based on PendingOrders functionality  is working as expected";
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					actions.moveToElement(searchbtn);
					actions.click().build().perform();
					searchbtn.sendKeys(Keys.CONTROL, "a");
					searchbtn.sendKeys(Keys.DELETE);
					Thread.sleep(2000);
					actions.sendKeys("Pending");
					actions.sendKeys(Keys.ENTER);
					actions.build().perform();
					Assert.assertTrue(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(noofrows - 1).getText().contains("PENDING"));
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);
					searchbtn.sendKeys(Keys.CONTROL, "a");
					searchbtn.sendKeys(Keys.DELETE);

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
		log.info("=======>>>>>>  END of the method -- Orders for this location --<<<<<===============");

	}

	// ==========================================================================

	@SuppressWarnings("deprecation")
	public void filter_Funtionality_Based_on_ServiceType() {

		log.info("START of the Method filter_Funtionality_Based_on_ServiceType");
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
					ETestReport = ext.startTest("Filter Orders Based on ServiceType");
					if (isExcutingFromTestSuite) {
						if (parentTestReport == null) {
							parentTestReport = ext.startTest("Filter Orders ");
						}
						parentTestReport.appendChild(ETestReport);
					}

					driver = JWebDriver.getInstance().getWebDriver();

					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					// ==========================================================================
					customMessage = "Verify User able to Filter orders based on Searchtype- PIP checkbox";

					WebElementDetails Filter_obj = webElementDetails.get(3);
					orders_for_this_Location.Filter(Filter_obj).click();
					orders_for_this_Location.Filter(Filter_obj).click();
					Thread.sleep(2000);

					WebElementDetails Clear_obj = webElementDetails.get(9);
					orders_for_this_Location.Clear(Clear_obj).click();
					Thread.sleep(2000);

					WebElementDetails Service_obj = webElementDetails.get(4);
					orders_for_this_Location.ServiceType(Service_obj).click();

					WebElementDetails Apply_obj = webElementDetails.get(8);
					orders_for_this_Location.Apply(Apply_obj).click();
					Thread.sleep(2000);

					int noofrows = driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
					Assert.assertTrue(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(1).getText().contains("PIP"));
					System.out.println(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(noofrows - 1).getText());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);
					// ==========================================================================

					customMessage = "Verify User able to Filter orders based on Searchtype- SCI checkbox";
					orders_for_this_Location.Filter(Filter_obj).click();
					orders_for_this_Location.Filter(Filter_obj).click();
					Thread.sleep(2000);

					orders_for_this_Location.Clear(Clear_obj).click();
					Thread.sleep(2000);

					WebElementDetails Service_obj1 = webElementDetails.get(5);
					orders_for_this_Location.ServiceType(Service_obj1).click();
					orders_for_this_Location.Apply(Apply_obj).click();
					Assert.assertTrue(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row"))
							.get(1).getText().contains("SCI"));
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					
					  // ==========================================================================
					  
					  customMessage =
					  "Verify User able to search orders on Searchtype- VNF checkbox";
					  
					  orders_for_this_Location.Filter(Filter_obj).click();
					  orders_for_this_Location.Filter(Filter_obj).click();
					  
					  orders_for_this_Location.Clear(Clear_obj).click();
					  
					  WebElementDetails Service_obj2 = webElementDetails.get(7);
					  orders_for_this_Location.ServiceType(Service_obj2).click();
					  orders_for_this_Location.ServiceType(Service_obj2).click();
					  
					  orders_for_this_Location.Apply(Apply_obj).click();
					  Assert.assertTrue(driver.findElements(By.cssSelector(
					  ".accordion-title.ves-table-row.row")).get(1).getText().
					  contains("No data to display.")); ETestReport.log(LogStatus.PASS,
					  customMessage.replace("Verify", "")); Thread.sleep(2000);
					  
					 
				}
			}

		}

		catch (java.lang.AssertionError e) {
			System.out.println(">>>>>>>>>>>>>>>>");
			ETestReport.log(LogStatus.FAIL, customMessage);
			// new TestMateException().handleException(e, customMessage,
			// AppUtil.getMethodName(), ETestReport);
		} catch (Exception e) {
			System.out.println(" fail test");
			e.printStackTrace();
			ETestReport.log(LogStatus.FAIL, customMessage);
			new TestMateException().handleException(e, customMessage + " -- Failed", AppUtil.getMethodName(),
					ETestReport);
		} finally {
			ext.endTest(ETestReport);
			ext.flush();
			if (!isExcutingFromTestSuite) {
				ext.close();
			}

		}
		log.info("=======>>>>>>  END of the method - Filter Orders by Service type --<<<<<===============");

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

					WebElementDetails Filter_obj = webElementDetails.get(3);
					orders_for_this_Location.Filter(Filter_obj).click();
					orders_for_this_Location.Filter(Filter_obj).click();
					Thread.sleep(2000);

					WebElementDetails Clear_obj = webElementDetails.get(9);
					orders_for_this_Location.Clear(Clear_obj).click();
					Thread.sleep(2000);

					customMessage = "Verify User able to filter Completed Orders ";
					WebElementDetails completed_obj = webElementDetails.get(10);
					orders_for_this_Location.Status(completed_obj).click();
					Thread.sleep(1000);
					WebElementDetails Apply_obj = webElementDetails.get(8);
					orders_for_this_Location.Apply(Apply_obj).click();
					Assert.assertTrue(
							driver.findElement(By.xpath(".//*[@ng-reflect-label=\'COMPLETED\']")).isDisplayed());
					ETestReport.log(LogStatus.PASS, customMessage.replace("Verify", ""));
					Thread.sleep(2000);

					customMessage = "Verify User able to filter Pending Orders ";
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

					customMessage = "Verify User able to filter Failed Orders ";
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
		log.info("=======>>>>>>  END of the method - Filter orders by status--<<<<<===============");

	}

	// ==========================================================================

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
