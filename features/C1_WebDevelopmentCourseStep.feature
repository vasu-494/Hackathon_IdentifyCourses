Feature: C1_WebDevelopmentCourseStep

  Scenario: Web Development Courses Search
    Given User navigates to Coursera Home Page
    When the user clicks on the search bar
    And the user selects the language and level
    Then verify details of the first course
    And verify details of the second course

  @sanity
  Scenario: Web Development Courses Search
    Given User navigates to Coursera Home Page
    When the user clicks on the search bar

  @regression
  Scenario: Web Development Courses Search
    Given User navigates to Coursera Home Page
    When the user clicks on the search bar
    And the user selects the language and level
    Then verify details of the first course
    And verify details of the second course
