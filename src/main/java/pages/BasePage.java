package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonFunctions;
import utilities.ExceptionHandler;

public class BasePage {

	protected WebDriver driver;
	protected CommonFunctions commonFunctions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	protected WebElement waitForElement(By locator, int timeoutInSeconds) {
		try {
			return commonFunctions.waitForElement(locator, timeoutInSeconds);
		} catch (Exception e) {
			ExceptionHandler.logException("waitForElement - locator: " + locator, e);
			throw e;
		}
	}

	protected void click(By locator, int timeoutInSeconds) {
		try {
			commonFunctions.clickElement(locator, timeoutInSeconds);
		} catch (Exception e) {
			ExceptionHandler.logException("click - locator: " + locator, e);
			throw e;
		}
	}

	protected void sendKeys(By locator, String text, int timeoutInSeconds) {
		try {
			commonFunctions.sendKeys(locator, text, timeoutInSeconds);
		} catch (Exception e) {
			ExceptionHandler.logException("sendKeys - locator: " + locator + ", text: " + text, e);
			throw e;
		}
	}

	protected void switchToFrame(By frameLocator, int timeoutInSeconds) {
		try {
			commonFunctions.switchToFrame(frameLocator, timeoutInSeconds);
		} catch (Exception e) {
			ExceptionHandler.logException("switchToFrame - locator: " + frameLocator, e);
			throw e;
		}
	}

	protected void switchToDefaultContent() {
		try {
			commonFunctions.switchToDefaultContent();
		} catch (Exception e) {
			ExceptionHandler.logException("switchToDefaultContent", e);
			throw e;
		}
	}
}
