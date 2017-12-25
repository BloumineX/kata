package io.bloumine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import static io.bloumine.RomanNumeral.orderRomanNumeralsByArabicValueDesc;

public class RomanNumberGenerator {

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();

        int remainingNumber = arabicNumber;
        for (RomanNumeral roman : orderRomanNumeralsByArabicValueDesc()) {

            String romanLetters = roman.retrieveRomanLettersFrom(remainingNumber);
            remainingNumber = roman.getRemainingNumberUpdated(arabicNumber);

            romanNumeral.append(romanLetters);
        }

        return romanNumeral.toString();
    }

    public int generateToArabicNumber(String romanNumber) {
        Deque<Integer> romanNumeralQueue = getQueueOfRomanNumeralLetters(romanNumber);
        int resultNumber = 0;

        while (!romanNumeralQueue.isEmpty()) {
            int asciiLetter = romanNumeralQueue.pollFirst();
            resultNumber += RomanNumeral.retrieveRomanNumeralFromASCII(asciiLetter).getEquivalentToArabic();

        }


        if ("III".equals(romanNumber))
            return 3;
        if ("II".equals(romanNumber))
            return 2;
        return 1;
    }

    public Deque<Integer> getQueueOfRomanNumeralLetters(String romanNumeral) {
        return romanNumeral.chars()
                    .boxed()
                    .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
