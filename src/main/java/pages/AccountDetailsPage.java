package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonFunctions;

public class AccountDetailsPage  {
	
	WebDriver driver;
	CommonFunctions commonFunctions;
    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.commonFunctions=new CommonFunctions(driver);
        
    }
    
    By newButton = By.xpath("//a[@id='copy_prop']");
    By brand = By.xpath("//li[@aria-controls='tabstrip-1']//child::a[@class='k-link']");
    By brandSections = By.xpath("//div[contains(@class,'desktop')]//a[contains(text(),'Trane Split Gas/AC 90+% AFUE')]");
    By proposalOptions = By.xpath("//a[contains(text(),'2 Ton Trane Split Gas 90%+')]");
    By statusDropDown = By.id("opportunity_status_id");
    By proposalOptionsToBeSold= By.xpath("//div[@id='available_options_gridbox']//table/tbody/tr[1]/td[1]/a");
    By saveButton = By.xpath("//input[@name='commit']");
    By opportunityDescription = By.id("opportunity_description");
    By saveNowButton = By.xpath("//input[@value='Save Now']");
    
    private By frameLocator = By.className("fancybox-iframe");

    public void switchToAccountFrame() {
        WebElement frame = driver.findElement(frameLocator);
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    

    public void clickNewButton() {
    	commonFunctions.waitForElement(newButton, 3000);
        driver.findElement(newButton).click();
    }
    public void clickOnBrand() {
        driver.findElement(brand).click();
    }
    public void clickOnBrandSections() {
        driver.findElement(brandSections).click();
    }
    public void clickOnProposalOptions() {
        driver.findElement(proposalOptions).click();
    }
    public void fillOpportunityDescription() {
        driver.findElement(opportunityDescription).sendKeys("Test");
        driver.findElement(saveNowButton).click();
    }
    
    public void selectSOLDOptionFromStatusDropdown() {
    	commonFunctions.refreshPage();
    	commonFunctions.pause(5);
        new Select(driver.findElement(statusDropDown)).selectByVisibleText("Sold");
    }
    public void clickOnProposalOptionsToBeSold() {
    	commonFunctions.switchToFrame(frameLocator, 3000);
    	commonFunctions.pause(2);
        driver.findElement(proposalOptionsToBeSold).click();
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButton).click();
        commonFunctions.switchToDefaultContent();
    }

}
