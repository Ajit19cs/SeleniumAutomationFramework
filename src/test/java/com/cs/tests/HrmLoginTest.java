package com.cs.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorName;
import com.cs.enums.CategoryType;
import com.cs.pages.hrmPages.OrangeHrmHomePage;
import com.cs.pages.hrmPages.OrangeHrmLoginPage;

public class HrmLoginTest extends BaseTest {

	@Test
	public void HrmLogin() {

		OrangeHrmLoginPage lgpg = new OrangeHrmLoginPage();
		OrangeHrmHomePage homepg = lgpg.enterUsername("Admin").enterPassword("admin123").clickLoginBtn();
		Assertions.assertThat(homepg.verifyHomepage()).isTrue();

	}
	@Test
	public void HrmLoginAgain() {

		OrangeHrmLoginPage lgpg = new OrangeHrmLoginPage();
		OrangeHrmHomePage homepg = lgpg.enterUsername("Admin").enterPassword("admin123").clickLoginBtn();
		Assertions.assertThat(homepg.verifyHomepage()).isTrue();

	}

	@Test
	public void HrmLoginDup() {

		OrangeHrmLoginPage lgpg = new OrangeHrmLoginPage();
		OrangeHrmHomePage homepg = lgpg.enterUsername("Admin2").enterPassword("admin123").clickLoginBtn();
		Assertions.assertThat(homepg.verifyHomepage()).isTrue();

	}
	@FrameworkAnnotation(author = {AuthorName.AJIT,AuthorName.MANU},category = {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test(description = "this is get HrmLoginDupAgain")
	public void HrmLoginDupAgain() {

		OrangeHrmLoginPage lgpg = new OrangeHrmLoginPage();
		OrangeHrmHomePage homepg = lgpg.enterUsername("Admin2").enterPassword("admin123").clickLoginBtn();
		Assertions.assertThat(homepg.verifyHomepage()).isTrue();

	}

}
