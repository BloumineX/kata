package io.bloumine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanNumberGenerator {

    public static final String NO_DELIMITER = "";

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        for (RomanNumeral roman : gerReverseRomanNumeralList()) {
            while (arabicNumber / roman.getArabicValue() >= 1) {
                romanNumber.append(roman.name());
                arabicNumber -= roman.getArabicValue();
            }

            if (roman.hasSubstractedRomanValue() && arabicNumber / roman.getArabicValueOfEnumWithSubstract() >= 1) {
                romanNumber.append(roman.getRomanNameWithSubstract());
                arabicNumber -= roman.getArabicValue();
            }
        }

        return romanNumber.toString();
    }

    public List<RomanNumeral> gerReverseRomanNumeralList() {
        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());
        Collections.reverse(romanNumerals);
        return romanNumerals;
    }
}
