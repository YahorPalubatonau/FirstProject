@MailRu
Feature: Test MailRu page

  Scenario: Verify that user in mailBox
    Given user login in mailBox
    Then user can sees Mailbox page

  Scenario: Verify that message can moves to Spam section
    Given user login in mailBox
    When user clicks on mail checkbox
    And user clicks on spam button
    Then user can sees message that mail was added in spam section

  Scenario: Verify that message can moves from Spam section
    Given user login in mailBox
    # When user clicks on span section button                 These three steps connected in pattern Fluent
    # And user clicks on mail checkbox in spam section
    # And user clicks on nospam button
    When user extracts mail from spam section
    Then user can sees message that mail was extracted from spam section

  Scenario: Verify that user can marks three checkboxes
    Given user login in mailBox
    When user clicks on inbox mail button
    And user clicks on three checkboxes
    Then user can sees all three checkboxes are marked

  Scenario: Verify that user can unmarks three checkboxes
    Given user login in mailBox
    When user clicks on unselect all button
    Then user can sees all checkboxes are unmarked

  Scenario: Verify that user can sends mail
    Given user login in mailBox
    When user clicks on button Write mail
    And user fills form To Whom:
    And user writes the text of mail
    And user clicks on button Send
    Then user can sees the message that mail was sended
