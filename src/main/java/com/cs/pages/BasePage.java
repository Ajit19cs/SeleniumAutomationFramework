package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;
import com.cs.factories.WaitFactory;
import com.cs.reports.ExtentLogger;

 public class BasePage {
	
	
	protected void sendKeys(By by,String textToEnter)
	{
		WaitFactory.performExpliciteWait(WaitStrategy.VISIBLE, by).sendKeys(textToEnter);
		ExtentLogger.logPass("enter text : "+textToEnter+" at path :"+by);
		
	}
	
	protected void actionClick(By by)
	{
		
		 WebElement element =WaitFactory.performExpliciteWait(WaitStrategy.CLIKABLE, by);
		 Actions mouse = new Actions(DriverManager.getDriver());
		 mouse.click(element).perform();
		
		ExtentLogger.logPass("click at path :"+by);
		
	}
	
	protected void click(By by)
	{
		
		WaitFactory.performExpliciteWait(WaitStrategy.CLIKABLE, by).click();
		ExtentLogger.logPass("click at path :"+by);
		
	}
	

}
