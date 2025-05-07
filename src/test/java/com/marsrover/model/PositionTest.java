package com.marsrover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testMoveForwardNorth() {
        Position pos = new Position(1, 1, Direction.N);
        Position expected = new Position(1, 2, Direction.N);
        assertEquals(expected.toString(), pos.moveForward().toString());
    }

    @Test
    void testTurnLeft() {
        Position pos = new Position(1, 1, Direction.N);
        assertEquals(Direction.W, pos.turnLeft().getDirection());
    }

    @Test
    void testTurnRight() {
        Position pos = new Position(1, 1, Direction.N);
        assertEquals(Direction.E, pos.turnRight().getDirection());
    }
}
