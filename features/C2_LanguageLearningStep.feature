Feature: C2_LanguageLearningStep

  Scenario: Display the language and level
    Given user navigates to the coursera home page
    When the user clicks on languages show more
    Then gets the languages count and languages
    And get the levels count and levels

  @sanity
  Scenario: Display the language and level
    Given user navigates to the coursera home page
    When the user clicks on languages show more
