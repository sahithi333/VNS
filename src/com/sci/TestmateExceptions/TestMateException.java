/**
 * @author Jp
 *
 */
package com.sci.TestmateExceptions;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.sci.Testmate.Common.Constants.ERROR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sci.Testmate.Screenshots.ScreenShotManager;
import com.sci.Testmate.util.JWebDriver;

public class TestMateException extends Throwable {
	protected transient final Log log = LogFactory.getLog(getClass());
	private static final long serialVersionUID = 2957585198043190934L;
	@SuppressWarnings("rawtypes")
	private Set m_Descriptions = new HashSet(5);
	private Exception m_Exception;

	// ==========================================================================

	public TestMateException() {
		super();
	}

	// ==========================================================================

	public TestMateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	// ==========================================================================

	public TestMateException(Throwable arg0) {
		super(arg0);
	}

	// ==========================================================================

	public TestMateException(PrintWriter out, Throwable exp) {
		exp.printStackTrace(out);
	}

	// ==========================================================================

	@SuppressWarnings("unchecked")
	public void addDescription(String description) {
		m_Descriptions.add(description);
	}

	// ==========================================================================

	@SuppressWarnings("unchecked")
	public String[] getDescriptions() {
		String[] desc = new String[m_Descriptions.size()];
		return (String[]) m_Descriptions.toArray(desc);
	}

	// ==========================================================================

	@SuppressWarnings("rawtypes")
	public Iterator iterator() {
		return m_Descriptions.iterator();
	}

	// ==========================================================================

	public TestMateException setException(Exception ex) {
		m_Exception = ex;
		return this;
	}

	// ==========================================================================

	public boolean hasException() {
		return (m_Exception != null);
	}

	// ==========================================================================

	public String getExceptionTrace() {
		if (hasException()) {
			StringWriter trace = new StringWriter();
			m_Exception.printStackTrace(new PrintWriter(trace));
			return trace.toString();
		} else {
			return "";
		}
	}

	// ==========================================================================

	public Exception getException() {
		return m_Exception;
	}

	// ==========================================================================

	public void handleException(Throwable e, String customMessage, String methodName, ExtentTest extTest) {

		log.error("PROBLEM in the method " + methodName);
		extTest.log(LogStatus.INFO, e.getMessage());
		// Local Machine Configuration
		String screenShotLocation = ScreenShotManager.getInstance().saveScreenShot(methodName, ERROR);

		extTest.log(LogStatus.INFO, extTest.addScreenCapture(screenShotLocation));
		e.printStackTrace();
		WebDriver driver = JWebDriver.getInstance().getWebDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
/*		if (driver.findElements(By.cssSelector(".sweet-alert.showSweetAlert.visible>h2")).size() != 0) {
			if (driver.findElement(By.cssSelector(".confirm")).isDisplayed()) {
				driver.findElement(By.cssSelector(".confirm")).click();
			}
		}
*/		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// ==========================================================================
	
	
	public void handleMAnualException(String customMessage, String methodName, ExtentTest extTest) {

		log.error("PROBLEM in the method " + methodName);
		extTest.log(LogStatus.INFO, getMessage());
		// Local Machine Configuration
		String screenShotLocation = ScreenShotManager.getInstance().saveScreenShot(methodName, ERROR);

		extTest.log(LogStatus.INFO, extTest.addScreenCapture(screenShotLocation));
		WebDriver driver = JWebDriver.getInstance().getWebDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	
	
	
	
	
	
}
