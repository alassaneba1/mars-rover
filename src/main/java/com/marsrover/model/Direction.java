package com.marsrover.model;

/**
 * Enum representing the four cardinal directions a rover can face:
 * North (N), East (E), South (S), and West (W).
 * Includes methods to rotate left or right from the current direction.
 */
public enum Direction {
    N, E, S, W;

    /**
     * Rotates the direction 90 degrees to the left (counterclockwise).
     * @return the new direction after rotating left
     */
    public Direction rotateLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    /**
     * Rotates the direction 90 degrees to the right (clockwise).
     * @return the new direction after rotating right
     */
    public Direction rotateRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }
}