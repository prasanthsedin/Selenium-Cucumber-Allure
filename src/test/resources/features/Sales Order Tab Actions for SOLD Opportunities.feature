Feature: Sales Order Tab Actions for SOLD Opportunities

  As a Dealer,
  I want to verify all available actions under the Sales Order tab
  So that I can confirm correct options are shown for SOLD opportunities

  Background:
    Given I am logged in as a Dealer
    And I have a SOLD Opportunity available in the system
    And I navigate to the Sales Order tab for the SOLD Opportunity

  Scenario: Verify 'Edit Options' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "Edit Options"

  Scenario: Verify 'View/Print Sales Agreement' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "View/Print Sales Agreement"

  Scenario: Verify 'Cancel Sales Agreement' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "Cancel Sales Agreement"

  Scenario: Verify 'View/Print/Export Work Order w/Prices' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "View/Print/Export Work Order w/Prices"

  Scenario: Verify 'View/Print/Export Work Order w/out Prices' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "View/Print/Export Work Order w/out Prices"

  Scenario: Verify 'Email Work Order' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "Email Work Order"

  Scenario: Verify 'Display Job Cost Analysis' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "Display Job Cost Analysis"

  Scenario: Verify 'Resend Sales Notification Email' is available under Sales Order actions
    When I open the actions dropdown under the Sales Order tab
    Then I should see the option "Resend Sales Notification Email"

  Scenario: Verify a Sales Order is generated after checkout
    Given I have completed the checkout process for an Opportunity
    Then a Sales Order should be generated
    And it should appear under the Sales Order tab for that Opportunity
