package com.nopcommerce.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.RegisterPageObject;

public class Register_Page_Object_Model extends AbstractTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
	}
	//@Test
	public void Register01_with_empty_data() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("");
		registerPage.enterLastNameTextbox("");
		registerPage.chooseDayOfBirth("12");
		registerPage.chooseMonthOfBirth("March");
		registerPage.chooseYearOfBirth("1990");
		registerPage.enterEmailTextbox("");
		registerPage.clickToRegisterButton();
		shouldSeeThatWarningMessageDisplayed(registerPage.getInforWarningNameText(), "First name is required.");
	}
	//@Test
	public void Register02_with_invalid_email() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("John");
		registerPage.enterLastNameTextbox("Simple");
		registerPage.selectDateOfBirth("31", "February", "1983");
		registerPage.enterEmailTextbox("zzinzin.com.vn");
		registerPage.enterPasswordTextbox("123456");
		registerPage.enterConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		shouldSeeThatWarningMessageDisplayed(registerPage.getInforWarningEmailText(), "Wrong email");
	}
	//@Test
	public void Register03_with_email_already_exists() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("John");
		registerPage.enterLastNameTextbox("Simple");
		registerPage.selectDateOfBirth("31", "February", "1983");
		registerPage.enterEmailTextbox("brian001@gmail.com");
		registerPage.enterPasswordTextbox("123456");
		registerPage.enterConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		shouldSeeThatWarningMessageDisplayed(registerPage.getInforWarningEmailExistsText(), "The specified email already exists");
		
	}
	//@Test
	public void Register04_with_password_less_than_6_charactor() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("John");
		registerPage.enterLastNameTextbox("Simple");
		registerPage.selectDateOfBirth("31", "February", "1983");
		registerPage.enterEmailTextbox("brian001@gmail.com");
		registerPage.enterPasswordTextbox("12345");
		registerPage.enterConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		verifyInfomationByAssertTrue(registerPage.getInforWarningPasswordLessThan6Text(), "must have at least 6 characters");
	}
	//@Test
	public void Register05_with_confirm_password_mismatched_password() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("John");
		registerPage.enterLastNameTextbox("Simple");
		registerPage.selectDateOfBirth("31", "February", "1983");
		registerPage.enterEmailTextbox("brian001@gmail.com");
		registerPage.enterPasswordTextbox("123456");
		registerPage.enterConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		verifyInfomationByAssertTrue(registerPage.getInforWarningPasswordMismatchText(), "The password and confirmation password do not match.");
	}
	@Test
	public void Register06_with_valid_data() {
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		RegisterPageObject registerPage = new RegisterPageObject(driver);
		registerPage.clickToGenderCheckbox();
		registerPage.enterFirstNameTextbox("John");
		registerPage.enterLastNameTextbox("Simple");
		registerPage.selectDateOfBirth("31", "February", "1983");
		registerPage.enterEmailTextbox(getRandomEmail());
		registerPage.enterPasswordTextbox("123456");
		registerPage.enterConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		shouldSeeThatWarningMessageDisplayed(registerPage.getInforRegisterSuccessText(), "Your registration completed");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
