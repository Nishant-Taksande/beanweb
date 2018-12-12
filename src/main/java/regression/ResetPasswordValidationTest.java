package regression;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
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
		driver = appLibrary.getDriverInstance();
	}

	@Test(dataProvider = "passValidation")
	public void testResetPassValidation(String Pass, String CnfPass,String PassValidation,String CnfPassValidation,String exeIndicator) throws Exception {

		
		appLibrary.launchAppDirectURL("");
		String emailAddress = "neoTest" + AppLibrary.getDate() + AppLibrary.randIntDigits(0, 99);
		SignUpPage su = new SignUpPage(driver);

		su.fillSignUpForm("Join As Individual", emailAddress, "Mishra", emailAddress + "@mailinator.com", "Admin123!@#",
				"Admin123!@#");
		
		MailinatorPage mp =new MailinatorPage(driver);
		mp.getVerification(emailAddress);

		AppLibrary.clickElement(driver, SignUpPage.returnToSignIn);

		LoginPage lp = new LoginPage(driver);
		lp.signIn(emailAddress + "@mailinator.com", "Admin123!@#");

		AppLibrary.verifyElement(driver, PortalPage.individualUserLabel);
		PortalPage pp = new PortalPage(driver);
		pp.logout();

		AppLibrary.clickElement(driver, LoginPage.forgotPassButton);

		AppLibrary.enterText(driver, ForgotPasswordPage.emailInput, emailAddress + "@mailinator.com");
		AppLibrary.clickElement(driver, ForgotPasswordPage.submitButton);

		String pass = mp.getPassword(emailAddress);;
		
		AppLibrary.clickElement(driver, SignUpPage.forgotReturnSignIn);

		lp.signIn(emailAddress + "@mailinator.com", pass);

		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		
		fp.fillResetPsdForm(pass,CnfPass);
		
		//pass validation
//		if (!emailvalidation.equalsIgnoreCase("")) {
//			AppLibrary.findElement(driver, SignUpPage.emailvalidation.replace("Replace", emailvalidation));
//		}
//		
//		if (!emailvalidation.equalsIgnoreCase("")) {
//			AppLibrary.findElement(driver, SignUpPage.emailvalidation.replace("Replace", emailvalidation));
//		}
//		
		
		
	}
	
}
