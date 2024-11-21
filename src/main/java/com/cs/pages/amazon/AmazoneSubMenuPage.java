package com.cs.pages.amazon;

import org.openqa.selenium.By;

import com.cs.pages.BasePage;
import com.cs.utils.DynamicXpathUtils;

public class AmazoneSubMenuPage extends BasePage {
	
	private String  subMenuName="//ul[contains(@class,'hmenu-visible')]//li[a[@class='hmenu-item'][text()='%s']]/a";
	                             
	
	
	public void clickSubMenuOption(String optionName)
	{
	      String menuSubNameXpath= DynamicXpathUtils.getDynamicXpath(subMenuName, optionName);
	      
	      actionClick(By.xpath(menuSubNameXpath));
	   
	}
	
	

}
