package com.cs.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cs.enums.BrowserType;
import com.cs.enums.ConfigProperties;
import com.cs.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(BrowserType browserName) {
		WebDriver driver = null;
		String remote = PropertyUtils.getPropertyMapValue(ConfigProperties.SELENIUM_GRID_ENABLED);
		String HubHost =PropertyUtils.getPropertyMapValue(ConfigProperties.SELENIUM_GRID_HUBHOST);
		

		if (BrowserType.FIREFOX.equals(browserName)) {
			if (remote.equalsIgnoreCase("true")) {

				FirefoxOptions options = new FirefoxOptions();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", "firefox");

				// Merge capabilities with FirefoxOptions
				options.merge(capabilities);

				try {
					driver = new RemoteWebDriver(new URL("http://"+HubHost+":4444/wd/hub"), options);
				} catch (MalformedURLException e) {

					e.printStackTrace();
				}
			} else {
				WebDriverManager.firefoxdriver().clearResolutionCache().setup();
				driver = new FirefoxDriver();
			}
		} else if (BrowserType.CHROME.equals(browserName)) {
			if (remote.equalsIgnoreCase("true")) {
				ChromeOptions options = new ChromeOptions();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", "chrome");

				// Merge capabilities with ChromeOptions
				options.merge(capabilities);

				try {
					driver = new RemoteWebDriver(new URL("http://"+HubHost+":4444/wd/hub"), options);
				} catch (MalformedURLException e) {

					e.printStackTrace();
				}
			} else {
				WebDriverManager.chromedriver().clearResolutionCache().setup();
				
				driver = new ChromeDriver();
			}
		}
		

		return driver;
	}

}
