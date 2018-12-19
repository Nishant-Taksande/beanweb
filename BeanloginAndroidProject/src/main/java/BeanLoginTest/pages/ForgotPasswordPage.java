package BeanLoginTest.pages;

import org.openqa.selenium.WebDriver;

import BeanLoginTest.lib.AppLibrary;


public class ForgotPasswordPage {
	WebDriver driver;
	public static String forgotPasswordLabel = "id:com.anisolutions.BeanLogin:id/tv_forgot_pass";
	public static String resetPassLabel = "xpath://*[@text ='Enter your Email Address below to reset your password.']";
	public static String forgotEmail = "xpath://*[@text ='Email']";
	public static String backButton = "xpath://*[@text ='Back']";
	public static String submitButton = "xpath://*[@text ='Submit']";
	
	
	 public ForgotPasswordPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	 
	 public ForgotPasswordPage verifyForgotPassPageUi() {
			AppLibrary.clickElement(driver, LoginPage.forgotPasswordButton);
			AppLibrary.findElement(driver, forgotPasswordLabel);
			AppLibrary.findElement(driver, resetPassLabel);
			AppLibrary.findElement(driver, forgotEmail);
			AppLibrary.findElement(driver, backButton);
			AppLibrary.findElement(driver, submitButton);
			return new ForgotPasswordPage(driver);
		}
	 
	
}
