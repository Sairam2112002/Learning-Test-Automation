@NOPCommerce @LandingPage
Feature: Verify the elements on NOP Commerce landing page
  Background:
    Given I navigate to NOP Commerce Landing Page

  Scenario: Validate landing page and description
    Given I am on NOP Commerce Landing Page
    Then below description must be displayed for landing page
      | Evaluate the functionality and convenience of nopCommerce as a customer and store owner |

  Scenario: Validate Showcase, Case studies and All features links are visible
    Given I am on NOP Commerce Landing Page
    Then below elements must be visible
      | Showcase     |
      | Case studies |
      | All features |

  Scenario Outline: Validate the functionality of "<Link Text>" link in landing page
    Given I am on NOP Commerce Landing Page
    And I click "<Link Text>" link in new tab
    Then the corresponding "<Page Link>" url should be displayed
    @check
    Examples:
    | Link Text    | Page Link                                   |
    | Showcase     | https://www.nopcommerce.com/en/showcase     |
    | Case studies | https://www.nopcommerce.com/en/case-studies |
    | All features | https://www.nopcommerce.com/en/features     |