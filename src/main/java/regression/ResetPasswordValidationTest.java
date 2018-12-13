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
import com.beanlogin.pages.MailinatorPage;
import com.beanlogin.pages.PortalPage;
import com.beanlogin.pages.SignUpPage;

public class ResetPasswordValidationTest extends TestBase {

	public Logger logger;
	String emailAddress;
	String pass;
	private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "passValidation")
	public String[][] getRegistrationDataFromExcelOne() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/forgotpasswordvalidation.xls", 1);
		return str;
	}

	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary();
		logger = Logger.getLogger("ResetPassValidationTest");
		System.out.println("ResetPassValidationTestStarted");
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
		AppLibrary.clickElement(driverw, LoginPage.forgotPassButton);

		AppLibrary.enterText(driverw, ForgotPasswordPage.emailInput, emailAddress + "@mailinator.com");
		AppLibrary.clickElement(driverw, ForgotPasswordPage.submitButton);

		 pass = mp.getPassword(emailAddress);
		 appLibrary.launchAppDirectURL("");
		 lp.signIn(emailAddress + "@mailinator.com", pass);
	}
	
	@Test(dataProvider = "passValidation", dependsOnMethods = "registration")
	public void testLoginValidationWithPostiveEmail(String Pass, String CnfPass, String PassValidation, String CnfPassValidation,
			String exeIndicator)
			throws IOException {
		if (exeIndicator.equalsIgnoreCase("Yes")) {
//			 appLibrary.launchAppDirectURL("");
			driverw.navigate().refresh();
			LoginPage lp = new LoginPage(driverw);
//			lp.signIn(emailAddress + "@mailinator.com", pass);

			ForgotPasswordPage fp = new ForgotPasswordPage(driverw);

			fp.fillResetPsdForm(Pass, CnfPass);

			// pass validation
			if (!PassValidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, ForgotPasswordPage.passvalidation.replace("Replace", PassValidation));
			}

			if (!CnfPassValidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driverw, ForgotPasswordPage.cnfPassvalidation.replace("Replace", CnfPassValidation));
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
		if (driverw != null)
			driverw.quit();

		Reporter.log("Closing the Browser Successfully", true);
		System.out.println("Closing the Browser Successfully");
		Reporter.log("</table>");
	}

}
