package com.cs.tests;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cs.driver.DriverManager;

public class HomePageTest extends BaseTest{
	
	@Test
	public void test2()
	{
        WebDriver driver =DriverManager.getDriver();
     
        driver.findElement(By.name("q")).sendKeys("testing mini bytes",Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//h3"));
		 
		 Assertions.assertThat(elements)
		           .hasSizeBetween(5, 100)
		           .extracting(WebElement :: getText)
		           .anySatisfy(text -> Assertions.assertThat(text).contains("Mini"));
		 
		String title=driver.getTitle();
		System.out.println("the value of title is : "+title);
		
		 Assertions.assertThat(title) 
		             .isNotNull() 
		             	.contains("mini");
		 
		
		
	}

}
