package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By accSections = By.cssSelector("div#content h2");
	private By header = By.cssSelector("div#logo h1 a");
	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	@Step("getAccPageTitle")
	public String getAccPageTitle() {
		return elementUtil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);
	}

	@Step("getAccpageUrl")
	public String getAccpageUrl() {
		return elementUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, 5);
	}

	@Step("getAccPageHeader")
	public String getAccPageHeader() {
		return elementUtil.doGetText(header);
	}
 
	@Step("getAccountSectionsList")
	public List<String> getAccountSectionsList() {
		List<String> accSecValueList = new ArrayList<String>();
		List<WebElement> accSecList = elementUtil.getElements(accSections);
		for (WebElement e : accSecList) {
			accSecValueList.add(e.getText());
		}
<<<<<<< HEAD
		//TODO Clean this commented code
		//Collections.sort(accSecValueList);
		return accSecValueList;		
=======
		// Collections.sort(accSecValueList);
		System.out.println("printing all the t est cases here");
		return accSecValueList;
>>>>>>> 3309d3670127a3e5baf6c1aff682024ec9fa3f20
	}

	@Step("isLogoutLinkExist")
	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}

	@Step("doSearch {0}")
	public ResultsPage doSearch(String productName) {
		System.out.println("searching the product: " + productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new ResultsPage(driver);
	}

}