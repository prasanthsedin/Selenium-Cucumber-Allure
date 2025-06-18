package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User launches the browser")
    public void launchBrowser() {
        driver = DriverFactory.getDriver();
        driver.get("https://uat.pricebookplus.com/login"); 
        loginPage = new LoginPage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("User clicks siginin button")
    public void clickLogin() {
        loginPage.clickLogin();
    }
}
