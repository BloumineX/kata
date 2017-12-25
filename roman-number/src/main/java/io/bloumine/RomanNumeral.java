package io.bloumine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public enum RomanNumeral {
    I(1, null), V(5, I), X(10, I), L(50, X), C(100, X), D(500, C), M(1000, C);

    private final int equivalentToArabic;
    private final RomanNumeral subsctractedValue;

    RomanNumeral(int equivalentToArabic, RomanNumeral canBeSubstractedToTheRoman) {
        this.equivalentToArabic = equivalentToArabic;
        this.subsctractedValue = canBeSubstractedToTheRoman;
    }

    public static List<RomanNumeral> orderRomanNumeralsByArabicValueDesc() {
        return Stream.of(RomanNumeral.values())
                .sorted((romanLetter1, romanLetter2) -> romanLetter2.compareNumericValueTo(romanLetter1))
                .collect(Collectors.toList());
    }

    public int getEquivalentToArabic() {
        return equivalentToArabic;
    }

    private static int romanLettersNeededFrom(Integer arabic, Integer romanLetterArabicValue) {
        return arabic / romanLetterArabicValue;
    }

    public String retrieveRomanLettersFrom(Integer arabic) {
        int timesRomanNumeralNeeded = romanLettersNeededFrom(arabic, this.equivalentToArabic);
        String romanLetter = getRomanLetterNTimes(timesRomanNumeralNeeded);

        int remainArabicNumber = arabic % this.equivalentToArabic;

        if (needToRemoveSubstractedValue(remainArabicNumber))
            romanLetter += this.getRomanNameWithSubstract();

        return romanLetter;
    }

    private boolean needToRemoveSubstractedValue(int remainArabic) {
        return this.hasSubstractedRomanLetter() &&
                romanLettersNeededFrom(remainArabic, this.getArabicValueOfEnumWithSubstract()) > 0;
    }

    public String getRomanLetterNTimes(int timesRomanLetterNeeded) {
        return IntStream.iterate(0, number -> number + 1)
                .limit(timesRomanLetterNeeded)
                .mapToObj(number -> this.name())
                .collect(Collectors.joining());
    }

    public int getRemainingNumberUpdated(int arabic) {
        int newNumber = arabic % this.equivalentToArabic;

        if (this.hasSubstractedRomanLetter())
            newNumber = newNumber % this.getArabicValueOfEnumWithSubstract();

        return newNumber;
    }

    private int getArabicValueOfEnumWithSubstract() {
        return this.equivalentToArabic - this.subsctractedValue.getEquivalentToArabic();
    }

    private String getRomanNameWithSubstract() {
        return subsctractedValue.name() + this.name();
    }

    private boolean hasSubstractedRomanLetter() {
        return subsctractedValue != null;
    }

    public int compareNumericValueTo(RomanNumeral other) {
        return this.equivalentToArabic - other.equivalentToArabic;
    }
}
