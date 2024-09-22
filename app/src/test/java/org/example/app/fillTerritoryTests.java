package org.example.app;

import exceptions.*;
import org.example.input.ArgumentInputHandler;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class fillTerritoryTests {

    @Test
    public void fillTerritoryBlackMajorityTest() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);

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
        //region {b1,c1} -> {5,10} should be filled by black (0)
        assertEquals(Arrays.asList(0,0), myGame.fillTerritory(Arrays.asList(5,10),6));
    }


    @Test
    public void fillTerritoryWhiteMajorityTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);

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
        assertEquals(Arrays.asList(1,1), myGame.fillTerritory(Arrays.asList(5,10),11));
    }


    @Test
    public void fillTerritoryDrawBlackLastMoveTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);

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
        assertEquals(Arrays.asList(1,1), myGame.fillTerritory(Arrays.asList(5,10),6));
    }


    @Test
    public void fillTerritoryDrawWhiteLastMoveTest() throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        Game myGame = new Game(5, argHandler, null);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);

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
        assertEquals(Arrays.asList(0,0), myGame.fillTerritory(Arrays.asList(5,10),11));
    }

}
