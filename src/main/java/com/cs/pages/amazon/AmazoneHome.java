package com.cs.pages.amazon;

import org.openqa.selenium.By;

import com.cs.pages.BasePage;

public class AmazoneHome extends BasePage{
	
	private String hamMenu= "//a[@id='nav-hamburger-menu']";
	
	public  AmazoneMenuPage clickHamburgerMenu() {
		
		
		click(By.xpath(hamMenu));
		return new AmazoneMenuPage();
	
	}

}
