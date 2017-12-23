package io.bloumine;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

public class BowlingGame {

    private static final int SECOND_TRY = 2;
    private Deque<Frame> frames;

    public BowlingGame() {
        this.frames = new LinkedList<>();

    }

    public void rolls(Integer pinsDownPerRoll) {
        Frame frame = getOrCreateLastFrame();
        frame.roll(pinsDownPerRoll);
    }

    private Frame getOrCreateLastFrame() {
        return Optional.ofNullable(frames.peekLast())
                .filter(frame -> isTenthFrame(frames) || (lastRollIsNotAStrike(frame) && frame.rollTry() != SECOND_TRY))
                .orElseGet(() -> {
                            Frame newFrame = new Frame();
                            frames.add(newFrame);
                            return newFrame;
                        }
                );
    }

    private boolean lastRollIsNotAStrike(Frame frame) {
        return !frame.isStrike();
    }

    private boolean isTenthFrame(Deque<Frame> frames) {
        return frames.size() == 10;
    }

    public int score() {
        int score = 0;
        while (!frames.isEmpty()) {
            Frame headFrame = frames.pollFirst();
            score += headFrame.score();

            if (headFrame.isSpare() && !frames.isEmpty())
                score += getNextRolls(1, frames.stream().limit(1));
            if (headFrame.isStrike() && !frames.isEmpty())
                score += getNextRolls(2, frames.stream().limit(2));
        }

        return score;
    }

    private int getNextRolls(int nbRoll, Stream<Frame> frames) {

        return frames
                .flatMap(frame -> frame.getRolls().stream())
                .limit(nbRoll)
                .mapToInt(roll -> roll)
                .sum();
    }
}
