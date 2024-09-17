package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class candidate_for_territory_test {

    @Test
    public void candidate4territory_test_topleft_false() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "c2");        
        myboard.nextMove_tests(false, "c1");
        
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
        assertEquals(false, myboard.candidate_for_territory(Arrays.asList(0,5)));
    }


    @Test
    public void candidate4territory_test_topleft_true() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a2");
        myboard.nextMove_tests(false, "b2");
        myboard.nextMove_tests(true, "b1");        
        
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
        assertEquals(true, myboard.candidate_for_territory(Arrays.asList(0)));
    }


    @Test
    public void candidate4territory_test_rightedge_true() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(5);
        myboard.nextMove_tests(true, "a5");
        myboard.nextMove_tests(false, "b4");
        myboard.nextMove_tests(true, "d5");        
        myboard.nextMove_tests(false, "c4");

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
        assertEquals(true, myboard.candidate_for_territory(Arrays.asList(9,14)));
    }

}

