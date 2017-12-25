package io.bloumine;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Roman number kata based on :
 * http://agilekatas.co.uk/katas/romannumerals-kata
 */
public class RomanNumberGeneratorTest {


    private RomanNumberGenerator romanNumberGenerator;

    private static Stream<Arguments> getRomanNumberAndArabicVersion() {
        return Stream.of(
                Arguments.of(1, "I")
                , Arguments.of(3, "III")
                , Arguments.of(9, "IX")
                , Arguments.of(1066, "MLXVI")
                , Arguments.of(1989, "MCMLXXXIX")
        );
    }

    private static Stream<Arguments> getRomanNumber1_2_3() {
        return Stream.of(
                Arguments.of(1, "I")
                , Arguments.of(2, "II")
                , Arguments.of(3, "III")
        );
    }

    @BeforeEach
    void setUp() {
        romanNumberGenerator = new RomanNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("getRomanNumberAndArabicVersion")
    public void should_convert_to_roman_numeral_numbers(int arabicNumber, String romanNumber) {
        assertThat(romanNumberGenerator.generateToRomanNumber(arabicNumber))
                .isEqualTo(romanNumber);
    }

    @Test
    public void should_return_I_when_input_is_1() {

        assertThat(romanNumberGenerator.generateToRomanNumber(1))
                .isEqualTo("I");
    }

    @Test
    public void should_return_V_when_input_is_5() {
        assertThat(romanNumberGenerator.generateToRomanNumber(5))
                .isEqualTo("V");
    }

    @ParameterizedTest
    @MethodSource("getRomanNumber1_2_3")
    public void should_return_up_to_3_I_when_number_is_up_to_3(int number, String romanNumber) {
        assertThat(romanNumberGenerator.generateToRomanNumber(number))
                .isEqualTo(romanNumber);
    }
}