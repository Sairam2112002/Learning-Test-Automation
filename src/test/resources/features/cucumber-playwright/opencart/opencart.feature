Feature: Opencart
  Scenario: user searches in the opencart website
    Given user opens the opencart website
    When user enters "macbook" in the search bar
    Then user navigates to search results page

  Scenario: user clicks on macbook pro
    When user clicks on MacbookPro
    Then user navigates to MacbookPro product page

  Scenario: verify the details of MacbookPro
    Then verify the title of the product is "MacBook Pro"
    And verify the brand is "Apple"
    And verify the product code is "Product 18"
    And verify the reward points are "800"
    And verify the price is "$2,000.00"