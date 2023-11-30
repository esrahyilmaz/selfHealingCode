@Regression
Feature: Regression Tests

  @regression_01
  Scenario: 1 Verify enter text to element
    And Open url
    And Enter text
      | TEST |
    And Click and verify elements
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox

  @regression_02
  Scenario: 2 Verify click on element
    When Open url
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Enter text
      | TEST |
    And Click and verify elements
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Scenario fail

  @regression_03
  Scenario: 3 Verify Playback mode
    And Open url
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox

  @regression_04
  Scenario: 4 Verify click on element
    When Open url
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Click on checkbox
    And Enter text
      | TEST |
    And Click and verify elements
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |
    And Enter text
      | TEST |