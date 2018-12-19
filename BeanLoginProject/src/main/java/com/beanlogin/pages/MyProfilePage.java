package com.beanlogin.pages;

import org.openqa.selenium.WebDriver;

import com.beanlogin.lib.AppLibrary;

public class MyProfilePage {

	WebDriver driver;

	public static String userProfileLabel = "xpath://span[text()='User Profile']";

	public static String basicDetailsLabel = "xpath://h6[text()='Basic Details']";

	public static String titleLabel = "xpath://div[@class='form-group customPadding']//label[text()='Title']";

	public static String titleInput = "xpath://input[@id='Title']";

	public static String firstNameLabel = "xpath://label[text()='First Name']";

	public static String firstNameInput = "xpath://input[@id='txtfirstName']";

	public static String lastNameLabel = "xpath://label[text()='Last Name']";

	public static String lastNameInput = "xpath://input[@id='LastName']";

	public static String emailLabel = "xpath://label[text()='Email Address']";

	public static String emailInput = "xpath://input[@id='txtEmail']";

	public static String secMailLabel = "xpath://label[text()='Secondary Email']";

	public static String secMailInput = "xpath://input[@id='txtSecondaryEmail']";

	public static String secEmailVerified = "xpath://i[@id='secondaryEmailVerified']";

	public static String secEmailNotVerified = "xpath://i[@id='secondaryEmailNotVerified']";

	public static String phoneLabel = "xpath://label[text()='Phone Numnber']";

	public static String phoneInput = "xpath://input[@id='PhoneNumber']";

	public static String addLabel = "xpath://label[text()='Address']";

	public static String addInput = "xpath://input[@id='Address']";

	public static String orgNamLabel = "xpath://label[text()='Organization Name']";

	public static String orgNameInput = "xpath://input[@id='txtOrgName']";

	public static String addInfoLabel = "xpath://h6[text()='Additional Information']";
	
	public static String addInfoTitleLabel = "xpath://div[@class='form-group']//label[text()='Title']";

	public static String addInfoTitleInput = "xpath://input[@id='txt_title']";

	public static String departmentLabel = "xpath://label[text()='Department']";

	public static String departmentInput = "xpath://input[@id='txt_department']";
	
	public static String companyLabel = "xpath://label[text()='CompanyName']";

	public static String companyInput = "xpath://input[@id='txt_companyname']";

	public static String savebasicDetails = "xpath://button[@id='btnUpdate'][contains(text(),'Save')]";

	public static String securityLabel = "xpath://h6[text()='Security']";

	public static String twoFactorLabel = "xpath://span[contains(text(),'Enable Two Factor Authentication')]";

	public static String twoFactorToggle = "xpath://div//label[input[contains(@id,'EnableTwoFactorAuth')]]//span";

	public static String killSwithLabel = "xpath://span[contains(text(),'Kill Switch')]";

	public static String killSwithToggle = "xpath://div//label[input[contains(@id,'DeletePassword')]]//span";

	public static String beanLoginPopupLabel = "xpath://span[contains(text(),'Allow BeanLogin PopUps')]";

	public static String beanLoginPopupToggle = "xpath://div//label[input[contains(@id,'BeanLoginPopup')]]//span";

	public static String passwordGenratorButton = "xpath://a[text()='Password Generator']";

	public static String changePassLabel = "xpath://h6[text()='Change Password']";

	public static String minLabel = "xpath://b[text()='Minimum Requirements']";

	public static String min6CharLabel = "xpath://li[text()='Minimum 6 characters in length.']";

	public static String upperCaseLabel = "xpath://li[text()='1 Uppercase Letter']";

	public static String lowerCaseLabel = "xpath://li[text()='1 Lowercase Letter']";

	public static String numberLabel = "xpath://li[text()='1 Number']";

	public static String symbolLabel = "xpath://li[text()='1 Symbol']";

	public static String currentPassLabel = "xpath://label[text()='Current Password']";

	public static String currentpassInput = "xpath://input[@id='txtCurrentpassword']";

	public static String newPassLabel = "xpath://label[text()='New Password']";

	public static String newPassInput = "xpath://input[@id='txtNewPassword']";

	public static String confirmPassLabel = "xpath://label[text()='Confirm Password']";

