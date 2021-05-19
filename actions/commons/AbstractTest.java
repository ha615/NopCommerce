package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AbstractTest {
	private WebDriver driver;
	
	private String localPath = System.getProperty("user.dir");

	private enum BROWSERS{
		FIREFOX, CHROME, IE, SAFARY, EDGE_LAGACY, EDGE_CHROMIUM, H_FIREFOX, H_CHROME;
	}
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSERS browser = BROWSERS.valueOf(browserName.toUpperCase());
		if(browser == BROWSERS.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", localPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser == BROWSERS.valueOf(browserName.toUpperCase())) {
			System.setProperty("webdriver.chrome.driver", localPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser == BROWSERS.valueOf(browserName.toUpperCase())) {
			System.setProperty("webdriver.edge.driver", localPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new RuntimeException("Please enter browser valid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.NOPCOMMERCE_URL);
		return driver;
	}
	
	protected void shouldSeeThatWarningMessageDisplayed(String actualMessga, String expectedMessage) {
		Assert.assertEquals(actualMessga, expectedMessage);
	}
	
	protected void verifyInfomationByAssertTrue(String actualMessage, String expectedMessage) {
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	protected void sleepInSecond(long times) {
		try {
			Thread.sleep(times*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getRandomEmail() {
		Random rand = new Random();
		return "zinzin" + rand.nextInt(9999) + "@yahoo.com";
	}
}
