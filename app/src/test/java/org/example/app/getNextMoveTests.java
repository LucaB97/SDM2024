package org.example.app;

import exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



/* Game myBoard = new Game(13);
   _________________________________________________________________________________ 
  |                                                                                 |
 a|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 b|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 c|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 d|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 e|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 f|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 g|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 h|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 i|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 j|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 k|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 l|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
  |    :     :     :     :     :     :     :     :     :     :     :     :     :    |
 m|      ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...   ...      |
  |_________________________________________________________________________________|
       1     2     3     4     5     6     7     8     9     10    11    12    13
*/


public class getNextMoveTests {
    
    //INCORRECT FORMAT EXCEPTION TESTS: only inputs like <letter><number> should be accepted
    @Test
    public void getNextMoveIncorrectFormatExceptionTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myBoard.getNextMove(true, "a-4");});
    }

    @Test
    public void getNextMoveIncorrectFormatExceptionTest2() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myBoard.getNextMove(true, "4a");});
    }

    @Test
    public void getNextMoveIncorrectFormatExceptionTest3() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myBoard.getNextMove(true, "4");});
    }

    //INVALID LOCATION EXCEPTION TESTS: inputs exceeding the board should be rejected
    @Test
    public void getNextMoveOutOfRangeLocationExceptionTest1() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        assertThrows(OutOfRangeLocationException.class, () -> {myBoard.getNextMove(true, "n0");});
    }

    @Test
    public void getNextMoveOutOfRangeLocationExceptionTest2() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        assertThrows(OutOfRangeLocationException.class, () -> {myBoard.getNextMove(true, "a14");});
    }

    //OCCUPIED LOCATION EXCEPTION TESTS
    @Test
    public void getNextMoveOccupiedLocationExceptionTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        myBoard.getNextMove(true, "a1");
        assertThrows(OccupiedLocationException.class, () -> {myBoard.getNextMove(false, "a1");});
    }

    //REGULAR FUNCTIONING 
    @Test
    public void getNextMoveCorrectPlacingBlackTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        myBoard.getNextMove(true, "a2");
        assertEquals(0, myBoard.board.get(1));
    }

    @Test
    public void getNextMoveCorrectPlacingWhiteTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        Game myBoard = new Game(13);
        myBoard.getNextMove(false, "a4");
        assertEquals(1, myBoard.board.get(3));
    }

}

