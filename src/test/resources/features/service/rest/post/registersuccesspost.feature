Feature: User Register

  As a user of the system I need to generate a new register so that I can use the service

  Scenario: Correct Registration of new User

    Given a person is on the user creation page and enters the username "eve.holt@reqres.in" and password "pistol"
    When this person sends the service new request
    Then the administrator should be able to get the registered information