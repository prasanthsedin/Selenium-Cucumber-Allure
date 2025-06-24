package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.AccountDetailsPage;
import pages.LoginPage;
import pages.ProposalListPage;
import pages.ProposalOptionsEditPage;
import pages.AccountListPage.AccountListPage;
import utilities.CommonFunctions;
import utilities.ConfigUtil;
import utilities.DriverFactory;
import utilities.ExceptionHandler;

public class FinancePlan {

    WebDriver driver;
    LoginPage loginPage;
    AccountListPage accountListPage;
    AccountDetailsPage accountDetailsPage;
    ProposalListPage proposalListPage;
    ProposalOptionsEditPage pOEditPage;
    CommonFunctions commonFunctions;

    @Before
    public void setup() {
        try {
            driver = DriverFactory.getDriver();
            loginPage = new LoginPage(driver);
            accountListPage = new AccountListPage(driver);
            accountDetailsPage = new AccountDetailsPage(driver);
            proposalListPage = new ProposalListPage(driver);
            pOEditPage = new ProposalOptionsEditPage(driver);
            commonFunctions = new CommonFunctions(driver);

            // Load URL safely
            String url = ConfigUtil.getUrl();
            driver.get(url);
        } catch (Exception e) {
            ExceptionHandler.logException("Error during test setup", e);
            throw new RuntimeException("Setup failed due to missing or incorrect configuration", e);
        }
    }

    @Given("Login to Application")
    public void login_to_application() {
        try {
            String username = ConfigUtil.getUsername();
            String password = ConfigUtil.getPassword();

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();
        } catch (Exception e) {
            ExceptionHandler.logException("Login failed", e);
            throw new RuntimeException("Login failed due to missing or incorrect credentials", e);
        }
    }

    @Then("Create a Account")
    public void create_a_account() {
        accountListPage.clickNewButton();
        accountListPage.enterFirstname("Test");
        accountListPage.enterLastname("Account_");
        accountListPage.clickSaveButton();
    }

    @Then("Add a Proposal to the account")
    public void add_a_proposal_to_the_account() {
        accountDetailsPage.clickNewButton();
        accountDetailsPage.switchToAccountFrame();
        accountDetailsPage.clickOnBrand();
        accountDetailsPage.clickOnBrandSections();
        accountDetailsPage.clickOnProposalOptions();
        accountDetailsPage.switchToDefaultContent();

        proposalListPage.closeSystemNamePopUp();
        proposalListPage.closeProblemsDetectedPopUp();
    }

    @Then("Click on Edit button for Proposal")
    public void click_on_edit_button_for_proposal() {
        proposalListPage.editFirstProposalOption();
    }

    @Then("Update a Finance Plan")
    public void update_a_finance_plan() {
        pOEditPage.selectFinancePlan13();
    }

    @Then("User logs out")
    public void user_logs_out() {
        commonFunctions.logout();
    }
}
