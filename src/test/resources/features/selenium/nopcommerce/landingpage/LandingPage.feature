Feature: Verify the elements on NOP Commerce landing page
  Background:
    Given I navigate to NOP Commerce Landing Page

  Scenario: Validate landing page and description
    Given I am on NOP Commerce Landing Page
    Then below description must be displayed for landing page
      | Evaluate the functionality and convenience of nopCommerce as a customer and store owner |