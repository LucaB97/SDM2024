package org.example.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isLocationAdjacentTests {

    // The point is NOT adjacent to the region
    @Test
    public void locationNotAdjacentTest() {
        
        Game myGame = new Game(5);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d1");
        myGame.board.grid.set(nextMove, 0);
        
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
        List<Integer> myRegion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(false, myGame.isLocationAdjacent(myRegion, 5));
    }

    // The point is adjacent to the region
    @Test
    public void locationAdjacentTest() {
        
        Game myGame = new Game(5);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);

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

        List<Integer> myRegion = new ArrayList<>(Arrays.asList(2,3,4));
        assertEquals(true, myGame.isLocationAdjacent(myRegion, 5));
    }

}