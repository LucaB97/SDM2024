package org.example.board;

import java.util.List;

import org.example.input.ConsoleInputHandler;
import org.example.input.InputHandler;
import exceptions.*;


public class Human extends Player {

    public Human(boolean isBlackPlayer) {
        super(isBlackPlayer);
    }

    @Override
    public int chooseMove(List<Integer> availableMoves, InputHandler inputHandler, Board board) {
        if (inputHandler instanceof ConsoleInputHandler) {
            System.out.println(getName() + " MOVES");
        }

        int move;
        
        while (true) {
            try {
                move = inputHandler.getNextMove(board, null);
                if (availableMoves.contains(move)) {
                    return move;
                } else {
                    System.out.println("Illegal move. Try again!\n");
                }
            } catch (IncorrectFormatException | OutOfRangeLocationException | OccupiedLocationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
