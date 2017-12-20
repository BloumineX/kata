package io.bloumine;

public class BowlingGame {

    private Integer score = 0;

    public void rolls(Integer roll) {
        score += roll;
    }

    public int score() {
        return score;
    }
}
