package org.example.app;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import exceptions.*;



public class Quentin {


    public static class Game {

        protected List<Integer> board = new ArrayList<>();
        private int line_size;
        private final Scanner scanner = new Scanner(System.in);
        
        public Game(final int size) {
            board.addAll(Collections.nCopies(size*size, -1));
            line_size = size;
        }

        public void random_filling(int dim) {
            Random random = new Random();
            for (int i = 0; i < dim*dim; i++) {
                board.add(random.nextInt(2)); 
            }
            line_size = dim;
        }
    


        @Override
        public String toString() {
            /* Print the board to the terminal */
            
            String rows = "abcdefghijklm";
            int rowidx = 0;
            String printed = "\n   _____" + "______".repeat(line_size-1) + "____\n";
            printed = printed + "  |     " + "      ".repeat(line_size-1) + "    |\n";
            String sep;            

            for (int i = 0 ; i < board.size() ; i++) {
                sep = i % line_size != 0 ? " ... " : " " + rows.charAt(rowidx++) + "|    ";
                if (board.get(i) == 0)
                    printed = printed + sep + "B";
                else if (board.get(i) == 1) 
                    printed = printed + sep + "W";
                else
                    printed = printed + sep + " ";

                if (i%line_size == line_size-1) {
                    if (i < board.size()-line_size)
                        printed = printed + "    |\n  |   " + " :    ".repeat(line_size) + "|\n  |   " + " :    ".repeat(line_size) + "|\n";
                    else
                    printed = printed + "    |\n";
                }
            }

            printed = printed + "  |_____" + "______".repeat(line_size-1) + "____|\n       ";
            for (int i = 0 ; i < line_size ; i++) 
                printed = printed + (i+1) + "     ";

            return printed;
        }



        public List<String> convert(final Set<Integer> values) {
            /* converts the locations of the board array in the <letter><number> format, useful when printing the winning path */
            List<String> converted_values = new ArrayList<>();
            int col;
            int row;

            for (int v : values) {
                col = v % line_size;
                row = v / line_size + 1;
                converted_values.add((char)('a' + row - 1) + Integer.toString(col));
            }

            return converted_values;
        }
        


        public boolean gameover() {
            /* It verifies if there is a winning path for any of the players */

            Set<Integer> winning_path = new TreeSet<>();
            boolean black_won = false;
            int i = 0;
            
            // Check if a winning path for the black player exists, from each of the possible starting locations (first row)
            while (!black_won && i<line_size) {
                if (board.get(i) == 0)
                    black_won = winning_path_lookup(i, new ArrayList<Integer>(), winning_path);
                i++;
            }

            if (black_won) {
                System.out.println("BLACK WON!");
                List<String> winning_path_positions = convert(winning_path);
                System.out.println(winning_path_positions);
                return true;
            }

            boolean white_won = false;
            i = 0;
            
            // Check if a winning path for the white player exists, from each of the possible starting locations (first column)
            while (!white_won && i<line_size) {
                if (board.get(i*line_size) == 1)
                    white_won = winning_path_lookup(i*line_size, new ArrayList<Integer>(), winning_path);
                i++;
            }

            if (white_won) {
                System.out.println("WHITE WON!");
                List<String> winning_path_positions = convert(winning_path);
                System.out.println(winning_path_positions);
                return true;
            }

            return false;
        }



