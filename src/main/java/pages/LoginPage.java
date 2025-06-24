package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By username = By.xpath("//input[@id='user_session_username']");
	private By password = By.id("user_session_password");
	private By signinBtn = By.xpath("//input[@value='SIGN IN']");

	public void enterUsername(String user) {
		sendKeys(username, user, 10);
	}

	public void enterPassword(String pass) {
		sendKeys(password, pass, 10);
	}

	public void clickLogin() {
		click(signinBtn, 10);
	}
}
