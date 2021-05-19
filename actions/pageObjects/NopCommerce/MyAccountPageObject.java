package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import commons.AbstractPage;
import pageUIs.NopCommerce.LoginPageUI;
import pageUIs.NopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {

	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerInfoLink() {
		clickToElement(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);

	}

	public void updateCustomerInfo(String fName, String lName, String dob, String mob, String yob, String email,
			String companyName) {
		updateGender();
		updateFirstName(fName);
		updateLastName(lName);
		updateDayOfBirth(dob);
		updateMonthOfBirth(mob);
		updateYearOfBirth(yob);
		updateEmail(email);
		updateCompanyName(companyName);
		clickToSaveButton();
	}

	private void clickToSaveButton() {
		waitForElementIsClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	private void updateGender() {
		waitForElementIsDisplayed(driver, LoginPageUI.GENDER_RADIO);
		clickToElement(driver, LoginPageUI.GENDER_RADIO);
	}

	private void updateFirstName(String firstName) {
		waitForElementIsDisplayed(driver, LoginPageUI.FIRST_NAME_TEXTBOX);
		getElement(driver, LoginPageUI.FIRST_NAME_TEXTBOX).clear();
		sendKeyToElement(driver, LoginPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	private void updateLastName(String lasttName) {
		waitForElementIsDisplayed(driver, LoginPageUI.LAST_NAME_TEXTBOX);
		getElement(driver, LoginPageUI.LAST_NAME_TEXTBOX).clear();
		sendKeyToElement(driver, LoginPageUI.LAST_NAME_TEXTBOX, lasttName);
	}

	private void updateDayOfBirth(String day) {
		Select select = new Select(driver.findElement(getByXpath(LoginPageUI.DAY_COMBOBOX)));
		select.selectByVisibleText(day);
	}

	private void updateMonthOfBirth(String month) {
		Select select = new Select(driver.findElement(getByXpath(LoginPageUI.MONTH_COMBOBOX)));
		select.selectByVisibleText(month);
	}

	private void updateYearOfBirth(String year) {
		Select select = new Select(driver.findElement(getByXpath(LoginPageUI.YEAR_COMBOBOX)));
		select.selectByVisibleText(year);
	}

	private void updateEmail(String email) {
		waitForElementIsDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		getElement(driver, LoginPageUI.EMAIL_TEXTBOX).clear();
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	private void updateCompanyName(String value) {
		sendKeyToElement(driver, LoginPageUI.COMPANY_TEXTBOX, value);

	}

	public String getCustomerInfoFirstName() {
		// TODO Auto-generated method stub
		return getAtributeElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
	}

	public String getCustomerInforLastName() {
		// TODO Auto-generated method stub
		return getAtributeElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
	}

	public String getCustomerInforDOB() {
		// TODO Auto-generated method stub
		return getTextForSelectElement(driver, MyAccountPageUI.DAY_SELECT);
	}

	public String getCustomerInforMOB() {
		// TODO Auto-generated method stub
		return getTextForSelectElement(driver, MyAccountPageUI.MONTH_SELECT);
	}

	public String getCustomerInforYOB() {
		// TODO Auto-generated method stub
		return getTextForSelectElement(driver, MyAccountPageUI.YEAR_SELECT);
	}

	public void clickToCustomerInfoAddressLink() {
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
	}

	public void clickToAddressNewButton() {
		clickToElement(driver, MyAccountPageUI.ADDRESS_NEW_BUTTON);
	}

	public void enterAddressDetailInfo(String fName, String lName, String email, String company, String country,
			String state, String city, String add1, String add2, String code, String phone, String fax) {
		enterAddressFirtName(fName);
		enterAddressLastName(lName);
		enterAddressEmail(email);
		enterAddressCompany(company);
		enterAddressCountry(country);
		chooseAddressStateProvin(state);
		chooseAddressCity(city);
		enterAddress1(add1);
		enterAddress2(add2);
		enterAddressZipcode(code);
		enterAddressPhoneNumber(phone);
		enterAddressFaxNumber(fax);
		clickToAddressSaveButton();
	}

	private void clickToAddressSaveButton() {
		// TODO Auto-generated method stub
		clickToElement(driver, MyAccountPageUI.ADD_SAVE_BUTTON);
	}

	private void enterAddressFirtName(String fName) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_FNAME_TEXTBOX, fName);
		
	}

	private void enterAddressLastName(String lName) {
		// TODO Auto-generated method stub
		sendKeyToElement(driver, MyAccountPageUI.ADD_LNAME_TEXTBOX, lName);
		
	}

	private void enterAddressEmail(String email) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_EMAIL_TEXTBOX, email);
	
	}

	private void enterAddressCompany(String company) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_COMPANY_TEXTBOX, company);
		
	}

	private void enterAddressCountry(String country) {
		selectToElement(driver, MyAccountPageUI.ADD_COUNTRY_SELECT, country);
		
	}

	private void chooseAddressStateProvin(String state) {
		selectToElement(driver, MyAccountPageUI.ADD_STATE_SELECT, state);
		
	}

	private void chooseAddressCity(String city) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_CITY_TEXTBOX, city);
		
	}

	private void enterAddress1(String add1) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_ADDRESS1_TEXTBOX, add1);
		
	}

	private void enterAddress2(String add2) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_ADDRESS2_TEXTBOX, add2);
		
	}

	private void enterAddressZipcode(String code) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_CODE_TEXTBOX, code);
		
	}

	private void enterAddressPhoneNumber(String phone) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_PHONE_TEXTBOX, phone);
		
	}

	private void enterAddressFaxNumber(String fax) {
		sendKeyToElement(driver, MyAccountPageUI.ADD_FAX_TEXTBOX, fax);
		
	}

	public String getAddressCustomerInfo() {
		// TODO Auto-generated method stub
		return getTextElement(driver, MyAccountPageUI.ADDRESS_LISTBOX);
	}

	public void clickToChangePasswordLink() {
		clickToElement(driver, MyAccountPageUI.CHANGE_PASS_LINK);
		
	}

	public void enterChangePasswordInfo(String oldpass, String newpass) {
		// TODO Auto-generated method stub
		enterOldPassword(oldpass);
		enterNewPassword(newpass);
		enterConfirmPassword(newpass);
		clickToChangePasswordButton();
	}

	private void clickToChangePasswordButton() {
		// TODO Auto-generated method stub
		clickToElement(driver, MyAccountPageUI.CHANGE_PASS_BUTTON);
	}

	private void enterOldPassword(String oldPass) {
		// TODO Auto-generated method stub
		sendKeyToElement(driver, MyAccountPageUI.OLD_PASS_TEXTBOX, oldPass);
	}
	
	private void enterNewPassword(String newPass) {
		// TODO Auto-generated method stub
		sendKeyToElement(driver, MyAccountPageUI.NEW_PASS_TEXTBOX, newPass);
	}
	private void enterConfirmPassword(String confirmPass) {
		// TODO Auto-generated method stub
		sendKeyToElement(driver, MyAccountPageUI.CONFIRM_PASS_TEXTBOX, confirmPass);
	}

	public String getPasswordChangeSuccessDisplay() {
		// TODO Auto-generated method stub
		return getTextElement(driver, MyAccountPageUI.SUCCESS_MESSAGE);
	}


}
