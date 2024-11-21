package com.cs.tests;

import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;
import com.cs.pages.amazon.AmazoneHome;

public class AmazoneTestCase extends BaseTest {
	
	
	@FrameworkAnnotation(author = {AuthorName.AJIT,AuthorName.MANU},category = {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test(description = "this is amazon Menu buton click flow")
	public void testAmazoneFlow() {

		new AmazoneHome().clickHamburgerMenu()
		                  .clickMenuOption("Mobiles, Computers")
		                   .clickSubMenuOption("Power Banks");

	}

}
