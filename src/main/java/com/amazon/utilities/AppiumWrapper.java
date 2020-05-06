package com.amazon.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.amazon.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumWrapper extends MobileBase{

	/**
	 * 
	 * Method for explicit wait
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public WebElement waitForExpectedElement(MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, timeOutInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * Method for set input value
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @param inputValue
	 */
	public void setInputBox(MobileElement element, long timeOutInSeconds, String inputValue) {
		waitForElement();
		waitForExpectedElement(element, timeOutInSeconds);
		waitForElement();
		
		element.sendKeys(inputValue);
	}
	
	/**
	 * 
	 * Method for set inputbox
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @param inputValue
	 */
	public void setInputClickBox( MobileElement element, long timeOutInSeconds, String inputValue) {
		waitForExpectedElement(element, timeOutInSeconds);
		element.click();
		element.sendKeys(inputValue);
	}
	
	/**
	 * 
	 * Method for click on element
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void taponElement( MobileElement element, long timeOutInSeconds) {
		waitForExpectedElement(element, timeOutInSeconds);
		 element.click();
	}
	
	/**
	 * 
	 * Method for is displayed
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean taponIfElementDisplayed(MobileElement element, long timeOutInSeconds) {
		try {
			WebElement ele = waitForExpectedElement(element, timeOutInSeconds);
			if (ele.isDisplayed()) {
				ele.click();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
		
	}
	
	/**
	 * Method for element dispalyed
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean elementDisplayed( MobileElement element, long timeOutInSeconds) {
		try {
			WebElement ele = waitForExpectedElement(element, timeOutInSeconds);
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

	/**
	 * Method for get text value
	 * @param appiumDriver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public String getTextValue( MobileElement element, long timeOutInSeconds) {
		WebElement ele = waitForExpectedElement(element, timeOutInSeconds);
		String textValue = ele.getText();
		return textValue;
	}
	
	/**
	 * 
	 * Method for scroll down
	 */
	public void scrollDown() {
	    //if pressX was zero it didn't work for me
	    int pressX = appiumDriver.manage().window().getSize().width / 2;
	    // 4/5 of the screen as the bottom finger-press point
	    int bottomY = appiumDriver.manage().window().getSize().height * 4/5;
	    // just non zero point, as it didn't scroll to zero normally
	    int topY = appiumDriver.manage().window().getSize().height / 8;
	    //scroll with TouchAction by itself
	    scroll(pressX, bottomY, pressX, topY);
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
