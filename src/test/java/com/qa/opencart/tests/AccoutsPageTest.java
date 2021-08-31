package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccoutsPageTest extends BaseTest {

	@BeforeClass
	public void accpageSetup()
	{
		accPage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password")); 
	}
	 
	
	@Test(priority=1)
	public void accPageTitle()
	{
		String title = accPage.getAccPageTitle();
		System.out.println("Account page title :" + title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void accPageHeader()
	{
		String header = accPage.getAccPageHeader();
		System.out.println("Account page title :" + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER);
	}	
	
	@Test(priority=3)
	public void accSectionList()
	{
		List<String> actAccsecList = accPage.getAccSectionsList();
		System.out.println("Account sections List :" +actAccsecList );
		Assert.assertEquals(actAccsecList, Constants.EXPECTED_ACCOUNT_SECTION_LIST);
	}
	
	@Test(priority=4)
	public void logoutLinkExistTest()
	{
		Assert.assertTrue(accPage.logoutLinkExist());
	}
	
	
	@DataProvider
	public Object [][] getSearchData(){
		return new Object[][] {
			{"MackBook Pro"},
			{"MackBook Air"},
			{"Apple"}
		};
			
		}
	
	
	@Test(priority=5, dataProvider="getSearchData")
	public void searchTest(String productName){
		resultsPage = accPage.doSearch(productName);
		String resultHeader = resultsPage.getSearchpageHeader();
		System.out.println("Result Header:"+ resultHeader);
		Assert.assertTrue(resultHeader.contains(productName));
	}
}
