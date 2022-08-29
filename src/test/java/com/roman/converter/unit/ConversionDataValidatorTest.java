package com.roman.converter.unit;

import com.roman.converter.validators.ConversionDataValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversionDataValidatorTest {

    private ConversionDataValidator underTest = new ConversionDataValidator();

    @Test
    public void validateNullToRomanThrowsNumberFormatExceptionTest() {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateIntForRomanConversion(0)
            );

        assertThat(ex.getMessage())
            .isEqualTo("Zero cannot be converted to roman numeral");
    }

    @Test
    public void validateRomanToIntThrowsNumberFormatExceptionTest() {

        NumberFormatException ex =
            assertThrows(
                NumberFormatException.class,
                () -> underTest.validateRomanForIntConversion("45")
            );

        assertThat(ex.getMessage())
            .isEqualTo("Roman numbers are comprised of alphabetic characters only");
    }
}
