package com.marsrover.command;

import com.marsrover.model.Position;

/**
 * Command that rotates the rover 90 degrees to the left (counterclockwise).
 */
public class TurnLeftCommand implements Command {

    @Override
    public Position apply(Position position) {
        return position.turnLeft();
    }
}
