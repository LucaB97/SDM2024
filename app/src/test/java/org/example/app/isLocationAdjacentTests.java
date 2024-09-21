package org.example.app;

import exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isLocationAdjacentTests {

    // The point is NOT adjacent to the region
    @Test
    public void locationNotAdjacentTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "b2");
        myBoard.getNextMove(true, "a2");        
        myBoard.getNextMove(false, "c2");
        myBoard.getNextMove(true, "d1");
        
        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|    B ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // The point b1 is "orthogonally" separated from the region [a3,a4,a5] 
        List<Integer> myRegion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(false, myBoard.isLocationAdjacent(myRegion, 5));
    }

    // The point is adjacent to the region
    @Test
    public void locationAdjacentTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "b2");
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(false, "c2");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5

        List<Integer> myRegion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(true, myBoard.isLocationAdjacent(myRegion, 5));
    }

}