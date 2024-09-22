package org.example.app;

import java.util.List;
import org.example.input.InputHandler;

public abstract class Player {
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

    // Abstract method for choosing a move
    public abstract int chooseMove(List<Integer> availableMoves, InputHandler inputHandler, Board board);
}
