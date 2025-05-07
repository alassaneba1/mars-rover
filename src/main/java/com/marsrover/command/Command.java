package com.marsrover.command;

import com.marsrover.model.Position;

/**
 * Command interface representing an action to be performed on a Position.
 */
@FunctionalInterface
public interface Command {
    /**
     * Applies this command to the given position and returns the resulting position.
     *
     * @param position the starting position
     * @return the resulting position after applying the command
     */
    Position apply(Position position);
}
