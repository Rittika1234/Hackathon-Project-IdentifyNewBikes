package com.googlesignin;


import com.tamali.base.Wait_;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


public class GoogleSignin {
      
	WebDriver driver;
	public String filePath = null;
     
	//Constructor to initialize the web driver and page objects
	
	 public GoogleSignin(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	 // page objects
	 
	 @FindBy(xpath = "/html[1]/body[1]/div[17]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]")
	 WebElement google;
	 
	 @FindBy(xpath ="//div[@id='forum_login_title_lg']")
	 WebElement signInButton;
	 
	 @FindBy(id = "identifierId")
	 WebElement email;
	 
	 @FindBy(xpath = "//span[contains(text(),'Next')]")
	 WebElement emailNextButton;
	 
	 @FindBy(xpath = "//div[@class='o6cuMc Jj6Lae' and contains(text(),'Enter a valid email or phone number')]")
	 WebElement errorMessage;
	 
	 @FindBy(id = "continue")
	 WebElement continueWithGoogle;
	
	// method to click on Sign In button
	 
	public void clickSignIn() {
		
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/SignInButton.png";
		
		signInButton.click();	
	}
	
	// method to sign in with Google
	
	public void googleSignIn() throws InterruptedException {
		
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/GoogleSignInButton.png";
		
		Wait_ wait = new Wait_();
		wait.waitExplicit(30,google,driver);
		
		google.click();
	}
     
	// method to enter invalid email ID
	
    public void emailInput(String emailId) {
		
		//new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
		
      try {
		// Get all window handles
		Set<String> windows = driver.getWindowHandles();
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    
		// Initialize an iterator for the window handles
		Iterator<String> iterator = windows.iterator();
		
		// Get the handle of the parent window
		String parent = iterator.next();
		
		// Get the handle of the child window
		String child = iterator.next();
		
		driver.switchTo().window(child);
		
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/EmailIdField.png";
		email.sendKeys(emailId);
		
	   } catch (NoSuchElementException e) {

         System.err.println("Exception occurred: " + e.getMessage());
         
        // Get all window handles
 		Set<String> windows = driver.getWindowHandles();
 		
 		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
 	    
 		// Initialize an iterator for the window handles
 		Iterator<String> iterator = windows.iterator();
 		
 		// Get the handle of the parent window
 		String parent = iterator.next();
 		
 		// Get the handle of the child window
 		String child = iterator.next();
 		
 		driver.switchTo().window(child);
 		
 		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/EmailIdField.png";
 		email.sendKeys(emailId);
      }
    }
	
    // method to click on Next button after entering email ID
    
    public void emailNext() {
		
		Actions action = new Actions(driver);
		action.moveToElement(emailNextButton).click().perform();
		
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/NextButton.png";
	}
    
    // method to capture the error message
    
    public void getErrorMessage() {
		
    	Wait_ wait = new Wait_();
		wait.waitExplicit(30,errorMessage,driver);
		
		String message= errorMessage.getText();
		
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/ErrorMessage.png";
		
		System.out.println(message);
	}

}
