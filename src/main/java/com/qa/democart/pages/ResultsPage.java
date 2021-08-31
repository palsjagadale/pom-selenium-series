package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By searchHeader = By.xpath(" //div[@id='content']/h1");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	public String getSearchpageHeader()
	{
		return elementUtil.doGetText(searchHeader);
	}
	
	
}
