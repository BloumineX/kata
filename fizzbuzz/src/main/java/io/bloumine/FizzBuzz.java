package io.bloumine;

public class FizzBuzz {
    public String generateString(int number) {
        if (number % 3 == 0)
            return "fizz";
        return String.valueOf(number);
    }
}
