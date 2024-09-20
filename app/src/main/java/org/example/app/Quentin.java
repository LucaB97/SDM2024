package org.example.app;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import exceptions.*;



public class Quentin {


    public static class Game {

        protected List<Integer> board = new ArrayList<>();
        private int sideLength;
        private final Scanner scanner = new Scanner(System.in);
        
        public Game(final int size) {
            board.addAll(Collections.nCopies(size*size, -1));
            sideLength = size;
        }    



        @Override
        public String toString() {
            /* Print the board to the terminal */
            
            String rows = "abcdefghijklm";
            int rowIndex = 0;
            String printed = "\n   _____" + "______".repeat(sideLength-1) + "____\n";
            printed = printed + "  |     " + "      ".repeat(sideLength-1) + "    |\n";
            String separator;            

            for (int i = 0 ; i < board.size() ; i++) {
                separator = i % sideLength != 0 ? " ... " : " " + rows.charAt(rowIndex++) + "|    ";
                if (board.get(i) == 0)
                    printed = printed + separator + "B";
                else if (board.get(i) == 1) 
                    printed = printed + separator + "W";
                else
                    printed = printed + separator + " ";

                if (i%sideLength == sideLength-1) {
                    if (i < board.size()-sideLength)
                        printed = printed + "    |\n  |   " + " :    ".repeat(sideLength) + "|\n  |   " + " :    ".repeat(sideLength) + "|\n";
                    else
                    printed = printed + "    |\n";
                }
            }

            printed = printed + "  |_____" + "______".repeat(sideLength-1) + "____|\n       ";
            for (int i = 0 ; i < sideLength ; i++) 
                printed = printed + (i+1) + "     ";

            return printed;
        }



        public List<String> convert(final Set<Integer> values) {
            /* converts the locations of the board array in the <letter><number> format, useful when printing the winning path */
            List<String> convertedValues = new ArrayList<>();
            int column, row;

            for (int v : values) {
                column = v % sideLength;
                row = v / sideLength + 1;
                convertedValues.add((char)('a' + row - 1) + Integer.toString(column));
            }

            return convertedValues;
        }
        


        public boolean checkIsGameover() {
            /* It verifies if there is a winning path for any of the players */

            Set<Integer> winningPath = new TreeSet<>();
            
            // Check if a winning path for the black player exists, from each of the possible starting locations (first row)
            boolean blackWon = false;
            int initialLocationBlack = 0;

            while (!blackWon && initialLocationBlack<sideLength) {
                if (board.get(initialLocationBlack) == 0)
                    blackWon = isWinningPath(initialLocationBlack, new ArrayList<Integer>(), winningPath);
                    initialLocationBlack++;
            }

            if (blackWon) {
                System.out.println("BLACK WON!");
                List<String> winningPathPositions = convert(winningPath);
                System.out.println(winningPathPositions);
                return true;
            }

            // Check if a winning path for the white player exists, from each of the possible starting locations (first column)
            boolean whiteWon = false;
            int rowIndex = 0;
            int initialLocationWhite;
            
            while (!whiteWon && rowIndex<sideLength) {
                initialLocationWhite = rowIndex*sideLength;
                if (board.get(initialLocationWhite) == 1)
                    whiteWon = isWinningPath(initialLocationWhite, new ArrayList<Integer>(), winningPath);
                rowIndex++;
            }

            if (whiteWon) {
                System.out.println("WHITE WON!");
                List<String> winningPathPositions = convert(winningPath);
                System.out.println(winningPathPositions);
                return true;
            }

            return false;
        }



        public boolean isWinningPath(final int initialLocation, List<Integer> excludedLocations, Set<Integer> candidatePath) {            
            /* Recursive function. 
               It checks for a winning path for a specific player:
               - a top-to-bottom way of orthogonally adjacent points, for the black player; 
               - a left-to-right way for the white player.
               The "exclude" list is populated with the already considered points: 
               they must be removed to prevent the function to get stuck.
               */
            
            List<Integer> sameColorNeighbours = new ArrayList<>();
            for (Integer n : findNeighbours(initialLocation)) {
                if (board.get(n).equals(board.get(initialLocation)) && !excludedLocations.contains(n))
                    sameColorNeighbours.add(n);
            }

            // Eligible locations for the end of a winning path: last row for black, last column for white
            List<Integer> arrivalLocations = new ArrayList<>();
            for (int i = 0; i < sideLength; i++) {
                if (board.get(initialLocation) == 0)
                    arrivalLocations.add(board.size() - sideLength + i);
                else
                    arrivalLocations.add(i*sideLength + sideLength - 1);
            }
            
            // Base case
            if (arrivalLocations.contains(initialLocation)) {
                return true;
            } 
            // Recursive case
            else {                
                excludedLocations.add(initialLocation);
                for (Integer x : sameColorNeighbours) {
                    if (isWinningPath(x, excludedLocations, candidatePath)) {
                        candidatePath.add(x);
                        candidatePath.add(initialLocation);
                        return true;
                    }
                }
            }
            return false;
        }



