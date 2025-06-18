package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.AccountDetailsPage;
import pages.LoginPage;
import pages.ProposalListPage;
import pages.ProposalOptionsEditPage;
import pages.AccountListPage.AccountListPage;
import utilities.CommonFunctions;
import utilities.DriverFactory;

public class FinancePlan {

    WebDriver  driver = DriverFactory.getDriver();;
    LoginPage loginPage = new LoginPage(driver);;
    AccountListPage accountListPage = new AccountListPage(driver);
	AccountDetailsPage accountDetailsPage= new AccountDetailsPage(driver);
	ProposalListPage proposalListPage=new ProposalListPage(driver);
	ProposalOptionsEditPage pOEditPage = new ProposalOptionsEditPage(driver);
	CommonFunctions commonFunctions = new CommonFunctions(driver);

	@Given("Login to Application with {string} and password {string}")
	public void login_to_application_with_credentials(String username, String password) {
		
        driver.get("https://uat.pricebookplus.com/login");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    
    @Then("Create a Account")
    public void create_a_account() throws Throwable {

		accountListPage.clickNewButton();
		accountListPage.enterFirstname("Test");
		accountListPage.enterLastname("Account "+(int)(Math.random() * 10000));
		accountListPage.clickSaveButton();
    }

	@Then("Add a Proposal to the account")
	public void add_a_proposal_to_the_account() throws Throwable {
		
		accountDetailsPage.clickNewButton();
		accountDetailsPage.switchToAccountFrame();
		accountDetailsPage.clickOnBrand();
		accountDetailsPage.clickOnBrandSections();
		accountDetailsPage.clickOnProposalOptions();
		accountDetailsPage.switchToDefaultContent();
		
		proposalListPage.closeSytemNamePopUp();
		proposalListPage.closeProblemsDetectedPopUp();
		
	}
	@Then("Click on Edit button for Proposal")
	public void click_on_edit_button_for_proposal() {
		proposalListPage.edit1stProposalOption();
	}
	@Then("Update a Finance Plan")
	public void update_a_finance_plan() {
		
		pOEditPage.selectAFinancePlan();
	}
	@Then("User logs out")
	public void user_logs_out() {
		commonFunctions.logout();
	}
}
