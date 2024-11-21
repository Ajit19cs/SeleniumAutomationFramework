package com.cs.reports;

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;
import com.cs.utils.ResourceLoader;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;
	private static String extentReportPath;

	public static void initExtentReport() throws Exception {
		if (Objects.isNull(extent)) {
			extentReportPath = System.getProperty("user.dir") + "/extent-output/" + System.currentTimeMillis()
					+ "/index.html";
			try (InputStream configStream = ResourceLoader.getResource("properties/extentReportFormat.json")) {
				extent = new ExtentReports();
				ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);

				// Temporarily create a local config file if necessary
				Path tempConfig = Files.createTempFile("extentConfig", ".json");
				Files.copy(configStream, tempConfig, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
				spark.loadJSONConfig(tempConfig.toFile());

				extent.attachReporter(spark);
				Files.deleteIfExists(tempConfig); // Clean up temporary config file
			}
		}
	}

	public static void flushExtentReport() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentReportManager.unload();

			// Only attempt to open the browser if the environment is not headless
			if (!GraphicsEnvironment.isHeadless()) {
				Desktop.getDesktop().browse(new File(extentReportPath).toURI());
			} else {
				System.out.println("Headless environment detected. Cannot open report in browser.");
			}
		}
	}

	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentReportManager.setTest(test);
	}

	public static void setAuthor(AuthorName[] author) {
		for (AuthorName temp : author) {
			ExtentReportManager.getTest().assignAuthor(temp.toString());
		}
	}

	public static void setCategory(CategoryType[] category) {
		for (CategoryType temp : category) {
			ExtentReportManager.getTest().assignCategory(temp.toString());
		}
	}
}
