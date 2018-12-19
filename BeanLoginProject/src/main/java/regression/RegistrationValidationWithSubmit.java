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
import com.beanlogin.pages.SignUpPage;



public class RegistrationValidationWithSubmit extends TestBase {

	public Logger logger;
	// private WebDriver driverw;
	private AppLibrary appLibrary;

	@DataProvider(name = "RegistrationWithSubmit")
	public String[][] getRegistrationDataFromExcelOne() throws Exception {

		String str[][] = AppLibrary.readExcel("TestData/registrationPageValidation.xls", 0);
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
		driver = appLibrary.getDriverInstance();
	}

	

	@Test(dataProvider = "RegistrationWithSubmit")
	public void testRegistrationValidationWithSubmitButton(String firstName, String lastName, String email, String psd,
			String CnfPass, String firstNameValidation,String lastNameValidation, String emailvalidation, String psdvalidation,
			String cnfPassValidation, String exeIndicator) throws IOException {

//		appLibrary.launchApp("registration");
		appLibrary.launchAppDirectURL("");
		if (exeIndicator.equalsIgnoreCase("Yes")) {
			SignUpPage sp =new SignUpPage(driver);
			
   			sp.fillSignUpForm("Join As Individual",firstName , lastName, email, psd, CnfPass);

			if (!firstNameValidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driver, SignUpPage.firstNamevalidation.replace("Replace", firstNameValidation));
				
			}

			if (!lastNameValidation.equalsIgnoreCase("")) {
				AppLibrary.findElement(driver, SignUpPage.lastNamevalidation.replace("Replace", lastNameValidation));
			}

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
