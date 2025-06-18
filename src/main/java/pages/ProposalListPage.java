package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonFunctions;

public class ProposalListPage {
	WebDriver driver;
	CommonFunctions commonFunctions; 
    public ProposalListPage(WebDriver driver) {
        this.driver = driver;
        this.commonFunctions=new CommonFunctions(driver); 
    }
    By saveButton = By.xpath("//div[@class='modal-footer']//child::input[@type='submit']");
    By closeButton = By.xpath("//div[@id='scanModal']//button[text()='Close']");
    By accountHyperLink = By.xpath("//a[text()='Account']");
    By proposalEditLink1st = By.xpath("//table/tbody/tr[1]/td//a[@class='k-button k-button-icontext k-grid-Edit']");
    


    public void closeSytemNamePopUp() {
        driver.findElement(saveButton).click();
        
    }
    public void closeProblemsDetectedPopUp() {
        driver.findElement(closeButton).click();
        
    }
    public void clickAccountHyperLink() {
        driver.findElement(accountHyperLink).click();
        
    }
    public void edit1stProposalOption() {
    	commonFunctions.waitForElement(proposalEditLink1st, 3000);
    	driver.findElement(proposalEditLink1st).click();
    }
	

}
