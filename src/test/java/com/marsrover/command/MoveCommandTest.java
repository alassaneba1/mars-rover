package com.marsrover.command;

import com.marsrover.model.Direction;
import com.marsrover.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    @Test
    void shouldMoveForwardNorth() {
        Position start = new Position(1, 1, Direction.N);
        Position result = new MoveCommand().apply(start);
        assertEquals("1 2 N", result.toString());
    }

    @Test
    void shouldMoveForwardWest() {
        Position start = new Position(1, 1, Direction.W);
        Position result = new MoveCommand().apply(start);
        assertEquals("0 1 W", result.toString());
    }
}
