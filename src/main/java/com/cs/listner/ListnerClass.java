package com.cs.listner;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;
import com.cs.enums.ConfigProperties;
import com.cs.reports.ExtentLogger;
import com.cs.reports.ExtentReport;
import com.cs.utils.ELKUtils;
import com.cs.utils.PropertyUtils;

public class ListnerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		try {
			ExtentReport.initExtentReport();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushExtentReport();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createTest(result.getMethod().getMethodName() + " : " + result.getMethod().getDescription());

		AuthorName[] authorName = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author();
		ExtentReport.setAuthor(authorName);

		CategoryType[] categoryName = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category();
		ExtentReport.setCategory(categoryName);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentLogger.logPass(result.getMethod().getMethodName() + " is passed sucessfully");
		if ("true".equals(PropertyUtils.getPropertyMapValue(ConfigProperties.SELENIUM_GRID_ENABLED)))
			ELKUtils.sendLogToELK(result.getMethod().getMethodName(), "Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.logFail(result.getMethod().getMethodName() + " is failed ", true);
		ExtentLogger.logFail(result.getThrowable().getMessage());
		ExtentLogger.logFail(Arrays.toString(result.getThrowable().getStackTrace()));
		if ("true".equals(PropertyUtils.getPropertyMapValue(ConfigProperties.SELENIUM_GRID_ENABLED)))
			ELKUtils.sendLogToELK(result.getMethod().getMethodName(), "Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.logSkipped(result.getMethod().getMethodName() + " is skipped ");
		if ("true".equals(PropertyUtils.getPropertyMapValue(ConfigProperties.SELENIUM_GRID_ENABLED)))
			ELKUtils.sendLogToELK(result.getMethod().getMethodName(), "Skip");

	}

}
