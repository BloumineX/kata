package io.bloumine;

import java.util.HashMap;
import java.util.Map;

public enum RomanNumeral {
    I(1), V(5), X(10);

    private static Map<Integer, RomanNumeral> arabicToNumeral;

    static {
        arabicToNumeral = new HashMap<>();
        for (RomanNumeral value : RomanNumeral.values()) {
            arabicToNumeral.put(value.getArabicValue(), value);
        }
    }

    private final int arabicValue;

    RomanNumeral(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    public static RomanNumeral getRomanNumeralFromArabic(int arabicValue) {
        return arabicToNumeral.get(arabicValue);
    }

    public int getArabicValue() {
        return arabicValue;
    }


}
