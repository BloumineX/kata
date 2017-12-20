package io.bloumine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void should_score_0_when_gutter_game() {
        performRolls(0);

        Assertions.assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void should_score_20_when_rolls_1_each_time() {
        performRolls(1);

        Assertions.assertThat(bowlingGame.score())
                .isEqualTo(20);
    }

    private void performRolls(int roll) {
        Stream.iterate(roll, nextRoll -> nextRoll).limit(20).forEach(bowlingGame::rolls);
    }

}
