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

    Examples:
    | Link Text    | Page Link                                   |
    | Showcase     | https://www.nopcommerce.com/en/showcase     |
    | Case studies | https://www.nopcommerce.com/en/case-studies |
    | All features | https://www.nopcommerce.com/en/features     |
    
  Scenario: Validate the visibility of available navigation sections in landing page
    Given I am on NOP Commerce Landing Page
    Then below elements must be visible
      | Product            |
      | Downloads          |
      | Support & services |
      | Partners           |

  Scenario Outline: Validate the visibility of available options in "<Section name>" navigation section in landing page
    Given I am on NOP Commerce Landing Page
    When I hover on "<Section name>" element
    Then the options "<Options>" should be displayed

    Examples:
    | Section name       | Options                                                                                           |
    | Product            | Store demo,Showcase Option,Features,Why for developers,Why for store owners,Industries            |
    | Downloads          | Download nopCommerce,Marketplace,Translations,Copyright removal key,Mobile application,Web API    |
    | Support & services | Training,Documentation,Community forums,Premium support services,Request a quote,Contact us       |

  Scenario: Validate the functionality of "Partners" navigation section in landing page
    Given I am on NOP Commerce Landing Page
    And I click "Partners" link in new tab
    Then the corresponding "https://www.nopcommerce.com/en/partners" url should be displayed

  Scenario: Validate the visibility of available options in "" in "" navigation section in landing page
    Given I am on NOP Commerce Landing Page
    When I hover on "Product" element
    And I hover on "Industries" element
    Then the options "Fashion,Health & Beauty,Food & Beverage,Automotive,Industrial & Scientific,Furniture,B2B eCommerce,International" should be displayed
    