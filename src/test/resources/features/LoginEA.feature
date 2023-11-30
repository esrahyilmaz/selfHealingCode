@Login
Feature: Login to portal

  @login_na  @login_02
  Scenario: 1 Verify able to login to NA
    Given Set Page
      | naLoginPage |
    Given I open url
    |https://portal.na.edu/ics/|
    When Click Login
    When Enter User
    |eyilmaz4|
    And Click Continue Button


