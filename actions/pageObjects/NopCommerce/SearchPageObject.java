package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NopCommerce.SearchPageUI;

public class SearchPageObject extends AbstractPage{
	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterSearchInfo(String keyword) {
		enterSearchKeyword(keyword);
		clikToSearchButton();	
	}
	private void enterSearchKeyword(String value) {
		sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
		
	}
	private void clikToSearchButton() {
		// TODO Auto-generated method stub
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	public String getWarningMessageDisplayed(String warnigMessage) {
		// TODO Auto-generated method stub
		return getTextElement(driver, warnigMessage);
	}

}
