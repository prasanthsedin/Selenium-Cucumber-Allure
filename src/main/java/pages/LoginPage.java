package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ExceptionHandler;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//input[@id='user_session_username']");
	By password = By.id("user_session_password");
	By signinBtn = By.xpath("//input[@value='SIGN IN']");

	public void enterUsername(String user) {
		try {
			driver.findElement(username).sendKeys(user);
		} catch (Exception e) {
			ExceptionHandler.logException("enterUsername", e);
		}
	}

	public void enterPassword(String pass) {
		try {
			driver.findElement(password).sendKeys(pass);
		} catch (Exception e) {
			ExceptionHandler.logException("enterPassword", e);
		}
	}

	public void clickLogin() {
		try {
			driver.findElement(signinBtn).click();
		} catch (Exception e) {
			ExceptionHandler.logException("clickLogin", e);
		}
	}
}
