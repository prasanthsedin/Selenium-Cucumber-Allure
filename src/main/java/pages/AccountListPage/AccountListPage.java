package pages.AccountListPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonFunctions;

public class AccountListPage {
	WebDriver driver;

    CommonFunctions commonFunctions;

    public AccountListPage(WebDriver driver) {
        this.driver = driver;
        this.commonFunctions=new CommonFunctions(driver);
    }

    By newButton = By.xpath("//div[@id='tabstrip-1']//a[text()='New']");
    By firstName = By.xpath("//input[@id='first_name']");
    By lastName = By.xpath("//input[@id='last_name']");
    By saveButton = By.xpath("//button[text()='Save']");

    public void clickNewButton() {
    	commonFunctions.waitForElement(newButton, 3000);
        driver.findElement(newButton).click();
    }
    public void enterFirstname(String name){

    	commonFunctions.waitForElement(firstName, 3000);
        driver.findElement(firstName).sendKeys(name);
    }
    public void enterLastname(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
    
	

}
