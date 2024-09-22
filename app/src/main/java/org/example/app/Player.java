package org.example.app;

import java.util.List;
import org.example.input.InputHandler;
import exceptions.*;

public class Player {
    private final boolean isBlackPlayer; // true for black, false for white
    private final String name;

    public Player(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        this.name = (isBlackPlayer) ? "Black" : "White";
    }

    public Player(boolean isBlackPlayer, String name) {
        this.isBlackPlayer = isBlackPlayer;
        this.name = name;
    }

    public boolean isBlack() {
        return isBlackPlayer;
    }

    public String getName() {
        return name;
    }

    // Player only chooses a move from available options, it doesn't validate the move
    public int chooseMove(List<Integer> availableMoves, InputHandler inputHandler, Board board) {
        System.out.println(name + " MOVES");
        int move;
        while (true) {
            try {
                if (availableMoves.contains(move = inputHandler.getNextMove(board, null)))
                    return move;
                else
                    System.out.println("Illegal move. Try again!\n");
                    
            } catch (IncorrectFormatException | OutOfRangeLocationException | OccupiedLocationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
