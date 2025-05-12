package com.marsrover;

import com.marsrover.model.Rover;
import com.marsrover.parser.InputParser;
import com.marsrover.parser.InputParser.RoverInstructions;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Entry point of the Mars Rover simulation.
 * Expects one argument: the path to the input file.
 */
 public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar rover.jar input.txt");
            return;
        }

        String inputFile = args[0];
        InputParser parser = new InputParser();

        try {
            Map.Entry<?, List<RoverInstructions>> result = parser.parseInput(Path.of(inputFile));
            List<RoverInstructions> roverInstructionsList = result.getValue();

            for (RoverInstructions roverInstructions : roverInstructionsList) {
                Rover rover = roverInstructions.rover();
                rover.executeAll(roverInstructions.commands());
                System.out.println(rover); // prints: x y direction
            }

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
