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


  @login_01
  Scenario: 1 Verify able to login to EA
    Given Set Page
      | EaLoginPage |
    Given I open url
      | https://qa-cpscreen.fadv.net/ |
     When Enter Client ID
      | 108907 |
    And Enter User ID
      | ANDREI |
    And Enter Password
      | Tester |
    And Click Sign In button
    And Click Proceed button
    And Enter Answer
      | test |
    And Click Submit button
    And Click Proceed button
    And Click I Agree button
    Then EA Home Page displays

#  @login_02
#  Scenario: 1 Verify able to login to Amazon Drug test
#
#    Given Open Amazon drug test url
#      | https://testnow-uat.fadv.com/admin |
#    When I Click Login Button
#    Given Set Page
#      | AmazonLoginPage |
#    When I Enter User Name
#      | ANDREI |
#    And I Enter User Password
#      | Tester |
#    And I Click Sign In button
