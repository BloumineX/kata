package io.bloumine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FizzBuzz kata
 * Kata based on :
 * http://codingdojo.org/kata/FizzBuzz/
 */
public class FizzBuzzTest {

    @Test
    public void should_return_1_when_input_is_1() {
        //Act
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Arrange
        String result = fizzBuzz.generateString(1);

        //Assert
        assertThat(result)
                .isEqualTo("1");
    }
}
