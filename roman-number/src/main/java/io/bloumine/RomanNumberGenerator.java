package io.bloumine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanNumberGenerator {

    public static final String NO_DELIMITER = "";

    public String generateToRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        for (RomanNumeral roman : gerReverseRomanNumeralList()) {
            romanNumber.append(roman.numeralRomanFromNumberIfExist(arabicNumber));
            arabicNumber = roman.returnArabicValueMinusRomanIfPossible(arabicNumber);
        }

        return romanNumber.toString();
    }

    private List<RomanNumeral> gerReverseRomanNumeralList() {
        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());
        Collections.reverse(romanNumerals);
        return romanNumerals;
    }
}
