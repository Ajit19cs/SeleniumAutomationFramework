package com.cs.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cs.driver.Driver;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	protected final void setup() throws Exception {
		Driver.initDriver();

		

	}

	@AfterMethod
	protected final void teardown() {

		Driver.quitDriver();

	}

}