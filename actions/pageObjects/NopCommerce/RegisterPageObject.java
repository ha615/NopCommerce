package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NopCommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{

	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderCheckbox() {
		// TODO Auto-generated method stub
		clickToRadioOrCheckbox(driver,RegisterPageUI.GENDER_RADIO);
		
	} 

	public void enterFirstNameTextbox(String firstName) {
		// TODO Auto-generated method stub
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void chooseDayOfBirth(String value) {
		selectToElement(driver, RegisterPageUI.DOB_SELECT, value);
	}

	public void chooseMonthOfBirth(String value) {
		selectToElement(driver, RegisterPageUI.MOB_SELECT, value);
		
	}

	public void chooseYearOfBirth(String value) {
		selectToElement(driver, RegisterPageUI.YOB_SELECT, value);
		
	}

	public void enterEmailTextbox(String value) {
		waitForElementIsDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, value);
	}

	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getInforWarningNameText() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.WARNING_NAME_TEXT);
	}
	public String getInforWarningEmailText() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.WARNING_EMAIL_TEXT);
	}
	public String getInforWarningEmailExistsText() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.WARNING_EMAIL_EXISTS_TEXT);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
		chooseDayOfBirth(day);
		chooseMonthOfBirth(month);
		chooseYearOfBirth(year);
	}

	public void enterPasswordTextbox(String value) {
		waitForElementIsDisplayed(driver, RegisterPageUI.PASSWORD_TEXTBOX);	
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, value);
	}

	public void enterConfirmPasswordTextbox(String value) {
		waitForElementIsDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);	
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, value);		
	}

	public String getInforWarningPasswordLessThan6Text() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.WARNING_PASSWORD_TEXT);
	}

	public String getInforWarningPasswordMismatchText() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.WARNING_CONFIRM_PASSWORD_TEXT);
	}

	public String getInforRegisterSuccessText() {
		// TODO Auto-generated method stub
		return getTextElement(driver, RegisterPageUI.INFO_SUCCESS);
	}
}
