package com.cs.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cs.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void logPass(String message) {
		ExtentReportManager.getTest().pass(message);
	}

	public static void logFail(String message) {
		ExtentReportManager.getTest().fail(message);
	}

	public static void logSkipped(String message) {
		ExtentReportManager.getTest().skip(message);
	}

	public static void logPass(String message, boolean takescreenshot) {
		if (takescreenshot) {
			ExtentReportManager.getTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64String()).build());

		} else
			ExtentReportManager.getTest().pass(message);
	}

	public static void logFail(String message, boolean takescreenshot) {

		if (takescreenshot) {
			ExtentReportManager.getTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64String()).build());
		} else
			ExtentReportManager.getTest().fail(message);
	}

	public static void logSkipped(String message, boolean takescreenshot) {
		if (takescreenshot) {
			ExtentReportManager.getTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64String()).build());
		} else

			ExtentReportManager.getTest().skip(message);
	}

	

}
