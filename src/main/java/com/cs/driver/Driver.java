package com.cs.driver;

import java.time.Duration;
import java.util.Objects;

import com.cs.enums.BrowserType;
import com.cs.enums.ConfigProperties;
import com.cs.factories.DriverFactory;
import com.cs.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static final void initDriver() {
	

		if (Objects.isNull(DriverManager.getDriver())) {
			String browser= PropertyUtils.getPropertyMapValue(ConfigProperties.BROWSER);
		
			DriverManager.setDriver(DriverFactory.getDriver(BrowserType.valueOf(browser.toUpperCase())));
		}

		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(60000));
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		DriverManager.getDriver().manage().window().maximize();

		DriverManager.getDriver().get(PropertyUtils.getPropertyMapValue(ConfigProperties.URL));
	}

	public static final void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();
			DriverManager.unload();

		}
	}

}
