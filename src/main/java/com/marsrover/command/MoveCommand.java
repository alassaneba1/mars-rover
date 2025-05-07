package com.marsrover.command;

import com.marsrover.model.Position;

/**
 * Command that moves the rover one step forward in its current direction.
 */
public class MoveCommand implements Command {

    @Override
    public Position apply(Position position) {
        return position.moveForward();
    }
}
