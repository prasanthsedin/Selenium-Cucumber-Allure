package pages.AccountListPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.ExceptionHandler;

public class SalesOrderTab extends BasePage {

	By saleOrderTab = By.linkText("Sales Order");
	By actionsButton = By.xpath("//span[text()='Actions']");
	By editOptions = By.linkText("Edit Options");
	By printSalesAgreement = By.linkText("View/Print Sales Agreement");

	public SalesOrderTab(WebDriver driver) {
		super(driver);
	}

	public void clickOnSalesOrderTab() {
		try {
			click(saleOrderTab, 3);
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnSalesOrderTab", e);
		}
	}

	public void clickOnActions() {
		try {
			click(actionsButton, 3);
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnActions", e);
		}
	}

	public void clickOnEditOptions() {
		try {
			click(editOptions, 3);
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnEditOptions", e);
		}
	}

	public void clickOnPrintSalesAgreement() {
		try {
			click(printSalesAgreement, 3);
		} catch (Exception e) {
			ExceptionHandler.logException("clickOnPrintSalesAgreement", e);
		}
	}
}
