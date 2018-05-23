/**
 * @author Jp
 *
 */
package com.sci.Testmate.util;

import static com.sci.Testmate.Common.Constants.*;


import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.internal.collections.Pair;

import com.relevantcodes.extentreports.ExtentReports;
import com.sci.Testmate.Common.Constants;
import com.sci.Testmate.TestScripts.LaunchTestScript;
import com.sci.Testmate.util.JWebDriver;

public class AppUtil {
	public static int i=0;
	
	
  //==========================================================================
  
  public static String getXMLFilePath(String xmlFileName) {
    StringBuffer xmlFilePath = new StringBuffer(""); 
    xmlFilePath.append(System.getProperty("user.dir"));
    xmlFilePath.append(XML_REPOSITORY);
    xmlFilePath.append(xmlFileName);
    xmlFilePath.append(XML);
    return xmlFilePath.toString();
  }
  
  //==========================================================================
  
  public static String getExcelFilePath(String excelFileName) {
    StringBuffer excelFilePath = new StringBuffer(""); 
    excelFilePath.append(System.getProperty("user.dir"));
    excelFilePath.append(EXCEL_REPOSITORY);
    excelFilePath.append(excelFileName);
    excelFilePath.append(EXCEL);
    return excelFilePath.toString();
  }
  
  //==========================================================================
  
  public static String getScreenShotsRepositoryFilePath(String className, String type) {
    StringBuffer screenShotsRepositoryFilePath = new StringBuffer(""); 
    // Comment the below line for Server configuration
    //screenShotsRepositoryFilePath.append(System.getProperty("user.dir"));
    screenShotsRepositoryFilePath.append(SCREEN_SHOTS_REPOSITORY);
    screenShotsRepositoryFilePath.append(className);
    screenShotsRepositoryFilePath.append(UNDER_SCORE);
    screenShotsRepositoryFilePath.append(type);
    screenShotsRepositoryFilePath.append(UNDER_SCORE);
    screenShotsRepositoryFilePath.append(System.currentTimeMillis());
    screenShotsRepositoryFilePath.append(PNG);
    return screenShotsRepositoryFilePath.toString();
  }
  
  //==========================================================================
  
  //Server Configuration (DevOps Statging server)
  public static String getScreenShotName(String className, String type) {
    StringBuffer screenShotsRepositoryFilePath = new StringBuffer("");
    screenShotsRepositoryFilePath.append(className);
    screenShotsRepositoryFilePath.append(UNDER_SCORE);
    screenShotsRepositoryFilePath.append(type);
    screenShotsRepositoryFilePath.append(UNDER_SCORE);
    screenShotsRepositoryFilePath.append(System.currentTimeMillis());
    screenShotsRepositoryFilePath.append(".jpg");
    return screenShotsRepositoryFilePath.toString();
  }
  
  //==========================================================================
  
  public static String getMethodName(){
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }
  
  //===========================================================================
  
  public static boolean isErrorMessageExist(List<WebElement> errorMessagesList, String messageToCheck) {
    boolean isErrorMessageExist = false;
    
    if(errorMessagesList != null && errorMessagesList.size() > 0) {
      for(WebElement webElement : errorMessagesList) {
        if(messageToCheck.equalsIgnoreCase(webElement.getText())) {
          isErrorMessageExist = true;
          break;
        }
      }
    }
    return isErrorMessageExist;
  }
  
  //===========================================================================
  
  public static boolean isManadatoryFieldExist(List<WebElement> errorMessagesList) {
    boolean isMandatoryFieldExist = false;
    
    if(errorMessagesList != null && errorMessagesList.size() > 0) {
      for(WebElement webElement : errorMessagesList) {
        if(webElement.getText().contains("required")) {
          isMandatoryFieldExist = true;
          break;
        }
      }
    }
    return isMandatoryFieldExist;
  }
  
  
//===========================================================================
//to get the extent report for the test results
public static ExtentReports extentReport(){
	
   ExtentReports ext  = null;
    File fi = new File(System.getProperty("user.dir")+"//ExtResults//TestResults-"+Constants.gettime()+".html");
    if (!fi.exists()) {
    	ext=new ExtentReports(System.getProperty("user.dir")+"//ExtResults//TestResults-"+Constants.gettime()+".html",true);
    	ext.loadConfig(new File(System.getProperty("user.dir")+"//src//extent-config.xml"));
        return ext;
    }else {
        ext=new ExtentReports(System.getProperty("user.dir")+"//ExtResults//TestResults-"+Constants.gettime()+".html",false);      
        ext.loadConfig(new File(System.getProperty("user.dir")+"//src//extent-config.xml"));
        return ext;
    }

}

	// ==========================================================================
// to get the extent report for the test results
public boolean checkLaunchIsSucess() {		
	LaunchTestScript launchTestScript = null;	
	if (!isLaunchSuccess) {
		launchTestScript = new LaunchTestScript();
		launchTestScript.launchbrowser();;
	}
	return isLaunchSuccess;

}

}
