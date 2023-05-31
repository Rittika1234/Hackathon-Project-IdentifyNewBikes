package com.tamali.base;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base
{
	
	public static WebDriver driver;
	public static String url = "https://www.zigwheels.com/";
	public static Properties prop;
	
	// Method to set up the WebDriver instance based on the browser specified in the configuration file
	
	public WebDriver driverSetup()
	{
		prop=new Properties();
		
		try 
		{
			// Loading the configuration file
			prop.load(new FileInputStream("src/main/java/config/config.properties"));
		}	
		 catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("browserName"));
		
       // Checking which browser is specified in the configuration file and creating the corresponding WebDriver instance
		if(prop.getProperty("browserName").matches("edge")) 
		{
			
			driver = new EdgeDriver();
		}
		 
		else if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(prop.getProperty("browserName").matches("explorer"))
		{
			driver=new InternetExplorerDriver(); 
		}
		
		
		// Maximizing the window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Navigating to the URL specified in the static variable
		driver.get(url);
		
		return driver;
		
	}
	
	// Method to quit the browser
	
	public void quitBrowser()
	{
		driver.quit();
	}

}



