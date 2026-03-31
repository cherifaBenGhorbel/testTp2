Feature: Form submission

  Scenario: User submits the form successfully
    Given the user is on the form page
    When the user fills the form
    And the user interacts with form elements
    And submits the form
    Then the user should see a success message