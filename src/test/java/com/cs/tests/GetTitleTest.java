package com.cs.tests;

import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.driver.DriverManager;
import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;

public class GetTitleTest extends BaseTest {
	
	
	@FrameworkAnnotation(author = {AuthorName.AJIT,AuthorName.MANU},category = {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test(description = "this is get title")
	public void testgetTitle() {

		
		System.out.println(DriverManager.getDriver().getTitle());

	}
	
	@FrameworkAnnotation(author = {AuthorName.AJIT,AuthorName.MANU},category = {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test(description = "this is get titles")
	public void testgetTitles() {

		
		System.out.println(DriverManager.getDriver().getTitle());

	}
	
	

}
