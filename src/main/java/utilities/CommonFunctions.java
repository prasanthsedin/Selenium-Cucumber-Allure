package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonFunctions {

	 private WebDriver driver;

	    public CommonFunctions(WebDriver driver) {
	        this.driver = driver;
	    }

	    By menu = By.xpath("//span[text()='Sedstart Automation ']");
	    By logoutButton = By.linkText("Log Out");
	    
	    public void logout() {
	    	WebElement menuButton=waitForElement(menu, 30000);
	    	menuButton.click();
	    	WebElement logOutButton=waitForElement(logoutButton, 30000);
	    	logOutButton.click();

	    	
	    }
	   
	    public WebElement waitForElement(By locator, int timeoutInSeconds) {
	        FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class)
	                .ignoring(ElementNotInteractableException.class)
	                .ignoring(StaleElementReferenceException.class);

	        return wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                WebElement element = driver.findElement(locator);
	                if (element.isDisplayed() && element.isEnabled()) {
	                    return element;
	                }
	                return null;
	            }
	        });
	    }

	    public void switchToFrame(By frameLocator, int timeoutInSeconds) {
	        WebElement frame = waitForElement(frameLocator, timeoutInSeconds);
	        driver.switchTo().frame(frame);
	    }

	    
	    public void switchToDefaultContent() {
	        driver.switchTo().defaultContent();
	    }
	    
	    public void refreshPage() {
	        driver.navigate().refresh();
	    }
	    
//	    public void waitUntilConditionMet(Supplier<Boolean> condition, int timeoutSeconds) {
//	        long endTime = System.currentTimeMillis() + timeoutSeconds * 1000;
//	        while (System.currentTimeMillis() < endTime) {
//	            try {
//	                if (condition.get()) return;
//	            } catch (Exception ignored) {}
//	            try {
//	                Thread.sleep(5000);
//	            } catch (InterruptedException ignored) {}
//	        }
//	        throw new TimeoutException("Condition not met within timeout");
//	    }
	    public void pause(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	    
	    //  Get all window handles as a List
	    public List<String> getWindowHandlesList() {
	        Set<String> handles = driver.getWindowHandles();
	        return new ArrayList<>(handles);
	    }

	    //  Switch to a window by index (0 = main/original)
	    public void switchToWindowByIndex(int index) {
	        List<String> windows = getWindowHandlesList();
	        if (index < windows.size()) {
	            driver.switchTo().window(windows.get(index));
	        } else {
	            throw new RuntimeException("Window index " + index + " not found");
	        }
	    }

	    //  Switch to the last (newest) window
	    public void switchToLastWindow() {
	        List<String> windows = getWindowHandlesList();
	        driver.switchTo().window(windows.get(windows.size() - 1));
	    }

	    //  Close current window and return to the first/main one
	    public void closeCurrentWindowAndSwitchBackToMain() {
	        driver.close();
	        List<String> windows = getWindowHandlesList();
	        if (!windows.isEmpty()) {
	            driver.switchTo().window(windows.get(0));
	        }
	    }

	    //  Get current window title
	    public String getCurrentWindowTitle() {
	        return driver.getTitle();
	    }
	    
	    public boolean verifyPageTitle(String expectedTitle) {
	        String actualTitle = driver.getTitle();
	        System.out.println("Actual title: " + actualTitle);
	        return actualTitle.equals(expectedTitle);
	    }
	    
}
