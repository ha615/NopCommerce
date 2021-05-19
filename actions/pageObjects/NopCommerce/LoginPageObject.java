package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NopCommerce.LoginPageUI;

public class LoginPageObject extends AbstractPage{

	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterEmailTextbox(String email) {
		waitForElementIsDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForElementIsDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementIsClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public void enterInformationLogin(String email, String password) {
		// TODO Auto-generated method stub
		enterEmailTextbox(email);
		enterPasswordTextbox(password);
		clickToLoginButton();
	}
	public String verifyErrorMessage() {
		// TODO Auto-generated method stub
		return getTextElement(driver, LoginPageUI.EMAIL_WARNING);
	}
	public String verifyNotRegistedEmailErrorMessage() {
		waitForElementIsDisplayed(driver, LoginPageUI.UNREGISTED_EMAIL_WARNING);
		return getTextElement(driver, LoginPageUI.UNREGISTED_EMAIL_WARNING);
	}
	public String verifySwitchHomePageSuccess() {
		waitForElementIsDisplayed(driver, LoginPageUI.LOGOUT_LINK);
		return getTextElement(driver, LoginPageUI.LOGOUT_LINK);
	}

}
