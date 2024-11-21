package com.cs.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cs.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {
		
	}

	
	public static String getBase64String()
	{
		    return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
