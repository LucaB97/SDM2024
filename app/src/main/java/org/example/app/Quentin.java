package org.example.app;

import org.example.endgame.CompletePathCondition;
import org.example.endgame.EndConditionChecker;
import org.example.input.ConsoleInputHandler;
import org.example.input.InputHandler;

public class Quentin {  

    public static void main(String[] args) {
        
        Game myBoard;        

        if (args.length > 0) {
            try {
                // Parse the first argument as an integer
                int size = Integer.parseInt(args[0]);
                InputHandler inputHandler = new ConsoleInputHandler();
                EndConditionChecker endCondition = new CompletePathCondition();
                myBoard = new Game(size, inputHandler, endCondition);
            } catch (NumberFormatException e) {
                System.out.println("The argument is not a valid integer.");
                return;
            }
        } else {
            myBoard = new Game();
        }
        System.out.println(myBoard + "\n");
        

    }
}