package com.roman.converter.validators;

import com.roman.converter.utils.ConversionUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class ConversionDataValidator {

    public void validateRomanForIntConversion(String romanNumber) {

        if (Objects.isNull(romanNumber)) {
            throw new NumberFormatException("Missing number for conversion");
        }

        if (romanNumber.isEmpty() || romanNumber.isBlank()) {
            throw new NumberFormatException("An empty string does not define a Roman numeral");
        }

        if (!Pattern.matches("[a-zA-Z]+", romanNumber)) {
            throw new NumberFormatException("Roman numbers are comprised of alphabetic characters only");
        }

        romanNumber.chars().mapToObj(i->(char)i).forEach(c -> {
            if (!ConversionUtils.ROMAN_TO_INT_DICTIONARY.containsKey(c)) {
                throw new NumberFormatException("Provided letter " + c + " is not used in roman numbers");
            }
        });
    }

    public void validateIntForRomanConversion(Integer number) {

        if (Objects.isNull(number)) {
            throw new NumberFormatException("Missing number for conversion");
        }

        if (number != Math.floor(number)) {
            throw new NumberFormatException("Floating point number cannot be converted to roman number");
        }
        if (number == 0) {
            throw new NumberFormatException("Zero cannot be converted to roman numeral");
        }
        if (number < 1) {
            throw new NumberFormatException("Value for roman numeral conversion must be positive");
        }
        if (number > 3999) {
            throw new NumberFormatException("Value of roman numeral must be 3999 or less");
        }
    }
}
