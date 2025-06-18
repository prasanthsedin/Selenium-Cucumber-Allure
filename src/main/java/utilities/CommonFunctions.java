package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonFunctions {

	private WebDriver driver;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	// Locators for logout
	private final By menu = By.xpath("//span[text()='Sedstart Automation ']");
	private final By logoutButton = By.linkText("Log Out");

	public void logout() {
		try {
			clickElement(menu, 30);
			clickElement(logoutButton, 30);
		} catch (Exception e) {
			ExceptionHandler.logException("logout", e);
			throw e;
		}
	}

	public WebElement waitForElement(By locator, int timeoutInSeconds) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
					.ignoring(ElementNotInteractableException.class).ignoring(StaleElementReferenceException.class);

			return wait.until(driver -> {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed() && element.isEnabled()) {
					return element;
				}
				return null;
			});
		} catch (Exception e) {
			ExceptionHandler.logException("waitForElement - locator: " + locator, e);
			throw e;
		}
	}

	public void clickElement(By locator, int timeoutInSeconds) {
		try {
			WebElement element = waitForElement(locator, timeoutInSeconds);
			element.click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickElement - locator: " + locator, e);
			throw e;
		}
	}

	public void sendKeys(By locator, String text, int timeoutInSeconds) {
		try {
			WebElement element = waitForElement(locator, timeoutInSeconds);
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			ExceptionHandler.logException("sendKeys - locator: " + locator + ", text: " + text, e);
			throw e;
		}
	}

	public void switchToFrame(By frameLocator, int timeoutInSeconds) {
		try {
			WebElement frame = waitForElement(frameLocator, timeoutInSeconds);
			driver.switchTo().frame(frame);
		} catch (Exception e) {
			ExceptionHandler.logException("switchToFrame - locator: " + frameLocator, e);
			throw e;
		}
	}

	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			ExceptionHandler.logException("switchToDefaultContent", e);
			throw e;
		}
	}

	public void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			ExceptionHandler.logException("refreshPage", e);
			throw e;
		}
	}

	public void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			ExceptionHandler.logException("pause", e);
		}
	}

	public List<String> getWindowHandlesList() {
		try {
			Set<String> handles = driver.getWindowHandles();
			return new ArrayList<>(handles);
		} catch (Exception e) {
			ExceptionHandler.logException("getWindowHandlesList", e);
			throw e;
		}
	}

	public void switchToWindowByIndex(int index) {
		try {
			List<String> windows = getWindowHandlesList();
			if (index >= 0 && index < windows.size()) {
				driver.switchTo().window(windows.get(index));
			} else {
				throw new RuntimeException("Window index " + index + " not found");
			}
		} catch (Exception e) {
			ExceptionHandler.logException("switchToWindowByIndex", e);
			throw e;
		}
	}

	public void switchToLastWindow() {
		try {
			List<String> windows = getWindowHandlesList();
			driver.switchTo().window(windows.get(windows.size() - 1));
		} catch (Exception e) {
			ExceptionHandler.logException("switchToLastWindow", e);
			throw e;
		}
	}

	public void closeCurrentWindowAndSwitchBackToMain() {
		try {
			driver.close();
			List<String> windows = getWindowHandlesList();
			if (!windows.isEmpty()) {
				driver.switchTo().window(windows.get(0));
			}
		} catch (Exception e) {
			ExceptionHandler.logException("closeCurrentWindowAndSwitchBackToMain", e);
			throw e;
		}
	}

	public String getCurrentWindowTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			ExceptionHandler.logException("getCurrentWindowTitle", e);
			throw e;
		}
	}

	public boolean verifyPageTitle(String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			System.out.println("Actual title: " + actualTitle);
			return actualTitle.equals(expectedTitle);
		} catch (Exception e) {
			ExceptionHandler.logException("verifyPageTitle", e);
			throw e;
		}
	}
}
