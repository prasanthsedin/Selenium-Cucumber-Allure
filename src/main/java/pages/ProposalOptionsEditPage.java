package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProposalOptionsEditPage extends BasePage {

	public ProposalOptionsEditPage(WebDriver driver) {
		super(driver);
	}

	private By financePlanDropdown = By.xpath("//span[contains(@id,'proposal_option_finance_plan_id')]");
	private By financePlanOption13 = By.xpath("//li[contains(@id,'proposal_option_finance_plan_id')][13]");

	public void selectFinancePlan13() {
		click(financePlanDropdown, 10);
		click(financePlanOption13, 10);
	}
}
