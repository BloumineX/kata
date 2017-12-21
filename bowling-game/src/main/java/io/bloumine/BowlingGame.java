package io.bloumine;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames;

    public BowlingGame() {
        this.frames = new ArrayList<>();
    }

    public void rolls(Integer pinsDownPerRoll) {
        Frame frame = getOrCreateLastFrame();
        frame.roll(pinsDownPerRoll);
    }

    private Frame getOrCreateLastFrame() {
        if (frames.size() > 0) {
            Frame frame = frames.get(frames.size() - 1);
            if (frame.getRolls().size() == 1)
                return frame;
        }

        Frame frame = new Frame();
        frames.add(frame);
        return frame;
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
