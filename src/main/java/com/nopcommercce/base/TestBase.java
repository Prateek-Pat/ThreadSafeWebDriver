package com.nopcommercce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/* Step1) Create 

 */

public class TestBase {
		
	public Properties prop;
	public FileInputStream fis;
	public BrowserFactory bf = null;
	public WebDriver driver; 
	
	String configFilePath  = "C:\\Users\\prate\\workspace\\ThreadSafe_WebDriver\\src\\main\\java\\com\\config\\properties\\config.properties";
	
	public TestBase() throws IOException{
		
		prop = new Properties();
		fis = new FileInputStream(configFilePath);
		prop.load(fis);
	}

	@BeforeMethod
	public void AppLaunch(){
		bf = new BrowserFactory();
		driver  = bf.createBrowserInstance("chrome");
		DriverFactory.getInstance().setDriver(driver);
		WebDriver driverInit = DriverFactory.getInstance().getDriver();
		
		//driverInit.manage().window().maximize();
		driverInit.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverInit.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);			
		driverInit.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown(){
	DriverFactory.getInstance().closeBrowser();	
	
	}
}