        public boolean winning_path_lookup(final int idx, List<Integer> exclude, Set<Integer> winning_path) {            
            /* Recursive function. 
               It checks for a winning path for a specific player:
               - a top-to-bottom way of orthogonally adjacent points, for the black player; 
               - a left-to-right way for the white player.
               The "exclude" list is populated with the already considered points: 
               if a winning path including them was not found, they must be removed to prevent the function to get stuck.
               */
            
            List<Integer> same_color_neighbours = new ArrayList<>();
            for (Integer n : neighbours(idx)) {
                if (board.get(n).equals(board.get(idx)) && !exclude.contains(n))
                    same_color_neighbours.add(n);
            }

            // Eligible locations for the end of a winning path: last row for black, last column for white
            List<Integer> arrival = new ArrayList<>();
            for (int i = 0; i < line_size; i++) {
                if (board.get(idx) == 0)
                    arrival.add(board.size() - line_size + i);
                else
                    arrival.add(i*line_size + line_size - 1);
            }
            
            // IF: idx is present in the array of arrival locations, THEN: a winning path is found
            if (arrival.contains(idx)) {
                return true;
            } 
            // ELSE:
            else {                
                exclude.add(idx);   // idx will be excluded by further research
                
                // recursively repeat the procedure on all the neighbours of idx with the same color 
                // (basically, you detect the winning path moving one step at a time)
                for (Integer g : same_color_neighbours) {
                    if (winning_path_lookup(g, exclude, winning_path)) {
                        winning_path.add(g);
                        winning_path.add(idx);
                        return true;
                    }
                }
            }
            return false;
        }



        public List<Integer> neighbours(final int idx) {
            /* It returns the orthogonally adjacent points to the input point */

            List<Integer> mylist = new ArrayList<>();            
            if (idx-line_size >= 0)
                mylist.add(idx-line_size);
            if ((idx-1 >= 0) && (idx/line_size == (idx-1)/line_size))
                mylist.add(idx-1); 
            if ((idx+1 < board.size()) && (idx/line_size == (idx+1)/line_size))
                mylist.add(idx+1);      
            if (idx+line_size < board.size())
                mylist.add(idx+line_size);                 
            return mylist;            
        }



        public List<Integer> diagonals(final int idx) {
            /* It returns the indexes of the diagonal points of the input point */

            List<Integer> mylist = new ArrayList<>();            
            if (idx-line_size-1 >= 0 && (idx-1)/line_size == idx/line_size)
                mylist.add(idx-line_size-1);
            if (idx-line_size+1 >= 0 && (idx+1)/line_size == idx/line_size)
                mylist.add(idx-line_size+1); 
            if (idx+line_size-1 < board.size() && (idx-1)/line_size == idx/line_size && idx != 0)
                mylist.add(idx+line_size-1);     
            if (idx+line_size+1 < board.size() && (idx+1)/line_size == idx/line_size)
                mylist.add(idx+line_size+1);     
            return mylist;  
        }



        public List<Integer> find_locations(boolean filled) {
            /* It returns the current set of filled locations (filled=true) or empty locations (filled=false) */

            List<Integer> locations;
            if (filled) {
                locations = IntStream.range(0, board.size())
                    .filter(i -> board.get(i) != -1)
                    .boxed()
                    .collect(Collectors.toList());
            } else {
                locations = IntStream.range(0, board.size())
                    .filter(i -> board.get(i) == -1)
                    .boxed()
                    .collect(Collectors.toList());
            }
            return locations;
        }



        public int nextMove(final boolean black) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* It gets a new input and checks whether the request for the next move can be fulfilled, specifically if:
             * the format of the input is correct (<letter><number>),
             * the location is valid (i.e., it is within the limits of the board),
             * the location is free (not occupied by the player or the opponent).
             * The procedure is repeated until all the checks are passed successfully, then the location is filled and its index returned */
            
            List<Integer> filled_locations = find_locations(true);
            boolean valid_move = false;
            boolean free_location = false;
            String pattern = "[a-zA-Z]\\d+";    //used to verify the input format
            int location = -1;
            String user_input;

            while (!valid_move || !free_location) {
                try {
                    
                    System.out.println("Enter a position in the board (e.g.: a1): ");
                    user_input = scanner.nextLine();

                    // check: input format correctness
                    if (!(user_input.matches(pattern))) {
                        throw new IncorrectFormatException("Incorrect format. Try again!\n");
                    }
                    
                    int letter = user_input.toLowerCase().charAt(0) - 'a';
                    int number = Integer.parseInt(user_input.substring(1));
                    location = letter * line_size + (number-1);
                    
                    // checks: location is valid and free
                    valid_move = location >= 0 && location < board.size() && number > 0 && number <= line_size;
                    free_location = !filled_locations.contains(location);
                    if (!valid_move) {
                        throw new InvalidLocationException("Invalid location. Try again!\n");                        
                    } else if (!free_location) {
                        throw new OccupiedLocationException("Location already filled. Try again!\n");
                    }

                    // if all the checks are passed, fill the location with the color of the player
                    board.set(location, black ? 0 : 1);

                } catch (IncorrectFormatException | InvalidLocationException | OccupiedLocationException e) {
                    // Print the exception message and continue the loop
                    System.out.println(e.getMessage());
                }
            }
            return location;
        }



