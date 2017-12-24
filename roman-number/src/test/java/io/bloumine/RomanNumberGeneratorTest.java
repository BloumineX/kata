package io.bloumine;


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


    static Stream<Arguments> getRomanNumberAndArabicVersion() {
        return Stream.of(
                Arguments.of(1, "I")
                , Arguments.of(3, "III")
                , Arguments.of(9, "IX")
                , Arguments.of(1066, "MLXVI")
                , Arguments.of(1989, "MCMLXXXIX")
        );
    }

    @ParameterizedTest
    @MethodSource("getRomanNumberAndArabicVersion")
    public void should_convert_to_roman_numeral_numbers(int arabicNumber, String romanNumber) {
        RomanNumberGenerator romanNumberGenerator = new RomanNumberGenerator();

        String result = romanNumberGenerator.generateToRomanNumber(arabicNumber);

        assertThat(result)
                .isEqualTo(romanNumber);
    }

//    @Test
//    public void should_return_I_when_input_is_1() {
//
//    }

}
