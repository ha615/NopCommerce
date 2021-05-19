package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.MyAccountPageObject;

public class My_Account_Page_Object_Model extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		HomePageObject homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterInformationLogin(GlobalConstants.EMAIL_LOGIN, GlobalConstants.PASSWORD_LOGIN);
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		sleepInSecond(5);
	}

	// @Test
	public void MyAccount01_Edit_Customer_Info() {
		MyAccountPageObject myAccountPage = new MyAccountPageObject(driver);
		myAccountPage.clickToCustomerInfoLink();
		myAccountPage.updateCustomerInfo("hay", "co gang", "16", "February", "1983", "ha514@outlook.com", "FPT-IS");
		shouldSeeThatWarningMessageDisplayed(myAccountPage.getCustomerInfoFirstName(), "hay");
		shouldSeeThatWarningMessageDisplayed(myAccountPage.getCustomerInforLastName(), "co gang");
		shouldSeeThatWarningMessageDisplayed(myAccountPage.getCustomerInforDOB(), "16");
		shouldSeeThatWarningMessageDisplayed(myAccountPage.getCustomerInforMOB(), "February");
		shouldSeeThatWarningMessageDisplayed(myAccountPage.getCustomerInforYOB(), "1983");
	}

	@Test
	public void MyAccount02_Edit_Addresses_Info() {
		MyAccountPageObject myAccountPageObject = new MyAccountPageObject(driver);
		myAccountPageObject.clickToCustomerInfoAddressLink();
		myAccountPageObject.clickToAddressNewButton();
		myAccountPageObject.enterAddressDetailInfo("Su", "BoA", "susu@yahoo.com", "KSB", "Korea", "Other", "Seoul",
				"South Kong", "North Zing", "048", "0988280577", "098-676767");
		verifyInfomationByAssertTrue(myAccountPageObject.getAddressCustomerInfo(), "susu@yahoo.com");
	}

	@Test
	public void MyAccount03_Edit_Change_Password_Info() {
		MyAccountPageObject myAccountPageObject = new MyAccountPageObject(driver);
		myAccountPageObject.clickToChangePasswordLink();
		myAccountPageObject.enterChangePasswordInfo("12345678","123456a@");
		shouldSeeThatWarningMessageDisplayed(myAccountPageObject.getPasswordChangeSuccessDisplay(),"Password was changed");
	}

	@Test
	public void MyAccount04_My_Product_Review_Info() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
