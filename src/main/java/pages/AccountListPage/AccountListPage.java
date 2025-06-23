package pages.AccountListPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class AccountListPage extends BasePage {

	public AccountListPage(WebDriver driver) {
		super(driver);
	}

	private By newButton = By.xpath("//div[@id='tabstrip-1']//a[text()='New']");
	private By firstName = By.xpath("//input[@id='first_name']");
	private By lastName = By.xpath("//input[@id='last_name']");
	private By saveButton = By.xpath("//button[text()='Save']");

	public void clickNewButton() {
		click(newButton, 10);
	}

	public void enterFirstname(String name) {
		sendKeys(firstName, name, 10);
	}

	public void enterLastname(String name) {
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
		sendKeys(lastName, name + timeStamp, 10);
	}

	public void clickSaveButton() {
		click(saveButton, 10);
	}
}
