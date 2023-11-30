@RecordMode
Feature: Record mode feature

  @RecordPage1
  Scenario: 1 Record mode page1
    Given Set Page
      | page1 |
    And Load custom url
      | page1.html |
    And Click and verify elements
#    And Store element info

  @RecordPage2
  Scenario: 2 Record mode page2
    Given Set Page
      | page2 |
    And Load custom url
      | page2.html |
    And Click and verify elements
#    And Store element info

  @RecordPage3
  Scenario: 3 Record mode page3
    Given Set Page
      | page3 |
    And Load custom url
      | page3.html |
    And Click and verify elements
#    And Store element info