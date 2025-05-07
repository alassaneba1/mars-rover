package com.marsrover.command;

import com.marsrover.model.Direction;
import com.marsrover.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TurnLeftCommandTest {

    @Test
    void shouldRotateLeft() {
        Position start = new Position(1, 1, Direction.N);
        Position result = new TurnLeftCommand().apply(start);
        assertEquals(Direction.W, result.getDirection());
    }
}
