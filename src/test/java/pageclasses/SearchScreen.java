package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
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

	/**
	 * 
	 * This method will not take first and last item randomly will pick the item of given range
	 * @return
	 */
	public int pickRandomItem() {
		int min = 2;
		List<MobileElement> getItems = appiumDriver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout"));
		int maxSize = getItems.size();
		
		try{if (maxSize > 1) {
			int dynamicSize = (int) (Math.random() * ((maxSize - 2) + 1)) + min;
			waitForElement();
			MobileElement listItem = getItems.get(dynamicSize);
			for(int i=0;i<(dynamicSize/4); i++ ) {
				if(listItem.isDisplayed()) {
					break;
				}
			}
			taponElement(appiumDriver, listItem, 120);
			return dynamicSize;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return maxSize;
	}

	/**
	 * Method for Item status
	 * 
	 */
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[5]/android.view.View/android.widget.TextView[2]")
	private MobileElement itemStatus;
	public String getItemStatus() {
		return getTextValue(appiumDriver, itemStatus, 30);
	}

	/**
	 * 
	 * Method for Wish List button
	 */
	@FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='wishlistButtonStack']")
	private MobileElement wishListButton;
	public void tapWishListButton() {
		scrollDown();
		taponElement(appiumDriver, wishListButton, 120);
	}
	

}
