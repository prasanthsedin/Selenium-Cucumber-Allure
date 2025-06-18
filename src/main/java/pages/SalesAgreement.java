package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dev.failsafe.internal.util.Assert;
import utilities.CommonFunctions;

public class SalesAgreement {
	WebDriver driver;
	CommonFunctions commonFunctions;

    public SalesAgreement(WebDriver driver) {
        this.driver = driver; 
        this.commonFunctions=new CommonFunctions(driver); 
    }
    
   
    By closePreview = By.linkText("Close");
    
    
    public void closePreview() {
    	commonFunctions.switchToLastWindow();
        driver.findElement(closePreview).click();
    }
    
    public void verifySaleAgreementTitle() {
    	Assert.isTrue(commonFunctions.verifyPageTitle("Print Preview - Sales Agreement"), "Page title did not match");
    	commonFunctions.closeCurrentWindowAndSwitchBackToMain();
    }

}
