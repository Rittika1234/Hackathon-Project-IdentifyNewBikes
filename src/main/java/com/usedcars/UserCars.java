package com.usedcars;

import java.io.IOException;
import java.util.List;
import com.tamali.base.Wait_;

//import com.utilityFiles.CaptureScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserCars{
	
	WebDriver driver;
	public String filePath = null;
    
	//Constructor to initialize WebElements
	
	public UserCars(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElements for used cars page
	
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsMenu;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement chennaiUsedCars;
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> modelName;
	
	
	// Mouse hover on 'Used cars' menu from the main menu bar
	
	public void usedCarsMenu() {
		
		Actions action = new Actions(driver);
		action.moveToElement(usedCarsMenu).perform();
		
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/UsedCarsMenu.png";
		
		System.out.println("Done Mouse hover on 'Used cars' from Menu");
	}
	
	// Click on 'Used cars in Chennai' link
	
	public void selectChennaiUsedCars() {
		
		chennaiUsedCars.click();
		
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/UsedCarsInChennai.png";

	}
	
	// Get list of all popular models of used cars in Chennai and write to excel file
	
	public void modelList() throws InterruptedException, IOException {
		 
		// Scroll down to make all elements visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, 500)");
	    
	    Wait_ wait = new Wait_();
		wait.waitListExplicit(30, modelName, driver);
	    
	    // Display the list of popular models on the console
	    System.out.println("Following is the list of Popular models:");
		for (int i = 0; i < modelName.size(); i++) {
			System.out.println(modelName.get(i).getText());
		}
	}

}
