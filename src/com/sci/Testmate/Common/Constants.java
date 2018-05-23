package com.sci.Testmate.Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Constants {
  public static String APPLICATION_URL = "application.url";
  
  public static String SMTP_AUTH_USER = null;
  public static String SMTP_AUTH_PWD = null;
  public static String COMMA = ",";
  public static String UNDER_SCORE = "_";
  
  public static boolean isLaunchSuccess = false;
  
  public static final String XML_REPOSITORY = "/xml_repository/";
  public static final String XML = ".xml";
  
  public static final String EXCEL_REPOSITORY = "/excel-data-repository/";
  public static final String EXCEL = ".xls";
  
  //Local Machine Configuration
  public static final String SCREEN_SHOTS_REPOSITORY = System.getProperty("user.dir")+"/screen_shots_repository/";
  
  //Server Configuration (DevOps Statging server)
  //public static final String SCREEN_SHOTS_REPOSITORY = "\\\\192.168.80.12\\testmaterepos\\";
  //public static final String SCREEN_SHOTS_LOCATION = "/usr/local/tomcat7/webapps/testmate_app_data/screen_shots_repository/";
  
  //public static final String SCREEN_SHOTS_REPOSITORY = "\\\\72.52.144.19\\testmatrepos\\";
  public static final String SCREEN_SHOTS_LOCATION = "/usr/local/apache-tomcat-7.0.42/webapps/testmate_app_data/screen_shots_repository/";
  
  public static final String PNG = ".png";
  public static final String PAGE_ELEMENT = "page-element";
  public static final String SUB_ELEMENT = "sub-element";
  public static final String CATEGORY = "category";
  public static final String CATEGORY_NORMAL = "normal";
  public static final String CATEGORY_PARALLEL = "parallel";
  public static final String CATEGORY_INNER = "inner";
  
  public static final String NO = "no";
  public static final String TYPE = "type";
  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String CLASS_NAME = "className";
  public static final String CSS_SELECTOR = "cssSelector";
  public static final String XPATH = "xPath";
  public static final String LINK_TEXT = "linkText";
  public static final String DATA = "data";
  
  public static final String TEXT_BOX = "text_box";
  public static final String TEXT_AREA = "text_area";
  public static final String RADIO_BUTTON = "radio_button";
  public static final String CHECK_BOX = "check_box";
  public static final String DROP_DOWN = "drop_down";
  public static final String HYPER_LINK = "hyper_link";
  public static final String BUTTON = "button";
  public static final String DATE_PICKER = "date_picker";
  public static final String FILE_BROWSE = "file_browse";
  public static final String TIME_PICKER = "time_picker";
  public static final String DIV = "div";
  
  public static boolean IS_BROWSER_INSTANTIATED = false;
  
  public static final String ERROR = "Error";
  public static final String INFO = "Info";
  public static final String DEBUG = "Debug";
  
  public static final String FAIL = "0";
  public static final String PASS = "1";
  
  public static final String TEST_SUITE_NAME = "<test_suite_name>";
  public static final String DATE_TIME = "<date_time>";
  public static final String TOTAL_NO_OF_TEST_CASES_RUN = "<tntcr>";
  public static final String TOTAL_NO_OF_TEST_CASES_PASSED = "<tntcp>";
  public static final String TOTAL_NO_OF_TEST_CASES_FAILED = "<tntcf>";
  
  public static final String TEST_REPORT_MAIL_TEMPLATE_PROPS_FILE = "test-report-mail-template";
  public static final String TEST_REPORT_MAIL_RECIPIENTS = "test.report.mail.recipients";
  public static final String TEST_REPORT_MAIL_SUBJECT = "test.report.mail.subject";
  public static final String TEST_REPORT_MAIL_MESSAGE_CONTENT = "test.report.mail.message";
  
  public static String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
  public static String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//Saving the Results with the Execution Time and Date
  
 static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
 static Date date = new Date();
 public static final String time = dateFormat.format(date);
 
 public static boolean isExcutingFromTestSuite = false; 
 public static ExtentTest parentTestReport;
 public static ExtentReports ext;
 public static boolean isExecuteSmokeTest = false;
 
 
 
 
 
 
 
 
 
 
 
 public static String gettime(){
	 if (isExecuteSmokeTest) {
		 return "Smoke"+time;
	}
    return time;
 
 }
}