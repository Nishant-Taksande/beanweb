package BeanLoginTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BeanLoginTest.lib.AppLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class ForgotPasswordPage {
	AndroidDriver<MobileElement> driver;
	public static String forgotPasswordLabel = "id:com.anisolutions.BeanLogin:id/tv_forgot_pass";
	public static String resetPassLabel = "xpath://*[@text ='Enter your Email Address below to reset your password.']";
	public static String forgotEmail = "xpath://*[@text ='Email']";
	public static String backButton = "xpath://*[@text ='Back']";
	public static String submitButton = "xpath://*[@text ='Submit']";
	
	public static String resetPasswordLabel = "xpath://*[@text ='Reset Password']";
	public static String newPassInput = "xpath://*[@text ='New Password']";
	public static String cnfPassInput = "xpath://*[@text ='Confirm New Password']";
//	public static String submitButton = "xpath://*[@text ='Submit']";
//	public static String backButton = "xpath://*[@text ='Back']";
	
	
	
	 public ForgotPasswordPage(WebDriver driver) {
		super();
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	 
	 public ForgotPasswordPage verifyForgotPassPageUi() throws Exception {
			AppLibrary.clickMobileElement(driver, LoginPage.forgotPasswordButton);
			AppLibrary.findElementForMobile(driver, forgotPasswordLabel);
			AppLibrary.findElementForMobile(driver, resetPassLabel);
			AppLibrary.findElementForMobile(driver, forgotEmail);
			AppLibrary.findElementForMobile(driver, backButton);
			AppLibrary.findElementForMobile(driver, submitButton);
			return new ForgotPasswordPage(driver);
		}
	 
	 public void fillResetPsdForm(String password,String cnfPass) throws Exception {
			if (!password.equalsIgnoreCase("")) {
			AppLibrary.enterMobileText(driver, newPassInput, password);
			}
			if (!cnfPass.equalsIgnoreCase("")) {
			AppLibrary.enterMobileText(driver, cnfPassInput, cnfPass);
			}
			AppLibrary.clickMobileElement(driver, submitButton);
			
		}
	 
	
}
