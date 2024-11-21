package com.cs.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cs.driver.DriverManager;
import com.cs.reports.ExtentReport;

public class LoginTest extends BaseTest{

	@Test
	public void login()
	{

		 ExtentReport.createTest("login");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("ajit cs",Keys.ENTER);


	}

	@Test
	public void logout()
	{

		 ExtentReport.createTest("logout");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("manjiri CA",Keys.ENTER);


	}
}
