package org.example.app;

import java.util.List;
import java.util.ArrayList;
import exceptions.*;

public class Quentin {  

    public static void main(String[] args) throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        Game myBoard;

        if (args.length > 0) {
            try {
                // Parse the first argument as an integer
                int size = Integer.parseInt(args[0]);
                myBoard = new Game(size);
            } catch (NumberFormatException e) {
                System.out.println("The argument is not a valid integer.");
                return;
            }
        } else {
            myBoard = new Game();
        }
        System.out.println(myBoard + "\n");

        List<Integer> blackMoves = new ArrayList<>();
        List<Integer> whiteMoves = new ArrayList<>();
        int lastMove;

        do {
            // Black
            blackMoves = myBoard.findAvailableMoves(true);
            System.out.println(blackMoves);
            if (!blackMoves.isEmpty()) {
                System.out.println("BLACK MOVES");                
                while (!blackMoves.contains(lastMove = myBoard.getNextMove(true))) {System.out.println("Illegal move. Try again!\n");}
                myBoard.updateBoard(true, lastMove);
                System.out.println(myBoard + "\n");
            } 

            // White
            if (!myBoard.isGameover()) {
                whiteMoves = myBoard.findAvailableMoves(false);
                System.out.println(whiteMoves);
                if (!whiteMoves.isEmpty()) {
                    System.out.println("WHITE MOVES");                
                    while (!whiteMoves.contains(lastMove = myBoard.getNextMove(false))) {System.out.println("Illegal move. Try again!\n");}
                    myBoard.updateBoard(false, lastMove);
                    System.out.println(myBoard + "\n");
                }    
            }
            
        } while (!myBoard.isGameover());

    }
}