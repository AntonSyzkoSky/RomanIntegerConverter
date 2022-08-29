package com.roman.converter.service;

import java.util.Map;

public class RomanIntegerConverterImpl implements RomanIntegerConverter {

    public final  int[] VALUES_FOR_INT_CONVERSION = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public final  String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override
    public String convertIntegerToRoman(Integer number) {


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
        return null;
    }
}
