@Regression2
Feature: Regression 2 Suite

  @regression2_01
  Scenario: 1 Verify enter text to element
    Given Set Page
      | newPageElements |
    And Open url
    And Enter text
      | TEST |
    And Scenario fail


  @regression2_02
  Scenario: 2 Verify click on checkbox
    Given Set Page
      | newPageElements |
    When Open url
    And Click on checkbox

  @regression2_03
  Scenario: 3 Verify click on checkbox2
    Given Set Page
      | newPageElements |
    And Open url
    And Click on checkbox2

  @regression2_04
  Scenario: 4 Click checkbox and verify heading
    Given Set Page
      | newPageElements |
    When Open url
    And Click and verify elements
