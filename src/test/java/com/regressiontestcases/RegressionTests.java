package com.regressiontestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.googlesignin.GoogleSignin;
import com.tamali.base.Base;
import com.usedcars.UserCars;
import com.upcomingbikes.UpcomingBikes;

//Class for Regression tests
public class RegressionTests {

	public static WebDriver driver;

	// Setting up the driver before each test method
	@BeforeMethod
	public void setup() {
		Base base = new Base();
		driver = base.driverSetup();
	}
    
	// Test method for Upcoming Bikes
	@Test(priority = 1)
	public void upComingBikes() throws Exception{
		
		UpcomingBikes up = new UpcomingBikes(driver);
		up.newBikesMenu();
		up.selectUpcomingBike();
		up.selectManufacturer();
		up.viewMoreBikes();
		up.bikeModels();
		
	}
	
	// Test method for Used Cars
	@Test(priority = 2)
	public void usedCars() throws InterruptedException, IOException {
		
		UserCars userCars = new UserCars(driver);
		userCars.usedCarsMenu();
		userCars.selectChennaiUsedCars();
		userCars.modelList();
	}
   
	// Test method for Google Sign In
	@Test(priority = 3)
	public void testGoogleSignIn() throws InterruptedException {
		
		GoogleSignin signin = new GoogleSignin(driver);
		signin.clickSignIn();
		signin.googleSignIn();
		signin.emailInput("abc@abc");
		signin.emailNext();
		signin.getErrorMessage();
		
	}
	
	// Closing the driver after each test method
	@AfterMethod
	public void closeDriver() {
		Base base = new Base();
		base.quitBrowser();
	}
	
}

