package com.beanlogin.pages;

import org.openqa.selenium.WebDriver;

import com.beanlogin.lib.AppLibrary;

public class ForgotPasswordPage {

	WebDriver driver;

	public static String forgotLabel = "xpath://h2[text()='Forgot Password ?']";
	public static String forgotText = "xpath://p[text()='Enter your Email Address below to reset your password.']";
	public static String emailLabel = "xpath://label[text()='Email Address']";

	public static String emailInput = "xpath://input[@id='forgotPasswordEmail']";
	public static String submitButton = "xpath://button[@id='btnForgotPassword']";
	public static String signInPageLink = "xpath://a[text()='RETURN TO SIGN IN PAGE']";
	
	
	
	//Reset password Page
	public static String resetPasswordLabel = "xpath://h2[text()='Reset Password']";
	public static String passwordLabel = "xpath://label[text()='Password']";
	public static String psdInput = "xpath://input[@id='txtNewPassword']";
	public static String ConfirmLabel = "xpath://label[text()='Confirm Password']";
	public static String confirmInput = "xpath://input[@id='txtConfirmNewPassword']";
	public static String submit = "xpath://button[@id='btnChangePassword']";
	
	
	//validation
	public static String emailvalidation = "xpath://span[@data-valmsg-for='EmailAddress'][text()='Replace']";
	public static String validation = "xpath://span[text()='Replace']";
	
	public ForgotPasswordPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public ForgotPasswordPage verifyForgotPassPageUi() {
		AppLibrary.clickElement(driver, LoginPage.forgotPassButton);
		AppLibrary.findElement(driver, forgotLabel);
		AppLibrary.findElement(driver, forgotText);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);

		AppLibrary.findElement(driver, submitButton);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, signInPageLink);

		return new ForgotPasswordPage(driver);
	}
	
	
	public void fillResetPsdForm(String password,String cnfPass) {
		if (!emailvalidation.equalsIgnoreCase("")) {
		AppLibrary.enterText(driver, psdInput, password);
		}
		if (!emailvalidation.equalsIgnoreCase("")) {
		AppLibrary.enterText(driver, confirmInput, cnfPass);
		}
		AppLibrary.clickElement(driver, submit);
		
		
	}
	
	
}
