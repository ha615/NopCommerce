package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	protected AbstractPage getAbstractPage() {
		return new AbstractPage();
	}

	protected By getByXpath(String locator) {
		return By.xpath(locator);
	}

	protected String getTextElement(WebDriver driver, String locator) {
		waitForElementIsDisplayed(driver, locator);
		return driver.findElement(getByXpath(locator)).getText();
	}
	protected String getAtributeElement(WebDriver driver, String locator) {
		waitForElementIsDisplayed(driver, locator);
		return driver.findElement(getByXpath(locator)).getAttribute("value");
	}
	
	protected String getTextForSelectElement(WebDriver driver, String locator) {
		waitForElementIsDisplayed(driver, locator);
		Select select = new Select(getWebElement(driver, locator));
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}
	protected WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected WebElement getElement(WebDriver driver, String locator) {
		waitForElementIsDisplayed(driver, locator);
		return driver.findElement(getByXpath(locator));
	}
	
	protected void clickToElement(WebDriver driver, String locator) {
		waitForElementIsClickable(driver, locator);
		getElement(driver, locator).click();
	}
	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		waitForElementIsDisplayed(driver,locator);
		getElement(driver, locator).sendKeys(value);
	}
	
	protected void clickToRadioOrCheckbox(WebDriver driver, String locator) {
		waitForElementIsClickable(driver,locator);
		if(!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void selectToElement(WebDriver driver, String locator, String value) {
		waitForElementIsClickable(driver, locator);
		WebElement drlElement = driver.findElement(getByXpath(locator));
		Select select = new Select(drlElement);
		select.selectByVisibleText(value);
	}

	public void waitForElementIsClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
		
	}

	public void waitForElementIsDisplayed(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
		
	}
	private WebDriverWait explicitWait;
}
