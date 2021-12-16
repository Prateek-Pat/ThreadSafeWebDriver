package com.nopcommercce.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public WebDriver driver = null;
	String  chromePath = "E:\\STUDY Mate\\SELENIUM\\BrowserDrivver's\\96 Version\\chromedriver_win32_2\\chromedriver.exe";
	String firefoxPath = "E:\\STUDY Mate\\SELENIUM\\BrowserDrivver's\\Firefox\\geckodriver-v0.30.0-win64\\geckodriver.exe";
	
	//Creating webDriver object for given browser
	public WebDriver createBrowserInstance(String browserName){
		
		if(browserName.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", chromePath);
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();			
		}		
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.chrome.driver", firefoxPath);
			//WebDriverManager.firefoxdriver().setup();			
			driver = new FirefoxDriver();	
		}
		
		else if(browserName.equalsIgnoreCase("Safari")){
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();	
		}
		
		return driver;
	}
}
