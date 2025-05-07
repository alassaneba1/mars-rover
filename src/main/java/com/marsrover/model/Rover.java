package com.marsrover.model;

import com.marsrover.command.Command;
import lombok.Getter;

/**
 * Represents a robotic rover on the Mars plateau.
 * Holds its current position and applies movement commands.
 */
@Getter
public class Rover {
    private Position position;
    private final Plateau plateau;

    public Rover(Position startPosition, Plateau plateau) {
        this.position = startPosition;
        this.plateau = plateau;
    }

    /**
     * Executes a single movement command (L, R, or M).
     *
     * @param command the command to execute
     */
    public void execute(Command command) {
        Position newPosition = command.apply(this.position);

        if (plateau.isWithinBounds(newPosition)) {
            this.position = newPosition;
        } else {
            System.err.println("🚫 Out of bounds: " + newPosition);
        }
    }

    /**
     * Executes a sequence of commands in order.
     *
     * @param commands list of movement commands
     */
    public void executeAll(Iterable<Command> commands) {
        for (Command command : commands) {
            execute(command);
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
