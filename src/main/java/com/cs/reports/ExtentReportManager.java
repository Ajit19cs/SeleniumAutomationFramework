package com.cs.reports;

import com.aventstack.extentreports.ExtentTest;

class ExtentReportManager {

	private ExtentReportManager() {

	}

	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	static final ExtentTest getTest() {
		return test.get();
	}

	static final void setTest(ExtentTest test) {

		ExtentReportManager.test.set(test);
	}

	static final void unload() {
		test.remove();
	}

}
