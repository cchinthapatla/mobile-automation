package testclasses;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageclasses.HomeScreen;
import pageclasses.LoginScreen;
import pageclasses.SearchScreen;
import utilities.ConfigFilesUtility;
import utilities.MobileBase;

public class MobileTest extends MobileBase {

	ExtentReports report;
	ExtentTest test;
	ConfigFilesUtility configFileObj;
	private Logger logger;

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public MobileTest() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(MobileTest.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("MobileTest.properties");
		report = new ExtentReports(
				projectPath + File.separator + "MobileReports" + File.separator + "ExtentReportResults.html");
	}
/**
 * 
 * Launch the App
 * @throws Exception
 */
	@BeforeClass
	public void launchMobileApp() throws Exception {
		try {
			mobileAppLaunch(projectPath + File.separator + "mobile" + File.separator + "apk" + File.separator
					+ "Amazon_shopping.apk", configFileObj.getProperty("deviceUDID"));
			logger.info("App is launched");
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
			LoginScreen loginScreen = new LoginScreen(appiumDriver);
			loginScreen.tapSignInButton();
			logger.info("Tapped on Sign in Button");
			test.log(LogStatus.INFO, "Tapped on Signin Button");
			waitForElement();
			loginScreen.setEmailorMobileField(configFileObj.getProperty("username"));
			logger.info("Filled Email Field : " + configFileObj.getProperty("username"));
			test.log(LogStatus.INFO, "Filled Email Field : " + configFileObj.getProperty("username"));
			loginScreen.tapContinueButton();
			logger.info("Tapped on Continue Button");
			test.log(LogStatus.INFO, "Tapped on Continue Button");
			loginScreen.setPasswordField(configFileObj.getProperty("password"));
			logger.info("Filled Password Field : ******");
			test.log(LogStatus.INFO, "Filled Password Field : ******");
			loginScreen.tapLoginButton();
			logger.info("Tapped on Login Button");
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
			HomeScreen homeScreen = new HomeScreen(appiumDriver);
			boolean isLang = homeScreen.tapLanguageButton();
			if (isLang) {
				logger.info("Tapped on English Language Button");
				test.log(LogStatus.INFO, "Tapped on English Language Button");
			}
			boolean isCancel = homeScreen.tapsaveChangesButton();
			if (isCancel) {
				logger.info("Tapped on Save Changes Button");
				test.log(LogStatus.INFO, "Tapped on saveChanges Button");
			}
			waitForElement();
			boolean isElement = homeScreen.loginVerification();
			if (isElement) {
				logger.info("User is successfully logged into app");
				test.log(LogStatus.PASS, "User is successfully logged into app");
			}
			homeScreen.setsearchField(configFileObj.getProperty("searchdata"));
			waitForElement();
			homeScreen.setsearchField1(configFileObj.getProperty("searchdata"));
			logger.info("Filled Search Field : " + configFileObj.getProperty("searchdata"));
			test.log(LogStatus.INFO, "Filled Search Field : " + configFileObj.getProperty("searchdata"));
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
			SearchScreen searchScreen = new SearchScreen(appiumDriver);
			int status = searchScreen.pickRandomItem();
			logger.info("Picked Item : " + (status == 0 ? "None" : status));
			test.log(LogStatus.INFO, "Picked Item : " + (status == 0 ? "None" : status));
			searchScreen.tapWishListButton();
			logger.info("Tapped on Wish List Button");
			test.log(LogStatus.INFO, "Tapped on Wish List Button");
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}

	@AfterClass
	public void tearDown() {
		try {
			appiumDriver.quit();
			report.endTest(test);
			report.flush();
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}
}
