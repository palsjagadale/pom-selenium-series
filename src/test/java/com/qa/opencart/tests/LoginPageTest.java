package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageTitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MESSG);

	}

	@Test(priority=2)
	public void loginPageHeaderTest() {
		String header = loginpage.getPageHeaderText();
		System.out.println("Login page header :" + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER, Errors.HEADER_ERROR_MESSG);

	}

	@Test(priority=3)
	public void ForgotPWDLinkTest() {
		Assert.assertTrue(loginpage.isForgotPWDLinkExist());
	}

	@Test(priority=4)
	public void loginTest() { 
		AccountsPage accPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
		Assert.assertTrue(accPage.logoutLinkExist());
	}

}