        public List<Integer> findNeighbours(final int location) {
            /* It returns the orthogonally adjacent points to the input point */

            List<Integer> neighboursList = new ArrayList<>();            
            
            if (location-sideLength >= 0)
                neighboursList.add(location-sideLength);
            
            if ((location-1 >= 0) && (location/sideLength == (location-1)/sideLength))
                neighboursList.add(location-1); 
            
            if ((location+1 < board.size()) && (location/sideLength == (location+1)/sideLength))
                neighboursList.add(location+1);      
            
            if (location+sideLength < board.size())
                neighboursList.add(location+sideLength);                 
            
            return neighboursList;            
        }



        public List<Integer> findDiagonals(final int location) {
            /* It returns the indexes of the diagonal points of the input point */

            List<Integer> diagonalPointsList = new ArrayList<>();            
            
            if (location-sideLength-1 >= 0 && (location-1)/sideLength == location/sideLength)
                diagonalPointsList.add(location-sideLength-1);
            
            if (location-sideLength+1 >= 0 && (location+1)/sideLength == location/sideLength)
                diagonalPointsList.add(location-sideLength+1); 
            
            if (location+sideLength-1 < board.size() && (location-1)/sideLength == location/sideLength && location != 0)
                diagonalPointsList.add(location+sideLength-1);     
            
            if (location+sideLength+1 < board.size() && (location+1)/sideLength == location/sideLength)
                diagonalPointsList.add(location+sideLength+1);     
            
            return diagonalPointsList;  
        }



        public List<Integer> findEmptyLocations(boolean empty) {
            /* It returns the current set of empty locations (empty=true) or empty locations (empty=false) */

            List<Integer> locationsList;
            if (empty) {
                locationsList = IntStream.range(0, board.size())
                    .filter(index -> board.get(index) == -1)
                    .boxed()
                    .collect(Collectors.toList());
            } else {
                locationsList = IntStream.range(0, board.size())
                    .filter(index -> board.get(index) != -1)
                    .boxed()
                    .collect(Collectors.toList());
            }
            return locationsList;
        }



        public int getNextMove(final boolean isBlackPlayer) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* It gets a new input and checks whether the request for the next move can be fulfilled, specifically if:
             * the format of the input is correct (<letter><number>),
             * the location is valid (i.e., it is within the limits of the board),
             * the location is free (not occupied by the player or the opponent).
             * The procedure is repeated until all the checks are passed successfully, then the location is filled and its index returned */
            
            List<Integer> filledLocations = findEmptyLocations(false);
            boolean isValidMove = false;
            boolean isFreeLocation = false;
            String input_expected_pattern = "[a-zA-Z]\\d+";    //used to verify the input format
            int location = -1;
            String userInput;

            while (!isValidMove || !isFreeLocation) {
                try {
                    
                    System.out.println("Enter a position in the board (e.g.: a1): ");
                    userInput = scanner.nextLine();

                    if (!(userInput.matches(input_expected_pattern))) {
                        throw new IncorrectFormatException("Incorrect format. Try again!\n");
                    }
                    
                    int moveLetter = userInput.toLowerCase().charAt(0) - 'a';
                    int moveNumber = Integer.parseInt(userInput.substring(1));
                    location = moveLetter * sideLength + (moveNumber-1);
                    
                    isValidMove = location >= 0 && location < board.size() && moveNumber > 0 && moveNumber <= sideLength;
                    isFreeLocation = !filledLocations.contains(location);
                    if (!isValidMove) {
                        throw new InvalidLocationException("Invalid location. Try again!\n");                        
                    } else if (!isFreeLocation) {
                        throw new OccupiedLocationException("Location already filled. Try again!\n");
                    }

                    // If all the checks are passed, fill the location with the color of the player
                    board.set(location, isBlackPlayer ? 0 : 1);

                } catch (IncorrectFormatException | InvalidLocationException | OccupiedLocationException e) {
                    System.out.println(e.getMessage());
                }
            }
            return location;
        }



