package pages.AccountListPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonFunctions;

public class SalesOrderTab {
	WebDriver driver;
	CommonFunctions commonFunctions;
	
	public  SalesOrderTab(WebDriver driver) {
		this.driver=driver;
		 this.commonFunctions=new CommonFunctions(driver);
    }

    By saleOrderTab = By.linkText("Sales Order");
    By actionsButton = By.xpath("//span[text()='Actions']");
    By editOptions = By.linkText("Edit Options");
    By printSalesAgreement = By.linkText("View/Print Sales Agreement");
    

    public void clickOnSalesOrderTab() {
    	commonFunctions.waitForElement(saleOrderTab, 3000);
        driver.findElement(saleOrderTab).click();
    }
    public void clickOnActions() {
    	commonFunctions.waitForElement(actionsButton, 3000);
        driver.findElement(actionsButton).click();
    }
    public void clickOnEditOptions() {
        driver.findElement(editOptions).click();
    }
    public void clickOnPrintSalesAgreement() {
        driver.findElement(printSalesAgreement).click();
    }

}
