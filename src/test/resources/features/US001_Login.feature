@Test
Feature: The user should be able to login, adds items to the basket, checkout and checks out successfully
  Background:
    Given User goes to "url"

  @Test1
  Scenario Outline: logs in, adds an item(s) to the basket, proceeds to checkout and checks out successfully
    When Enter "<username>", "<password>" and click the login
    Then add two items
    And Click the Shopping Cart
    Then Click the Checkout Button
    And Fill out the required info and click the continue
    Then Click the finish button and ensure that user can see "Thank you for your order!"
    Examples:
  | username              | password     |
  |standard_user          | secret_sauce |
  |problem_user           | secret_sauce |
  |performance_glitch_user| secret_sauce |
  |error_user             | secret_sauce |
  |visual_user            | secret_sauce |


    @Test2
    Scenario Outline: logs in with invalid username
      When Enter "<username>", "<password>" and click the login
      Then Ensure that user can see the alert "Epic sadface: Sorry, this user has been locked out."
      Examples:
      | username      | password     |
      |locked_out_user| secret_sauce |





