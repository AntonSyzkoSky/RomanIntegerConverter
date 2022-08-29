Feature: Roman Integer Converter
         As a user I want to get a clear error message when providing invalid input for conversion

  Scenario Outline: converting zero integer to roman number I'm getting an error
    Given I convert <integer> to roman
    Then I am getting <error> error message
    Examples:
      | integer | error                                               |
      | 0       | Zero cannot be converted to roman numeral           |
      | -1      | Value for roman numeral conversion must be positive |
      | 4000    | Value of roman numeral must be 3999 or less         |

  Scenario Outline: converting invalid roman to integer I'm getting an error
    Given I convert <roman> to integer
    Then I am getting <error> error message
    Examples:
      | roman | error                                                     |
      | XXW   | Provided letter W is not used in roman numbers            |
      | 45    | Roman numbers are comprised of alphabetic characters only |
      | %£@   | Roman numbers are comprised of alphabetic characters only |
      | empty | An empty string does not define a Roman numeral           |
      | null  | Missing number for conversion                             |
