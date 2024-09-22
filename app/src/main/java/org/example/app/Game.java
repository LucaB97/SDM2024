package org.example.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.example.endgame.CompletePathCondition;
import org.example.endgame.EndConditionChecker;
import org.example.input.ConsoleInputHandler;
import org.example.input.InputHandler;
import exceptions.*;


public class Game {

    final static int default_size = 13;
    protected final Board board;
    protected final InputHandler inputHandler;
    protected final EndConditionChecker endConditionChecker;
    private final Player blackPlayer;
    private final Player whitePlayer;

    public Game() {
        this.board = new Board(default_size);
        this.inputHandler = new ConsoleInputHandler();
        this.endConditionChecker = new CompletePathCondition();
        this.blackPlayer = new Player(true);
        this.whitePlayer = new Player(false);
    }   

    public Game(int size) {
        this.board = new Board(size);
        this.inputHandler = new ConsoleInputHandler();
        this.endConditionChecker = new CompletePathCondition();
        this.blackPlayer = new Player(true);
        this.whitePlayer = new Player(false);
    } 

    public Game(int size, InputHandler inputHandler, EndConditionChecker endConditionChecker) {
        this.board = new Board(size);
        this.inputHandler = inputHandler;
        this.endConditionChecker = endConditionChecker;
        this.blackPlayer = new Player(true);
        this.whitePlayer = new Player(false);
    }    


    boolean isLocationAdjacent(List<Integer> region, int location) {
        /* It evaluates whether the region (first argument) contains any direct 
           (or indirect) adjacent locations to a specific empty location (second argument) */
       
        // Find all the empty neighbours of the points of the region
        Set<Integer> regionNeighbours = new TreeSet<>();
        for (int member : region) {
            regionNeighbours.addAll(board.findNeighbours(member));
        }
        regionNeighbours.removeIf(index -> board.grid.get(index) != -1);
        
        // Find the neighbours of the point to verify adjacency to the region
        Set<Integer> locationNeighboursExtended = new TreeSet<>(board.findNeighbours(location));
        locationNeighboursExtended.removeIf(index -> board.grid.get(index) != -1);
        locationNeighboursExtended.add(location);
        Set<Integer> temporarySet = new TreeSet<>(locationNeighboursExtended);

        while (true) {
            // extend the research for (indirect) neighbours of the point
            for (int x : temporarySet) {
                locationNeighboursExtended.addAll(board.findNeighbours(x));
            }
            locationNeighboursExtended.removeIf(index -> board.grid.get(index) != -1);

            // Early exit if the point is adjacent to the region
            Set<Integer> overlapCheck = new TreeSet<>(locationNeighboursExtended);
            overlapCheck.retainAll(regionNeighbours);
            if (!overlapCheck.isEmpty())
                return true;

            // If no more new locations are found, stop the search
            if (locationNeighboursExtended.equals(temporarySet))
                break;

            // Update the set of neighbors to include the indirect ones
            temporarySet.clear();
            temporarySet.addAll(locationNeighboursExtended);
        }
        
        return false;
    }

    
    List<Integer> findNextRegion(final List<Integer> emptyLocations) {
        /* It determines the next region (group of adjacent empty locations) in the board */
        
        List<Integer> regionLocations = new ArrayList<>();
        for (int next : emptyLocations) {                
            if (regionLocations.isEmpty() || isLocationAdjacent(regionLocations, next)) {
                regionLocations.add(next);
            }
        }
        return regionLocations;
    }


    boolean isValidTerritory(final List<Integer> region) {            
        /* It checks if the region verifies the condition to be considered a territory:
         * each location in the region has at least two not-empty neighbours */

        int counterNotEmptyNeighbours = 0;
        for (int member : region) {
            for (int i : board.findNeighbours(member)) {
                if (board.grid.get(i) != -1)
                    counterNotEmptyNeighbours++;
            }
            if (counterNotEmptyNeighbours < 2)
                return false;
            counterNotEmptyNeighbours = 0;
        }
        return true;
    }


