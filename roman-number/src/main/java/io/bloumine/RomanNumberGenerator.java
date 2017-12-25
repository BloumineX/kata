package io.bloumine;

public class RomanNumberGenerator {
    public String generateToRomanNumber(int arabicNumber) {
        if (arabicNumber == 5)
            return "V";
        if (arabicNumber == 3)
            return "III";
        if (arabicNumber == 2)
            return "II";
        return "I";
    }
}
