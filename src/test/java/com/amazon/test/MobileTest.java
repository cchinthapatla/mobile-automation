package com.amazon.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.drivermanager.DriverManager;
import com.amazon.screens.HomeScreen;
import com.amazon.screens.LoginScreen;
import com.amazon.screens.SearchScreen;
import com.amazon.utilities.AppiumWrapper;
import com.amazon.utilities.ExcelDataReaderUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MobileTest extends DriverManager{
 private AppiumWrapper appiumWrapper;
	ExtentReports report;
	ExtentTest test;
	private ExcelDataReaderUtility excelObj;
	private Logger logger;

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public MobileTest() throws Exception {
		appiumWrapper = new AppiumWrapper();
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(MobileTest.class);
		excelObj = new ExcelDataReaderUtility(projectPath + File.separator + "testdata" + File.separator + "testdata.xlsx",
				0);
		report = new ExtentReports(
				projectPath + File.separator + "MobileReports" + File.separator + "ExtentReportResults.html");
	}

	/**
	 * 
	 * Launch the App
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void launchMobileApp() throws Exception {
		try {

			String udid = excelObj.getStringCelldata(1, 1);
			mobileAppLaunch(projectPath + File.separator + "mobile" + File.separator + "apk" + File.separator
					+ "Amazon_shopping.apk", udid);
			getDriver().rotate(ScreenOrientation.LANDSCAPE);
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}

	/**
	 * 
	 * Login into App
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void loginTest() throws Exception {
		try {
			test = report.startTest("LoginTest");
			LoginScreen loginScreen = new LoginScreen();
			loginScreen.tapSignInButton();
			test.log(LogStatus.INFO, "Tapped on Signin Button");
			appiumWrapper.waitForElement();
			String userName = excelObj.getStringCelldata(1, 2);
			test.log(LogStatus.INFO, "Filled Email Field : " + userName);
			loginScreen.tapContinueButton();
			test.log(LogStatus.INFO, "Tapped on Continue Button");
			loginScreen.setPasswordField(excelObj.getStringCelldata(1, 3));
			test.log(LogStatus.INFO, "Filled Password Field : ******");
			loginScreen.tapLoginButton();
			test.log(LogStatus.INFO, "Tapped on Login Button");
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}

	/**
	 * Home Page Test
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void homeTest() throws Exception {
		try {
			test = report.startTest("HomeTest");
			HomeScreen homeScreen = new HomeScreen();
			boolean isLang = homeScreen.tapLanguageButton();
			if (isLang) {
				test.log(LogStatus.INFO, "Tapped on English Language Button");
			}
			boolean isCancel = homeScreen.tapsaveChangesButton();
			if (isCancel) {
				test.log(LogStatus.INFO, "Tapped on saveChanges Button");
			}
			appiumWrapper.waitForElement();
			boolean isElement = homeScreen.loginVerification();
			if (isElement) {
				test.log(LogStatus.PASS, "User is successfully logged into app");
			}
			String searchData = excelObj.getStringCelldata(1, 0);
			homeScreen.setsearchField(searchData);
			appiumWrapper.waitForElement();
			homeScreen.setsearchField1(searchData);
			test.log(LogStatus.INFO, "Filled Search Field : " + searchData);
			appiumWrapper.waitForElement();
			homeScreen.tapsearchItem();
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}

	/**
	 * 
	 * Search Results and add item to wish list
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void searchTest() throws Exception {
		try {
			test = report.startTest("SearchTest");
			SearchScreen searchScreen = new SearchScreen();
			int status = searchScreen.pickRandomItem();
			test.log(LogStatus.INFO, "Picked Item : " + (status == 0 ? "None" : status));
			String itemName = searchScreen.getItemName();
			test.log(LogStatus.INFO, "Item Name: " + itemName);
			String itemPrice = searchScreen.getItemPrice();
			test.log(LogStatus.INFO, "Item Price: " + itemPrice);
			searchScreen.addToCart();
			test.log(LogStatus.INFO, "Tapped on Addd to Cart Button");
			searchScreen.cartView();
			test.log(LogStatus.INFO, "Tapped on Cart Button");
			String addedItemInCartName = searchScreen.verifyingIncartAddedItem();
			if (itemName.contains(addedItemInCartName)) {
				test.log(LogStatus.PASS, "Added Cart Item Name : " + addedItemInCartName + " Item Name" + itemName);
			}else {
				test.log(LogStatus.PASS, "Added Cart Item Name : " + addedItemInCartName + " Item Name" + itemName);
			}
			String addedItemInCartPrice = searchScreen.verifyingIncartAddedItemPrice();
			if (itemPrice.contains(addedItemInCartPrice)) {
				test.log(LogStatus.FAIL, "Cart Item Price :" + addedItemInCartPrice);
			}else {
				test.log(LogStatus.FAIL, "Cart Item Price :" + addedItemInCartPrice);
			}
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}

	@AfterClass
	public void tearDown() {
		try {
			getDriver().quit();
			report.endTest(test);
			report.flush();
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}
}
