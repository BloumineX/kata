package io.bloumine;

public enum RomanNumeral {
    I(1, null), V(5, I), X(10, I), L(50, X), C(100, X), D(500, C), M(1000, C);

    private final int arabicValue;
    private final RomanNumeral subsctractedValue;

    RomanNumeral(int arabicValue, RomanNumeral canBeSubstractedToTheRoman) {
        this.arabicValue = arabicValue;
        this.subsctractedValue = canBeSubstractedToTheRoman;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public String numeralRomanFromNumberIfExist(Integer arabic) {
        StringBuilder numeral = new StringBuilder();

        while (arabicNumberDividedByRomanEqIsAtLeast1(arabic, this.getArabicValue())) {
            numeral.append(this.name());
            arabic -= this.getArabicValue();
        }

        if (this.hasSubstractedRomanValue()
                && arabicNumberDividedByRomanEqIsAtLeast1(arabic, this.getArabicValueOfEnumWithSubstract())) {
            numeral.append(this.getRomanNameWithSubstract());
        }

        return numeral.toString();
    }

    public int returnArabicValueMinusRomanIfPossible(int arabic) {
        while (arabicNumberDividedByRomanEqIsAtLeast1(arabic, this.getArabicValue()))
            arabic -= this.getArabicValue();

        if (this.hasSubstractedRomanValue()
                && arabicNumberDividedByRomanEqIsAtLeast1(arabic, this.getArabicValueOfEnumWithSubstract())) {
            arabic -= this.getArabicValueOfEnumWithSubstract();
        }

        return arabic;
    }

    private int getArabicValueOfEnumWithSubstract() {
        return this.arabicValue - this.subsctractedValue.getArabicValue();
    }

    private String getRomanNameWithSubstract() {
        return subsctractedValue.name() + this.name();
    }

    private boolean hasSubstractedRomanValue() {
        return subsctractedValue != null;
    }

    private boolean arabicNumberDividedByRomanEqIsAtLeast1(int arabicNumber, int arabicValue) {
        return arabicNumber / arabicValue >= 1;
    }

    public int compareNumericValueTo(RomanNumeral other) {
        return this.arabicValue - other.arabicValue;
    }
}
