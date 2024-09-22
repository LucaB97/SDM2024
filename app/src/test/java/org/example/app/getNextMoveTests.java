package org.example.app;

import exceptions.*;
import org.junit.jupiter.api.Test;
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
    public void getNextMoveIncorrectFormatExceptionTest1() {
        Game myGame = new Game(5);
        assertThrows(IncorrectFormatException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "a-1");});
    }

    @Test
    public void getNextMoveIncorrectFormatExceptionTest2() {
        Game myGame = new Game(5);
        assertThrows(IncorrectFormatException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "4a");});
    }

    @Test
    public void getNextMoveIncorrectFormatExceptionTest3() {
        Game myGame = new Game(5);
        assertThrows(IncorrectFormatException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "4");});
    }

    //INVALID LOCATION EXCEPTION TESTS: inputs exceeding the board should be rejected
    @Test
    public void getNextMoveOutOfRangeLocationExceptionTest1() {
        Game myGame = new Game(5);
        assertThrows(OutOfRangeLocationException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "n0");});
    }

    @Test
    public void getNextMoveOutOfRangeLocationExceptionTest2() {
        Game myGame = new Game(5);
        assertThrows(OutOfRangeLocationException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "a14");});
    }

    //OCCUPIED LOCATION EXCEPTION TESTS
    @Test
    public void getNextMoveOccupiedLocationExceptionTest() {
        Game myGame = new Game(5);
        myGame.board.grid.set(0, 0);
        assertThrows(OccupiedLocationException.class, () -> {myGame.inputHandler.getNextMove(myGame.board, "a1");});
    }
}

