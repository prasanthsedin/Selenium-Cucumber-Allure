package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.ExceptionHandler;

public class AccountDetailsPage extends BasePage {

	public AccountDetailsPage(WebDriver driver) {
		super(driver);
	}

	private By newButton = By.xpath("//a[@id='copy_prop']");
	private By brand = By.xpath("//li[@aria-controls='tabstrip-1']//a[@class='k-link']");
	private By brandSections = By.xpath("//div[contains(@class,'desktop')]//a[contains(text(),'Trane Split Gas/AC 90+% AFUE')]");
	private By proposalOptions = By.xpath("//a[contains(text(),'2 Ton Trane Split Gas 90%+')]");
	private By statusDropDown = By.id("opportunity_status_id");
	private By proposalOptionsToBeSold = By.xpath("//div[@id='available_options_gridbox']//table/tbody/tr[1]/td[1]/a");
	private By saveButton = By.xpath("//input[@name='commit']");
	private By opportunityDescription = By.id("opportunity_description");
	private By saveNowButton = By.xpath("//input[@value='Save Now']");
	private By frameLocator = By.className("fancybox-iframe");

	public void switchToAccountFrame() {
		switchToFrame(frameLocator, 20);
	}

	public void switchToDefaultContent() {
		super.switchToDefaultContent(); // Uses BasePage method
	}

	public void clickNewButton() {
		click(newButton, 20);
	}

	public void clickOnBrand() {
		click(brand, 10);
	}

	public void clickOnBrandSections() {
		click(brandSections, 10);
	}

	public void clickOnProposalOptions() {
		click(proposalOptions, 10);
	}

	public void fillOpportunityDescription(String description) {
		sendKeys(opportunityDescription, description, 10);
		click(saveNowButton, 10);
	}

	public void selectSOLDOptionFromStatusDropdown() {
		try {
			commonFunctions.refreshPage();
			commonFunctions.pause(5);
			new Select(waitForElement(statusDropDown, 10)).selectByVisibleText("Sold");
		} catch (Exception e) {
			ExceptionHandler.logException("selectSOLDOptionFromStatusDropdown", e);
			throw e;
		}
	}

	public void clickOnProposalOptionsToBeSold() {
		switchToFrame(frameLocator, 20);
		commonFunctions.pause(2);
		click(proposalOptionsToBeSold, 10);
	}

	public void clickOnSaveButton() {
		click(saveButton, 10);
		switchToDefaultContent();
	}
}
