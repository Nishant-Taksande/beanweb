package BeanLoginTest.pages;
import org.openqa.selenium.interactions.touch.TouchActions;

import BeanLoginTest.lib.AppLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	AndroidDriver<MobileElement> driver;

	public static String beanLoginLogo = "id:com.anisolutions.BeanLogin:id/iv_logo_login";
	public static String emailLabel = "id:com.anisolutions.BeanLogin:id/tv_email";
	public static String emailInput = "id:com.anisolutions.BeanLogin:id/et_email";
	public static String passwordLabel = "id:com.anisolutions.BeanLogin:id/tv_pass";
	public static String passwordInput = "id:com.anisolutions.BeanLogin:id/et_pass";

	public static String loginButton = "id:com.anisolutions.BeanLogin:id/btn_login";
	public static String forgotPasswordButton = "id:com.anisolutions.BeanLogin:id/tv_forgot_pass";
	public static String signUpButton = "id:com.anisolutions.BeanLogin:id/tv_sign_up";


	//
	public static String invalidPassMess = "id:com.anisolutions.BeanLogin:id/tv_message";
	public static String alertLabel = "xpath://*[@text ='Alert']";
	public static String okButton = "xpath://*[@text ='Ok']";
	
	public LoginPage(AndroidDriver driver) {
		super();
		this.driver = (AndroidDriver<MobileElement>) driver;
	}

	public LoginPage verifyLoginPageUi() throws Exception {

		AppLibrary.findElementForMobile(driver, beanLoginLogo);
		AppLibrary.findElementForMobile(driver, emailLabel);
		AppLibrary.findElementForMobile(driver, emailInput);
		AppLibrary.clickMobileElement(driver, passwordInput);
		AppLibrary.findElementForMobile(driver, passwordLabel);
		AppLibrary.findElementForMobile(driver, passwordInput);
		AppLibrary.findElementForMobile(driver, loginButton);
		AppLibrary.findElementForMobile(driver, forgotPasswordButton);
		AppLibrary.findElementForMobile(driver, signUpButton);
		
		
		return new LoginPage(driver);

	}

	public void signIn(String email, String pass) throws Exception {
		AppLibrary.enterMobileText(driver, emailInput, email);
		AppLibrary.enterMobileText(driver, passwordInput, pass);
		AppLibrary.clickMobileElement(driver, loginButton);
	}

}
