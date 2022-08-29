package com.roman.converter.unit;

import com.roman.converter.validators.ConversionDataValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversionDataValidatorTest {

    private ConversionDataValidator underTest = new ConversionDataValidator();

    @ParameterizedTest(name = "converting null {0} to roman throws {1}")
    @NullSource
    public void validateNullToRomanThrowsNumberFormatExceptionTest(Integer input) {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateIntForRomanConversion(input)
            );

        assertThat(ex.getMessage())
            .isEqualTo("Missing number for conversion");
    }

    @ParameterizedTest(name = "converting null {0} to int throws {1}")
    @NullSource
    public void validateNullToIntThrowsNumberFormatExceptionTest(String input) {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateRomanForIntConversion(input)
            );

        assertThat(ex.getMessage())
            .isEqualTo("Missing number for conversion");
    }

    @ParameterizedTest(name = "converting invalid int {0} to roman throws {1}")
    @MethodSource
    public void validateIntToRomanThrowsNumberFormatExceptionTest(int number, String exceptionMessage) {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateIntForRomanConversion(number)
            );

        assertThat(ex.getMessage())
            .isEqualTo(exceptionMessage);
    }

    @ParameterizedTest(name = "converting invalid roman {0} to int throws {1}")
    @MethodSource
    public void validateRomanToIntThrowsNumberFormatExceptionTest(String romanNumber, String exceptionMessage) {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateRomanForIntConversion(romanNumber)
            );

        assertThat(ex.getMessage())
            .isEqualTo(exceptionMessage);
    }

    private static Stream<Arguments> validateRomanToIntThrowsNumberFormatExceptionTest() {
        return Stream.of(
            Arguments.of("", "An empty string does not define a Roman numeral"),
            Arguments.of("   ", "An empty string does not define a Roman numeral"),
            Arguments.of("W", "Provided letter W is not used in roman numbers"),
            Arguments.of("a", "Provided letter a is not used in roman numbers"),
            Arguments.of("45", "Roman numbers are comprised of alphabetic characters only"),
            Arguments.of("&$£", "Roman numbers are comprised of alphabetic characters only")
        );
    }

    private static Stream<Arguments> validateIntToRomanThrowsNumberFormatExceptionTest() {
        return Stream.of(
            Arguments.of(0, "Zero cannot be converted to roman numeral"),
            Arguments.of(-1, "Value for roman numeral conversion must be positive"),
            Arguments.of(4000, "Value of roman numeral must be 3999 or less"),
            Arguments.of(Integer.MIN_VALUE, "Value for roman numeral conversion must be positive"),
            Arguments.of(Integer.MAX_VALUE, "Value of roman numeral must be 3999 or less")
        );
    }
}
