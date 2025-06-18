package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CommonFunctions;
import utilities.ExceptionHandler;

public class ProposalOptionsEditPage {
	WebDriver driver;
	CommonFunctions commonFunctions;

	public ProposalOptionsEditPage(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	By financePlanDrropdown = By.xpath("//span[contains(@id,'proposal_option_finance_plan_id')]");
	By financePlan13 = By.xpath("//li[contains(@id,'proposal_option_finance_plan_id')][13]");

	public void selectAFinancePlan() {
		try {
			commonFunctions.waitForElement(financePlanDrropdown, 3000);
			driver.findElement(financePlanDrropdown).click();
			commonFunctions.waitForElement(financePlan13, 3000);
			driver.findElement(financePlan13).click();
		} catch (Exception e) {
			ExceptionHandler.logException("selectAFinancePlan", e);
		}
	}
}
