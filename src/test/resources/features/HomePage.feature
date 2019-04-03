
Feature: Test Home page

  Scenario: Verify that MailRu homepage opens correct
    Then user can sees logo MailRu

  Scenario: Verify that list of suggest works correct
    When user enters tree symbols
    Then  user sees list of suggests