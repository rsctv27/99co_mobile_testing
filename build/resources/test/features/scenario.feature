@99co
Feature: Login user

  @scenario-1
  Scenario: Login user with valid credential
    Given user is on home page
    When user click home bottom bar
    And user click login bottom bar
    And user will be redirected to login page
    And user input email with "dummy99co@gmail.com"
    And user input password with "qwerty123"
    And user click login button
    Then user should see success dialog pop up

  @scenario-2
  Scenario: Login user with empty credential
    Given user is on home page
    When user click home bottom bar
    And user click login bottom bar
    And user will be redirected to login page
    And user click login button
    Then user should see error message input email
    And user should see error message input password
