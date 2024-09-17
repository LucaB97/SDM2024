package org.example.app;

import org.example.app.Quentin.Game;
import exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



/* Game myboard = new Game(13);
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


public class nextmove_test {
    
    //INCORRECT FORMAT EXCEPTION TESTS: only inputs like <letter><number> should be accepted
    @Test
    public void nextmove_test_incorrectformatException_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myboard.nextMove_tests(true, "a-4");});
    }

    @Test
    public void nextmove_test_incorrectformatException_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myboard.nextMove_tests(true, "4a");});
    }

    @Test
    public void nextmove_test_incorrectformatException_3() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        assertThrows(IncorrectFormatException.class, () -> {myboard.nextMove_tests(true, "4");});
    }

    //INVALID LOCATION EXCEPTION TESTS: inputs exceeding the board should be rejected
    @Test
    public void nextmove_test_invalidlocationException_1() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        assertThrows(InvalidLocationException.class, () -> {myboard.nextMove_tests(true, "n0");});
    }

    @Test
    public void nextmove_test_invalidlocationException_2() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        assertThrows(InvalidLocationException.class, () -> {myboard.nextMove_tests(true, "a14");});
    }

    //OCCUPIED LOCATION EXCEPTION TESTS
    @Test
    public void nextmove_test_occupiedlocationException() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        myboard.nextMove_tests(true, "a1");
        assertThrows(OccupiedLocationException.class, () -> {myboard.nextMove_tests(false, "a1");});
    }

    //REGULAR FUNCTIONING 
    @Test
    public void nextmove_test_correct_placing_black() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        myboard.nextMove_tests(true, "a2");
        assertEquals(0, myboard.board.get(1));
    }

    @Test
    public void nextmove_test_correct_placing_white() throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        Game myboard = new Game(13);
        myboard.nextMove_tests(false, "a4");
        assertEquals(1, myboard.board.get(3));
    }

}

