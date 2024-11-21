package com.cs.pages.hrmPages;

import org.openqa.selenium.By;

import com.cs.pages.BasePage;

public final class OrangeHrmLoginPage extends BasePage {

	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");

	public OrangeHrmLoginPage enterUsername(String username) {
		sendKeys(this.username, username);

		return this;
	}

	public OrangeHrmLoginPage enterPassword(String paswd) {
		sendKeys(this.password, paswd);

		return this;
	}

	public OrangeHrmHomePage clickLoginBtn() {
		click(loginBtn);

		return new OrangeHrmHomePage();
	}

}
