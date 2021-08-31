package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//Private By Locators
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn= By.xpath("//input[@type='submit']");
	private By forgotpwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password'] ");
	private By header = By.xpath("//div[@id='logo']//a[text()='Your Store']");
	
	
	//constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page Actions / Page Methods /functionality or behavior of the page / no assertion
	
	public String getLoginPageTitle()
	{
		return elementUtil.waitForTitlesIs(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public String getPageHeaderText()
	{
		return elementUtil.doGetText(header);
	}
	 
	public boolean isForgotPWDLinkExist()
	{
		return elementUtil.doDisplayed(forgotpwdLink);
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		/*
		 * driver.findElement(emailId).sendKeys(un);;
		 * driver.findElement(password).sendKeys(un);
		 * driver.findElement(loginBtn).click();
		 */
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
}
