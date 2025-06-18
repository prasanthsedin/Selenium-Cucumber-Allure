package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountDetailsPage;
import pages.ProposalListPage;
import pages.SalesAgreement;
import pages.AccountListPage.SalesOrderTab;
import utilities.CommonFunctions;
import utilities.DriverFactory;

public class SalesOrderTabActionsForSOLDOpportunities {
	WebDriver driver;
	AccountDetailsPage accountDetailsPage;
	SalesOrderTab salesOrderTab;
	SalesAgreement salesAgreement;
	ProposalListPage proposalListPage;
	CommonFunctions commonFunctions;

	@Before
	public void setup() {
		WebDriver driver = DriverFactory.getDriver();
		accountDetailsPage = new AccountDetailsPage(driver);
		salesOrderTab = new SalesOrderTab(driver);
		salesAgreement = new SalesAgreement(driver);
		proposalListPage = new ProposalListPage(driver);
		commonFunctions = new CommonFunctions(driver);
	}

	@Then("SOLD Proposal in account page")
	public void sold_proposal_in_account_page() throws Throwable {

		proposalListPage.clickAccountHyperLink();
		accountDetailsPage.selectSOLDOptionFromStatusDropdown();
		accountDetailsPage.clickOnProposalOptionsToBeSold();
		accountDetailsPage.clickOnSaveButton();
	}

	@Then("Navigate to the Sales Order tab for the SOLD Opportunity")
	public void navigate_to_the_sales_order_tab_for_the_sold_opportunity() {

		salesOrderTab.clickOnSalesOrderTab();
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
		commonFunctions.switchToLastWindow();
		salesAgreement.closePreview();

	}

	@Given("Validate the Sales Agreement details")
	public void validateSalesAgreementDetails() {
		salesAgreement.verifySaleAgreementTitle();
		commonFunctions.closeCurrentWindowAndSwitchBackToMain();
		commonFunctions.verifyPageTitle("Account");
	}

}
