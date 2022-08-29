package com.roman.converter.utils;

import java.util.Map;

public class ConversionUtils {

    public final static int[] VALUES_FOR_INT_CONVERSION = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public final static String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public final static Map<Character, Integer> ROMAN_TO_INT_DICTIONARY = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
}
