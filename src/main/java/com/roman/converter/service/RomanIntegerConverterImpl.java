package com.roman.converter.service;

import com.roman.converter.validators.ConversionDataValidator;

import java.util.Map;

public class RomanIntegerConverterImpl implements RomanIntegerConverter {

    private final ConversionDataValidator conversionDataValidator;

    public final  int[] VALUES_FOR_INT_CONVERSION = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public final  String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public final  Map<Character, Integer> ROMAN_TO_INT_DICTIONARY = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public RomanIntegerConverterImpl(ConversionDataValidator conversionDataValidator) {
        this.conversionDataValidator = conversionDataValidator;
    }

    @Override
    public String convertIntegerToRoman(Integer number) {

        conversionDataValidator.validateIntForRomanConversion(number);

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; number > 0; i++)
            while (number >= VALUES_FOR_INT_CONVERSION[i]) {
                romanNumber.append(ROMAN_NUMBERS[i]);
                number -= VALUES_FOR_INT_CONVERSION[i];
            }

        return romanNumber.toString();
    }

    @Override
    public Integer convertRomanToInteger(String romanNumber) {
        conversionDataValidator.validateRomanForIntConversion(romanNumber);

        Integer intResult = 0;

        for (int i = 0; i < romanNumber.length(); i++) {

            if(!ROMAN_TO_INT_DICTIONARY.containsKey(romanNumber.charAt(i))){
                throw new NumberFormatException("Latin letter provided is not used in roman math");
            }
            //exceptions of IV , IX etc ...
            if (i > 0 && ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i)) > ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i - 1))) {

                intResult += ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i)) - 2 * ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i - 1));

            } else {
                intResult += ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i));
            }
        }
        return intResult;
    }
}
