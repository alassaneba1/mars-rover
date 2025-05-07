package com.marsrover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testRotateLeft() {
        assertEquals(Direction.W, Direction.N.rotateLeft());
        assertEquals(Direction.S, Direction.W.rotateLeft());
        assertEquals(Direction.E, Direction.S.rotateLeft());
        assertEquals(Direction.N, Direction.E.rotateLeft());
    }

    @Test
    void testRotateRight() {
        assertEquals(Direction.E, Direction.N.rotateRight());
        assertEquals(Direction.S, Direction.E.rotateRight());
        assertEquals(Direction.W, Direction.S.rotateRight());
        assertEquals(Direction.N, Direction.W.rotateRight());
    }
}
