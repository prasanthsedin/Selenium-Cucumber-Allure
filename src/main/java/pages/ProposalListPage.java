package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CommonFunctions;
import utilities.ExceptionHandler;

public class ProposalListPage {
	WebDriver driver;
	CommonFunctions commonFunctions;

	public ProposalListPage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	By saveButton = By.xpath("//div[@class='modal-footer']//child::input[@type='submit']");
	By closeButton = By.xpath("//div[@id='scanModal']//button[text()='Close']");
	By accountHyperLink = By.xpath("//a[text()='Account']");
	By proposalEditLink1st = By.xpath("//table/tbody/tr[1]/td//a[@class='k-button k-button-icontext k-grid-Edit']");

	public void closeSytemNamePopUp() {
		try {
			driver.findElement(saveButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("closeSytemNamePopUp", e);
		}
	}

	public void closeProblemsDetectedPopUp() {
		try {
			driver.findElement(closeButton).click();
		} catch (Exception e) {
			ExceptionHandler.logException("closeProblemsDetectedPopUp", e);
		}
	}

	public void clickAccountHyperLink() {
		try {
			driver.findElement(accountHyperLink).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickAccountHyperLink", e);
		}
	}

	public void edit1stProposalOption() {
		try {
			commonFunctions.waitForElement(proposalEditLink1st, 3000);
			driver.findElement(proposalEditLink1st).click();
		} catch (Exception e) {
			ExceptionHandler.logException("edit1stProposalOption", e);
		}
	}
}
