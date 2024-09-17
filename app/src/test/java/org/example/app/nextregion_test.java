package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class nextregion_test {

    //TEST REGIONS WHICH ARE NOT TERRITORIES
    @Test
    public void nextregion_test_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "a2");        
        myboard.nextMove_tests(false, "b3");
        myboard.nextMove_tests(true, "b4");
        myboard.nextMove_tests(false, "b5");
        
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
        // The function next_region scans the array linearly (completing the rows), 
        // so the first empty region should be find at: [a3,a4,a5], which corresponds to the indexes: [2,3,4]
        
        List<Integer> empty_locations = myboard.find_locations(false);
        assertEquals(new ArrayList<>(Arrays.asList(2,3,4)), myboard.next_region(empty_locations));
    }

    @Test
    public void nextregion_test_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a1");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(false, "c2");
        myboard.nextMove_tests(true, "a3");
        myboard.nextMove_tests(false, "d2");
        myboard.nextMove_tests(true, "a4");
        myboard.nextMove_tests(false, "d1");
        myboard.nextMove_tests(true, "a5");

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
        List<Integer> empty_locations = myboard.find_locations(false);
        assertEquals(new ArrayList<>(Arrays.asList(5,10)), myboard.next_region(empty_locations));
    }

}