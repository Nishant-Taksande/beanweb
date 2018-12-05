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
}