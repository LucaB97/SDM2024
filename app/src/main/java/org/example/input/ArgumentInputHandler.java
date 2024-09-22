package org.example.input;

import org.example.app.*;
import exceptions.IncorrectFormatException;
import exceptions.OccupiedLocationException;
import exceptions.OutOfRangeLocationException;

import java.util.List;

public class ArgumentInputHandler implements InputHandler {

    @Override
    public int getNextMove(Board board, String move) {
        return validateMove(board, move);
    }

    private int validateMove(Board board, String userInput) {
        /* It checks whether the input move can be fulfilled, specifically if:
         * the format of the input is correct (<letter><number>),
         * the location is valid (i.e., it is within the limits of the board),
         * the location is free (not occupied by the player or the opponent). */

        String inputExpectedPattern = "[a-zA-Z]\\d+";
        if (!userInput.matches(inputExpectedPattern)) {
            throw new IncorrectFormatException("Incorrect format. Try again!\n");
        }

        int moveLetter = userInput.toLowerCase().charAt(0) - 'a';
        int moveNumber = Integer.parseInt(userInput.substring(1));
        int location = moveLetter * board.sideLength + (moveNumber - 1);

        if (location < 0 || location >= board.grid.size() || moveNumber <= 0 || moveNumber > board.sideLength) {
            throw new OutOfRangeLocationException("Location out of range. Try again!\n");
        }

        List<Integer> filledLocations = board.findEmptyLocations(false);
        if (filledLocations.contains(location)) {
            throw new OccupiedLocationException("Location already filled. Try again!\n");
        }

        return location;
    }
}

