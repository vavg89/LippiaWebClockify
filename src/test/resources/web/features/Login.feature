Feature: Login in clockify web

  Scenario: Login with valid credentials
    Given The client is on clockify page
    When The client login with credentials email user and password password
    Then The client verify clockify home page is displayed

  @Regression @Clockify @Login
  Scenario Outline: Login with parameters
    Given The client is on clockify page
    When The client click <text1> button
    And The client click <text2> button
    When The client login with credentials email <user> and password <password>
    Then The client verify clockify home page is displayed

    Examples:
      | text1  | text2           | user          | password        |
      | Log in | Log in manually | USERNAME_ENV  | PASSWORD_ENV    |
