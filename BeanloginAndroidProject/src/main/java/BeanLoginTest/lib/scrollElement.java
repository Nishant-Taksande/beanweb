package BeanLoginTest.lib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollElement {
	
	AndroidDriver<MobileElement> driver;
	public scrollElement(WebDriver driver){
		super();
		this.driver=(AndroidDriver<MobileElement>) driver;
	}
	
	public MobileElement scrollToExactElement(WebElement ele,String str){
		return ((AndroidElement)ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\""+str+"\"));");
		
	}
	
	public MobileElement ScrollToElement(String ele,String str){
		
		WebElement ele1=AppLibrary.findElement(driver, ele);
		return ((AndroidElement)ele1).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().textContains(\""+str+"\"));");
	}
	
	public void ScrollStepWise(WebElement ele,int step){
		((AndroidElement)ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollForward("+step+")");
	}
	
	
	

}
