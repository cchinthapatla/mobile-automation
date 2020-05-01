package pageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.MobileBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class LoginScreen extends MobileBase {
	public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/sign_in_button")	
	private MobileElement signInButton;
	public void tapSignInButton() {
		taponElement(appiumDriver, signInButton, 120);		
	}
	@FindBy(how = How.ID, using = "ap_email_login")	
	private MobileElement emailORmobileField;
	public void setEmailorMobileField(String emailORmobileNumber) {
		setInputBox(appiumDriver, emailORmobileField, 120, emailORmobileNumber);		
	}
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")	
	private MobileElement continueButton;
	public void tapContinueButton() {
		taponElement(appiumDriver, continueButton, 120);		
	}
	
	@FindBy(how = How.ID, using = "ap_password")	
	private MobileElement passwordField;
	public void setPasswordField(String password) {
		setInputBox(appiumDriver, passwordField, 120, password);		
	}
	
	@FindBy(how = How.ID, using = "signInSubmit")	
	private MobileElement loginButton;
	public void tapLoginButton() {
		taponElement(appiumDriver, loginButton, 120);		
	}
	
	
	
	
	
}