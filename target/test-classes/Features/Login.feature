Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    # Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then use is logged in successfully into the application
    # And close the browser

  @smoke2
  Scenario: Valid Admin login
    # Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then use is logged in successfully into the application
    # And close the browser

  @scenarioOutline
  #Parameterization/DataDriven
  Scenario Outline: Login with multiple credentials using Scenario Outline
   # Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then use is logged in successfully into the application
    # And close the browser
    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |

  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |
  #will open and close browser once


    # HOOKS: For defining Pre and Post steps in any Cucumber framework
    #      : This is always created inside the StepDefinition folder
    #      : This class can not be inherited
   #       :