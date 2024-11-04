@system
Feature: Sauce Demo Login

  Background: 
    Given I navigate to Swag labs

	@sanity @regression
  Scenario: Login to Swag labs
    When I login to swag labs
    Then Swag Labs home page displays

	@smoke
  Scenario Outline: Login with different credentials to Swag Labs
    When I login to swag labs using <username> and <password>
    Then Swag Labs home page displays

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |
      | visual_user     | secret_sauce |
