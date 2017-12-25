package io.bloumine;

public class RomanNumberGenerator {

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();

        int remainingNumber = arabicNumber;
        for (RomanNumeral roman : RomanNumeral.orderRomanNumeralsByArabicValueDesc()) {

            String romanLetters = roman.retrieveRomanLettersFrom(remainingNumber);
            remainingNumber = roman.getRemainingNumberUpdated(arabicNumber);

            romanNumeral.append(romanLetters);
        }

        return romanNumeral.toString();
    }
}
