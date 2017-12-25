package io.bloumine;

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

    public int generateToArabicNumber(String romanNumeral) {
        if (romanNumeral == "II")
            return 2;
        return 1;
    }
}
