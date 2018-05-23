package com.sci.Testmate.TestSuites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Sample {
	static WebDriver driver;
	JavascriptExecutor javascriptExecutor;
	Select select;

	@Test
	public void launch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\IEDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("localhost:4200");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath(".//*[@id='main-content']/app-landing/div[1]/app-landing-nav[2]/div/h1")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("graphItem0")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@ng-reflect-label='User Groups']")).click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		
		int noofdeletebuttons = driver.findElements(By.cssSelector(".cui-sm.close-alt")).size();
		
		System.out.println(noofdeletebuttons);
		
			
		//	driver.findElements(By.cssSelector(".cui-sm.close-alt")).get(noofdeletebuttons-1).click();
		
			int noofcolumns = driver.findElements(By.cssSelector(".label-content")).size();
			

		System.out.println(noofcolumns);
			
		System.out.println(driver.findElements(By.cssSelector(".label-content")).get(noofcolumns-3).getText());
		
		
/*		driver.findElement(By.xpath(".//*[@ng-reflect-label='Applications']")).click();
		Thread.sleep(3000);

		
		int nooftables = driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).size();
		System.out.println("size is : "+ nooftables);
	
		System.out.println(driver.findElements(By.cssSelector(".accordion-title.ves-table-row.row")).get(1).getText());
		
	
		
		
		
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		
		if(driver.findElements(By.xpath(".//*[@ng-reflect-meta-data='[object Object]']")).get(0).isDisplayed()) {
			System.out.println(" table displaying");
		}
		else {
			System.out.println(" table not displaying");

		}
		
		
		System.out.println(driver.findElements(By.cssSelector(".label-content")).get(2).getText() + " text is ");
		
*/		
		

	//	driver.findElement(By.xpath(".//*[@ng-reflect-label=\'Applications\']")).click();
		Thread.sleep(3000);

/*		WebElement parent = driver.findElement(By.className("bottom-button"));

		WebElement addbutton = parent.findElement(By.xpath(".//*[@ng-reflect-klass='btn']"));

		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", addbutton);
		Thread.sleep(2000);

		addbutton.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@data-toggle='dropdown']")).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath(".//*[@aria-labelledby='dropdownMenuButton']"));
		Thread.sleep(2000);

		//dropdown.findElement(By.linkText("UDP")).click();
		
		javascriptExecutor.executeScript("arguments[0].click();", dropdown.findElement(By.linkText("UDP")));
*/		
		
/*		List<WebElement>  edit_button = driver.findElements(By.cssSelector(".cui-sm.edit-nu-er"));
System.out.println("size is "+ edit_button.size());	
edit_button.get(1).click();

*/		
		
/*		List<WebElement>  close_button = driver.findElements(By.cssSelector(".cui-sm.close-alt"));
System.out.println("size is "+ close_button.size());	

close_button.get(1).click();
*/		
		
		
		// new Select(driver.findElement(By.id("dropdownMenuButton"))).selectByIndex(0);

		// new Select(driver.findElement(By.id("dropdownMenuButton"))).selectByIndex(1);

	}
}

/*
 * // driver.findElement(By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[1]/div[2]/div/div/div")).click();
 * 
 * // String first = // driver.findElement(By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[2]/div[1]/div[3]/div/div/div/div/div"
 * )).getText();
 * 
 * // String second = // driver.findElement(By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[3]/div[1]/div[3]/div/div/div/div/div"
 * )).getText();
 * 
 * // String third = // driver.findElement(By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[4]/div[1]/div[3]/div/div/div/div/div"
 * )).getText();
 * 
 * // String forth = // driver.findElement(By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[5]/div[1]/div[3]/div/div/div/div/div"
 * )).getText();
 * 
 * String first = driver .findElement( By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/div"
 * )) .getText();
 * 
 * String second = driver .findElement( By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[3]/div[1]/div[2]/div/div/div/div/div"
 * )) .getText();
 * 
 * String third = driver .findElement( By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[4]/div[1]/div[2]/div/div/div/div/div"
 * )) .getText();
 * 
 * String forth = driver .findElement( By.xpath(
 * ".//*[@id='tickets-table']/div/div[3]/div[5]/div[1]/div[2]/div/div/div/div/div"
 * )) .getText();
 * 
 * List<String> stringList = new ArrayList<>();
 * 
 * stringList.add(first); stringList.add(second); stringList.add(third);
 * stringList.add(forth);
 * 
 * boolean isSorted = true; for (int i = 0; i < stringList.size() - 1; i++) { //
 * System.out.println(stringList.get(i)); if
 * (stringList.get(i).compareToIgnoreCase(stringList.get(i + 1)) > 0) { isSorted
 * = false; System.out.
 * println(" Circuit id Ascending order is not working as expected -- Test Fail"
 * ); break; }
 * 
 * System.out.
 * println(" Circuit id Ascending order working as expected - Test pass"); }
 * 
 * System.out.println(first + " " + second + " " + third + " " + forth);
 * 
 * }
 * 
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * }
 * 
 * // String txt = driver.findElement(By.id("graphItem0")).getText(); //
 * System.out.println(txt);
 * 
 * }
 */
