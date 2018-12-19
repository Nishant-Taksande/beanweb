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
	
	
	//secondary email page
	
	public static String tempPassLabel = "xpath://p[text()='Please choose one of your email addresses to recieve temporary password.']";
	public static String primaryEmailButton = "xpath://input[@id='PrimaryEmailCheck']";
	public static String primaryEmailLabel = "xpath://label[@id='PrimaryEmail']";
	public static String secondaryEmailButton = "xpath://input[@id='SecondaryEmailCheck']";
	public static String secondaryEmailLabel = "xpath://label[@id='SecondaryEmail']";
	public static String secSubmitButton = "xpath://button[text()='Submit']";
	
	
	//enter same email id
	public static String sameEmailIdLabel = "xpath://p[text()='Enter the same email address which you have selected earlier.']";
	public static String recoveryMailInput = "xpath://input[@id='RecoveryEmailId']";
	public static String emailSentMess = "xpath://div[@id='DivEmailSent']";
	
	
	
	//Reset password Page
	public static String resetPasswordLabel = "xpath://h2[text()='Reset Password']";
	public static String passwordLabel = "xpath://label[text()='Password']";
	public static String psdInput = "xpath://input[@id='txtNewPassword']";
	public static String ConfirmLabel = "xpath://label[text()='Confirm Password']";
	public static String confirmInput = "xpath://input[@id='txtConfirmNewPassword']";
	public static String submit = "xpath://button[@id='btnChangePassword']";
	
	
	//forgot password page validation
	public static String emailvalidation = "xpath://span[@data-valmsg-for='EmailAddress'][text()='Replace']";
	public static String validation = "xpath://span[text()='Replace']";
	
	//Reset password page validation
	
	public static String passvalidation = "xpath://span[@data-valmsg-for='password'][text()='Replace']";
	public static String cnfPassvalidation = "xpath://span[@data-valmsg-for='ConfirmPassword'][text()='Replace']";
	
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
		AppLibrary.findElement(driver, signInPageLink);

		return new ForgotPasswordPage(driver);
	}
	
	
	public void fillResetPsdForm(String password,String cnfPass) {
		if (!password.equalsIgnoreCase("")) {
		AppLibrary.enterText(driver, psdInput, password);
		}
		if (!cnfPass.equalsIgnoreCase("")) {
		AppLibrary.enterText(driver, confirmInput, cnfPass);
		}
		AppLibrary.clickElement(driver, submit);
		
		
	}
	
	
	public ForgotPasswordPage verifyForgotPassSecMailPageUi(String email) {
		AppLibrary.enterText(driver, emailInput, email);
		AppLibrary.clickElement(driver, submitButton);
		AppLibrary.findElement(driver, tempPassLabel);
		AppLibrary.findElement(driver, primaryEmailButton);
		AppLibrary.findElement(driver, primaryEmailLabel);
		AppLibrary.findElement(driver, secondaryEmailButton);
		AppLibrary.findElement(driver, secondaryEmailLabel);
		AppLibrary.findElement(driver, secSubmitButton);
		AppLibrary.findElement(driver, signInPageLink);
		return new ForgotPasswordPage(driver);
	}
	
	
	public ForgotPasswordPage verifyForgotPassEnterEmailPageUi(String SecMail) {
		AppLibrary.clickElement(driver, secondaryEmailButton);
		AppLibrary.clickElement(driver, secSubmitButton);
		AppLibrary.findElement(driver, forgotLabel);
		AppLibrary.findElement(driver, sameEmailIdLabel);
		AppLibrary.findElement(driver, recoveryMailInput);
		AppLibrary.findElement(driver, secSubmitButton);
		AppLibrary.findElement(driver, signInPageLink);
		AppLibrary.enterText(driver, emailInput, SecMail);
		AppLibrary.clickElement(driver, secSubmitButton);
		AppLibrary.findElement(driver, forgotLabel);
		AppLibrary.findElement(driver, emailSentMess);
		AppLibrary.findElement(driver, signInPageLink);
		return new ForgotPasswordPage(driver);
	}
	
	
}