        public int nextMove_tests(final boolean black, final String user_input) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* Variation of the previous function, which takes as argument the next location (useful for tests) */
            
            List<Integer> filled_locations = find_locations(true);
            String pattern = "[a-zA-Z]\\d+";    //used to verify the input format

            if (!(user_input.matches(pattern))) {
                throw new IncorrectFormatException("Incorrect format. Try again!\n");
            }
            
            int letter = user_input.toLowerCase().charAt(0) - 'a';
            int number = Integer.parseInt(user_input.substring(1));
            int location = letter*line_size + (number-1);
            
            boolean valid_move =  location>=0 && location<board.size() && number>0 && number<=line_size;
            boolean free_location = !filled_locations.contains(location);
            if (!valid_move) {
                throw new InvalidLocationException("Invalid location. Try again!\n");
            }

            if (!free_location) {
                throw new OccupiedLocationException("Location already filled. Try again!\n");
            }

            board.set(location, black ? 0 : 1);
            return location;  
        }
        


        public void update_board(final boolean black) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
            /* It updates the board with the last move and all the related changes (if they are compliant to the rules):
               (1) The regions present on the board after the last move are identified and, 
                   if they have the requirements to be considered a territory, they are filled accordingly;
               (2) A check is carried out to verify whether the last move produced some illegal configuration on the board:
                   in this case, all the locations filled during this function call are freed, and a new input is asked for */

            List<Integer> empty_locations = new ArrayList<>();            
            List<Integer> region = new ArrayList<>();
            List<Integer> territories = new ArrayList<>();

            int last_move = nextMove(black);

            // Until a valid move is prompted (both the move and the consequent board configuration have to be valid):
            while (true) {
                empty_locations = find_locations(false);

                // All the regions are identified, one at a time, until all the empty locations have been considered 
                while (!empty_locations.isEmpty()) {
                    
                    region = next_region(empty_locations);
                    if (candidate_for_territory(region)) {
                        fill_territory(region, last_move);
                        territories.addAll(region);
                    }
                    
                    // The locations belonging to the region are removed from the list of empty locations
                    empty_locations.removeAll(region);                    
                }

                if (!legal_move(last_move)) {
                    board.set(last_move, -1);
                    territories.forEach(index -> board.set(index, -1));
                    territories.clear();
                    System.out.println("Illegal move. Try again!\n");
                    last_move = nextMove(black);
                }
                else
                    break;
            }      
        }



        public boolean legal_move(final int last_move) {
            /* It verifies if a move is legal, i.e., if at the end of the player's turn 
               there are NOT any couples of points with the same color s.t. they are diagonally 
               adjacent and the do not share any orthogonally adjacent, like-colored neighbor */
            
            List<Integer> likeColoredNeighbours = new ArrayList<>();

            // Check for and store the locations of the like-colored neighbours of the last point
            for (int i : neighbours(last_move)) {
                if (board.get(i) == board.get(last_move)) {
                    likeColoredNeighbours.add(i);
                }
            }

            // Verify if any of the diagonally adjacent points are like-colored and share any of the neighbours from before
            for (int i : diagonals(last_move)) {
                if (board.get(i) == board.get(last_move)) {
                    Set<Integer> commonNeighbours = new TreeSet<>(neighbours(i));
                    commonNeighbours.retainAll(likeColoredNeighbours);

                    // If not, the move is illegal!
                    if (commonNeighbours.isEmpty()) {
                        return false;
                    }
                }
            }

            return true;
        }



        public List<Integer> next_region(final List<Integer> empty_locations) {
            /* It determines the next region (group of adjacent empty locations) in the board */
            
            List<Integer> region = new ArrayList<>();
            for (int loc : empty_locations) {                
                if (region.isEmpty() || adjacent_location(region, loc)) {
                    region.add(loc);
                }
            }
            return region;
        }
        


        public boolean adjacent_location(List<Integer> region, int idx) {
            /* It evaluates whether the region (first argument) contains any direct 
               (or indirect) adjacent locations to a specific empty location (second argument) */
           
            // Find all the empty neighbours of the points of the region
            Set<Integer> region_neighbours = new TreeSet<>();
            for (int curr : region) {
                region_neighbours.addAll(neighbours(curr));
            }
            region_neighbours.removeIf(index -> board.get(index) != -1);
            
            // Find the neighbours of the point of which you want to verify the adjacency to the region
            Set<Integer> extended_idx_neighbours = new TreeSet<>(neighbours(idx));
            extended_idx_neighbours.removeIf(index -> board.get(index) != -1);
            extended_idx_neighbours.add(idx);
            
            // IF: the two sets of neighbours overlap, the point is adjacent to the region 
            Set<Integer> tempSet = new TreeSet<>(extended_idx_neighbours);
            tempSet.retainAll(region_neighbours);
            if (!tempSet.isEmpty())
                return true;

            // extend the research for (indirect) neighbours of idx
            while (true) {
                
                for (int x : extended_idx_neighbours) {
                    tempSet.addAll(neighbours(x));
                }
                tempSet.removeIf(index -> board.get(index) != -1);
                
                // IF: no more locations are found which are adjacent to the point or its current neighbours, return false 
                if (extended_idx_neighbours.equals(tempSet))
                    return false;
                
                // Update the set of neighbours of idx, including the indirect ones 
                extended_idx_neighbours.clear();
                extended_idx_neighbours.addAll(tempSet);

                // IF: the two sets of neighbours overlap, the point is adjacent to the region
                tempSet.retainAll(region_neighbours);
                if (!tempSet.isEmpty())
                    return true;
            }
        }



        public boolean candidate_for_territory(final List<Integer> region) {            
            /* It checks if the region verifies the condition to be considered a territory:
             * each location in the region has at least two filled neighbours */

            int cnt = 0;
            for (int curr : region) {
                for (int i : neighbours(curr)) {
                    if (board.get(i) != -1)
                        cnt++;
                }
                if (cnt < 2)
                    return false;
                cnt = 0;
            }
            return true;
        }


        public List<Integer> fill_territory(final List<Integer> territory, final int last_move) {
            /* It fills all the locations in the territory with the color of the player who has the majority of the filled neighbours 
               (in the event of a tie, the territory gets the color of the player who did not make the last move) */

            // Find all the distinct neighbours of the points of a territory
            Set<Integer> neighbours_union = new TreeSet<>();
            for (int i : territory)
                neighbours_union.addAll(neighbours(i));
            neighbours_union.removeAll(territory);
            List<Integer> distinctNeighbours = new ArrayList<>(neighbours_union);

            // Count how many neighbours are WHITE and how many BLACK
            int cnt_black = 0, cnt_white = 0;
            for (int i : distinctNeighbours) {
                if (board.get(i) == 0)
                    cnt_black++;
                else if (board.get(i) == 1)
                    cnt_white++;
            }

            // IF: tie, THEN: increase the count of the player who did not play the last move
            if (cnt_black == cnt_white) {
                if (board.get(last_move) == 1)
                    cnt_black++;
                else
                    cnt_white++;
            }

            // Assign to all locations in the territory a value according to the counts
            final int replacement = (cnt_black<cnt_white)? 1 : 0;
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
            myboard.update_board(true);
            System.out.println(myboard + "\n");
            if (!myboard.gameover()) {
                System.out.println("WHITE MOVES");
                myboard.update_board(false);
                System.out.println(myboard + "\n");
            }
        } while (!myboard.gameover());

    }
}