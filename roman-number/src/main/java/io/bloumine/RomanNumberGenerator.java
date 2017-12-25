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

    public int generateToArabicNumber(String romanNumeralLetters) {
        Deque<Integer> romanNumeralQueue = getQueueOfRomanNumeralLetters(romanNumeralLetters);
        int resultNumber = 0;

        while (romanNumeralQueueIsNotEmpty(romanNumeralQueue)) {
            int asciiLetter = pollNextValue(romanNumeralQueue);

            if (asciiLetterIsASubstractedValue(asciiLetter, romanNumeralQueue.peekFirst())) {
                Integer nextRomanASCIILetter = pollNextValue(romanNumeralQueue);
                resultNumber += getArabicNumberFromRomanSubstractedASCIILetter(nextRomanASCIILetter);
                continue;
            }

            resultNumber += getArabicNumberFromRomanASCIILetter(asciiLetter);
        }

        return resultNumber;
    }

    public Integer pollNextValue(Deque<Integer> romanNumeralQueue) {
        return romanNumeralQueue.pollFirst();
    }

    public boolean romanNumeralQueueIsNotEmpty(Deque<Integer> romanNumeralQueue) {
        return !romanNumeralQueue.isEmpty();
    }

    private int getArabicNumberFromRomanSubstractedASCIILetter(int asciiLetter) {
        return RomanNumeral.retrieveRomanNumeralFromASCII(asciiLetter).getArabicValueOfEnumWithSubstract();
    }

    public int getArabicNumberFromRomanASCIILetter(int asciiLetter) {
        return RomanNumeral.retrieveRomanNumeralFromASCII(asciiLetter).getEquivalentToArabic();
    }

    private boolean asciiLetterIsASubstractedValue(int romanASCIILetter, Integer nextRomanASCIILetter) {
        return nextRomanASCIILetter != null
            && getArabicNumberFromRomanASCIILetter(romanASCIILetter) < getArabicNumberFromRomanASCIILetter(nextRomanASCIILetter);
    }

    public Deque<Integer> getQueueOfRomanNumeralLetters(String romanNumeral) {
        return romanNumeral.chars()
                    .boxed()
                    .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
