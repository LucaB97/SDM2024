package org.example.app;

import org.example.board.Computer;
import org.example.board.Human;
import org.example.board.Player;
import org.example.endgame.CompletePathCondition;
import org.example.endgame.ConsoleEndGame;
import org.example.endgame.EndConditionChecker;
import org.example.endgame.EndGameDealer;
import org.example.input.ConsoleInputHandler;
import org.example.input.InputHandler;


public class QuentinConsole {  

    public static void main(String[] args) {
        
        Game newGame;        

        if (args.length > 0) {
            
            try {
                // Parse the first argument as an integer
                int size = Integer.parseInt(args[0]);
                InputHandler inputHandler = new ConsoleInputHandler();
                EndConditionChecker endCondition = new CompletePathCondition();
                EndGameDealer endGameDealer = new ConsoleEndGame();
                Player blackPlayer = new Human(true); // or new Computer(true);
                Player whitePlayer = new Computer(false); // or new Human(false);
                newGame = new Game(size, inputHandler, endCondition, endGameDealer, blackPlayer, whitePlayer);
            
            } catch (NumberFormatException e) {
                System.out.println("The argument is not a valid integer.");
                return;
            }
       
        } else {
            newGame = new Game();
        }
        
        System.out.println(newGame.board + "\n");
        newGame.playGame();
    }
}