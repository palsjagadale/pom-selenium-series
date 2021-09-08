package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.ProductInfoPage;
import com.qa.democart.pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	DriverFactory df;
	
	LoginPage loginpage;
	AccountsPage accPage;
	ResultsPage resultsPage;
	ProductInfoPage productInfoPage;

	
	@BeforeTest
	public void SetUp()
	{
		
		df=new DriverFactory();
		prop=df.initProperties();
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
 