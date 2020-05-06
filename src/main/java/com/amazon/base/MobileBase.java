package com.amazon.base;

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

	/**
	 * 
	 * Method to launch application with desired capabilities
	 * @param appPath
	 * @param deviceUDID
	 * @throws Exception
	 */
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
	}
	
}
