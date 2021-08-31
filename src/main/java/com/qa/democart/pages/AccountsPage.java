package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;	
	private ElementUtil elementUtil;
	
	private By accountSection= By.xpath("//div[@id='content']//h2");
	private By header = By.xpath("//div[@id='logo']//a");
	private By logoutLink = By.linkText("Logout");
	private By searchfield = By.xpath("//input[@name='search']");
	private By searchBtn = By.xpath("//div[@id='search']//button");
	
	public AccountsPage(WebDriver driver){
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle()
	{
		return elementUtil.waitForTitlesIs(Constants.ACCOUNT_PAGE_TITLE, 5);
	}
	
	public String getAccPageUrl()
	{
		return elementUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, 5);
		 
	}
	
	public String getAccPageHeader()
	{
		return elementUtil.doGetText(header);
	}
	
	public List<String> getAccSectionsList()
	{
		List<String> accSecValueList = new ArrayList<String>();
		List<WebElement> accSecList = elementUtil.getElements(accountSection);
		for(WebElement e : accSecList)
		{
			accSecValueList.add(e.getText());
		}
		//TODO Clean this commented code
		//Collections.sort(accSecValueList);
		return accSecValueList;		
	}
	
	public boolean logoutLinkExist()
	{
		return elementUtil.doDisplayed(logoutLink);
	}
	
	public ResultsPage doSearch(String ProductName)
	{
		System.out.println("Searching the productList:" +ProductName); 
		elementUtil.doSendKeys(searchfield, ProductName);
		elementUtil.doClick(searchBtn);
		return new ResultsPage(driver);
	}
	
	
	
	
}
