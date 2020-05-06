package com.amazon.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.base.MobileBase;
import com.amazon.utilities.AppiumWrapper;

import io.appium.java_client.MobileElement;

public class SearchScreen extends MobileBase {
	private AppiumWrapper appiumWrapper;
	public SearchScreen() {
		appiumWrapper = new AppiumWrapper();
	}

	@FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='bylineInfo']")
	private MobileElement itemStatus;
	@FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='atfRedesign_priceblock_priceToPay']/android.widget.EditText")
	private MobileElement itemPrice;
	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='add-to-cart-button']")
	private MobileElement addToCart;
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_count']")
	private MobileElement cart;
	@FindBy(how = How.XPATH, using = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]")
	private MobileElement verifyingIncartAddedItem;
	@FindBy(how = How.XPATH, using = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.ListView/android.view.View[1]")
	private MobileElement verifyingIncartAddedItemPrice;

	/**
	 * 
	 * This method will not take first and last item randomly will pick the item of
	 * given range
	 * 
	 * @return
	 */
	public int pickRandomItem() {
		int min = 2;
		appiumWrapper.waitForElement();
		List<MobileElement> getItems = appiumDriver.findElements(By.xpath(
				"//android.widget.LinearLayout[@resource-id='com.amazon.mShop.android.shopping:id/list_product_linear_layout']"));
		int maxSize = getItems.size();
		try {
			if (maxSize > 1) {
				int dynamicSize = (int) (Math.random() * ((maxSize - 2) + 1)) + min;
				System.out.println(dynamicSize);
				appiumWrapper.waitForElement();
				if (dynamicSize == maxSize) {
					dynamicSize = dynamicSize - 1;
				}
				MobileElement listItem = getItems.get(dynamicSize);
				for (int i = 0; i < 4; i++) {
					if (listItem.isDisplayed()) {
						appiumWrapper.taponElement(listItem, 120);
						break;
					} else {
						appiumWrapper.scrollDown();
					}
				}
				return dynamicSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxSize;
	}

	/**
	 * Method for Item status
	 * 
	 */
	public String getItemName() {
		return appiumWrapper.getTextValue(itemStatus, 60);
	}

	/**
	 * 
	 * Method for get item price
	 * 
	 * @return
	 */
	public String getItemPrice() {
		return appiumWrapper.getTextValue(itemPrice, 60);
	}

	/**
	 * 
	 * Method for Wish List button
	 */
	public void addToCart() {
		appiumWrapper.scrollDown();
		appiumWrapper.taponElement(addToCart, 120);
	}

	/**
	 * 
	 * Cart Method
	 */
	public void cartView() {
		appiumWrapper.scrollDown();
		appiumWrapper.taponElement(cart, 120);
	}

	/**
	 * 
	 * method for add cart
	 * @return
	 */
	public String verifyingIncartAddedItem() {
		return appiumWrapper.getTextValue(verifyingIncartAddedItem, 60);
	}

	/**
	 * Method for item price in cart
	 * 
	 * @return
	 */
	public String verifyingIncartAddedItemPrice() {
		return appiumWrapper.getTextValue(verifyingIncartAddedItemPrice, 60);
	}

}
