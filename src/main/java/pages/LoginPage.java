package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.xpath("//input[@id='user_session_username']");
    By password = By.id("user_session_password");
    By signinBtn = By.xpath("//input[@value='SIGN IN']");

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }


	public void clickLogin() {
		driver.findElement(signinBtn).click();
		
	}
}