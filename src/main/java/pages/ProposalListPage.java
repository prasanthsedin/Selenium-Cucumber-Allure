package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProposalListPage {
	WebDriver driver;

    public ProposalListPage(WebDriver driver) {
        this.driver = driver;
    }
    By saveButton = By.xpath("//div[@class='modal-footer']//child::input[@type='submit']");
    By closeButton = By.xpath("//div[@id='scanModal']//button[text()='Close']");
    By accountHyperLink = By.xpath("//a[text()='Account']");
    
    


    public void closeSytemNamePopUp() {
        driver.findElement(saveButton).click();
        
    }
    public void closeProblemsDetectedPopUp() {
        driver.findElement(closeButton).click();
        
    }
    public void clickAccountHyperLink() {
        driver.findElement(accountHyperLink).click();
        
    }
	

}