        public int nextMove_tests(final boolean black, final String userInput) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* Variation of the previous function, which takes as argument the next location (useful for tests) */
            
            List<Integer> filledLocations = findEmptyLocations(false);
            String pattern = "[a-zA-Z]\\d+";    //used to verify the input format

            if (!(userInput.matches(pattern))) {
                throw new IncorrectFormatException("Incorrect format. Try again!\n");
            }
            
            int letter = userInput.toLowerCase().charAt(0) - 'a';
            int number = Integer.parseInt(userInput.substring(1));
            int location = letter*sideLength + (number-1);
            
            boolean validMove =  location>=0 && location<board.size() && number>0 && number<=sideLength;
            boolean freeLocation = !filledLocations.contains(location);
            if (!validMove) {
                throw new InvalidLocationException("Invalid location. Try again!\n");
            }

            if (!freeLocation) {
                throw new OccupiedLocationException("Location already filled. Try again!\n");
            }

            board.set(location, black ? 0 : 1);
            return location;  
        }
        


        public void updateBoard(final boolean isBlackPlayer) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* It updates the board with the last move and all the related changes (if they are compliant to the rules):
               (1) The regions present on the board after the last move are identified and, 
                   if they have the requirements to be considered a territory, they are filled accordingly;
               (2) A check is carried out to verify whether the last move produced some illegal configuration on the board:
                   in this case, all the locations filled during this function call are freed, and a new input is asked for */

            List<Integer> emptyLocations = new ArrayList<>();            
            List<Integer> currentRegion = new ArrayList<>();
            List<Integer> territories = new ArrayList<>();

            int lastMove = getNextMove(isBlackPlayer);

            // Until a valid move is prompted (both the move and the consequent board configuration have to be valid):
            while (true) {
                emptyLocations = findEmptyLocations(true);

                // The regions are identified, one at a time, until all the empty locations have been considered 
                while (!emptyLocations.isEmpty()) {
                    
                    currentRegion = findNextRegion(emptyLocations);
                    if (isTerritory(currentRegion)) {
                        fillTerritory(currentRegion, lastMove);
                        territories.addAll(currentRegion);
                    }
                    
                    // The locations belonging to the region are removed from the list of empty locations
                    emptyLocations.removeAll(currentRegion);                    
                }

                if (!isLegalMove(lastMove)) {
                    board.set(lastMove, -1);
                    territories.forEach(index -> board.set(index, -1));
                    territories.clear();
                    System.out.println("Illegal move. Try again!\n");
                    lastMove = getNextMove(isBlackPlayer);
                }
                else
                    break;
            }      
        }



        public boolean isLegalMove(final int location) {
            /* It verifies if a move is legal, i.e., if at the end of the player's turn 
               there are NOT any couples of points with the same color such that they are diagonally 
               adjacent and the do not share any orthogonally adjacent, like-colored neighbour */
            
            List<Integer> likeColoredNeighbours = new ArrayList<>();

            // Check for and store the locations of the like-colored neighbours of the last point
            for (int i : findNeighbours(location)) {
                if (board.get(i) == board.get(location)) {
                    likeColoredNeighbours.add(i);
                }
            }

            // Verify if any of the diagonally adjacent points are like-colored and share any of the neighbours from before
            for (int i : findDiagonals(location)) {
                if (board.get(i) == board.get(location)) {
                    Set<Integer> commonNeighbours = new TreeSet<>(findNeighbours(i));
                    commonNeighbours.retainAll(likeColoredNeighbours);

                    // If not, the move is illegal!
                    if (commonNeighbours.isEmpty()) {
                        return false;
                    }
                }
            }

            return true;
        }



        public List<Integer> findNextRegion(final List<Integer> emptyLocations) {
            /* It determines the next region (group of adjacent empty locations) in the board */
            
            List<Integer> regionLocations = new ArrayList<>();
            for (int next : emptyLocations) {                
                if (regionLocations.isEmpty() || isLocationAdjacent(regionLocations, next)) {
                    regionLocations.add(next);
                }
            }
            return regionLocations;
        }
        


        public boolean isLocationAdjacent(List<Integer> region, int location) {
            /* It evaluates whether the region (first argument) contains any direct 
               (or indirect) adjacent locations to a specific empty location (second argument) */
           
            // Find all the empty neighbours of the points of the region
            Set<Integer> regionNeighbours = new TreeSet<>();
            for (int member : region) {
                regionNeighbours.addAll(findNeighbours(member));
            }
            regionNeighbours.removeIf(index -> board.get(index) != -1);
            
            // Find the neighbours of the point of which you want to verify the adjacency to the region
            Set<Integer> locationNeighboursExtended = new TreeSet<>(findNeighbours(location));
            locationNeighboursExtended.removeIf(index -> board.get(index) != -1);
            locationNeighboursExtended.add(location);
            
            // If the two sets of neighbours overlap, the point is adjacent to the region 
            Set<Integer> temporarySet = new TreeSet<>(locationNeighboursExtended);
            temporarySet.retainAll(regionNeighbours);
            if (!temporarySet.isEmpty())
                return true;

            // extend the research for (indirect) neighbours of the point
            while (true) {
                
                for (int x : locationNeighboursExtended) {
                    temporarySet.addAll(findNeighbours(x));
                }
                temporarySet.removeIf(index -> board.get(index) != -1);
                
                // If no more locations are found which are adjacent to the point or its current neighbours, return false 
                if (locationNeighboursExtended.equals(temporarySet))
                    return false;
                
                // Update the set of neighbours of the point, including the indirect ones 
                locationNeighboursExtended.clear();
                locationNeighboursExtended.addAll(temporarySet);

                // If the two sets of neighbours overlap, the point is adjacent to the region
                temporarySet.retainAll(regionNeighbours);
                if (!temporarySet.isEmpty())
                    return true;
            }
        }



        public boolean isTerritory(final List<Integer> region) {            
            /* It checks if the region verifies the condition to be considered a territory:
             * each location in the region has at least two not-empty neighbours */

            int counterNotEmptyNeighbours = 0;
            for (int member : region) {
                for (int i : findNeighbours(member)) {
                    if (board.get(i) != -1)
                        counterNotEmptyNeighbours++;
                }
                if (counterNotEmptyNeighbours < 2)
                    return false;
                counterNotEmptyNeighbours = 0;
            }
            return true;
        }



        public List<Integer> fillTerritory(final List<Integer> territory, final int lastMove) {
            /* It fills all the locations in the territory with the color of the player who has the majority of the filled neighbours 
               (in the event of a tie, the territory gets the color of the player who did not make the last move) */

            // Find all the distinct neighbours of the points of a territory
            Set<Integer> neighboursUnion = new TreeSet<>();
            for (int member : territory)
                neighboursUnion.addAll(findNeighbours(member));
            neighboursUnion.removeAll(territory);
            List<Integer> distinctNeighbours = new ArrayList<>(neighboursUnion);

            // Count how many neighbours are WHITE and how many BLACK
            int counterBlackNeighbours = 0, counterWhiteNeighbours = 0;
            for (int i : distinctNeighbours) {
                if (board.get(i) == 0)
                    counterBlackNeighbours++;
                else if (board.get(i) == 1)
                    counterWhiteNeighbours++;
            }

            // If the counters have the same value, increase the counter of the player who did not play the last move
            if (counterBlackNeighbours == counterWhiteNeighbours) {
                if (board.get(lastMove) == 1)
                    counterBlackNeighbours++;
                else
                    counterWhiteNeighbours++;
            }

            // Assign to all locations in the territory a value according to the counts
            final int replacement = (counterBlackNeighbours<counterWhiteNeighbours)? 1 : 0;
            territory.forEach(index -> board.set(index, replacement));

            // The newly inserted values are returned (useful for tests)
            List<Integer> values = new ArrayList<>();
            for (int index : territory) {
                values.add(board.get(index));
            }
    
            return values;
        }
    }



    public static void main(String[] args) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        
        Game myboard = new Game(5);
        System.out.println(myboard + "\n");
        do {
            System.out.println("BLACK MOVES");
            myboard.updateBoard(true);
            System.out.println(myboard + "\n");
            if (!myboard.checkIsGameover()) {
                System.out.println("WHITE MOVES");
                myboard.updateBoard(false);
                System.out.println(myboard + "\n");
            }
        } while (!myboard.checkIsGameover());

    }
}