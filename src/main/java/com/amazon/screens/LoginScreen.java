package com.amazon.screens;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.base.MobileBase;
import com.amazon.utilities.AppiumWrapper;

import io.appium.java_client.MobileElement;

public class LoginScreen extends MobileBase {
	private AppiumWrapper appiumWrapper;
	
	public LoginScreen() {
		appiumWrapper = new AppiumWrapper();
	}
	
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/sign_in_button")	
	private MobileElement signInButton;
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='ap_email_login']")	
	private MobileElement emailORmobileField;
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")	
	private MobileElement continueButton;
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='ap_password']")	
	private MobileElement passwordField;
	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='signInSubmit']")	
	private MobileElement loginButton;
	
	/**
	 * 
	 * Method for signin button
	 */
	public void tapSignInButton() {
		appiumWrapper.taponElement(signInButton, 120);		
	}
	
	/**
	 * 
	 * Method for Email field  
	 */
	public void setEmailorMobileField(String emailORmobileNumber) {
		appiumWrapper.setInputBox(emailORmobileField, 120, emailORmobileNumber);		
	}
	
	/**
	 * 
	 * Method for continue button
	 */
	public void tapContinueButton() {
		appiumWrapper.taponElement(continueButton, 120);		
	}
	
	/**
	 * 
	 * Method for password field
	 */
	public void setPasswordField(String password) {
		appiumWrapper.setInputBox(passwordField, 120, password);		
	}
	
	/**
	 * 
	 * Method for Login Button
	 */
	public void tapLoginButton() {
		appiumWrapper.taponElement(loginButton, 120);		
	}
}