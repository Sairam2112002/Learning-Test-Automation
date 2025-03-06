@Feature
Feature: To understand the Cucumber basic features
  Background: This is a sample Background
    Given User is on application landing page

  Rule: This is a sample rule - 1
    Example: Sample example - 1 in Rule - 1
      Given User is on login page
      When User enters credentials
      And User clicks login
      Then User should navigate to their landing page

    Example: Sample example - 2 in Rule - 1
      Given User is on login page
      When User enters credentials
      And User clicks login
      Then User should navigate to their landing page

  @Scenario
  Scenario: This is a sample scenario - 1
    Given User is on login page
    When User enters credentials
    And User clicks login
    Then User should navigate to their landing page

  @Scenario
  Scenario: This is a sample scenario - 2
    Given User is on login page
    When User enters credentials
    And User clicks login
    Then User should navigate to their landing page

  @ScenarioOutline
  Scenario Outline: This is a sample scenario outline - 1
    Given there are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <left> cucumbers

    Examples:
      | start | eat | left |
      |    12 |   5 |    7 |
      |    20 |   5 |   15 |