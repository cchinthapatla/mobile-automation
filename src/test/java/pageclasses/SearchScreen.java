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
		//scrollDown();
		int min = 2;
		waitForElement();
		List<MobileElement> getItems = appiumDriver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id='com.amazon.mShop.android.shopping:id/list_product_linear_layout']"));
		int maxSize = getItems.size();
	
		try{if (maxSize > 1) {
			int dynamicSize = (int) (Math.random() * ((maxSize - 2) + 1)) + min;
			System.out.println(dynamicSize);
			waitForElement();
			if(dynamicSize == maxSize) {
				dynamicSize = dynamicSize-1;
			}
			MobileElement listItem = getItems.get(dynamicSize);
			for(int i=0;i<4; i++ ) {
				if(listItem.isDisplayed()) {
				  taponElement(appiumDriver, listItem, 120);
				  break;
				} else {
					scrollDown();
				}
			} 
			
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
	@FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='bylineInfo']")	
	private MobileElement itemStatus;
	public String getItemName() {
		return getTextValue(appiumDriver, itemStatus, 60);
	}
	
	@FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='atfRedesign_priceblock_priceToPay']/android.widget.EditText")
	private MobileElement itemPrice;
	public String getItemPrice() {
		
		return getTextValue(appiumDriver, itemPrice, 60);
	}

	/**
	 * 
	 * Method for Wish List button
	 */
	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='add-to-cart-button']")
	private MobileElement addToCart;
	public void addToCart() {
		scrollDown();
		taponElement(appiumDriver, addToCart, 120);
	}
	
	/**
	 * 
	 * Cart Method
	 */
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_count']")
	private MobileElement cart;
	public void cartView() {
		scrollDown();
		taponElement(appiumDriver, cart, 120);
	}
	
	
	@FindBy(how = How.XPATH, using = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]")
	private MobileElement verifyingIncartAddedItem;
	public String  verifyingIncartAddedItem() {
		return getTextValue(appiumDriver, verifyingIncartAddedItem, 60);
	}
	
	@FindBy(how = How.XPATH, using = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.ListView/android.view.View[1]")
	
	private MobileElement verifyingIncartAddedItemPrice;
	public String  verifyingIncartAddedItemPrice() {
		return getTextValue(appiumDriver, verifyingIncartAddedItemPrice, 60);
	}
	

}
