package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProposalListPage extends BasePage {

	public ProposalListPage(WebDriver driver) {
		super(driver);
	}

	private By saveButton = By.xpath("//div[@class='modal-footer']//input[@type='submit']");
	private By closeButton = By.xpath("//div[@id='scanModal']//button[text()='Close']");
	private By accountHyperLink = By.xpath("//a[text()='Account']");
	private By proposalEditLink1st = By.xpath("//table/tbody/tr[1]/td//a[@class='k-button k-button-icontext k-grid-Edit']");

	public void closeSystemNamePopUp() {
		click(saveButton, 10);
	}

	public void closeProblemsDetectedPopUp() {
		click(closeButton, 10);
	}

	public void clickAccountHyperLink() {
		click(accountHyperLink, 10);
	}

	public void editFirstProposalOption() {
		click(proposalEditLink1st, 30);
	}
}
