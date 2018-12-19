package BeanLoginTest.Regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BeanLoginTest.lib.AppLibrary;
import BeanLoginTest.lib.TestBase;
import BeanLoginTest.pages.ForgotPasswordPage;

public class ForgotPasswordUiTest extends TestBase {

	public Logger logger;

	 @BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("LoginPageUiTest");
		System.out.println("LoginUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void testForgotPassUi() throws Exception {
		driver = appLibrary.getDriverInstance();
	
	System.out.println(driver.toString());
	new ForgotPasswordPage(driver).verifyForgotPassPageUi();
		System.out.println("Verified Successfully ");
	}
	
	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result){
		System.out.println("im doing nothign");
	}
	
	@Override
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		if (driver != null)
			driver.quit();
		
		Reporter.log("Closing the Browser Successfully", true);
		System.out.println("Closing the Browser Successfully");
		Reporter.log("</table>");
	}

}
