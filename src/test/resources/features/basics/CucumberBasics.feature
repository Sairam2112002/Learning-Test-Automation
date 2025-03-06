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

  @DataTable
  Scenario: Data Table example - 1
    Given Data table as list of list of strings
      | firstName   | lastName | birthDate  |
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |

  @DataTable
  Scenario: Data Table example - 2
    Given Data table as list of maps
      | firstName   | lastName | birthDate  |
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |

  @DataTable
  Scenario: Data Table example - 3
    Given Data table as map
      | KMSY | Louis Armstrong New Orleans International Airport |
      | KSFO | San Francisco International Airport               |
      | KSEA | Seattle–Tacoma International Airport              |
      | KJFK | John F. Kennedy International Airport             |

  @DataTable
  Scenario: Data Table example - 4
    Given Data table as map of lists
      | KMSY | 29.993333 |  -90.258056 |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 |  -73.778889 |

  @DataTable
  Scenario: Data Table example - 4
    Given Data table as map of maps
      |      |       lat |         lon |
      | KMSY | 29.993333 |  -90.258056 |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 |  -73.778889 |