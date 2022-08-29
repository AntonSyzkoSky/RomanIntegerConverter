Feature: Roman Integer Converter
         As a user I want to get a clear error message when providing invalid input for conversion

  Scenario: converting zero integer to roman number I'm getting an error
    Given I convert 0 to roman
    Then I am getting Zero cannot be converted to roman numeral error message

  Scenario: converting invalid roman to integer I'm getting an error
    Given I convert 45 to integer
    Then I am getting Roman numbers are comprised of alphabetic characters only error message
