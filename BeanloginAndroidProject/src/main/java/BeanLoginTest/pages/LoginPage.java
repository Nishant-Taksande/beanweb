package BeanLoginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BeanLoginTest.lib.AppLibrary;

public class LoginPage {
	WebDriver driver;

	public static String beanLoginLogo = "id:com.anisolutions.BeanLogin:id/iv_logo_login";
	public static String emailLabel = "id:com.anisolutions.BeanLogin:id/tv_email";
	public static String emailInput = "id:com.anisolutions.BeanLogin:id/et_email";
	public static String passwordLabel = "id:com.anisolutions.BeanLogin:id/tv_pass";
	public static String passwordInput = "id:com.anisolutions.BeanLogin:id/et_pass";

	public static String loginButton = "id:com.anisolutions.BeanLogin:id/btn_login";
	public static String forgotPasswordButton = "id:com.anisolutions.BeanLogin:id/tv_forgot_pass";
	public static String signUpButton = "id:com.anisolutions.BeanLogin:id/tv_sign_up";
	

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPage verifyLoginPageUi() {

		AppLibrary.findElement(driver, beanLoginLogo);
		AppLibrary.findElement(driver, emailLabel);
		AppLibrary.findElement(driver, emailInput);
//		driver.findElement(By.id(passwordInput)).click();
		AppLibrary.clickElement(driver, passwordInput);
		AppLibrary.findElement(driver, passwordLabel);
		AppLibrary.findElement(driver, passwordInput);
		AppLibrary.findElement(driver, loginButton);
		AppLibrary.findElement(driver, forgotPasswordButton);
		AppLibrary.findElement(driver, signUpButton);

		return new LoginPage(driver);

	}

	// public void signIn(String email, String pass) {
	// AppLibrary.enterText(driver, emailInput, email);
	// AppLibrary.enterText(driver, passwordInput, pass);
	// AppLibrary.clickElement(driver, signInButton);
	// }

}
