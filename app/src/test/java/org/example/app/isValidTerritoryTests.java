package org.example.app;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isValidTerritoryTests {

    @Test
    public void isValidTerritoryTestTopLeftFalseTest() {

        Game myGame = new Game(5);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c1");
        myGame.board.grid.set(nextMove, 1);
        
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
        assertEquals(false, myGame.isValidTerritory(Arrays.asList(0,5)));
    }


    @Test
    public void isValidTerritoryTestTopLeftTrueTest() {

        Game myGame = new Game(5);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b1");
        myGame.board.grid.set(nextMove, 0);    
        
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
        assertEquals(true, myGame.isValidTerritory(Arrays.asList(0)));
    }


    @Test
    public void isValidTerritoryTestRightEdgeTrueTest() {

        Game myGame = new Game(5);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a5");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d5");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 1);

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
        assertEquals(true, myGame.isValidTerritory(Arrays.asList(9,14)));
    }

}

