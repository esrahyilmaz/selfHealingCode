@Smoke
Feature: Smoke Tests

  @smoke_01 @t
  Scenario: 1 Check enter text to element
#    Given Initialize driver
#      | chrome |
    And Open url
    And Enter text
      | TEST |
    And Click on checkbox

  @smoke_02
  Scenario: 2 Check click on element
    When Open url
    And Click on checkbox
    And Scenario fail


  @smoke_03 @t
  Scenario: 3 Check Record mode
#    Given Initialize driver with event listener
#      | chrome |
    And Set record mode as true
    And Set Page
      | newPageElements |
    And Open url
    And Click and verify elements
    And Store element info

  @smoke_04
  Scenario: 4 Check Playback mode
    Given Set Page
      | newPageElements |
#    Given Initialize driver with event listener
#      | chrome |
    And Open url
    And Click and verify elements