package org.example.endgame;

import org.example.board.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CompletePathCondition implements EndConditionChecker {
    

    protected Board board;

    public void getBoardConfiguration(Board currentBoard) {
        board = currentBoard;
    }

    private boolean checkCondition(int initialLocation, List<Integer> excludedLocations, Set<Integer> candidatePath) {
        /* Recursive function. 
           It checks for a winning path for a specific player:
           - a top-to-bottom way of orthogonally adjacent points, for the black player; 
           - a left-to-right way for the white player.
           The "exclude" list is populated with the already considered points: 
           they must be removed to prevent the function to get stuck.
           */
        
        List<Integer> sameColorNeighbours = new ArrayList<>();
        for (Integer n : board.findNeighbours(initialLocation)) {
            if (board.grid.get(n).equals(board.grid.get(initialLocation)) && !excludedLocations.contains(n))
                sameColorNeighbours.add(n);
        }

        // Eligible locations for the end of a winning path: last row for black, last column for white
        List<Integer> arrivalLocations = new ArrayList<>();
        for (int i = 0; i < board.sideLength; i++) {
            if (board.grid.get(initialLocation) == 0)
                arrivalLocations.add(board.grid.size() - board.sideLength + i);
            else
                arrivalLocations.add(i*board.sideLength + board.sideLength - 1);
        }
        
        // Base case
        if (arrivalLocations.contains(initialLocation)) {
            return true;
        } 
        // Recursive case
        else {                
            excludedLocations.add(initialLocation);
            for (Integer x : sameColorNeighbours) {
                if (checkCondition(x, excludedLocations, candidatePath)) {
                    candidatePath.add(x);
                    candidatePath.add(initialLocation);
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public boolean checkConditionBlack() {
        
        Set<Integer> blackWinningPath = new TreeSet<>();
        boolean blackWon = false;
        int initialLocationBlack = 0;

        while (!blackWon && initialLocationBlack<board.sideLength) {
            if (board.grid.get(initialLocationBlack) == 0)
                blackWon = checkCondition(initialLocationBlack, new ArrayList<Integer>(), blackWinningPath);
                initialLocationBlack++;
        }

        return blackWon;
    }


    @Override
    public boolean checkConditionWhite() {
        
        Set<Integer> whiteWinningPath = new TreeSet<>();
        boolean whiteWon = false;
        int rowIndex = 0;
        int initialLocationWhite;
        
        while (!whiteWon && rowIndex<board.sideLength) {
            initialLocationWhite = rowIndex*board.sideLength;
            if (board.grid.get(initialLocationWhite) == 1)
                whiteWon = checkCondition(initialLocationWhite, new ArrayList<Integer>(), whiteWinningPath);
            rowIndex++;
        }

        return whiteWon;
    }
}
