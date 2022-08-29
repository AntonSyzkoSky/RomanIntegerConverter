package com.roman.converter.unit;

import com.roman.converter.service.RomanIntegerConverter;
import com.roman.converter.service.RomanIntegerConverterImpl;
import com.roman.converter.validators.ConversionDataValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RomanIntegerConverterImplTest {

    private ConversionDataValidator conversionDataValidator;
    private RomanIntegerConverter underTest ;

    @BeforeEach
    void setUp() {
        conversionDataValidator = new ConversionDataValidator();
        underTest = new RomanIntegerConverterImpl(conversionDataValidator);
    }

    @ParameterizedTest(name = "converting int number {0} to roman gives {1}")
    @MethodSource
    public void convertIntToRomanTest(int intNumber, String romanNumber) {
        Assertions.assertThat(underTest.convertIntegerToRoman(intNumber)).isEqualTo(romanNumber);
    }

    @ParameterizedTest(name = "converting roman number {0} to int gives {1}")
    @MethodSource
    public void convertRomanToIntTest(String romanNumber, int intNumber) {
        Assertions.assertThat(underTest.convertRomanToInteger(romanNumber)).isEqualTo(intNumber);
    }

    private static Stream<Arguments> convertIntToRomanTest() {
        return Stream.of(
            Arguments.of(1, "I"),
            Arguments.of(2, "II"),
            Arguments.of(3, "III"),
            Arguments.of(4, "IV"),
            Arguments.of(5, "V"),
            Arguments.of(6, "VI"),
            Arguments.of(9, "IX"),
            Arguments.of(10, "X"),
            Arguments.of(11, "XI"),
            Arguments.of(15, "XV"),
            Arguments.of(19, "XIX"),
            Arguments.of(20, "XX"),
            Arguments.of(40, "XL"),
            Arguments.of(50, "L"),
            Arguments.of(90, "XC"),
            Arguments.of(100, "C"),
            Arguments.of(400, "CD"),
            Arguments.of(500, "D"),
            Arguments.of(900, "CM"),
            Arguments.of(1000, "M"),
            Arguments.of(2000, "MM"),
            Arguments.of(3000, "MMM"),
            Arguments.of(3999, "MMMCMXCIX")
        );
    }

    private static Stream<Arguments> convertRomanToIntTest() {
        return Stream.of(
            Arguments.of("I", 1),
            Arguments.of("II", 2),
            Arguments.of("III", 3),
            Arguments.of("IV", 4),
            Arguments.of("V", 5),
            Arguments.of("VI", 6),
            Arguments.of("IX", 9),
            Arguments.of("X", 10),
            Arguments.of("XI", 11),
            Arguments.of("XV", 15),
            Arguments.of("XIX", 19),
            Arguments.of("XX", 20),
            Arguments.of("XL", 40),
            Arguments.of("L", 50),
            Arguments.of("XC", 90),
            Arguments.of("C", 100),
            Arguments.of("CD", 400),
            Arguments.of("D", 500),
            Arguments.of("CM", 900),
            Arguments.of("M", 1000),
            Arguments.of("MM", 2000),
            Arguments.of("MMM", 3000),
            Arguments.of("MMMCMXCIX", 3999)
        );
    }
}