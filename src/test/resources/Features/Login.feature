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


    # HOOKS: For defining Pre and Post steps in any Cucumber framework
    #      : This is always created inside the StepDefinition folder
    #      : This class can not be inherited
   #       :