package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.ArrayList;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isWinningPathTests {

    @Test
    public void isWinningPathBlackFalseTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(5);
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(true, "a2");
        myBoard.nextMove_tests(true, "b2");        
        myBoard.nextMove_tests(true, "c2");
        myBoard.nextMove_tests(true, "c3");
        myBoard.nextMove_tests(true, "c4");
        myBoard.nextMove_tests(true, "d4");

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
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(true, "a2");
        myBoard.nextMove_tests(true, "b2");        
        myBoard.nextMove_tests(true, "c2");
        myBoard.nextMove_tests(true, "c3");
        myBoard.nextMove_tests(true, "c4");
        myBoard.nextMove_tests(true, "d4");
        myBoard.nextMove_tests(true, "d5");

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
        myBoard.nextMove_tests(true, "a1");
        myBoard.nextMove_tests(true, "a2");
        myBoard.nextMove_tests(true, "b2");        
        myBoard.nextMove_tests(true, "c2");
        myBoard.nextMove_tests(true, "c3");
        myBoard.nextMove_tests(true, "c4");
        myBoard.nextMove_tests(true, "d4");
        myBoard.nextMove_tests(true, "e4");

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
        myBoard.nextMove_tests(false, "a1");
        myBoard.nextMove_tests(false, "a2");
        myBoard.nextMove_tests(false, "b2");        
        myBoard.nextMove_tests(false, "c2");
        myBoard.nextMove_tests(false, "c3");
        myBoard.nextMove_tests(false, "c4");
        myBoard.nextMove_tests(false, "d4");

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
        myBoard.nextMove_tests(false, "a1");
        myBoard.nextMove_tests(false, "a2");
        myBoard.nextMove_tests(false, "b2");        
        myBoard.nextMove_tests(false, "c2");
        myBoard.nextMove_tests(false, "c3");
        myBoard.nextMove_tests(false, "c4");
        myBoard.nextMove_tests(false, "d4");
        myBoard.nextMove_tests(false, "e4");

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
        myBoard.nextMove_tests(false, "a1");
        myBoard.nextMove_tests(false, "a2");
        myBoard.nextMove_tests(false, "b2");        
        myBoard.nextMove_tests(false, "c2");
        myBoard.nextMove_tests(false, "c3");
        myBoard.nextMove_tests(false, "c4");
        myBoard.nextMove_tests(false, "d4");
        myBoard.nextMove_tests(false, "d5");

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

