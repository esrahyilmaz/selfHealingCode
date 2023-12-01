@Login
Feature: Login to portal

  @login_na  @login_02
  Scenario: 1 Verify able to login to NA
    Given Set Page
      | naLoginPage |
    When I open url
    |https://portal.na.edu/ics/|
    And Click Login
    And Enter User
    |eyilmaz4|
    Then Click Continue Button


