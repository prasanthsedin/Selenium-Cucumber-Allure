package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountDetailsPage;
import pages.ProposalListPage;
import pages.SalesAgreement;
import pages.AccountListPage.AccountListPage;
import pages.AccountListPage.SalesOrderTab;
import utilities.CommonFunctions;
import utilities.DriverFactory;

public class SalesOrderTabActionsForSOLDOpportunities  {
	
	WebDriver driver = DriverFactory.getDriver();;
	AccountListPage accountListPage = new AccountListPage(driver);
	AccountDetailsPage accountDetailsPage= new AccountDetailsPage(driver);
	ProposalListPage proposalListPage=new ProposalListPage(driver);
	SalesOrderTab salesOrderTab = new SalesOrderTab(driver);
	SalesAgreement salesAgreement = new SalesAgreement(driver);
	CommonFunctions commonFunctions = new CommonFunctions(driver);
	
	@Then("Create a Account")
    public void create_a_account() throws Throwable {

		accountListPage.clickNewButton();
		accountListPage.enterFirstname("Test");
		accountListPage.enterLastname("Account "+(int)(Math.random() * 100));
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
		proposalListPage.clickAccountHyperLink();
		
	}
	@Then("SOLD Proposal in account page")
	public void sold_proposal_in_account_page() throws Throwable {
	    accountDetailsPage.selectSOLDOptionFromStatusDropdown();
	    accountDetailsPage.clickOnProposalOptionsToBeSold();
	    accountDetailsPage.clickOnSaveButton();
	}
	@Then("Navigate to the Sales Order tab for the SOLD Opportunity")
	public void navigate_to_the_sales_order_tab_for_the_sold_opportunity() {
	    
		salesOrderTab.clickOnSalesOrderTab();
	}
	
	@Then("User logs out")
	public void user_logs_out() {
	    commonFunctions.logout(); 
	}
	@Then("Click on actions dropdown under the Sales Order tab")
	public void click_on_actions_dropdown_under_the_sales_order_tab() {
	    salesOrderTab.clickOnActions();
		
	}
	@Then("Click on Edit Options and update two proposal")
	public void click_on_edit_options_and_update_two_proposal() {
		salesOrderTab.clickOnEditOptions();
		
	    accountDetailsPage.clickOnProposalOptionsToBeSold();
	    accountDetailsPage.clickOnSaveButton();
	}
	@Then("Click the option View\\/Print Sales Agreement")
	public void click_the_option_view_print_sales_agreement() {
	    salesOrderTab.clickOnPrintSalesAgreement();
	    salesAgreement.closePreview();
	    
	}

	@Given("Validate the Sales Agreement details")
    public void validateSalesAgreementDetails() {
		salesAgreement.verifySaleAgreementTitle();
    }


	
}
