package org.example.app;

import java.util.List;
import org.example.input.InputHandler;

public class Computer extends Player {

    public Computer(boolean isBlackPlayer) {
        super(isBlackPlayer);
    }

    @Override
    public int chooseMove(List<Integer> availableMoves, InputHandler inputHandler, Board board) {
        // Implement computer logic for choosing a move
        // For example, randomly selecting a move from availableMoves
        int randomIndex = (int) (Math.random() * availableMoves.size());
        return availableMoves.get(randomIndex);
    }
}
