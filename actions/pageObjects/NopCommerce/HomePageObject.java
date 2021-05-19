package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NopCommerce.HomePageUI;
import pageUIs.NopCommerce.LoginPageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		// TODO Auto-generated method stub
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForElementIsDisplayed(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToMyAccountLink() {
		waitForElementIsDisplayed(driver, LoginPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.MY_ACCOUNT_LINK);
	}

	public void clickToSearchLink() {
		clickToElement(driver, HomePageUI.SEARCH_LINK);
		
	}

}
