package io.bloumine;

public enum RomanNumeral {
    I(1, null), V(5, I), X(10, I);

    private final int arabicValue;
    private final RomanNumeral subsctractedValue;

    RomanNumeral(int arabicValue, RomanNumeral canBeSubstractedToTheRoman) {
        this.arabicValue = arabicValue;
        this.subsctractedValue = canBeSubstractedToTheRoman;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public int getArabicValueOfEnumWithSubstract() {
        return this.arabicValue - this.subsctractedValue.getArabicValue();
    }

    public String getRomanNameWithSubstract() {
        return subsctractedValue.name() + this.name();
    }

    public boolean hasSubstractedRomanValue() {
        return subsctractedValue != null;
    }
}
