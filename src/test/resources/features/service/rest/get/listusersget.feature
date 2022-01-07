Feature: List User Information

  As an administrator I want to obtain the information of the list of users of the system that have been registered

  Scenario: List User Information

    Given several users have been registered on the platform
    When the information request is sent
    Then the administrator should be able to get the registered information