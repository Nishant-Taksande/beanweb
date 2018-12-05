package regression;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;
import com.beanlogin.pages.LoginPage;
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class RegistrationFuctionalityActiveUserTest extends TestBase {

	public Logger logger;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("RegistrationFunctinalityTest");
		System.out.println("RegistrationFunctinalityTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void testRegistrationFunctinality() throws Exception {

		driver = appLibrary.getDriverInstance();
		appLibrary.launchAppDirectURL("");
		String emailAddress = "neoTest" + AppLibrary.randInt();

		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("Join As Individual", emailAddress, "Mishra", emailAddress + "@mailinator.com", "Admin123!@#",
				"Admin123!@#");
		appLibrary.getVerification(emailAddress);
		
		AppLibrary.clickElement(driver, SignUpPage.returnToSignIn);
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		
		AppLibrary.verifyElement(driver, PortalPage.individualUserLabel);
		

	}

}