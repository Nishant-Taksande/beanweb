package com.beanlogin.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.beanlogin.lib.AppLibrary;
import com.beanlogin.lib.TestBase;

public class MailinatorPage {

	WebDriver mailDriver;

	public static String verifyEmailLabel = "xpath://td[contains(text(),'BeanLogin: Verify Email')]";

	public static String iframe = "xpath://iframe[@id='msg_body']";

	public static String clickHereButton = "xpath://a[text()='click here']";

	public static String verificationCompleteLabel = "//label[text()='Email Verification Complete']";

	public static String deleteMailButton = "xpath://button[@id='trash_but']";

	public static String forgotPasswordLabel = "xpath://td[contains(text(),'BeanLogin: Forgot Password')]";

	public static String PasswordText = "xpath://tr//td//b";

	public MailinatorPage(WebDriver Driver) {
		super();
		this.mailDriver = Driver;
	}

	public void getVerification(String email) throws Exception{

		// System.setProperty("webdriver.firefox.profile", "default");
		AppLibrary ap = new AppLibrary();
		mailDriver = ap.launchDefaultDriverInstance();
		
		

		boolean flag;
		int counter = 2;

		try {
			do {
				flag = false;
				counter--;
				System.out.println("Counter = " + counter);

				try {

					mailDriver.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email + "#/#inboxpane");
					AppLibrary.sleep(3000);

					AppLibrary.syncAndClick(mailDriver, verifyEmailLabel);

				} catch (Exception e) {
					flag = true;
				}

				AppLibrary.sleep(1000);
				mailDriver.switchTo().frame(AppLibrary.findElement(mailDriver, iframe));
				AppLibrary.syncAndClick(mailDriver, clickHereButton);

				AppLibrary.switchToWindow(mailDriver, 2);
				mailDriver.findElement(By.xpath(verificationCompleteLabel));

				AppLibrary.switchToWindow(mailDriver, 1);
				mailDriver.switchTo().defaultContent();
				AppLibrary.findElement(mailDriver, deleteMailButton).click();// delete
			} while (flag && counter > 0);

			mailDriver.quit();

		} catch (Exception e1) {
			mailDriver.quit();
			throw new Exception("Failed to access verification");
		}
	}

	
	public String getPassword(String email) throws Exception {

		String text;
		AppLibrary ap = new AppLibrary();
		mailDriver = ap.launchDefaultDriverInstance();

		boolean flag;
		int counter = 2;
		try {
			do {
				flag = false;
				counter--;
				System.out.println("Counter = " + counter);

				try {

					mailDriver
							.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email + "#/#inboxpane");
					AppLibrary.sleep(3000);

					AppLibrary.syncAndClick(mailDriver, forgotPasswordLabel);

				} catch (Exception e) {
					flag = true;
				}

				AppLibrary.sleep(1000);

				mailDriver.switchTo().frame(AppLibrary.findElement(mailDriver, iframe));
				text = AppLibrary.findElement(mailDriver, PasswordText).getText();

				mailDriver.switchTo().defaultContent();
				AppLibrary.findElement(mailDriver, deleteMailButton).click();// delete

			} while (flag && counter > 0);

			mailDriver.quit();

		} catch (Exception e1) {
			mailDriver.quit();
			throw new Exception("Failed to access verification");
		}
		return text;
	}

	
}
