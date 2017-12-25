package io.bloumine;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumberGenerator {
    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        if (arabicNumber == 5)
            romanNumber.append("V");

        if (arabicNumber <= 3)
            romanNumber.append(getIWhenNumberInfTo3(arabicNumber));

        return romanNumber.toString();
    }

    private String getIWhenNumberInfTo3(int arabicNumber) {
        return  IntStream.iterate(1, number -> number + 1)
                .limit(arabicNumber)
                .mapToObj(arabic -> "I")
                .collect(Collectors.joining(""));


    }
}
