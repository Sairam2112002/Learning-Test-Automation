Feature: To create an User and verifying
  Scenario Outline: creating an user
    Given user sets the base uri for account creation
    When user sends post request with required details
    |<username>|<password>|
    Then validate that the response code is 201
    And validate the username
    |<username>|

    Examples:
    |username|password|
    |dobby17|Dobby@123|

  @userValidation
  Scenario: validating the created user by logging in
    Given user opens the book store website
    When user enters the created details and logs in
    Then verify the created username

  @userValidation
  Scenario Outline: validating existing users via logging in
    Given user opens the book store website
    When user enters the details and logs in
    |<username>|<password>|

    Then verify the username
    |<username>|

    Examples:
    |username|password|
    |dobby1|Dobby@123|
    |dobby2|Dobby@123|
    |dobby3|Dobby@123|
    |dobby4|Dobby@123|
    |dobby5|Dobby@123|