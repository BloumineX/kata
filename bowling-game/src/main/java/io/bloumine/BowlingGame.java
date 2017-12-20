package io.bloumine;

public class BowlingGame {

    private Integer score = 0;

    public void rolls(Integer pinsDownPerRoll) {
        score += pinsDownPerRoll;
    }

    public int score() {
        return score;
    }
}
