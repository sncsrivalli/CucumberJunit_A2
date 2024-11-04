@integration
Feature: Demo App Login Feature
  Verify if User is able to login to the application
  
  @sanity 
  Scenario: App login with valid credentials
    Given I will navigate to skillrary demo app
    When I will login with valid username and password
    Then I can see Dashboard of the application

	@smoke
  Scenario Outline: App login with different credentials
    Given I will navigate to skillrary demo app
    When I will login with <username> and <password>
    Then I can see Dashboard of the application

    Examples: 
      | username | password |
      | admin    | admin    |
      | user1    | admin    |
      | abcdef   | abc!@123 |
