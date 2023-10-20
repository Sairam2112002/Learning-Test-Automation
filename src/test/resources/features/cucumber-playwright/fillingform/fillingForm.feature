Feature: Filling a Survey Form
  Scenario: fill the survey form and verify the entered details
    Given user opens the survey form website
    When user enters all the required details
    Then verify the entered name is "Harry Potter"
    And verify the entered email is "hogwarts@gmail.com"
    And verify the entered age is "20"
    And verify the selected role is "Full Time Job"
    And verify the checked recommendation
    And verify the selected improvements
    And verify the entered suggestions is "FreeCodeCamp is a great place to learn"