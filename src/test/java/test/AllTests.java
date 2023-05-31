package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tamali.base.Base;
import com.usedcars.UserCars;
import com.upcomingbikes.UpcomingBikes;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.googlesignin.GoogleSignin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class AllTests {

	public static WebDriver driver;
	public static ExtentSparkReporter reporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "/ExtentReport/extentReportFile.html");
	public static ExtentReports extent = new ExtentReports();

	@BeforeMethod
	public void setup() {
		Base base = new Base();
		driver = base.driverSetup();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("Automation Result");
		reporter.config().setReportName("Indentify New Bikes Automation Test");
		reporter.config().setTheme(Theme.DARK);
		ExtentTest logger = extent.createTest("Driver Test");
		logger.log(Status.INFO, "Browser launched");
		logger.log(Status.INFO, "Navigated to https://www.zigwheels.com/");
		
	}
    
	@Test(priority = 1)
	public void upComingBikes() throws Exception{
		UpcomingBikes up = new UpcomingBikes(driver);
		
		up.newBikesMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Upcoming Bikes Test");
		logger.log(Status.INFO, "Mouse Hover on 'New Bikes'");
		
		up.selectUpcomingBike();
		logger.log(Status.INFO, "Upcoming Bikes submenu is selected");
		
		up.selectManufacturer();
		logger.log(Status.INFO, "Manufacturer name is selected as 'Honda'");
		
		up.viewMoreBikes();
		logger.log(Status.INFO, "View More button is clicked");
		
		up.bikeModels();
		logger.log(Status.INFO, "Upcoming Bikes under 4 lac is displayed on console ");

		logger.log(Status.PASS, "Upcoming Bikes test is passed");
		
		extent.flush();
		
	}
	
	@Test(priority = 2)
	public void usedCars() throws InterruptedException, IOException {
		UserCars userCars = new UserCars(driver);
		
		userCars.usedCarsMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Used Cars in Chennai Test");
		logger.log(Status.INFO, "Mouse Hover on 'Used Cars'");
		
		userCars.selectChennaiUsedCars();
		logger.log(Status.INFO, "Find Used Cars in Chennai is selected as Location");
		
		userCars.modelList();
		logger.log(Status.INFO, "Popular Models List is Displayed on console");
		
		logger.log(Status.PASS, "Used cars in chennai test is passed");
		
		extent.flush();
	}
   
	@Test(priority = 3)
	public void testGoogleSignIn() throws InterruptedException {
		GoogleSignin signin = new GoogleSignin(driver);
		
		signin.clickSignIn();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Google Sign In Test");
		logger.log(Status.INFO, "Sign In button is clicked");
		
		signin.googleSignIn();
		logger.log(Status.INFO, "Continue with Google button is clicked");
		
		signin.emailInput("abc@abc");
		logger.log(Status.INFO, "An invalid email id is entered into Email field");
		
		signin.emailNext();
		logger.log(Status.INFO, "Next button is clicked after entering the invalid email id");
		
		signin.getErrorMessage();
		logger.log(Status.INFO,
				"Error message is captured successfully and displayed on console");
		
		logger.log(Status.PASS, "Google Sign In test is passed");

		
		extent.flush();
		
	}
	
	@AfterMethod
	public void closeDriver() {
		Base base = new Base();
		base.quitBrowser();
	}
	
}

