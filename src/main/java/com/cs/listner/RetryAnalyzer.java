package com.cs.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.cs.enums.ConfigProperties;
import com.cs.utils.PropertyUtils;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private int retryCount = 1;
	private static boolean retryEnabled = false;

	static {

		if (PropertyUtils.getPropertyMapValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			retryEnabled = true;

	}

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;
		if (retryEnabled) {
			value = count < retryCount;
			count++;
		}

		return value;

	}

}
