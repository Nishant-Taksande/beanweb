package com.beanlogin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.beanlogin.lib.AppLibrary;

public class LoginPage {
	WebDriver driver;

	public static String beanLogin = "xpath://h2[@class='form-login-heading']";
	public static String beanLoginIcon = "xpath://h2//img[contains(@src,'BeanLoginLogo')]";
	public static String emailInput = "xpath://input[@id='Email']";

	public static String passwordInput = "xpath://input[@id='Password']";
	public static String signInButton = "xpath://button[@id='signInButton']";
	public static String signUpButton = "xpath://a[text()='Sign Up']";
	public static String signUpRightIcon = "xpath://i[@class='glyphicon glyphicon-ok-sign']";
	public static String forgotPassButton = "xpath://a[text()='Forgot Password?']";
	public static String forgotLockButton = "xpath://i[@class='glyphicon glyphicon-lock']";
	public static String comboSecureLogo = "xpath://div[@class='col-xs-4']//img[contains(@src,'comodo_secure_seal')]";
	public static String beanLoginLogo = "xpath://h2//img[contains(@src,'BeanLoginLogo')]";

	/// header
	public static String headerComboSecureLogo = "xpath://div[@class='container-fluid']//img[contains(@src,'comodo_secure_seal')]";
	public static String HeadrbeanLoginLogo = "xpath://div[@class='navbar-header']//img[contains(@src,'BeanLoginLogo')]";
	
	
	//Inactive user message
	
	public static String inactiveUser = "xpath://li[text()='Your account is not yet verified. Please verify your account from registered email.']";
	//wrong pass validation message
	
	public static String passValidation = "xpath://li[contains(text(),'For account safety, access will be disabled')]";
	
	public static String validation ="xpath://li[text()='Replace']";
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPage verifyLoginPageUi() {

		AppLibrary.findElement(driver, beanLogin);
		AppLibrary.findElement(driver, beanLoginIcon);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, passwordInput);

		AppLibrary.findElement(driver, signInButton);
		AppLibrary.findElement(driver, signUpButton);
		AppLibrary.findElement(driver, signUpRightIcon);
		AppLibrary.findElement(driver, forgotPassButton);

		AppLibrary.findElement(driver, forgotLockButton);
		AppLibrary.findElement(driver, comboSecureLogo);
		AppLibrary.findElement(driver, beanLoginLogo);
		AppLibrary.findElement(driver, passwordInput);

		AppLibrary.findElement(driver, headerComboSecureLogo);
		AppLibrary.findElement(driver, HeadrbeanLoginLogo);

		return new LoginPage(driver);

	}

	public void signIn(String email, String pass) {
		AppLibrary.enterText(driver, emailInput, email);
		AppLibrary.enterText(driver, passwordInput, pass);
		AppLibrary.clickElement(driver, signInButton);
	}

}
