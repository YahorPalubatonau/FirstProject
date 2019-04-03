@API
Feature: Test VK page

  Scenario: Verify that user adds comment on VK wall
    When user enters comment
    Then user can sees new comment on VK wall

  Scenario: Verify that user edits himself comment on VK wall
    When user corrected comment
    Then  user sees the corrected comment