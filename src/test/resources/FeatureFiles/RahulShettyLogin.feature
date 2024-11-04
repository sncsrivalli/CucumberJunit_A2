@functional
Feature: Rahul Shetty Login Feature
  Verify if user is able to login to rahul shetty academy app

	@smoke @regression
  Scenario: Login to Rahul Shetty with valid credentials
    Given Navigate to Rahul Shetty App
    When Give rahulshettyacademy and learning to login
    Then Shop Name should be displayed

	@smoke 
  Scenario Outline: Login to Rahul Shetty with different data
    Given Navigate to Rahul Shetty App
    When Login as <username> and <password>
    Then Shop Name should be displayed

    Examples: 
      | username           | password |
      | rahulshettyacademy | learning |
      | srivalli           | srivalli |
