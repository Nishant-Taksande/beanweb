package com.beanlogin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.beanlogin.lib.AppLibrary;

public class SignUpPage {

	WebDriver driver;

	public static String signUpLabel = "xpath://h2[text()='Sign Up']";

	// Join As Individual,Join As Organization
	public static String dropDownSelection = "xpath://select[@id='drpUserSelection']";

	public static String firstNameLabel = "xpath://label[contains(text(),'First Name')]";

	public static String firstnameInput = "xpath://input[@id='txtfirstName']";
	public static String lastnameLabel = "xpath://label[contains(text(),'Last Name')]";
	public static String lastNameInput = "xpath://input[@id='txtLastName']";

	public static String emailLabel = "xpath://label[contains(text(),'Email')]";
	public static String emailInput = "xpath://input[@id='txtEmail']";

	public static String passwordLabel = "xpath://label[text()='Password']";
	public static String pswordInput = "xpath://input[@id='txtPassword']";

	public static String confirmPasswordLabel = "xpath://label[text()='Confirm Password']";
	public static String confirmPswordInput = "xpath://input[@id='txtConfirmPassword']";

	public static String submitButton = "xpath://button[@id='IndividualSubmit']";
	public static String alreadyRegsiteredLabel = "xpath://p[contains(text(),'Already registered?')]";

	public static String singInOk = "xpath://i[@class='glyphicon glyphicon-ok-sign']";
	public static String signInLink = "xpath://a[text()='Sign In']";
	
	
	public static String returnToSignIn ="xpath://a[text()='Return To Sign In page']";

	public SignUpPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public SignUpPage verifySignupPageUi() {
		AppLibrary.clickElement(driver, LoginPage.signUpButton);
		AppLibrary.findElement(driver, signUpLabel);
		AppLibrary.findElement(driver, firstNameLabel);
		AppLibrary.findElement(driver, firstnameInput);
		AppLibrary.findElement(driver, lastnameLabel);

		AppLibrary.findElement(driver, lastNameInput);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, passwordLabel);

		AppLibrary.findElement(driver, pswordInput);
		AppLibrary.findElement(driver, confirmPasswordLabel);
		AppLibrary.findElement(driver, confirmPswordInput);
		AppLibrary.findElement(driver, submitButton);

		AppLibrary.findElement(driver, alreadyRegsiteredLabel);
		AppLibrary.findElement(driver, singInOk);
		AppLibrary.findElement(driver, signInLink);

		return new SignUpPage(driver);

	}

	public void fillSignUpForm(String DropDown,String firstName, String lastName, String email, String pass, String confirmPass) {

		
		AppLibrary.clickElement(driver, LoginPage.signUpButton);
		WebElement element = AppLibrary.findElement(driver, dropDownSelection);
		AppLibrary.selectElement(element, DropDown);

		AppLibrary.enterText(driver, firstnameInput, firstName);
		AppLibrary.enterText(driver, lastNameInput, lastName);
		AppLibrary.enterText(driver, emailInput, email);
		AppLibrary.enterText(driver, pswordInput, pass);
		AppLibrary.enterText(driver, confirmPswordInput, confirmPass);
		AppLibrary.clickElement(driver, submitButton);
		
		//For using function
//		SignUpPage su = new SignUpPage(driver);
//
//		su.fillSignUpForm("Join As Organization", "lokesh", "Mishra", "lokesh@mailinator.com", "Admin123!@#",
//				"Admin123!@#");

	}

}
