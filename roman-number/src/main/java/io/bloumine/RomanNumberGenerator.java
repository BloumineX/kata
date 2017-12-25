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
                .sorted(this::getHighestArabicValueFrom)
                .collect(Collectors.toList());
    }

    private int getHighestArabicValueFrom(RomanNumeral numeralLetter1, RomanNumeral numeralLetter2) {
        return numeralLetter2.getArabicValue() - numeralLetter1.getArabicValue();
    }
}
