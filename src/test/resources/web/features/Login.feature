Feature: Login in clockify web

  @Regression @Clockify @Login
  Scenario: Login with valid credentials
    Given The client is on clockify page
    When The client login with credentials email email and password password
    Then The client verify clockify home page is displayed
