Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user click on PIM option

  @empSearch @smoke1
  Scenario: Search Employee by ID
    # Given open the browser and launch HRMS application
    # When user enters valid email and valid password
    # And click on login button
    # When user click on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information is displayed
    # And close the browser

  @empSearchJobTitle @smoke1
  Scenario: Search Employee by Job Title
    # Given open the browser and launch HRMS application
    # When user enters valid email and valid password
    # And click on login button
    # When user click on PIM option
    When user select Job Title
    And clicks on search button
    And user see employee information is displayed
    # And close the browser

  # Background: This is used to defined all the the common steps that multiple
  #             scenarios have in the feature file, till the time flow is not broken