package ru.zavoiko.live;

import java.awt.*;

public enum Status {
    NONE,
    BORN,
    LIVE,
    DEAD;

    public Status firstStep(int around) {
        return switch (this) {
            case NONE -> around >= 3 ? BORN : NONE;
            case LIVE -> around <= 1 || around > 3 ? DEAD : LIVE;
            default -> this;
        };
    }

    public Status secondStep() {
        return switch (this) {
            case BORN -> LIVE;
            case DEAD -> NONE;
            default -> this;
        };
    }

    public Color getColor() {
        return switch (this) {
            case LIVE -> Color.GREEN;
            case BORN -> Color.GRAY;
            case DEAD -> Color.RED;
            default -> Color.BLACK;
        };
    }

    public boolean isCell() {
        return Status.LIVE == this || Status.DEAD == this;
    }

}
