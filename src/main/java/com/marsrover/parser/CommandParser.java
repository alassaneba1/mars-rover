package com.marsrover.parser;

import com.marsrover.command.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses a string of characters into a list of executable Command objects.
 */
public class CommandParser {

    /**
     * Converts a string like "LMLMRM" into a list of Command objects.
     *
     * @param instructionString the input string of instructions
     * @return list of Command objects
     * @throws IllegalArgumentException if an unknown instruction is found
     */
    public List<Command> parse(String instructionString) {
        List<Command> commands = new ArrayList<>();

        for (char c : instructionString.toCharArray()) {
            switch (c) {
                case 'L' -> commands.add(new TurnLeftCommand());
                case 'R' -> commands.add(new TurnRightCommand());
                case 'M' -> commands.add(new MoveCommand());
                default -> throw new IllegalArgumentException("Unknown instruction: " + c);
            }
        }

        return commands;
    }
}
