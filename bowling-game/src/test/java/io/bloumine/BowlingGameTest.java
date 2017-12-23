package io.bloumine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void should_score_0_when_gutter_game() {
        performRolls(20, 0);

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void should_score_20_when_rolls_1_each_time() {
        performRolls(20, 1);

        assertThat(bowlingGame.score())
                .isEqualTo(20);
    }

    @Test
    public void should_score_29_when_roll_spare_and_1_pin_down_each_roll() {
        performRolls(2, 5);
        performRolls(18, 1);

        assertThat(bowlingGame.score())
                .isEqualTo(29);
    }

    @Test
    public void should_score_29_when_roll_1_and_tenth_frame_is_spare_and_1() {
        performRolls(19, 1);
        performRolls(1, 9);
        performRolls(1, 1);

        assertThat(bowlingGame.score())
                .isEqualTo(29);
    }

    @Test
    public void should_score_30_when_roll_strike_and_then_1_pin_down_each_roll() {
        performRolls(1, 10);
        performRolls(18, 1);

        assertThat(bowlingGame.score())
                .isEqualTo(30);
    }

    @Test
    public void should_score_300_when_perfect_game() {
        performRolls(12, 10);

        assertThat(bowlingGame.score())
                .isEqualTo(300);
    }

    private void performRolls(int roll, int pinsDownPerRoll) {
        Stream.iterate(pinsDownPerRoll, nextRoll -> nextRoll)
                .limit(roll)
                .forEach(bowlingGame::rolls);
    }
}
