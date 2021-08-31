package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static By getBy(String locatortype, String locatorValue)
	{
		By locator = null;
		switch (locatortype) {
		
		case "id":			
			locator=By.id(locatorValue);			
			break;
			
		case "xpath":			
			locator=By.xpath(locatorValue);			
			break;
			
		case "name":			
			locator=By.name(locatorValue);			
			break;
			
		case "className":			
			locator=By.className(locatorValue);			
			break;

		case "linkText":			
			locator=By.linkText(locatorValue);			
			break;
		case "partialLinkText":			
			locator=By.partialLinkText(locatorValue);			
			break;
			
		case "cssSelector":			
			locator=By.cssSelector(locatorValue);			
			break;

		default:
			System.out.println("Please pass correct locator");
			break;
		}
		
		return locator;
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public  WebElement getElement(String locatortype, String locatorValue)
	{
		
		return driver.findElement(getBy( locatortype,  locatorValue));
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetAttribute(By locator, String AttrName) {
		return getElement(locator).getAttribute(AttrName);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doEnable(By locator) {
		return getElement(locator).isEnabled();
	}

	
	public void clickonelement(By locator, String value) {

		List<WebElement> elelist = getElements(locator);
		System.out.println(elelist.size());

		for (WebElement e : elelist) {

			if (e.getText().equals(value)) {
				e.click();
				break;
			}

		}

	}
	// ***************************************** /Select dropdownUtils/ ***********************************************************

	public void doSelectByVisibleText(By locator, String Text) {

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(Text);

	}

	public void doSelectByValue(By locator, String Value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(Value);

	}

	public void doSelectByIndex(By locator, int index) {

		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);

	}
	
	//******************************************* window Commands ****************************************************
	
	public void doMaximizeWindow() {
		driver.manage().window().maximize();

	}

	public void doPageTimeout() {
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

	}

	
	//************************************ without select Option **********************************************************
	
	public List<String> GetDopDownOptionList(By locator) {

		List<String> optionValueList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			optionValueList.add(text);

			/*
			 * String optiontext = e.getAttribute(text); System.out.println(optiontext);
			 */
		}

		return optionValueList;

	}

	public void selectDopDownOptionList(By locator, String value) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void clickDropDownValue(By locator, String value) {

		List<WebElement> optionList = getElements(locator);
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals("value")) {
				e.click();
				break;
			}
		}

	}
	
	
	/************************************* waitUtils **********************************************/
	
	
	public  Alert waitForAlert(int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public  String getAlertText(int timeOut) {
	     String text =  waitForAlert(timeOut).getText();
	     acceptAlert(timeOut);
	     return text;
	}

	public  void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismisstAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public  void sendKeysOnAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

	public  WebElement waitforElementpresence(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout); //no default constructor 
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public String waitForTitlesIs(String fullTitle, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.titleIs(fullTitle)));
		return driver.getTitle();
		
	}
	
	public String waitForUrlContains(String urlFraction, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.urlContains(urlFraction)))
		{
			return driver.getCurrentUrl();
		}
		
		return null;
		
	}
}
