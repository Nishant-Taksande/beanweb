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
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class RegistrationFunctionalityInactiveUserTest extends TestBase {

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
	public void testRegistrationInactiveFunctinality() throws Exception {

		driver = appLibrary.getDriverInstance();
		appLibrary.launchAppDirectURL("");
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		String emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);
		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("Join As Individual", firstname, LastName, emailAddress +"@mailinator.com", "Admin123!@#", "Admin123!@#");

		
		AppLibrary.clickElement(driver, SignUpPage.returnToSignIn);
		
		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");
		
		AppLibrary.verifyElement(driver, LoginPage.inactiveUser);
		
		AppLibrary.verifyAbsent(driver, PortalPage.individualUserLabel);
		

	}
	
	
	
	
	
	

}
