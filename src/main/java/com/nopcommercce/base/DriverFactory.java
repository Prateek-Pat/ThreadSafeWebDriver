package com.nopcommercce.base;

import org.openqa.selenium.WebDriver;

/* Implementation of DriverFacotry using Desing Pattern

1. Singleton Desing Pattern
	 1) Private Construtor
 	 2) Static getInstance Method whose return type is object of DriverFactory
2. Factory Desing Pattern

*/

public class DriverFactory {

	//Singelton Pattern
	
	private static DriverFactory df = null;
	
	// 1. Private Constructor
	private DriverFactory(){
		
	}
	
	// 2. Static getInstance Method
	public static DriverFactory getInstance(){
		if(df == null){			
			df = new DriverFactory();						
		}  
		return df;
	}
	

	/*Factory Design Pattern
	 * 
	 * below  used methods are threadlocal class methods,
	 *  which implements facotry desing Pattern
	*/
		
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver(){
		return driver.get();			
	}
	
	public void setDriver(WebDriver driverInstance){
		driver.set(driverInstance);	
	}
	
	public void closeBrowser(){		
		driver.get().close();
		driver.remove();
	}
	
}
	
	
	

