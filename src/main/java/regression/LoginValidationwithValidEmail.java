package regression;

import java.io.IOException;
import java.net.MalformedURLException;

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
import com.beanlogin.pages.MailinatorPage;
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class LoginValidationwithValidEmail extends TestBase {

	public Logger logger;
	String emailAddress;
	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "LoginWithPositiveEmail")
	public String[][] getLoginValidationDataFromExceltwo() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/LoginValidation.xls", 1);
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

	@Test
	public void registration() throws Exception {
		appLibrary.launchAppDirectURL("");
		emailAddress = "neoTest" + AppLibrary.getDate() + AppLibrary.randIntDigits(0, 99);
		System.out.println(emailAddress);
		SignUpPage su = new SignUpPage(driverw);
		su.fillSignUpForm("Join As Individual", emailAddress, "Mishra", emailAddress + "@mailinator.com", "Admin123!@#",
				"Admin123!@#");
		MailinatorPage mp = new MailinatorPage(driverw);
		mp.getVerification(emailAddress);
		AppLibrary.clickElement(driverw, SignUpPage.returnToSignIn);
		LoginPage lp = new LoginPage(driverw);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		PortalPage pp = new PortalPage(driverw);
		pp.logout();
	}

	@Test(dataProvider = "LoginWithPositiveEmail", dependsOnMethods = "registration")
	public void testLoginValidationWithPostiveEmail(String psd, String Validation, String exeIndicator)
			throws IOException {
		if (exeIndicator.equalsIgnoreCase("Yes")) {
			appLibrary.launchAppDirectURL("");

			AppLibrary.findElement(driverw, LoginPage.emailInput).sendKeys(emailAddress + "@mailinator.com");
			if (!psd.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, LoginPage.passwordInput).sendKeys(psd);
			}
			AppLibrary.clickElement(driverw, LoginPage.signInButton);

			AppLibrary.findElement(driverw, LoginPage.validation.replace("Replace", Validation));

		}
	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		System.out.println("im doing nothing");
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
