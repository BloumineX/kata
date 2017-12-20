package io.bloumine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class BowlingGameTest {

    @Test
    public void should_score_0_when_gutter_game() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        Stream.iterate(20, n -> 0).limit(20).forEach(bowlingGame::rolls);

        //Act
        int scorePlayer = bowlingGame.score();

        //Assert
        Assertions.assertThat(scorePlayer).isEqualTo(0);
    }
}
