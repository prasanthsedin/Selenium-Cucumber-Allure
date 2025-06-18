package pages.AccountListPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CommonFunctions;
import utilities.ExceptionHandler;

public class AccountListPage {
	WebDriver driver;
	CommonFunctions commonFunctions;

	public AccountListPage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	By newButton = By.xpath("//div[@id='tabstrip-1']//a[text()='New']");
	By firstName = By.xpath("//input[@id='first_name']");
	By lastName = By.xpath("//input[@id='last_name']");
	By saveButton = By.xpath("//button[text()='Save']");

	public void clickNewButton() {
		try {
			commonFunctions.waitForElement(newButton, 3000);
			driver.findElement(newButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickNewButton", e);
		}
	}

	public void enterFirstname(String name) {
		try {
			commonFunctions.waitForElement(firstName, 3000);
			driver.findElement(firstName).sendKeys(name);
		} catch (Exception e) {
			ExceptionHandler.logException("enterFirstname", e);
		}
	}

	public void enterLastname(String name) {
		try {

			String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
			driver.findElement(lastName).sendKeys(name+timeStamp);
		} catch (Exception e) {
			ExceptionHandler.logException("enterLastname", e);
		}
	}

	public void clickSaveButton() {
		try {
			driver.findElement(saveButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickSaveButton", e);
		}
	}
}
