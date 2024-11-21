package com.cs.pages.hrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cs.driver.DriverManager;

public final class OrangeHrmHomePage {

	
	private By dashBoard = By.xpath("//h6[text()='Dashboard']");
	

	
	public boolean verifyHomepage()
	{
		List<WebElement> elements=DriverManager.getDriver().findElements(this.dashBoard);
		 return !elements.isEmpty();
		
		
	}
	
}
