package io.bloumine;

public class FizzBuzz {
    public String generateString(int number) {
        if (isMultipleOf3Or5(number))
            return fizzIfMultipleOf3(number) + buzzIfMultipleOf5(number);

        return String.valueOf(number);
    }

    private boolean isMultipleOf3Or5(int number) {
        return isMultipleOf3(number) || isMultipleOf5(number);
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }

    public String buzzIfMultipleOf5(int number) {
        return isMultipleOf5(number) ? "buzz" : "";
    }

    public String fizzIfMultipleOf3(int number) {
        return isMultipleOf3(number) ? "fizz" : "";
    }
}
