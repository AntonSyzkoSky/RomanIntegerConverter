Feature: Roman Integer Converter
         As a user I want to convert integers to roman numbers and back

  Scenario Outline: converting roman numbers I'm getting corresponding integer results
    Given I convert <roman> to integer
    Then I am getting <integer> as result
    Examples:
      | roman     | integer |
      | I         | 1       |
      | IV        | 4       |
      | V         | 5       |
      | VI        | 6       |
      | IX        | 9       |
      | X         | 10      |
      | XI        | 11      |
      | XL        | 40      |
      | L         | 50      |
      | XC        | 90      |
      | C         | 100     |
      | CD        | 400     |
      | D         | 500     |
      | CM        | 900     |
      | M         | 1000    |
      | MMMCMXCIX | 3999    |

  Scenario Outline: converting integer numbers I'm getting corresponding roman numbers
    Given I convert <integer> to roman
    Then I am getting roman number <roman> as result
    Examples:
      | roman     | integer |
      | I         | 1       |
      | IV        | 4       |
      | V         | 5       |
      | VI        | 6       |
      | IX        | 9       |
      | X         | 10      |
      | XI        | 11      |
      | XL        | 40      |
      | L         | 50      |
      | XC        | 90      |
      | C         | 100     |
      | CD        | 400     |
      | D         | 500     |
      | CM        | 900     |
      | M         | 1000    |
      | MMMCMXCIX | 3999    |
