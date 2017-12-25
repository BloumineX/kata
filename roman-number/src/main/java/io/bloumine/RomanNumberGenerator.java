package io.bloumine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumberGenerator {

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();

        int remainingNumber = arabicNumber;
        for (RomanNumeral roman : getRomanNumeralOrderedDescFromArabicValue()) {

            String romanLetters = getHighestRomanLettersLowerThanRemainingNumber(remainingNumber, roman);
            remainingNumber = roman.getRemainingNumberUpdated(arabicNumber);

            romanNumeral.append(romanLetters);
        }

        return romanNumeral.toString();
    }

    private String getHighestRomanLettersLowerThanRemainingNumber(int remainingNumber, RomanNumeral roman) {
        return roman.romanLetterNeededToConvert(remainingNumber);
    }

    private List<RomanNumeral> getRomanNumeralOrderedDescFromArabicValue() {
        return Stream.of(RomanNumeral.values())
                .sorted((romanLetter1, romanLetter2) -> romanLetter2.compareNumericValueTo(romanLetter1))
                .collect(Collectors.toList());
    }
}
