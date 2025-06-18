package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CommonFunctions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import utilities.ExceptionHandler;

public class SalesAgreement {
	WebDriver driver;
	CommonFunctions commonFunctions;

	public SalesAgreement(WebDriver driver) {
		this.driver = driver;
		this.commonFunctions = new CommonFunctions(driver);
	}

	By closePreview = By.linkText("Close");

	public void closePreview() {
		try {
			driver.findElement(closePreview).click();
		} catch (Exception e) {
			ExceptionHandler.logException("closePreview", e);
		}
	}

	public void verifySaleAgreementTitle() {
		try {
			String expectedTitle = "Print Preview - Sales Agreement";
			String actualTitle = driver.getTitle();
			assertThat("Page title did not match", actualTitle, equalTo(expectedTitle));
		} catch (Exception e) {
			ExceptionHandler.logException("verifySaleAgreementTitle", e);
		}

	}
}
