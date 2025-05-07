package com.marsrover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testIsWithinBounds() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isWithinBounds(new Position(0, 0, Direction.N)));
        assertTrue(plateau.isWithinBounds(new Position(5, 5, Direction.S)));
        assertFalse(plateau.isWithinBounds(new Position(6, 5, Direction.E)));
        assertFalse(plateau.isWithinBounds(new Position(-1, 0, Direction.W)));
    }
}
