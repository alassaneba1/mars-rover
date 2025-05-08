package com.marsrover.parser;

import com.marsrover.command.Command;
import com.marsrover.model.Direction;
import com.marsrover.model.Plateau;
import com.marsrover.model.Position;
import com.marsrover.model.Rover;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Parses the input file and creates Plateau, Rovers, and their corresponding commands.
 */
public class InputParser {

    private final CommandParser commandParser = new CommandParser();

    public record RoverInstructions(Rover rover, List<Command> commands) {}

    /**
     * Parses the input file and returns the plateau and list of rovers + their commands.
     *
     * @param pathToFile path to the input.txt file
     * @return a Map with the Plateau and list of RoverInstructions
     * @throws IOException if the file can't be read
     */
    public Map.Entry<Plateau, List<RoverInstructions>> parseInput(Path pathToFile) throws IOException {
        List<String> lines = Files.readAllLines(pathToFile);
        if (lines.size() < 3 || lines.size() % 2 == 0)
            throw new IllegalArgumentException("Invalid input format");

        // Plateau size
        String[] plateauParts = lines.getFirst().split(" ");
        int maxX = Integer.parseInt(plateauParts[0]);
        int maxY = Integer.parseInt(plateauParts[1]);
        Plateau plateau = new Plateau(maxX, maxY);

        List<RoverInstructions> rovers = new ArrayList<>();

        for (int i = 1; i < lines.size(); i += 2) {
            // Position line
            String[] posParts = lines.get(i).split(" ");
            int x = Integer.parseInt(posParts[0]);
            int y = Integer.parseInt(posParts[1]);
            Direction direction = Direction.valueOf(posParts[2]);

            Position startPosition = new Position(x, y, direction);
            Rover rover = new Rover(startPosition, plateau);

            // Instruction line
            String instructionLine = lines.get(i + 1);
            List<Command> commands = commandParser.parse(instructionLine);

            rovers.add(new RoverInstructions(rover, commands));
        }

        return Map.entry(plateau, rovers);
    }
}
