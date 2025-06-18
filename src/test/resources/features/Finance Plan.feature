Feature: Finance Plan

  Scenario: Update a Finance Plan Scenario
    Given Login to Application with "sedstart123" and password "sedstart123"
    Then Create a Account 
    And Add a Proposal to the account
    Then Click on Edit button for Proposal
    And Update a Finance Plan
    And User logs out