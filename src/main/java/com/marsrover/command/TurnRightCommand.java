package com.marsrover.command;

import com.marsrover.model.Position;

/**
 * Command that rotates the rover 90 degrees to the right (clockwise).
 */
public class TurnRightCommand implements Command {

    @Override
    public Position apply(Position position) {
        return position.turnRight();
    }
}
