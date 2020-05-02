package pageclasses;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.MobileBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends MobileBase {
	
	/**
	 * Constructor
	 * 
	 * @param appiumDriver
	 */
	public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/**
	 * 
	 * Method for signin button
	 */
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/sign_in_button")	
	private MobileElement signInButton;
	public void tapSignInButton() {
		taponElement(appiumDriver, signInButton, 120);		
	}
	
	/**
	 * 
	 * Method for Email field  
	 */
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='ap_email_login']")	
	private MobileElement emailORmobileField;
	public void setEmailorMobileField(String emailORmobileNumber) {
		setInputBox(appiumDriver, emailORmobileField, 120, emailORmobileNumber);		
	}
	
	/**
	 * 
	 * Method for continue button
	 */
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")	
	private MobileElement continueButton;
	public void tapContinueButton() {
		taponElement(appiumDriver, continueButton, 120);		
	}
	
	/**
	 * 
	 * Method for password field
	 */
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id='ap_password']")	
	private MobileElement passwordField;
	public void setPasswordField(String password) {
		setInputBox(appiumDriver, passwordField, 120, password);		
	}
	
	/**
	 * 
	 * Method for Login Button
	 */
	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='signInSubmit']")	
	private MobileElement loginButton;
	public void tapLoginButton() {
		taponElement(appiumDriver, loginButton, 120);		
	}
	
	
	
	
	
}