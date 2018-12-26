package BeanLoginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import BeanLoginTest.lib.AppLibrary;
import BeanLoginTest.lib.scrollElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class SignUpPage {
//	WebDriver driver;
	AndroidDriver<MobileElement> driver;
	public static String NaviateUpButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
	public static String signUpLabel = "xpath://*[@text ='Sign Up']";
	public static String joinUsLabel = "xpath://*[@text ='Join AS']";
	public static String individualButton = "id:com.anisolutions.BeanLogin:id/iv_individual";
	public static String individualLabel = "xpath://*[@text ='Individual']";
	public static String firstNameLabel = "xpath://*[@text ='First Name']";
	public static String firstnameInput = "xpath://*[@text ='Enter First Name']";
	public static String lastNameLabel = "xpath://*[@text ='Last Name']";
	public static String lastNameInput = "xpath://*[@text ='Enter Last Name']";
	public static String emailLabel = "xpath://*[@text ='Email']";
	public static String emailInput = "xpath://*[@text ='Enter Email Address']";
	public static String passwordLabel = "xpath://*[@text ='Password']";
	public static String psdInput = "id:com.anisolutions.BeanLogin:id/et_pass";
	public static String cnfPassLabel = "xpath://*[@text ='Confirm Password']";
	public static String cnfPassInput = "id:com.anisolutions.BeanLogin:id/et_c_pass";
	public static String miniPassrequirementLabel = "xpath://*[@text ='Minimum Password Requirements']";
	public static String passRules = "id:com.anisolutions.BeanLogin:id/tv_pass_rules2";
	public static String submitButton = "xpath://*[@text ='Submit']";
	public static String listView = "id:android:id/content";
	public static String listView1 = "class:android.widget.FrameLayout";
	
	//After submit
	public static String emailSentMess = "xpath://*[@text ='Validation Email sent!']";
	public static String verifylink = "xpath://*[@text ='Please click on the verify link to complete registration and setup.']";
	public static String OkButton = "xpath://*[@text ='Ok']";

	public SignUpPage(WebDriver driver) {
		super();
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	
	
	public SignUpPage verifySignUpPageUi() {
		AppLibrary.clickElement(driver, LoginPage.signUpButton);
		AppLibrary.findElement(driver, NaviateUpButton);
		AppLibrary.findElement(driver, signUpLabel);
		AppLibrary.findElement(driver, joinUsLabel);
		AppLibrary.findElement(driver, individualButton);
		AppLibrary.findElement(driver, individualLabel);
		AppLibrary.findElement(driver, firstNameLabel);
		AppLibrary.findElement(driver, firstnameInput);
		AppLibrary.findElement(driver, lastNameLabel);
		AppLibrary.findElement(driver, lastNameInput);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);
		AppLibrary.findElement(driver, passwordLabel);
		AppLibrary.findElement(driver, psdInput);
		AppLibrary.findElement(driver, cnfPassLabel);
		AppLibrary.findElement(driver, cnfPassInput);
		AppLibrary.findElement(driver, miniPassrequirementLabel);
		AppLibrary.findElement(driver, passRules);
		scrollElement sc = new scrollElement(driver);
		sc.ScrollToElement(listView1, "Submit");
		AppLibrary.findElement(driver, submitButton);
		
		return new SignUpPage(driver);

	}
	
	
public void fillSignUpForm(String DropDown,String firstName, String lastName, String email, String pass, String confirmPass) throws Exception {

		
		AppLibrary.clickMobileElement(driver, LoginPage.signUpButton);
		if (!firstName.equalsIgnoreCase("")){
		AppLibrary.enterMobileText(driver, firstnameInput, firstName);
		}
		if (!lastName.equalsIgnoreCase("")){
		AppLibrary.enterMobileText(driver, lastNameInput, lastName);
		}
		if (!email.equalsIgnoreCase("")){
		AppLibrary.enterMobileText(driver, emailInput, email);
		}
		if (!pass.equalsIgnoreCase("")){
		AppLibrary.enterMobileText(driver, psdInput, pass);
		}
		if (!confirmPass.equalsIgnoreCase("")){
		AppLibrary.enterMobileText(driver, cnfPassInput, confirmPass);
		}
		scrollElement sc = new scrollElement(driver);
		sc.ScrollToElement(listView1, "Submit");
		
		AppLibrary.clickMobileElement(driver, submitButton);
		
	
	}

}
