package com.roman.converter.service;

public interface RomanIntegerConverter {
    String convertIntegerToRoman(Integer number) throws NumberFormatException;
    Integer convertRomanToInteger(String romanNumber) throws NumberFormatException;
}
