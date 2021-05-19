package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;

public class Login_Page_Object_Model extends AbstractTest{
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
	}
	
	@Test
	public void Login01_With_empty_data() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin("", "");
		shouldSeeThatWarningMessageDisplayed(loginPage.verifyErrorMessage(), "Please enter your email");
	}
	@Test
	public void Login02_With_invalid_email() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin("12334", "123456a@");
		shouldSeeThatWarningMessageDisplayed(loginPage.verifyErrorMessage(), "Wrong email");
	}
	@Test
	public void Login03_With_email_not_registed() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin("12334@hotmail.com", "123456a@");
		shouldSeeThatWarningMessageDisplayed(loginPage.verifyNotRegistedEmailErrorMessage(), "No customer account found");
	}
	@Test
	public void Login04_With_email_registed_and_blank_password() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin("brian001@gmail.com", "");
		verifyInfomationByAssertTrue(loginPage.verifyNotRegistedEmailErrorMessage(), "The credentials provided are incorrect");
	}
	@Test
	public void Login05_Login_with_email_registed_and_invalid_password() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin("brian001@gmail.com", "123456");
		verifyInfomationByAssertTrue(loginPage.verifyNotRegistedEmailErrorMessage(), "The credentials provided are incorrect");
	}
	@Test
	public void Login06_With_email_registed_and_valid_password() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin(GlobalConstants.EMAIL_LOGIN, GlobalConstants.PASSWORD_LOGIN);
		verifyInfomationByAssertTrue(loginPage.verifySwitchHomePageSuccess(),"Log out");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
