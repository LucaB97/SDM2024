package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fillTerritoryTests {

    @Test
    public void fillTerritoryBlackMajorityTest() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(false, "d1");
        myBoard.nextMove_tests(true, "c2");        
        myBoard.nextMove_tests(false, "d2");
        myBoard.nextMove_tests(true, "b2");

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
    public void fillTerritoryWhiteMajorityTest() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(false, "d1");
        myBoard.nextMove_tests(true, "a2");        
        myBoard.nextMove_tests(false, "b2");
        myBoard.nextMove_tests(true, "a3");
        myBoard.nextMove_tests(false, "c2");

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
    public void fillTerritoryDrawBlackLastMoveTest() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(false, "d1");
        myBoard.nextMove_tests(true, "a2");        
        myBoard.nextMove_tests(false, "d2");
        myBoard.nextMove_tests(true, "a3");
        myBoard.nextMove_tests(false, "c2");
        myBoard.nextMove_tests(true, "b2");

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
    public void fillTerritoryDrawWhiteLastMoveTest() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(false, "d1");
        myBoard.nextMove_tests(true, "a2");        
        myBoard.nextMove_tests(false, "d2");
        myBoard.nextMove_tests(true, "b2");
        myBoard.nextMove_tests(false, "c2");

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
