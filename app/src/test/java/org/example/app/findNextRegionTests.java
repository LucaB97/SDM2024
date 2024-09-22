package org.example.app;

import exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.example.input.ArgumentInputHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class findNextRegionTests {

    //TEST REGIONS WHICH ARE NOT TERRITORIES
    @Test
    public void findNextRegionTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b5");
        myGame.board.grid.set(nextMove, 1);
        
        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ... W ... B ... W    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // The function findNextRegion scans the array linearly (completing the rows), 
        // so the first empty region should be find at: [a3,a4,a5], which corresponds to the indexes: [2,3,4]
        
        List<Integer> emptyLocations = myGame.board.findEmptyLocations(true);
        assertEquals(new ArrayList<>(Arrays.asList(2,3,4)), myGame.findNextRegion(emptyLocations));
    }

    @Test
    public void findNextRegionTest2() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a5");
        myGame.board.grid.set(nextMove, 0);

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ... B ... B ... B    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|    W ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // Expected region: [b1,c1] --> [5,10] 
        List<Integer> emptyLocations = myGame.board.findEmptyLocations(true);
        assertEquals(new ArrayList<>(Arrays.asList(5,10)), myGame.findNextRegion(emptyLocations));
    }

    @Test
    public void findNextRegionTest3() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a5");
        myGame.board.grid.set(nextMove, 0);

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ... B ... B ... B    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ...   ... W ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|    W ...   ... W ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // Expected region: [b1,b2,c2] --> [5,6,11] 
        List<Integer> emptyLocations = myGame.board.findEmptyLocations(true);
        assertEquals(new ArrayList<>(Arrays.asList(5,6,11)), myGame.findNextRegion(emptyLocations));
    }

}