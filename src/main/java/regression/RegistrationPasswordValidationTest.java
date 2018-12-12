package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
import com.beanlogin.pages.SignUpPage;

public class RegistrationPasswordValidationTest extends TestBase {

	public Logger logger;
	// private WebDriver driverw;
	// private AppLibrary appLibrary;
	String screenshotName;

	@DataProvider(name = "RegistrationWithoutSubmit")
	public String[][] getRegistrationDataFromExcel() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/registrationPageValidation.xls", 1);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("RegistrationValidationTest");
		System.out.println("RegistrationValidationTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		// appLibrary = new
		// AppLibrary("testRegistrationValidationWithoutContinue");
		driver = appLibrary.getDriverInstance();
	}

	@Test(dataProvider = "RegistrationWithoutSubmit")
	public void testRegistrationValidationWithoutContinue(String email, String psd, String cnfPass,
			String emailvalidation, String psdvalidation, String cnfPassValidation, String exeIndicator)
			throws IOException {

		appLibrary.launchAppDirectURL("");

		if (exeIndicator.equalsIgnoreCase("Yes")) {

			AppLibrary.clickElement(driver, LoginPage.signUpButton);

			AppLibrary.enterTextForValidation(driver, SignUpPage.emailInput, email);

			AppLibrary.enterTextForValidation(driver, SignUpPage.pswordInput, psd);

			AppLibrary.enterTextForValidation(driver, SignUpPage.confirmPswordInput, cnfPass);
			
			AppLibrary.enterTextForValidation(driver, SignUpPage.pswordInput, "Tab");

			// Verify validation
			
		
			if (!emailvalidation.equalsIgnoreCase("")) {
			AppLibrary.findElement(driver, SignUpPage.emailvalidation.replace("Replace", emailvalidation));
			}

			if (!psdvalidation.equalsIgnoreCase("")) {
			AppLibrary.findElement(driver, SignUpPage.passvalidation.replace("Replace", psdvalidation));
			}
			if (!cnfPassValidation.equalsIgnoreCase("")) {
			AppLibrary.findElement(driver, SignUpPage.cnfPassvalidation.replace("Replace", cnfPassValidation));
			}

		}
	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
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
