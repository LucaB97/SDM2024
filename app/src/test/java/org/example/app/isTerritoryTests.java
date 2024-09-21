package org.example.app;

import exceptions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isTerritoryTests {

    @Test
    public void isTerritoryTestTopLeftFalseTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(false, "b2");
        myBoard.getNextMove(true, "c2");        
        myBoard.getNextMove(false, "c1");
        
        //      _________________________________
        //     |                                 |
        //    a|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|    W ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // The points [a1,b1] do not constitute a territory since point a1 does not have two filled neighbours 
        assertEquals(false, myBoard.isTerritory(Arrays.asList(0,5)));
    }


    @Test
    public void isTerritoryTestTopLeftTrueTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(false, "b2");
        myBoard.getNextMove(true, "b1");        
        
        //      _________________________________
        //     |                                 |
        //    a|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|    B ... W ...   ...   ...      |
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
        // The point a1 has two filled neighbours, so it is a territory
        assertEquals(true, myBoard.isTerritory(Arrays.asList(0)));
    }


    @Test
    public void isTerritoryTestRightEdgeTrueTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a5");
        myBoard.getNextMove(false, "b4");
        myBoard.getNextMove(true, "d5");        
        myBoard.getNextMove(false, "c4");

        //      _________________________________
        //     |                                 |
        //    a|      ...   ...   ...   ... B    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ...   ...   ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ...   ...   ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ...   ... B    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        // The points [b5,c5] are a territory
        assertEquals(true, myBoard.isTerritory(Arrays.asList(9,14)));
    }

}