    List<Integer> fillTerritory(final List<Integer> territory, final int lastMove) {
        /* It fills all the locations in the territory with the color of the player who has the majority of the filled neighbours 
           (in the event of a tie, the territory gets the color of the player who did not make the last move) */

        // Find all the distinct neighbours of the points of a territory
        Set<Integer> distinctNeighbours = new TreeSet<>();
        for (int member : territory)
            distinctNeighbours.addAll(board.findNeighbours(member));
        distinctNeighbours.removeAll(territory);

        // Count how many neighbours are WHITE and how many BLACK
        int counterBlackNeighbours = 0, counterWhiteNeighbours = 0;
        for (int i : distinctNeighbours) {
            if (board.grid.get(i) == 0)
                counterBlackNeighbours++;
            else if (board.grid.get(i) == 1)
                counterWhiteNeighbours++;
        }

        // If the counters have the same value, increase the counter of the player who did not play the last move
        if (counterBlackNeighbours == counterWhiteNeighbours) {
            if (board.grid.get(lastMove) == 1)
                counterBlackNeighbours++;
            else
                counterWhiteNeighbours++;
        }

        // Assign to all locations in the territory a value according to the counts
        final int replacement = (counterBlackNeighbours < counterWhiteNeighbours)? 1 : 0;
        territory.forEach(index -> board.grid.set(index, replacement));

        // The newly inserted values are returned (useful for tests)
        List<Integer> values = new ArrayList<>();
        for (int index : territory) {
            values.add(board.grid.get(index));
        }

        return values;
    }


    boolean isLegal(final int location) {
        /* It verifies if a certain configuration is legal or not.
           A location is illegal if it has one or more like-colored diagonal points and no like-colored neighbours */
        
        List<Integer> likeColoredNeighbours = new ArrayList<>();

        // Check for and store the locations of the like-colored neighbours
        for (int i : board.findNeighbours(location)) {
            if (board.grid.get(i) == board.grid.get(location)) {
                likeColoredNeighbours.add(i);
            }
        }

        // Verify if any of the diagonally adjacent points are like-colored and share any of the neighbours from before
        for (int i : board.findDiagonals(location)) {
            if (board.grid.get(i) == board.grid.get(location)) {
                Set<Integer> commonNeighbours = new TreeSet<>(board.findNeighbours(i));
                commonNeighbours.retainAll(likeColoredNeighbours);

                if (commonNeighbours.isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }


    public List<Integer> updateBoard(final boolean isBlackPlayer, final int move) {
        /* It identifies the regions, one at a time, until all the empty locations have been considered, and fills them 
               if they have the requirements to be considered a territory */

        List<Integer> emptyLocations = new ArrayList<>();            
        List<Integer> currentRegion = new ArrayList<>();
        List<Integer> territories = new ArrayList<>();

        board.grid.set(move, isBlackPlayer ? 0 : 1);
        emptyLocations = board.findEmptyLocations(true);
        // (1) 
        while (!emptyLocations.isEmpty()) {                    
            currentRegion = findNextRegion(emptyLocations);
            if (isValidTerritory(currentRegion)) {
                fillTerritory(currentRegion, move);
                territories.addAll(currentRegion);
            }                    
            emptyLocations.removeAll(currentRegion);                    
        }

        territories.add(0, move);
        return territories;
    }      


    public List<Integer> findAvailableMoves(final boolean isBlackPlayer) {
        /* It returns the available moves for the player, given the current board configuration */

        List<Integer> emptyLocations = board.findEmptyLocations(true);
        List<Integer> filledLocations = new ArrayList<>();
        List<Integer> availableMoves = new ArrayList<>();

        for (int current : emptyLocations) {
            filledLocations = updateBoard(isBlackPlayer, current);

            for (int x : filledLocations) {
                if (!isLegal(x)) {
                    filledLocations.forEach(index -> board.grid.set(index, -1));
                    filledLocations.clear();
                    break;
                }
            }

            if (!filledLocations.isEmpty()) {
                availableMoves.add(current);
                filledLocations.forEach(index -> board.grid.set(index, -1));
                filledLocations.clear();
            }
        }

        return availableMoves;   
    }
    

    public boolean isGameover() {
        /* It verifies if there is a winning path for any of the players */
        
        endConditionChecker.getBoardConfiguration(board);
        
        if (endConditionChecker.checkConditionBlack()) {
            System.out.println("BLACK WON!");
            return true;
        } else if (endConditionChecker.checkConditionWhite()) {
            System.out.println("WHITE WON!");
            return true;
        } else
            return false;

    }


    public void makeMove(Player player) {
        List<Integer> availableMoves = findAvailableMoves(player.isBlack());

        if (availableMoves.isEmpty())
            throw new NoMovesAvailableException(player.getName() + " has no available moves"); 
        
        int lastMove = player.chooseMove(availableMoves, inputHandler, board);
        updateBoard(player.isBlack(), lastMove);
        System.out.println(board + "\n");
            
    }


    public void playGame() {
        
        while (true) {
            // Black
            makeMove(blackPlayer);
            if (!isGameover()) 
                break;
            
            // White
            makeMove(whitePlayer);
            if (!isGameover()) 
                break;
        }
    }

}
