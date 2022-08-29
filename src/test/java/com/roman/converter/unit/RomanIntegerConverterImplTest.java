package com.roman.converter.unit;

import com.roman.converter.service.RomanIntegerConverter;
import com.roman.converter.service.RomanIntegerConverterImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RomanIntegerConverterImplTest {

    private RomanIntegerConverter underTest = new RomanIntegerConverterImpl();

    @Test
    public void convertIntToRomanBaseCaseTest() {
        assertThat(underTest.convertIntegerToRoman(1)).isEqualTo("I");
    }

    @Test
    public void convertRomanToIntBaseCaseTest() {
        assertThat(underTest.convertRomanToInteger("IX")).isEqualTo(9);
    }

}