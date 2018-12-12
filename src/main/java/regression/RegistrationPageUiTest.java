package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;
import com.beanlogin.pages.SignUpPage;

public class RegistrationPageUiTest extends TestBase {

	public Logger logger;

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("SignUpPageUiTest");
		System.out.println("SignUpUiTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void testRegistrationUi() throws Exception {
		driver = appLibrary.getDriverInstance();
		appLibrary.launchAppDirectURL("");
		new SignUpPage(driver).verifySignupPageUi();
		System.out.println("Verified Successfully ");

	}

}
