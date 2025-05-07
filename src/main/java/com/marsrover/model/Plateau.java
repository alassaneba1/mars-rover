package com.marsrover.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents the rectangular plateau on Mars, defined by its upper-right coordinates (maxX, maxY).
 * The lower-left corner is always assumed to be (0, 0).
 */
@Getter
@AllArgsConstructor
public class Plateau {
    private final int maxX;
    private final int maxY;

    /**
     * Checks whether the given position is within the bounds of the plateau.
     *
     * @param position the position to validate
     * @return true if the position is within bounds, false otherwise
     */
    public boolean isWithinBounds(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
