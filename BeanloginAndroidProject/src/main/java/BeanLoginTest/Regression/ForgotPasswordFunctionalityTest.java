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
import BeanLoginTest.pages.LoginPage;
import BeanLoginTest.pages.MailinatorPage;
import BeanLoginTest.pages.MyAppPage;
import BeanLoginTest.pages.SignUpPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordFunctionalityTest extends TestBase {

	public Logger logger;
	String emailAddress;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("ForgotPassFunctinalityTest");
		System.out.println("ForgotPassFunctinalityTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void registration() throws Exception {

		driver = (AndroidDriver<MobileElement>) appLibrary.getDriverInstance();

		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);
		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("", firstname, LastName, emailAddress + "@mailinator.com", "Admin123!@#", "Admin123!@#");
		AppLibrary.findElement(driver, SignUpPage.emailSentMess);
		AppLibrary.sleep(2000);
		MailinatorPage mp = new MailinatorPage(driver);
		mp.getVerification(emailAddress);
		AppLibrary.syncAndClickMobileElement(driver, SignUpPage.OkButton);
		LoginPage lp = new LoginPage(driver);

		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.sleep(2000);
		AppLibrary.clickMobileElement(driver, MyAppPage.myAppsLabel);
		new MyAppPage(driver).logOut();

	}

	@Test(dependsOnMethods = "registration")
	public void testForgotPassFunctinality() throws Exception {
		// driver = (AndroidDriver<MobileElement>)
		// appLibrary.getDriverInstance();
		AppLibrary.clickMobileElement(driver, LoginPage.forgotPasswordButton);
		AppLibrary.enterMobileText(driver, ForgotPasswordPage.forgotEmail, emailAddress + "@mailinator.com");
		AppLibrary.clickMobileElement(driver, ForgotPasswordPage.submitButton);
		MailinatorPage mp = new MailinatorPage(driver);
		String pass = mp.getPassword(emailAddress);
		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", pass);
		new ForgotPasswordPage(driver).fillResetPsdForm("Pass123!@#", "Pass123!@#");
		
		AppLibrary.verifyMobileElement(driver, MyAppPage.myAppsLabel);
		new MyAppPage(driver).logOut();
		
		//existing pass login
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		AppLibrary.verifyMobileElement(driver, LoginPage.invalidPassMess);
		AppLibrary.clickMobileElement(driver, LoginPage.okButton);
		//new pass login
		lp.signIn(emailAddress + "@mailinator.com", "Pass123!@#");
		new MyAppPage(driver).logOut();
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