	public static String confirmPassInput = "xpath://input[@id='txtConfirmNewPassword']";

	public static String saveChangePass = "xpath://button[@id='btnResetPassword'][contains(text(),'Save')]";

	public static String activeDevicesLabel = "xpath://h6[text()='Active Devices']";
	
	public static String popUp = "xpath://button[@id='btnModalOK']";
	

	public MyProfilePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public PortalPage verifyPortalpageUi() {

		AppLibrary.findElement(driver, userProfileLabel);
		AppLibrary.findElement(driver, basicDetailsLabel);
		AppLibrary.findElement(driver, titleLabel);
		AppLibrary.findElement(driver, titleInput);
		AppLibrary.findElement(driver, firstNameLabel);
		AppLibrary.findElement(driver, firstNameInput);
		AppLibrary.findElement(driver, lastNameLabel);
		AppLibrary.findElement(driver, lastNameInput);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, secMailLabel);
		AppLibrary.findElement(driver, secMailInput);
		AppLibrary.findElement(driver, phoneLabel);
		AppLibrary.findElement(driver, phoneInput);
		AppLibrary.findElement(driver, addLabel);
		AppLibrary.findElement(driver, addInput);
		AppLibrary.findElement(driver, orgNamLabel);
		AppLibrary.findElement(driver, orgNameInput);
		AppLibrary.findElement(driver, addInfoLabel);
		AppLibrary.findElement(driver, addInfoTitleLabel);
		AppLibrary.findElement(driver, addInfoTitleInput);
		AppLibrary.findElement(driver, departmentLabel);
		AppLibrary.findElement(driver, departmentInput);
		AppLibrary.findElement(driver, companyLabel);
		AppLibrary.findElement(driver, companyInput);
		AppLibrary.findElement(driver, savebasicDetails);
		AppLibrary.findElement(driver, securityLabel);
		AppLibrary.findElement(driver, twoFactorLabel);
		AppLibrary.findElement(driver, twoFactorToggle);
		AppLibrary.findElement(driver, killSwithLabel);
		AppLibrary.findElement(driver, killSwithToggle);
		AppLibrary.findElement(driver, beanLoginPopupLabel);
		AppLibrary.findElement(driver, beanLoginPopupToggle);
		AppLibrary.findElement(driver, passwordGenratorButton);
		AppLibrary.findElement(driver, changePassLabel);
		AppLibrary.findElement(driver, minLabel);
		AppLibrary.findElement(driver, min6CharLabel);
		AppLibrary.findElement(driver, upperCaseLabel);
		AppLibrary.findElement(driver, lowerCaseLabel);
		AppLibrary.findElement(driver, numberLabel);
		AppLibrary.findElement(driver, symbolLabel);
		AppLibrary.findElement(driver, currentPassLabel);
		AppLibrary.findElement(driver, currentpassInput);
		AppLibrary.findElement(driver, newPassLabel);
		AppLibrary.findElement(driver, newPassInput);
		AppLibrary.findElement(driver, confirmPassLabel);
		AppLibrary.findElement(driver, confirmPassInput);
		AppLibrary.findElement(driver, saveChangePass);
		AppLibrary.findElement(driver, activeDevicesLabel);
		return new PortalPage(driver);

	}

	public void verifyPortalEmail(String email, String firstName, String lastName) {
		AppLibrary.clickElement(driver, PortalPage.menu);
		AppLibrary.clickElement(driver, PortalPage.myprofileLink);
		AppLibrary.verificationEmail(driver, emailInput, email);
		AppLibrary.verificationEmail(driver, firstNameInput, firstName);
		AppLibrary.verificationEmail(driver, lastNameInput, lastName);
	}
	
	public void clickOnMyProfileButton() {
		AppLibrary.clickElement(driver, PortalPage.menu);
		AppLibrary.clickElement(driver, PortalPage.myprofileLink);
	}

	// public void fillMyProfileForm(String title, String firstName, String
	// lastName) {
	//
	// AppLibrary.verificationEmail(driver, emailInput, title);
	// AppLibrary.verificationEmail(driver, firstNameInput, firstName);
	// AppLibrary.verificationEmail(driver, lastNameInput, lastName);
	// }

}
