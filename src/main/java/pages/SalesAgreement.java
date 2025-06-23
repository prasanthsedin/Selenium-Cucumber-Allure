package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import utilities.ExceptionHandler;

public class SalesAgreement extends BasePage {

	public SalesAgreement(WebDriver driver) {
		super(driver);
	}

	private By closePreview = By.linkText("Close");

	public void closePreview() {
		click(closePreview, 10);
	}

	public void verifySaleAgreementTitle() {
		String expectedTitle = "Print Preview - Sales Agreement";
		String actualTitle = driver.getTitle();
		try {
			assertThat("Page title did not match", actualTitle, equalTo(expectedTitle));
		} catch (AssertionError ae) {
			ExceptionHandler.logException("verifySaleAgreementTitle - Assertion Failed", ae);
			throw ae;
		}
	}
}
