Feature: Roman Integer Converter
         As a user I want to convert integers to roman numbers and back

  Scenario: converting roman numbers I'm getting corresponding integer results
    Given I convert I to integer
    Then I am getting 1 as result


  Scenario: converting integer numbers I'm getting corresponding roman numbers
    Given I convert 1 to roman
    Then I am getting roman number I as result

