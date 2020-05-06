package com.amazon.screens;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.base.MobileBase;
import com.amazon.utilities.AppiumWrapper;

import io.appium.java_client.MobileElement;

public class HomeScreen extends MobileBase {
	private AppiumWrapper appiumWrapper;
	public HomeScreen() {
		appiumWrapper = new AppiumWrapper();
	}
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[3]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.RadioButton")	
	private MobileElement languageButton;
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[3]/android.view.View/android.view.View/android.view.View[8]/android.view.View[2]/android.widget.Button")
	private MobileElement saveChangesButton;
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchField;
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchField1;
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement searchItem;
	
	/**
	 * 
	 * Method for Language 
	 */
	public boolean tapLanguageButton() {
		return appiumWrapper.taponIfElementDisplayed(languageButton, 30);
	}
	
	/**
	 * 
	 * Method for Save Changes
	 */
	public boolean tapsaveChangesButton() {
		return appiumWrapper.taponIfElementDisplayed(saveChangesButton, 30);
	} 
	
	/**
	 * 
	 * Method to click on Search Field
	 */
	public void setsearchField(String searchValue) {
		searchField.click();
	}
	public boolean loginVerification() {
		return appiumWrapper.elementDisplayed(searchField, 120);
	}
	
	/**
	 * 
	 * Method to enter search data in search field
	 */
	public void setsearchField1(String searchValue) {
		appiumWrapper.setInputBox(searchField1, 120, searchValue);
	}
	
	/**
	 * 
	 * Method for search item
	 */
	public void tapsearchItem() {
		appiumWrapper.taponElement(searchItem, 120);		
	}
}
