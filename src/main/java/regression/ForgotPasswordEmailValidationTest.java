package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;
import com.beanlogin.pages.ForgotPasswordPage;
import com.beanlogin.pages.LoginPage;
import com.beanlogin.pages.SignUpPage;



public class ForgotPasswordEmailValidationTest extends TestBase {

	public Logger logger;
//	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "EmailValidation")
	public String[][] getLoginValidationDataFromExcel() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/forgotpasswordvalidation.xls", 0);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("forgotPasswordEmailValidationTest");
		System.out.println("forgotPasswordEmailValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		driver = appLibrary.getDriverInstance();
	}

	@Test(dataProvider = "EmailValidation")
	public void testpasswordvalidation(String email, String emailValidation, String exeIndicator) throws IOException {
		if (exeIndicator.equalsIgnoreCase("Yes")) {
			appLibrary.launchAppDirectURL("");
			AppLibrary.clickElement(driver, LoginPage.forgotPassButton);
			if (!email.equalsIgnoreCase("")) {
			AppLibrary.enterText(driver, ForgotPasswordPage.emailInput, email);
			}
			AppLibrary.clickElement(driver, ForgotPasswordPage.submitButton);
			
			AppLibrary.findElement(driver, ForgotPasswordPage.validation.replace("Replace", emailValidation));

		}

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
