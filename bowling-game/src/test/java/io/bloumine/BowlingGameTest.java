package io.bloumine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class BowlingGameTest {

    @Test
    public void should_score_0_when_gutter_game() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        Stream.iterate(0, n -> 0).limit(20).forEach(bowlingGame::rolls);

        //Act
        int scorePlayer = bowlingGame.score();

        //Assert
        Assertions.assertThat(scorePlayer).isEqualTo(0);
    }

    @Test
    public void should_score_20_when_rolls_1_each_time() {
        BowlingGame bowlingGame = new BowlingGame();
        Stream.iterate(1, n->1).limit(20).forEach(bowlingGame::rolls);

        int scorePlayer = bowlingGame.score();

        Assertions.assertThat(scorePlayer)
                .isEqualTo(20);
    }

}
