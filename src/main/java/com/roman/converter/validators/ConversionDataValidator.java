package com.roman.converter.validators;

import java.util.Objects;
import java.util.regex.Pattern;

import static com.roman.converter.utils.ConversionUtils.ROMAN_TO_INT_DICTIONARY;

public class ConversionDataValidator {

    public void validateRomanForIntConversion(String romanNumber) {

        validateNullInput(romanNumber);

        if (romanNumber.isEmpty() || romanNumber.isBlank()) {
            throwException("An empty string does not define a Roman numeral");
        }

        if (!Pattern.matches("[a-zA-Z]+", romanNumber)) {
            throwException("Roman numbers are comprised of alphabetic characters only");
        }

        romanNumber.chars().mapToObj(i->(char)i).forEach(c -> {
            if (!ROMAN_TO_INT_DICTIONARY.containsKey(c)) {
                throwException("Provided letter " + c + " is not used in roman numbers");
            }
        });
    }

    public void validateIntForRomanConversion(Integer number) {

        validateNullInput(number);

        if (number != Math.floor(number)) {
            throwException("Floating point number cannot be converted to roman number");
        }
        if (number == 0) {
            throwException("Zero cannot be converted to roman numeral");
        }
        if (number < 1) {
            throwException("Value for roman numeral conversion must be positive");
        }
        if (number > 3999) {
            throwException("Value of roman numeral must be 3999 or less");
        }
    }

    private <T> void  validateNullInput(T input){
        if (Objects.isNull(input)) {
            throwException("Missing number for conversion");
        }
    }

    private void throwException(String errorMessage){
        throw new NumberFormatException(errorMessage);
    }
}
