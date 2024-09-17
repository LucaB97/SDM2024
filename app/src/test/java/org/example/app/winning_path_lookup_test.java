package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.ArrayList;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class winning_path_lookup_test {

    @Test
    public void winningpathlookup_test_black_false_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(true, "b2");        
        myboard.nextMove_tests(true, "c2");
        myboard.nextMove_tests(true, "c3");
        myboard.nextMove_tests(true, "c4");
        myboard.nextMove_tests(true, "d4");

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
        assertEquals(false, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void winningpathlookup_test_black_false_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(true, "b2");        
        myboard.nextMove_tests(true, "c2");
        myboard.nextMove_tests(true, "c3");
        myboard.nextMove_tests(true, "c4");
        myboard.nextMove_tests(true, "d4");
        myboard.nextMove_tests(true, "d5");

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
        assertEquals(false, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void winningpathlookup_test_black_true() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(true, "b2");        
        myboard.nextMove_tests(true, "c2");
        myboard.nextMove_tests(true, "c3");
        myboard.nextMove_tests(true, "c4");
        myboard.nextMove_tests(true, "d4");
        myboard.nextMove_tests(true, "e4");

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
        assertEquals(true, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void winningpathlookup_test_white_false_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(false, "a1");
        myboard.nextMove_tests(false, "a2");
        myboard.nextMove_tests(false, "b2");        
        myboard.nextMove_tests(false, "c2");
        myboard.nextMove_tests(false, "c3");
        myboard.nextMove_tests(false, "c4");
        myboard.nextMove_tests(false, "d4");

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
        assertEquals(false, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void winningpathlookup_test_white_false_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(false, "a1");
        myboard.nextMove_tests(false, "a2");
        myboard.nextMove_tests(false, "b2");        
        myboard.nextMove_tests(false, "c2");
        myboard.nextMove_tests(false, "c3");
        myboard.nextMove_tests(false, "c4");
        myboard.nextMove_tests(false, "d4");
        myboard.nextMove_tests(false, "e4");

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
        assertEquals(false, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }


    @Test
    public void winningpathlookup_test_white_true() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(false, "a1");
        myboard.nextMove_tests(false, "a2");
        myboard.nextMove_tests(false, "b2");        
        myboard.nextMove_tests(false, "c2");
        myboard.nextMove_tests(false, "c3");
        myboard.nextMove_tests(false, "c4");
        myboard.nextMove_tests(false, "d4");
        myboard.nextMove_tests(false, "d5");

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
        assertEquals(true, myboard.winning_path_lookup(0, new ArrayList<Integer>(), new TreeSet<Integer>()));
    }
}

