package org.example.app;

import org.example.endgame.CompletePathCondition;
import org.example.endgame.EndConditionChecker;
import org.example.input.ConsoleInputHandler;
import org.example.input.InputHandler;

public class Quentin {  

    public static void main(String[] args) {
        
        Game newGame;        

        if (args.length > 0) {
            try {
                // Parse the first argument as an integer
                int size = Integer.parseInt(args[0]);
                InputHandler inputHandler = new ConsoleInputHandler();
                EndConditionChecker endCondition = new CompletePathCondition();
                newGame = new Game(size, inputHandler, endCondition);
            } catch (NumberFormatException e) {
                System.out.println("The argument is not a valid integer.");
                return;
            }
        } else {
            newGame = new Game(5, new ConsoleInputHandler(), new CompletePathCondition());
        }
        System.out.println(newGame.board + "\n");
        newGame.playGame();
    }
}