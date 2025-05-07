package com.marsrover.model;

import com.marsrover.command.MoveCommand;
import com.marsrover.command.TurnLeftCommand;
import com.marsrover.command.TurnRightCommand;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void testExecuteSingleMove() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(new Position(1, 2, Direction.N), plateau);
        rover.execute(new MoveCommand());
        assertEquals("1 3 N", rover.toString());
    }

    @Test
    void testExecuteAll() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(new Position(1, 2, Direction.N), plateau);
        rover.executeAll(List.of(
                new TurnLeftCommand(),
                new MoveCommand(),
                new TurnLeftCommand(),
                new MoveCommand(),
                new TurnLeftCommand(),
                new MoveCommand(),
                new TurnLeftCommand(),
                new MoveCommand(),
                new MoveCommand()
        ));
        assertEquals("1 3 N", rover.toString());
    }
}
