/**
 * @author Jp
 *
 */
package com.sci.Testmate.util;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JWebDriver {
  private static JWebDriver jWebDriver = null;
  WebDriver driver = null;
  ResourceBundle resourceBundle = null;
  
  //==========================================================================
  
  private JWebDriver() {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\IEDriver\\chromedriver.exe");
    driver = new ChromeDriver();
   driver.get("http://localhost:4200");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  //==========================================================================
  
  public static synchronized JWebDriver getInstance() {
    if(jWebDriver == null) {
      jWebDriver = new JWebDriver();
    } 
    return jWebDriver;
  }
  
  //==========================================================================
  
  public WebDriver getWebDriver() {
    return driver;
  }

  //==========================================================================
}
