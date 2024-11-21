package com.cs.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {
		
	}
	private static final ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();



	public static final WebDriver getDriver() {
		return dr.get();
	}

	public static final void setDriver(WebDriver driver) {

		dr.set(driver);
	}
	public static final void unload()
	{
		dr.remove();
	}
}
