package utilities;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBase {
	DesiredCapabilities capabilities;
	public static String projectPath = System.getProperty("user.dir");
	public static String reportsPath = projectPath + File.separator + "WebReports" + File.separator;
	public static String mobileReportsPath = projectPath + File.separator + "MobileReports" + File.separator;
	public AppiumDriver<MobileElement> appiumDriver;
	public void mobileAppLaunch(String appPath, String deviceUDID) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "devicename");		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "platformName");	
		capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "360");
		if (appPath.contains(".apk")) {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			appiumDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	}
	public static WebElement waitForExpectedElement(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, timeOutInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void setInputBox(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds, String inputValue) {
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		element.sendKeys(inputValue);
	}
	
	public void taponElement(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		element.click();
	}
	
	public String getTextValue(AppiumDriver<MobileElement> appiumDriver, MobileElement element, long timeOutInSeconds) {
		waitForExpectedElement(appiumDriver, element, timeOutInSeconds);
		String textValue = element.getText();
		return textValue;
	}
}
