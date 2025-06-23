package pages.AccountListPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SalesOrderTab extends BasePage {

	private By saleOrderTab = By.linkText("Sales Order");
	private By actionsButton = By.xpath("//span[text()='Actions']");
	private By editOptions = By.linkText("Edit Options");
	private By printSalesAgreement = By.linkText("View/Print Sales Agreement");

	public SalesOrderTab(WebDriver driver) {
		super(driver);
	}

	public void clickOnSalesOrderTab() {
		click(saleOrderTab, 3);
	}

	public void clickOnActions() {
		click(actionsButton, 3);
	}

	public void clickOnEditOptions() {
		click(editOptions, 3);
	}

	public void clickOnPrintSalesAgreement() {
		click(printSalesAgreement, 3);
	}
}
