package com.sci.Testmate.TestScripts;

import static com.sci.Testmate.Common.Constants.ext;
import static com.sci.Testmate.Common.Constants.isExcutingFromTestSuite;
import static com.sci.Testmate.Common.Constants.parentTestReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Pageobjects.Bandwidth_Alerts_by_Location;
import com.sci.Testmate.Pageobjects.Homepage;
import com.sci.Testmate.Pageobjects.LocationToolsPageObjects;
import com.sci.Testmate.model.WebElementDetails;
import com.sci.Testmate.util.AppUtil;
import com.sci.Testmate.util.JWebDriver;
import com.sci.Testmate.util.XMLParser;
import com.sci.TestmateExceptions.TestMateException;

public class LocationToolsTestScript {
	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> homePageWebElementsList = null;

	private List<WebElementDetails> webElementDetails = XMLParser.getInstance()
			.getWebElements(LocationToolsPageObjects.class.getSimpleName());

	Homepage homePage;
	Bandwidth_Alerts_by_Location bandwidth_Alerts_by_Location;
	LocationToolsTestScript locationToolsobj;
	static String address = null;
	ExtentTest ETestReport;
	AppUtil apt = new AppUtil();
	LocationToolsPageObjects 	locationToolsPageObjects;


				
		@Before
		public void beforeTest() {
			log.info("START of the method beforeTest");
			System.out.println("<<<<<<<<<<<<< Beforemethod  >>>>>>>>>>>>");
			log.info("END of the method beforeTest");
		}
		//===========================================================================================

		
		@SuppressWarnings("unused")
		private void setPrerequisites() throws InterruptedException {

			if (homePageWebElementsList == null) {
				homePageWebElementsList = XMLParser.getInstance().getWebElements(Homepage.class.getSimpleName());
			}

		}

		//===========================================================================================
	
		
		@Test
		public void locationTools() {
			
		
			log.info("START of the method LocationTools ");
			homePage = new Homepage();
			String customMessage = null;
			WebDriver driver = null;
			bandwidth_Alerts_by_Location = new Bandwidth_Alerts_by_Location();
			locationToolsobj = new LocationToolsTestScript();
			locationToolsPageObjects = new LocationToolsPageObjects();

			try {
				setPrerequisites();
				if (homePageWebElementsList != null && homePageWebElementsList.size() > 0) {
					if (apt.checkLaunchIsSucess()) {
						if (ext == null) {
							ext = AppUtil.extentReport();
						}
						//System.out.println("test");
						ETestReport = ext.startTest("Location wise tools ");
						if (isExcutingFromTestSuite) {
							if (parentTestReport == null) {
								parentTestReport = ext.startTest("Locationtools");
							}
							parentTestReport.appendChild(ETestReport);
						}

						driver = JWebDriver.getInstance().getWebDriver();


						Thread.sleep(2000);
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
						customMessage = " Verify Applications Menu working as expexted ";
						WebElementDetails applications = webElementDetails.get(0);
						locationToolsPageObjects.Applications(applications).click();
						Thread.sleep(3000);
						locationToolsPageObjects.Applications(applications).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS,  customMessage);

		
						customMessage = " Verify Diagnostics Menu working as expexted ";
						WebElementDetails diagnostics= webElementDetails.get(1);
						locationToolsPageObjects.Diagnostics(diagnostics).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS, customMessage);
						
						
						
						customMessage = "Verify Users  Menu working as expexted";
						WebElementDetails users= webElementDetails.get(2);
						locationToolsPageObjects.Users(users).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS, customMessage);

						
						
						customMessage = " Verify Orders Menu At working as expexted";
						WebElementDetails orders= webElementDetails.get(3);
						locationToolsPageObjects.Orders(orders).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS,  customMessage);

						
						customMessage = " Verify Inventory Menu At working as expexted";
						WebElementDetails inventory= webElementDetails.get(4);
						locationToolsPageObjects.Inventory(inventory).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS,  customMessage);

						
						customMessage = "Verify Tickets Menu At working as expexted";
						WebElementDetails tickets= webElementDetails.get(5);
						locationToolsPageObjects.Tickets(tickets).click();
						Thread.sleep(3000);
						ETestReport.log(LogStatus.PASS, customMessage);

					}
				}

			}

			catch (java.lang.AssertionError e) {
				System.out.println(">>>>>>>>>>>>>>>>");
				ETestReport.log(LogStatus.FAIL, customMessage);
				new TestMateException().handleException(e, customMessage,
						"", ETestReport);
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
			log.info("============>>>>>   END of the method Location Wise Tools      <<<<<=================");

		}

		
		
		
		
			
	
	
	
	
	@Test
	public boolean editTools() throws InterruptedException{
		WebDriver driver;
		driver = JWebDriver.getInstance().getWebDriver();

		try{
			driver = JWebDriver.getInstance().getWebDriver();
			
			
			driver.findElement(By.xpath("//*[@ng-reflect-icon='edit']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("ng-reflect-label='Agree and Submit'")).click();
			Thread.sleep(2000);
			
			return true;
		}catch(Exception e){
			return false;
		}

	}
	
	
	public  String area(){
		WebDriver driver;
		driver = JWebDriver.getInstance().getWebDriver();

		  String address = driver.findElement(By.tagName("address")).getText();
		  String[] lines = address.split("\\n");

		  String line = lines[1];

return  line;
	}

	
}