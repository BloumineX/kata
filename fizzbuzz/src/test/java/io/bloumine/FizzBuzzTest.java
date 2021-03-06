package io.bloumine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
                , Arguments.of(7, "7")
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

    @Test
    public void should_return_fizz_when_input_is_3() {
        assertThat(numberToString(3))
                .isEqualTo("fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    public void should_return_fizz_when_input_is_multiple_of_3(int multipleOf3) {
        assertThat(numberToString(multipleOf3))
                .isEqualTo("fizz");
    }

    @Test
    public void should_return_buzz_when_input_is_5() {
        assertThat(numberToString(5))
                .isEqualTo("buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 25})
    public void should_return_buzz_when_input_is_multiple_of_5(int multipleOf5) {
        assertThat(numberToString(multipleOf5))
                .isEqualTo("buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45})
    public void should_return_fizzbuzz_when_input_is_multiple_of_3_and_5(int multipleOf3And5) {
        assertThat(numberToString(multipleOf3And5))
                .isEqualTo("fizzbuzz");
    }

    private String numberToString(int number) {
        return fizzBuzz.generateString(number);
    }
}
