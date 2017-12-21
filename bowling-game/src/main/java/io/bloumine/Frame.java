package io.bloumine;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> rolls;

    public Frame() {
        this.rolls = new ArrayList<>();
    }

    public int rollTry() {
        return rolls.size();
    }

    public void roll(Integer pinsDownPerRoll) {
        this.rolls.add(pinsDownPerRoll);
    }

    public int score() {
        return rolls.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getRolls() {
        return new ArrayList<>(rolls);
    }

    public boolean isSpare() {
        return rolls.size() > 1 && rolls.stream().mapToInt(roll -> roll).sum() == 10;
    }
}
