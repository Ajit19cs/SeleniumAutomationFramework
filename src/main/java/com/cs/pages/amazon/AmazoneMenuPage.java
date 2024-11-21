package com.cs.pages.amazon;

import org.openqa.selenium.By;

import com.cs.pages.BasePage;
import com.cs.utils.DynamicXpathUtils;

public class AmazoneMenuPage extends BasePage {
	
	
	
	private String  menuName="//a[@class='hmenu-item'][div[text()='%s']]/parent::li";
	
	
	public AmazoneSubMenuPage clickMenuOption(String optionName)
	{
	      String menuNameXpath= DynamicXpathUtils.getDynamicXpath(menuName, optionName);
	      
	      actionClick(By.xpath(menuNameXpath));
	      return new AmazoneSubMenuPage();
	      
	      
	}
	

}
