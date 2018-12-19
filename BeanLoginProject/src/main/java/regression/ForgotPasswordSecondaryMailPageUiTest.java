package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;
import com.beanlogin.pages.ForgotPasswordPage;
import com.beanlogin.pages.LoginPage;
import com.beanlogin.pages.MailinatorPage;
import com.beanlogin.pages.MyProfilePage;
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class ForgotPasswordSecondaryMailPageUiTest extends TestBase {

	public Logger logger;
	String emailAddress;
	String secEmailAddress;

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("ForgotPassPageUiTest");
		System.out.println("ForgotPassUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
		driver = appLibrary.getDriverInstance();
	}

	@Test
	public void registration() throws Exception {
		appLibrary.launchAppDirectURL("");
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);
		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("Join As Individual", firstname, LastName, emailAddress + "@mailinator.com", "Admin123!@#",
				"Admin123!@#");

		MailinatorPage mp = new MailinatorPage(driver);
		mp.getVerification(emailAddress);

		AppLibrary.clickElement(driver, SignUpPage.returnToSignIn);

		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		PortalPage pp = new PortalPage(driver);

		secEmailAddress = "Nick" + unique;
		System.out.println(emailAddress);
		new MyProfilePage(driver).clickOnMyProfileButton();
		AppLibrary.enterText(driver, MyProfilePage.secMailInput, secEmailAddress + "@mailinator.com");
		AppLibrary.syncAndClick(driver, MyProfilePage.popUp);
		AppLibrary.clickElement(driver, MyProfilePage.titleLabel);
		AppLibrary.syncAndClick(driver, MyProfilePage.savebasicDetails);
		// Email Not Verified
		AppLibrary.findElement(driver, MyProfilePage.secEmailNotVerified);
		// Verify secondary email
		mp.getVerification(secEmailAddress);

		// Refresh browser
		driver.navigate().refresh();
		// Verified Email
		AppLibrary.findElement(driver, MyProfilePage.secEmailVerified);
		pp.logout();

	}

	@Test(dependsOnMethods = "registration")
	public void testForgotPassUi() throws Exception {
		appLibrary.launchAppDirectURL("");
		new ForgotPasswordPage(driver).verifyForgotPassPageUi().verifyForgotPassSecMailPageUi(emailAddress+ "@mailinator.com")
				.verifyForgotPassEnterEmailPageUi(secEmailAddress+ "@mailinator.com");
		System.out.println("Verified Successfully ");
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
