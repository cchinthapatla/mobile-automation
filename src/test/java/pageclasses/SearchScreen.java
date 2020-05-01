package pageclasses;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.MobileBase;

public class SearchScreen extends MobileBase {
	public SearchScreen(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView[1]")	
	private MobileElement itemStatus;
	public String getItemStatus() {
		String getItemStatus = getTextValue(appiumDriver, itemStatus, 120);
		return getItemStatus;
	}
	
	@FindBy(how = How.ID, using = "add-to-wishlist-button-submit")	
	private MobileElement wishListButton;
	public void tapWishListButton() {
		taponElement(appiumDriver, wishListButton, 120);		
	}
	
}
