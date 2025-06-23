package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonFunctions;

public class BasePage {

	protected WebDriver driver;
	protected CommonFunctions commonFunctions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	protected WebElement waitForElement(By locator, int timeoutInSeconds) {
		return commonFunctions.waitForElement(locator, timeoutInSeconds);
	}

	protected void click(By locator, int timeoutInSeconds) {
		commonFunctions.clickElement(locator, timeoutInSeconds);
	}

	protected void sendKeys(By locator, String text, int timeoutInSeconds) {
		commonFunctions.sendKeys(locator, text, timeoutInSeconds);
	}

	protected void switchToFrame(By frameLocator, int timeoutInSeconds) {
		commonFunctions.switchToFrame(frameLocator, timeoutInSeconds);
	}

	protected void switchToDefaultContent() {
		commonFunctions.switchToDefaultContent();
	}
}
