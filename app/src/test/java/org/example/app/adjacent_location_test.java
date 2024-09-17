package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class adjacent_location_test {

    // The point is NOT adjacent to the region
    @Test
    public void nextregion_test_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "a2");        
        myboard.nextMove_tests(false, "c2");
        myboard.nextMove_tests(true, "d1");
        
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
        List<Integer> myregion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(false, myboard.adjacent_location(myregion, 5));
    }

    // The point is adjacent to the region
    @Test
    public void nextregion_test_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(false, "c2");

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

        List<Integer> myregion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(true, myboard.adjacent_location(myregion, 5));
    }

}