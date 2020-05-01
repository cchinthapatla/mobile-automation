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

	public MobileTest() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(MobileTest.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("MobileTest.properties");
		report = new ExtentReports(projectPath + File.separator + "MobileReports" + File.separator + "ExtentReportResults.html");
	}
	@BeforeClass
	public void launchMobileApp() throws Exception {
		mobileAppLaunch(projectPath + File.separator + "mobile" + File.separator + "apk" + File.separator + "Amazon_shopping.apk", "1215fcadde7a1104");
		logger.info("App is launched");
	}
	@Test(priority=1)
	public void loginTest() throws Exception {
		test = report.startTest("LoginTest");
		LoginScreen loginScreen = new LoginScreen(appiumDriver);
		loginScreen.tapSignInButton();
		logger.info("Tapped on Sign in Button");
		test.log(LogStatus.INFO, "Tapped on Signin Button");
		loginScreen.setEmailorMobileField("chandrachinthapatla@gmail.com");
		logger.info("Filled Email Field : " );
		test.log(LogStatus.INFO, "Filled Email Field :");
		loginScreen.tapContinueButton();
		logger.info("Tapped on Continue Button");
		test.log(LogStatus.INFO, "Tapped on Continue Button");
		loginScreen.setPasswordField("Sekhar@123");
		logger.info("Filled Password Field : ******" );
		test.log(LogStatus.INFO, "Filled Password Field : ******");
		loginScreen.tapLoginButton();
		logger.info("Tapped on Login Button");
		test.log(LogStatus.INFO, "Tapped on Login Button");
	}
	@Test(priority=2)
	public void homeTest() throws Exception {
		test = report.startTest("HomeTest");
		HomeScreen homeScreen = new HomeScreen(appiumDriver);
		homeScreen.tapCancelButton();
		logger.info("Tapped on Cancel Button");
		test.log(LogStatus.INFO, "Tapped on Cancel Button");
		homeScreen.setsearchField("65-inch TV");
		logger.info("Filled Search Field : ******" );
		test.log(LogStatus.INFO, "Filled Search Field : ******");
		homeScreen.tapsearchItem();
	}
	@Test(priority=3)
	public void searchTest() throws Exception {
		test = report.startTest("SearchTest");
		SearchScreen searchScreen = new SearchScreen(appiumDriver);
		String itemStatus = searchScreen.getItemStatus();
		logger.info("Item Status is: " + itemStatus);
		test.log(LogStatus.INFO, "Item Status is : " + itemStatus);
		searchScreen.tapWishListButton();
		logger.info("Tapped on Wish List Button");
		test.log(LogStatus.INFO, "Tapped on Wish List Button");
	}
	@AfterClass
	public void tearDown() {
		appiumDriver.quit();
		report.endTest(test);
		report.flush();
	}
}
