package io.bloumine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumberGenerator {

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        for (RomanNumeral roman : getRomanLetterOrderedDescFromValue()) {
            romanNumber.append(roman.numeralRomanFromNumberIfExist(arabicNumber));
            arabicNumber = roman.returnArabicValueMinusRomanIfPossible(arabicNumber);
        }

        return romanNumber.toString();
    }

    private List<RomanNumeral> getRomanLetterOrderedDescFromValue() {
        return Stream.of(RomanNumeral.values())
                .sorted((romanLetter1, romanLetter2) -> romanLetter2.compareNumericValueTo(romanLetter1))
                .collect(Collectors.toList());
    }
}
