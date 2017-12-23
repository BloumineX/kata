package io.bloumine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FizzBuzz kata
 * Kata based on :
 * http://codingdojo.org/kata/FizzBuzz/
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    private static Stream<Arguments> generateSimpleNumber() {
        return Stream.of(
                Arguments.of(1, "1")
                , Arguments.of(2, "2")
                , Arguments.of(4, "4")
                , Arguments.of(5, "5")
        );
    }

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_return_1_when_input_is_1() {
        assertThat(numberToString(1))
                .isEqualTo("1");
    }

    @ParameterizedTest
    @MethodSource("generateSimpleNumber")
    public void should_return_string_number_when_input_is(int number, String solution) {
        assertThat(numberToString(number))
                .isEqualTo(solution);
    }

    private String numberToString(int number) {
        return fizzBuzz.generateString(number);
    }
}
