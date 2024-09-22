package org.example.app;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Board {

    public List<Integer> grid = new ArrayList<>();
    public int sideLength;
    final Scanner scanner = new Scanner(System.in);


    public Board(final int size) {
        grid.addAll(Collections.nCopies(size*size, -1));
        sideLength = size;
    }    


    @Override
    public String toString() {
        /* Print the grid to the terminal */
        
        String rows = "abcdefghijklm";
        int rowIndex = 0;
        String printed = "\n   _____" + "______".repeat(sideLength-1) + "____\n";
        printed = printed + "  |     " + "      ".repeat(sideLength-1) + "    |\n";
        String separator;            

        for (int i = 0 ; i < grid.size() ; i++) {
            separator = i % sideLength != 0 ? " ... " : " " + rows.charAt(rowIndex++) + "|    ";
            if (grid.get(i) == 0)
                printed = printed + separator + "B";
            else if (grid.get(i) == 1) 
                printed = printed + separator + "W";
            else
                printed = printed + separator + " ";

            if (i%sideLength == sideLength-1) {
                if (i < grid.size()-sideLength)
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


    public List<Integer> findEmptyLocations(final boolean empty) {
        /* It returns the current set of empty locations (empty=true) or filled locations (empty=false) */

        List<Integer> locationsList;
        if (empty) {
            locationsList = IntStream.range(0, grid.size())
                .filter(index -> grid.get(index) == -1)
                .boxed()
                .collect(Collectors.toList());
        } else {
            locationsList = IntStream.range(0, grid.size())
                .filter(index -> grid.get(index) != -1)
                .boxed()
                .collect(Collectors.toList());
        }
        return locationsList;
    } 


    public List<Integer> findNeighbours(final int location) {
        /* It returns the orthogonally adjacent points to the input point */

        List<Integer> neighboursList = new ArrayList<>();            
        
        if (location-sideLength >= 0)
            neighboursList.add(location-sideLength);
        
        if ((location-1 >= 0) && (location/sideLength == (location-1)/sideLength))
            neighboursList.add(location-1); 
        
        if ((location+1 < grid.size()) && (location/sideLength == (location+1)/sideLength))
            neighboursList.add(location+1);      
        
        if (location+sideLength < grid.size())
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
        
        if (location+sideLength-1 < grid.size() && (location-1)/sideLength == location/sideLength && location != 0)
            diagonalPointsList.add(location+sideLength-1);     
        
        if (location+sideLength+1 < grid.size() && (location+1)/sideLength == location/sideLength)
            diagonalPointsList.add(location+sideLength+1);     
        
        return diagonalPointsList;  
    }  
    
}
