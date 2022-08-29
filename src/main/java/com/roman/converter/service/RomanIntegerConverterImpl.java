package com.roman.converter.service;

import com.roman.converter.validators.ConversionDataValidator;

import static com.roman.converter.utils.ConversionUtils.ROMAN_NUMBERS;
import static com.roman.converter.utils.ConversionUtils.ROMAN_TO_INT_DICTIONARY;
import static com.roman.converter.utils.ConversionUtils.VALUES_FOR_INT_CONVERSION;

public class RomanIntegerConverterImpl implements RomanIntegerConverter {

    private final ConversionDataValidator conversionDataValidator;

    public RomanIntegerConverterImpl(ConversionDataValidator conversionDataValidator) {
        this.conversionDataValidator = conversionDataValidator;
    }

    @Override
    public String convertIntegerToRoman(Integer number) {

        conversionDataValidator.validateIntForRomanConversion(number);

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; number > 0; i++) {
            while (number >= VALUES_FOR_INT_CONVERSION[i]) {
                romanNumber.append(ROMAN_NUMBERS[i]);
                number -= VALUES_FOR_INT_CONVERSION[i];
            }
        }

        return romanNumber.toString();
    }

    @Override
    public Integer convertRomanToInteger(String romanNumber) {
        conversionDataValidator.validateRomanForIntConversion(romanNumber);

        Integer intResult = 0;

        for (int i = 0; i < romanNumber.length(); i++) {

            if (!ROMAN_TO_INT_DICTIONARY.containsKey(romanNumber.charAt(i))) {
                throw new NumberFormatException("Latin letter provided is not used in roman math");
            }
            //exceptions of IV , IX etc ...
            if (i > 0 && ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i)) >
                         ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i - 1))) {

                intResult += ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i)) -
                             2 * ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i - 1));

            } else {
                intResult += ROMAN_TO_INT_DICTIONARY.get(romanNumber.charAt(i));
            }
        }
        return intResult;
    }
}
