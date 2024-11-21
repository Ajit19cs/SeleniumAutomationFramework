package com.cs.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.constants.FrameWorkConstatns;
import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;

public final class WaitFactory {

	private WaitFactory() {

	}

	public static WebElement performExpliciteWait(WaitStrategy waitType, By by) {
		WebElement element = null;

		if (WaitStrategy.PRESENT == waitType) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMillis(FrameWorkConstatns.getExplicitewait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (WaitStrategy.VISIBLE == waitType) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMillis(FrameWorkConstatns.getExplicitewait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (WaitStrategy.CLIKABLE == waitType) {

			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMillis(FrameWorkConstatns.getExplicitewait()))
					.until(ExpectedConditions.elementToBeClickable(by));

		}

		else if (WaitStrategy.NONE == waitType) {
			element = DriverManager.getDriver().findElement(by);
		}

		return element;

	}

}
