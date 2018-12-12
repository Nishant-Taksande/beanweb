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
	//forgot pass return sign in page
	public static String forgotReturnSignIn="xpath://a[text()='RETURN TO SIGN IN PAGE']";
	
	//validation
	public static String validation="xpath://span[text()='Replace']";
	public static String firstNamevalidation="xpath://span[@for='txtfirstName'][text()='Replace']";
	public static String lastNamevalidation="xpath://span[@for='txtLastName'][text()='Replace']";
	public static String emailvalidation="xpath://span[@for='txtEmail'][text()='Replace']";
	public static String passvalidation="xpath://span[@for='txtPassword'][text()='Replace']";
	public static String cnfPassvalidation="xpath://span[@for='txtConfirmPassword'][text()='Replace']";
	
	//Exiting user validation
	public static String alreadyRegisteredvalidation="xpath://div[contains(text(),'Error Registering User. User already registered.')]";
	
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
		if (!firstName.equalsIgnoreCase("")){
		AppLibrary.enterText(driver, firstnameInput, firstName);
		}
		if (!lastName.equalsIgnoreCase("")){
		AppLibrary.enterText(driver, lastNameInput, lastName);
		}
		if (!email.equalsIgnoreCase("")){
		AppLibrary.enterText(driver, emailInput, email);
		}
		if (!pass.equalsIgnoreCase("")){
		AppLibrary.enterText(driver, pswordInput, pass);
		}
		if (!confirmPass.equalsIgnoreCase("")){
		AppLibrary.enterText(driver, confirmPswordInput, confirmPass);
		}
		AppLibrary.clickElement(driver, submitButton);
		
	
	}

}
