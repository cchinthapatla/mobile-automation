package utilities;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class MobileBase {
	DesiredCapabilities capabilities;
	public static String projectPath = System.getProperty("user.dir");
	public static String reportsPath = projectPath + File.separator + "WebReports" + File.separator;
	public static String mobileReportsPath = projectPath + File.separator + "MobileReports" + File.separator;
	public AppiumDriver<MobileElement> appiumDriver;

	public void mobileAppLaunch(String appPath, String deviceUDID) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");	
		
		capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET,  true);	
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "360");
		capabilities.setCapability("app", appPath);
		if (appPath.contains(".apk")) {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			appiumDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		//appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	}
	public static WebElement waitForExpectedElement(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, timeOutInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void setInputBox(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds, String inputValue) {
		waitForElement();
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		waitForElement();
		
		element.sendKeys(inputValue);
	}
	
	public void setInputClickBox(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds, String inputValue) {
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		element.click();
		element.sendKeys(inputValue);
	}
	
	
	public void taponElement(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
	
		 element.click();
		
	}
	
	public boolean taponIfElementDisplayed(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		try {
			WebElement ele = waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
			if (ele.isDisplayed()) {
				ele.click();
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
		
	}
	public boolean elementDisplayed(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		try {
			WebElement ele = waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
			if (ele.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
		
	}
	
	//Don't use if not required 
	public void waitForElement() {
		try {
		Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public String getTextValue(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		WebElement ele = waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		String textValue = ele.getText();
		return textValue;
	}
	
	
	public void scrollDown() {
	    //if pressX was zero it didn't work for me
	    int pressX = appiumDriver.manage().window().getSize().width / 2;
	    // 4/5 of the screen as the bottom finger-press point
	    int bottomY = appiumDriver.manage().window().getSize().height * 4/5;
	    // just non zero point, as it didn't scroll to zero normally
	    int topY = appiumDriver.manage().window().getSize().height / 8;
	    //scroll with TouchAction by itself
	    scroll(pressX, bottomY, pressX, topY);
	    //System.out.println(""+pressX + "y: ::: " + bottomY);
	}
	
	
	/*
	 * Don't forget that it's "natural scroll" where 
	 * fromY is the point where you press and toY where you release it
	 */
	@SuppressWarnings("rawtypes")
	private void scroll(int fromX, int fromY, int toX, int toY) {
	    TouchAction touchAction = new TouchAction(appiumDriver);
	    touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	
}