/*
 * driver.findElement(By.xpath(
 * ".//*[@id='main-content']/app-landing/div[1]/app-landing-nav[1]/div/h1")).
 * click(); Thread.sleep(3000); driver.get("http:localhost:4200");
 * Thread.sleep(3000);
 */

/*
 * driver.findElement(By.xpath(
 * ".//*[@id='main-content']/app-landing/div[1]/app-landing-nav[3]/div/h1")).
 * click(); Thread.sleep(3000);
 */
/*
 * driver.findElement(By.id("graphItem0")).click(); String msg = area() +
 * " test "; System.out.println(msg);
 * 
 * driver.findElement(By.id("graphItem1")).click(); String msg1 = area() +
 * " test "; System.out.println(msg1);
 */

/*
 * driver.findElement(By.xpath(".//*[@ng-reflect-icon='org']")).click();
 * 
 * List<WebElement> Address = driver.findElements(By.tagName("address"));
 * for(int i=0; i<Address.size(); i++){
 * 
 * System.out.println(Address.size()); Thread.sleep(2000);
 * Address.get(i).click(); System.out.println(area());
 * 
 * }
 */

/*
 * public String area() { String line = null;
 * 
 * String adress = Address.get().getText();
 * 
 * String[] lines = adress.split("\\n");
 * 
 * line = lines[0]; System.out.println(line);
 * 
 * } return line;
 * 
 * } }
 */
/*
 * address = address.replaceAll("\n", ""); System.out.println(address);
 */

/*
 * driver.findElement(By.xpath("//*[@ng-reflect-icon='edit']")).click();
 * Thread.sleep(2000);
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-icon='edit']")).click();
 * Thread.sleep(2000);
 * 
 * 
 * WebElement button = driver.findElement(By.className("primary"));
 * Thread.sleep(2000);
 * 
 * 
 * 
 * button.findElement(By.linkText("Agree and Submit")).click();
 * Thread.sleep(2000);
 * 
 */

// driver.findElement(By.xpath(".*[@id='app-main-nav']/app-main-nav-item[1]/div")).click();
// driver.findElement(By.xpath(".*[@id='graphItem0']/div/div[3]/div")).click();

// Thread.sleep(2000);

// ng-reflect-icon="network"

/*
 * String address = driver.findElement(By.tagName("address")).getText();
 * System.out.println(address);
 */

/*
 * address = address.replaceAll("\n", ""); System.out.println(address); String
 * address1 = driver.findElement(By.xpath(".*[@id='graphItem0']/div/div[1]")).
 * getText(); address1 = address1.replaceAll("\n", "");
 * System.out.println(address1); Assert.assertEquals(address, address1);
 */

/*
 * String [] arrOfStr = address.split("\n"); System.out.println(arrOfStr);
 */
/*
 * List<WebElement> bars = driver.findElements(By.className("bandwidth-bar"));
 * System.out.println(bars.size());
 * 
 * graphItem1
 * 
 * List<WebElement> names = driver.findElements(By.id("graphItem")); for(int
 * i=0; i<names.size(); i++){
 * 
 * System.out.println(names.get(i).getText()); System.out.println(
 * "========================================================================="
 * ); System.out.println(names.get(i).getTagName());
 * 
 * }
 */

/*
 * JavascriptExecutor js =(JavascriptExecutor)driver;
 * js.executeScript("window.scrollBy(0,1000)");
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Applications']")).click()
 * ; Thread.sleep(2000);
 * 
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Diagnostics']")).click();
 * Thread.sleep(2000);
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Users']")).click();
 * Thread.sleep(2000);
 * 
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Orders']")).click();
 * Thread.sleep(2000);
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Inventory']")).click();
 * Thread.sleep(2000);
 * 
 * driver.findElement(By.xpath("//*[@ng-reflect-label='Tickets]")).click();
 * Thread.sleep(2000);
 */
