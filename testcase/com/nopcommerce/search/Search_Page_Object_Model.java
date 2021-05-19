package com.nopcommerce.search;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.SearchPageObject;
import pageUIs.NopCommerce.SearchPageUI;

public class Search_Page_Object_Model extends AbstractTest{
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		HomePageObject homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		LoginPageObject loginPageObject = new LoginPageObject(driver);
		loginPageObject.enterInformationLogin(GlobalConstants.EMAIL_LOGIN, GlobalConstants.PASSWORD_LOGIN);
		//verify login sucsess
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToSearchLink();
	}
	@Test
	public void Search01_With_Empty_Data() {
		SearchPageObject searchPageObject = new SearchPageObject(driver);
		searchPageObject.enterSearchInfo("");
		shouldSeeThatWarningMessageDisplayed(searchPageObject.getWarningMessageDisplayed(SearchPageUI.SEARCH_TEXTBOX),"Search term minimum length is 3 characters");
	}
	
	@Test
	public void Search02_With_Data_Not_Exits() {
		SearchPageObject searchPageObject = new SearchPageObject(driver);
		searchPageObject.enterSearchInfo("Galaxy A71");
		shouldSeeThatWarningMessageDisplayed(searchPageObject.getWarningMessageDisplayed(SearchPageUI.SEARCH_TEXTBOX),"No products were found that matched your criteria.");
	}
	@Test
	public void Search03_With_Product_Name() {
		
	}
	@Test
	public void Search04_With_Product_Name() {
		
	}
	@Test
	public void AdvanceSearch05_With_Parent_Categories() {
		
	}
	@Test
	public void AdvanceSearch06_With_Sub_Categories() {
		
	}
	@Test
	public void AdvanceSearch07_With_Incorrect_Manufacture() {
		
	}
	@Test
	public void AdvanceSearch08_With_Correct_Manufacture() {
		
	}
	public void AdvanceSearch09_With_Price_Range_Scope() {
		
	}
	@Test
	public void AdvanceSearch10_With_Price_Range_Less_Than_Product_Range() {
		
	}
	@Test
	public void AdvanceSearch11_With_Price_Range_Big_Than_Product_Range() {
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
