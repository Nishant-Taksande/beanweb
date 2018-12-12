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
import com.beanlogin.pages.LoginPage;

public class LoginValidationWithInvalidPassword extends TestBase {
	
	public Logger logger;
	String emailAddress;
	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "Login")
	public String[][] getLoginValidationDataFromExcel() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/LoginValidation.xls", 2);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("LoginValidationTest");
		System.out.println("LoginValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		driverw = appLibrary.getDriverInstance();
	}

	@Test(dataProvider = "Login")
	public void testLoginValidationWithInvalidPass(String email, String psd, String validation, String exeIndicator) throws IOException {

		appLibrary.launchAppDirectURL("");
		if (exeIndicator.equalsIgnoreCase("Yes")) {
			if (!email.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.emailInput).sendKeys(email);
			}
			if (!psd.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.passwordInput).sendKeys(psd);
			}
			AppLibrary.clickElement(driverw, LoginPage.signInButton);


			
				AppLibrary.findElement(driverw, LoginPage.validation.replace("Replace",validation));

		}
	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		System.out.println("i do nothing");
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		appLibrary.closeBrowser();
		Reporter.log("Closing the Browser Successfully", true);
		System.out.println("Closing the Browser Successfully");
		Reporter.log("</table>");
	}
}
