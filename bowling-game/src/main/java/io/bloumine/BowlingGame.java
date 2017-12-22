package io.bloumine;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames;

    public BowlingGame() {
        this.frames = new ArrayList<>();
    }

    public void rolls(Integer pinsDownPerRoll) {
        Frame frame = getLastFrame();
        frame.roll(pinsDownPerRoll);
    }

    private Frame getLastFrame() {
        return frames.
                stream()
                .reduce((frame1, frame2) -> frame2)
                .filter(lastFrame -> lastFrame.rollTry() != 2)
                .orElseGet(() -> {
                    Frame newFrame = new Frame();
                    frames.add(newFrame);
                    return newFrame;
                });
    }

    public int score() {
        int score = 0;
        for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
            Frame currentFrame = frames.get(frameIndex);

            score += currentFrame.score();

            if (currentFrame.isSpare())
                score += getFirstRollOfNextFrame(frames, frameIndex + 1);
        }

        return score;
    }

    private int getFirstRollOfNextFrame(List<Frame> frames, int frameIndex) {
        if (frameIndex >= frames.size())
            return 0;
        return frames.get(frameIndex).getRolls().get(0);
    }
}
