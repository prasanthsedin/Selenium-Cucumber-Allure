Feature: Sales Order Tab Actions for SOLD Opportunities

  Background:
    Given User launches the browser
    When User enters username "sedstart123" and password "sedstart123"
    Then User clicks siginin button
    Then Create a Account 
    And Add a Proposal to the account
    And SOLD Proposal in account page
    And Navigate to the Sales Order tab for the SOLD Opportunity
    Then Click on actions dropdown under the Sales Order tab
    

Scenario: Verify 'Edit Options' is available under Sales Order actions
    Then Click on Edit Options and update two proposal
    And User logs out

  Scenario: Verify 'View/Print Sales Agreement' is available under Sales Order actions
    Then Click the option View/Print Sales Agreement
    Given Validate the Sales Agreement details
    And User logs out

  

  