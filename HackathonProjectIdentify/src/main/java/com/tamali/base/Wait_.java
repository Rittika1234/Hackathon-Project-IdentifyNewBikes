package com.tamali.base;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_ {
	 // Declaring WebDriver as a static variable so that it can be accessed throughout the class
	
     public static WebDriver driver;
     public static WebDriverWait waits;
	
	//Method to define explicit wait
     
	public void waitExplicit(int sec, WebElement element ,WebDriver driver) {
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(sec));
	    waits.until(ExpectedConditions.elementToBeClickable(element));
	}
    
	public void waitListExplicit(int sec, List<WebElement> elements ,WebDriver driver) {
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(sec));
	    waits.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
