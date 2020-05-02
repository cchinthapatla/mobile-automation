package pageclasses;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.MobileBase;

public class HomeScreen extends MobileBase {
	/**
	 * Constructor
	 * 
	 * @param appiumDriver
	 */
	public HomeScreen(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/**
	 * 
	 * Method for Language 
	 */
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[3]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.RadioButton")	
	private MobileElement languageButton;
	public boolean tapLanguageButton() {
		return taponIfElementDisplayed(appiumDriver, languageButton, 30);
	}
	
	/**
	 * 
	 * Method for Save Changes
	 */
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View[3]/android.view.View/android.view.View/android.view.View[8]/android.view.View[2]/android.widget.Button")
	private MobileElement saveChangesButton;
	public boolean tapsaveChangesButton() {
		return taponIfElementDisplayed(appiumDriver, saveChangesButton, 30);
	} 
	
	/**
	 * 
	 * Method to click on Search Field
	 */
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchField;
	public void setsearchField(String searchValue) {
		searchField.click();
		
	}
	public boolean loginVerification() {
		return elementDisplayed(appiumDriver, searchField, 120);
	}
	
	/**
	 * 
	 * Method to enter search data in search field
	 */
	@FindBy(how = How.ID, using = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchField1;
	public void setsearchField1(String searchValue) {
		setInputBox(appiumDriver, searchField1, 120, searchValue);
	}
	
	/**
	 * 
	 * Method for search item
	 */
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement searchItem;
	public void tapsearchItem() {
		taponElement(appiumDriver, searchItem, 120);		
	}
}
