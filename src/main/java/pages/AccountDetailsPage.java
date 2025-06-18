package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonFunctions;
import utilities.ExceptionHandler;

public class AccountDetailsPage {

	WebDriver driver;
	CommonFunctions commonFunctions;

	public AccountDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	By newButton = By.xpath("//a[@id='copy_prop']");
	By brand = By.xpath("//li[@aria-controls='tabstrip-1']//child::a[@class='k-link']");
	By brandSections = By
			.xpath("//div[contains(@class,'desktop')]//a[contains(text(),'Trane Split Gas/AC 90+% AFUE')]");
	By proposalOptions = By.xpath("//a[contains(text(),'2 Ton Trane Split Gas 90%+')]");
	By statusDropDown = By.id("opportunity_status_id");
	By proposalOptionsToBeSold = By.xpath("//div[@id='available_options_gridbox']//table/tbody/tr[1]/td[1]/a");
	By saveButton = By.xpath("//input[@name='commit']");
	By opportunityDescription = By.id("opportunity_description");
	By saveNowButton = By.xpath("//input[@value='Save Now']");
	private By frameLocator = By.className("fancybox-iframe");

	public void switchToAccountFrame() {
		try {
			WebElement frame = driver.findElement(frameLocator);
			driver.switchTo().frame(frame);
		} catch (Exception e) {
			ExceptionHandler.logException("switchToAccountFrame", e);
		}
	}

	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			ExceptionHandler.logException("switchToDefaultContent", e);
		}
	}

	public void clickNewButton() {
		try {
			commonFunctions.waitForElement(newButton, 30);
			driver.findElement(newButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickNewButton", e);
		}
	}

	public void clickOnBrand() {
		try {
			driver.findElement(brand).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnBrand", e);
		}
	}

	public void clickOnBrandSections() {
		try {
			driver.findElement(brandSections).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnBrandSections", e);
		}
	}

	public void clickOnProposalOptions() {
		try {
			driver.findElement(proposalOptions).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnProposalOptions", e);
		}
	}

	public void fillOpportunityDescription() {
		try {
			driver.findElement(opportunityDescription).sendKeys("Test");
			driver.findElement(saveNowButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("fillOpportunityDescription", e);
		}
	}

	public void selectSOLDOptionFromStatusDropdown() {
		try {
			commonFunctions.refreshPage();
			commonFunctions.pause(5);
			new Select(driver.findElement(statusDropDown)).selectByVisibleText("Sold");
		} catch (Exception e) {
			ExceptionHandler.logException("selectSOLDOptionFromStatusDropdown", e);
		}
	}

	public void clickOnProposalOptionsToBeSold() {
		try {
			commonFunctions.switchToFrame(frameLocator, 30);
			commonFunctions.pause(2);
			driver.findElement(proposalOptionsToBeSold).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnProposalOptionsToBeSold", e);
		}
	}

	public void clickOnSaveButton() {
		try {
			driver.findElement(saveButton).click();
			commonFunctions.switchToDefaultContent();
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnSaveButton", e);
		}
	}
}
