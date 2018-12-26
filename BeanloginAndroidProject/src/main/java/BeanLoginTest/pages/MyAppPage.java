package BeanLoginTest.pages;

import org.openqa.selenium.WebDriver;

import BeanLoginTest.lib.AppLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MyAppPage {
	AndroidDriver<MobileElement> driver;
	
	public static String myAppsLabel = "xpath://*[@text ='My Apps']";
	
	public static String beanloginLogo = "id:com.anisolutions.BeanLogin:id/toolbar_ivNavigation";
	public static String eyeIcon = "id:com.anisolutions.BeanLogin:id/toolbar_eye";
	public static String plusSign = "id:com.anisolutions.BeanLogin:id/toolbar_ivGetAvailableApps";
//	public static String eyeIcon = "id:com.anisolutions.BeanLogin:id/toolbar_eye";
//	public static String beanloginLogo = "id:com.anisolutions.BeanLogin:id/toolbar_ivNavigation";
//	public static String eyeIcon = "id:com.anisolutions.BeanLogin:id/toolbar_eye";
//	public static String beanloginLogo = "id:com.anisolutions.BeanLogin:id/toolbar_ivNavigation";
//	public static String eyeIcon = "id:com.anisolutions.BeanLogin:id/toolbar_eye";
//	public static String beanloginLogo = "id:com.anisolutions.BeanLogin:id/toolbar_ivNavigation";
//	public static String eyeIcon = "id:com.anisolutions.BeanLogin:id/toolbar_eye";

	
	
	//Side panel
	public static String favoritesLabel = "xpath://*[@text ='Favorites']";
	public static String mostUsedLabel = "xpath://*[@text ='Most Used']";
	public static String folderLabel = "xpath://*[@text ='Folders']";
	public static String sharedLabel = "xpath://*[@text ='Shared']";
	public static String accountLabel = "xpath://*[@text ='Account']";
	public static String logoutLabel = "xpath://*[@text ='Logout']";
	
	
	////logout confirmation
	public static String confirmLabel = "xpath://*[@text ='Confirmation']";
	public static String logoutMesLabel = "xpath://*[@text ='Are you sure you want to logout?']";
	public static String yesButton = "xpath://*[@text ='YES']";
	public static String cancelButon = "xpath://*[@text ='Cancel']";
	
	//logged In
	public static String tickImg = "id:com.anisolutions.BeanLogin:id/iv_login_again_tick";
	public static String loggedLabel = "xpath://*[@text ='You have logged out successfully']";
	public static String loginAgain = "xpath://*[@text ='Log In Again']";
	
	public MyAppPage(WebDriver driver) {
		super();
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	public MyAppPage verifyMyAppPageUi() throws Exception {

		AppLibrary.findElementForMobile(driver, myAppsLabel);
		AppLibrary.findElementForMobile(driver, beanloginLogo);
		AppLibrary.findElementForMobile(driver, eyeIcon);
		AppLibrary.findElementForMobile(driver, plusSign);	
		
		AppLibrary.clickMobileElement(driver, beanloginLogo);
		AppLibrary.findElementForMobile(driver, favoritesLabel);
		AppLibrary.findElementForMobile(driver, mostUsedLabel);
		AppLibrary.findElementForMobile(driver, folderLabel);
		AppLibrary.findElementForMobile(driver, sharedLabel);
		AppLibrary.findElementForMobile(driver, accountLabel);
		AppLibrary.findElementForMobile(driver, logoutLabel);
		
		return new MyAppPage(driver);

	}
	
	public void logOut() throws Exception{
		AppLibrary.clickMobileElement(driver, myAppsLabel);
		AppLibrary.clickMobileElement(driver, beanloginLogo);
		AppLibrary.sleep(1000);
		AppLibrary.clickMobileElement(driver, logoutLabel);
		AppLibrary.clickMobileElement(driver, yesButton);
		AppLibrary.clickMobileElement(driver, loginAgain);
	}
	
	
	
	
}
