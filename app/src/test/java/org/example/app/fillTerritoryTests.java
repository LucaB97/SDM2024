package org.example.app;

import exceptions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fillTerritoryTests {

    @Test
    public void fillTerritoryBlackMajorityTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "d1");
        myBoard.getNextMove(true, "c2");        
        myBoard.getNextMove(false, "d2");
        myBoard.getNextMove(true, "b2");

        //      _________________________________
        //     |                                 |
        //    a|    B ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|    W ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        //region {b0,c0} -> {5,10} should be filled by black (0)
        assertEquals(Arrays.asList(0,0), myBoard.fillTerritory(Arrays.asList(5,10),6));
    }


    @Test
    public void fillTerritoryWhiteMajorityTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "d1");
        myBoard.getNextMove(true, "a2");        
        myBoard.getNextMove(false, "b2");
        myBoard.getNextMove(true, "a3");
        myBoard.getNextMove(false, "c2");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ... B ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|    W ...   ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        //region {b0,c0} -> {5,10} should be filled by white (1)
        assertEquals(Arrays.asList(1,1), myBoard.fillTerritory(Arrays.asList(5,10),11));
    }


    @Test
    public void fillTerritoryDrawBlackLastMoveTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "d1");
        myBoard.getNextMove(true, "a2");        
        myBoard.getNextMove(false, "d2");
        myBoard.getNextMove(true, "a3");
        myBoard.getNextMove(false, "c2");
        myBoard.getNextMove(true, "b2");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ... B ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
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
        //region {b0,c0} -> {5,10} should be filled by white (1)
        assertEquals(Arrays.asList(1,1), myBoard.fillTerritory(Arrays.asList(5,10),6));
    }


    @Test
    public void fillTerritoryDrawWhiteLastMoveTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(false, "d1");
        myBoard.getNextMove(true, "a2");        
        myBoard.getNextMove(false, "d2");
        myBoard.getNextMove(true, "b2");
        myBoard.getNextMove(false, "c2");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
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
        //region {b0,c0} -> {5,10} should be filled by black (0)
        assertEquals(Arrays.asList(0,0), myBoard.fillTerritory(Arrays.asList(5,10),11));
    }

}
