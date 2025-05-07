package com.marsrover.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a rover's immutable position (x, y) on the plateau,
 * along with its current facing direction.
 * <p>
 * Uses Lombok to generate constructor and getters.
 */
@AllArgsConstructor
@Getter
public class Position {
    private final int x;
    private final int y;
    private final Direction direction;

    /**
     * Returns a new Position after moving forward
     * based on the current direction.
     *
     * @return new forward Position
     */
    public Position moveForward() {
        return switch (direction) {
            case N -> new Position(x, y + 1, direction);
            case S -> new Position(x, y - 1, direction);
            case E -> new Position(x + 1, y, direction);
            case W -> new Position(x - 1, y, direction);
        };
    }

    /**
     * Returns a new Position rotated 90° to the left.
     *
     * @return new Position with updated direction
     */
    public Position turnLeft() {
        return new Position(x, y, direction.rotateLeft());
    }

    /**
     * Returns a new Position rotated 90° to the right.
     *
     * @return new Position with updated direction
     */
    public Position turnRight() {
        return new Position(x, y, direction.rotateRight());
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
