package io.bloumine;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class BowlingGame {

    private static final int SECOND_TRY = 2;
    private static final int NEXT_FRAME = 1;
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
                .filter(frame -> isTenthFrame(frames) || !isStrike(frame) && frame.rollTry() != SECOND_TRY)
                .orElseGet(() -> {
                            Frame newFrame = new Frame();
                            frames.add(newFrame);
                            return newFrame;
                        }
                );
    }

    private boolean isStrike(Frame frame) {
        return frame.isStrike();
    }

    private boolean isTenthFrame(Deque<Frame> frames) {
        return frames.size() == 9;
    }

    public int score() {
        int score = 0;
        while (!frames.isEmpty()) {
            Frame headFrame = frames.pollFirst();
            score += headFrame.score();

            if (headFrame.isSpare() && !frames.isEmpty())
                score += frames.peekFirst().getRolls().get(0);
            if (headFrame.isStrike() && !frames.isEmpty())
                score += getNextRolls(2, frames);
        }

        return score;
    }

    private int getNextRolls(int nbRoll, Deque<Frame> frames) {
        int score = 0;

        for (Frame next : frames) {
            return next.getRolls().stream().limit(nbRoll).mapToInt(roll -> roll).sum();
        }

        return score;
    }
}
