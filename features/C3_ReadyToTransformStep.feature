Feature: C3_ReadyToTransformStep

  Scenario: Fill the Ready To Transform form
    Given user navigate to the coursera home page
    When user clicks on For Enterprise page
    And user clicks on What We Offer page
    And user clicks on Coursera for Campus
    And scrolls to the form
    Then enters the details in the form
    And captures the error message

  @sanity
  Scenario: Fill the Ready To Transform form
    Given user navigate to the coursera home page
    When user clicks on For Enterprise page
    And user clicks on What We Offer page
    And user clicks on Coursera for Campus
    And scrolls to the form

  @regression
  Scenario: Fill the Ready To Transform form
    Given user navigate to the coursera home page
    When user clicks on For Enterprise page
    And user clicks on What We Offer page
    And user clicks on Coursera for Campus
    And scrolls to the form
    Then enters the details in the form
    And captures the error message
