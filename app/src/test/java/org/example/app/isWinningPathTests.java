package org.example.app;

import exceptions.*;
import java.util.ArrayList;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isWinningPathTests {

    @Test
    public void isWinningPathBlackFalseTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(true, "b2");        
        myBoard.getNextMove(true, "c2");
        myBoard.getNextMove(true, "c3");
        myBoard.getNextMove(true, "c4");
        myBoard.getNextMove(true, "d4");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... B ... B ... B ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... B ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(false, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void isWinningPathBlackFalseTest2() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(true, "b2");        
        myBoard.getNextMove(true, "c2");
        myBoard.getNextMove(true, "c3");
        myBoard.getNextMove(true, "c4");
        myBoard.getNextMove(true, "d4");
        myBoard.getNextMove(true, "d5");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... B ... B ... B ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... B ... B    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(false, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void isWinningPathBlackTrueTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(true, "a1");
        myBoard.getNextMove(true, "a2");
        myBoard.getNextMove(true, "b2");        
        myBoard.getNextMove(true, "c2");
        myBoard.getNextMove(true, "c3");
        myBoard.getNextMove(true, "c4");
        myBoard.getNextMove(true, "d4");
        myBoard.getNextMove(true, "e4");

        //      _________________________________
        //     |                                 |
        //    a|    B ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... B ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... B ... B ... B ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... B ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ... B ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(true, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void isWinningPathWhiteFalseTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(false, "a1");
        myBoard.getNextMove(false, "a2");
        myBoard.getNextMove(false, "b2");        
        myBoard.getNextMove(false, "c2");
        myBoard.getNextMove(false, "c3");
        myBoard.getNextMove(false, "c4");
        myBoard.getNextMove(false, "d4");

        //      _________________________________
        //     |                                 |
        //    a|    W ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ... W ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(false, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void isWinningPathWhiteFalseTest2() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(false, "a1");
        myBoard.getNextMove(false, "a2");
        myBoard.getNextMove(false, "b2");        
        myBoard.getNextMove(false, "c2");
        myBoard.getNextMove(false, "c3");
        myBoard.getNextMove(false, "c4");
        myBoard.getNextMove(false, "d4");
        myBoard.getNextMove(false, "e4");

        //      _________________________________
        //     |                                 |
        //    a|    W ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ... W ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ... W ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(false, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void isWinningPathWhiteTrueTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.getNextMove(false, "a1");
        myBoard.getNextMove(false, "a2");
        myBoard.getNextMove(false, "b2");        
        myBoard.getNextMove(false, "c2");
        myBoard.getNextMove(false, "c3");
        myBoard.getNextMove(false, "c4");
        myBoard.getNextMove(false, "d4");
        myBoard.getNextMove(false, "d5");

        //      _________________________________
        //     |                                 |
        //    a|    W ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    b|      ... W ...   ...   ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    c|      ... W ... W ... W ...      |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    d|      ...   ...   ... W ... W    |
        //     |    :     :     :     :     :    |
        //     |    :     :     :     :     :    |
        //    e|      ...   ...   ...   ...      |
        //     |_________________________________|
        //          1     2     3     4     5
        //
        assertEquals(true, myBoard.isWinningPath(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }
}

