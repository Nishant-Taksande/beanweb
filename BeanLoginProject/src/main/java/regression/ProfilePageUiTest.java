package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;
import com.beanlogin.pages.LoginPage;
import com.beanlogin.pages.MailinatorPage;
import com.beanlogin.pages.MyProfilePage;
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class ProfilePageUiTest extends TestBase {

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
	public void testMyProfilePageUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchAppDirectURL("");

		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		String emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);
		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("Join As Individual", firstname, LastName, emailAddress +"@mailinator.com", "Admin123!@#", "Admin123!@#");

		MailinatorPage mp = new MailinatorPage(driver);
		mp.getVerification(emailAddress);

		AppLibrary.clickElement(driver, SignUpPage.returnToSignIn);

		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		
		
		AppLibrary.clickElement(driver, PortalPage.menu);
		AppLibrary.clickElement(driver, PortalPage.myprofileLink);
		new MyProfilePage(driver).verifyPortalpageUi();
		System.out.println("Verified Successfully ");
	}

}
