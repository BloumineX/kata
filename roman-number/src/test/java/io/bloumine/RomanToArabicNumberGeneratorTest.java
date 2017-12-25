package io.bloumine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToArabicNumberGeneratorTest {

    private RomanNumberGenerator romanNumberGenerator;

    private static Stream<Arguments> getArabicNumbersAndNumeralNumber() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("III", 3),
                Arguments.of("IX", 9),
                Arguments.of("MLXVI", 1066),
                Arguments.of("MCMLXXXIX", 1989)
        );
    }

    @BeforeEach
    public void setUp() {
        this.romanNumberGenerator = new RomanNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("getArabicNumbersAndNumeralNumber")
    public void should_convert_to_roman_numeral_numbers(String romanNumber, int arabicNumber) {
        assertThat(getArabicNumber(romanNumber))
                .isEqualTo(arabicNumber);
    }

    @Test
    public void should_return_1_when_romanNumeral_is_I() {
        assertThat(getArabicNumber("I"))
                .isEqualTo(1);
    }

    @Test
    public void should_return_2_when_romanNumeral_is_II() {
        assertThat(getArabicNumber("II"))
                .isEqualTo(2);
    }

    @Test
    public void should_return_3_when_romanNumeral_is_III() {
        assertThat(getArabicNumber("III"))
                .isEqualTo(3);
    }

    private int getArabicNumber(String romanNumeral) {
        return romanNumberGenerator.generateToArabicNumber(romanNumeral);
    }


}
