package org.example.app;

import org.example.endgame.CompletePathCondition;
import org.example.endgame.EndConditionChecker;
import org.example.input.ArgumentInputHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class isWinningPathTests {

    @Test
    public void isWinningPathBlackFalseTest1() {
        
        System.out.println("isWinningPathBlackFalseTest1");
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 0);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(false, myGame.endConditionChecker.checkConditionBlack());
    }


    @Test
    public void isWinningPathBlackFalseTest2() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d5");
        myGame.board.grid.set(nextMove, 0);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(false, myGame.endConditionChecker.checkConditionBlack());
    }


    @Test
    public void isWinningPathBlackTrueTest() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 0);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "e4");
        myGame.board.grid.set(nextMove, 0);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(true, myGame.endConditionChecker.checkConditionBlack());
    }


    @Test
    public void isWinningPathWhiteFalseTest1() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 1);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(false, myGame.endConditionChecker.checkConditionWhite());
    }


    @Test
    public void isWinningPathWhiteFalseTest2() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "e4");
        myGame.board.grid.set(nextMove, 1);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(false, myGame.endConditionChecker.checkConditionWhite());
    }


    @Test
    public void isWinningPathWhiteTrueTest() {
        
        ArgumentInputHandler argHandler = new ArgumentInputHandler();
        EndConditionChecker endConditionChecker = new CompletePathCondition();
        Game myGame = new Game(5, argHandler, endConditionChecker);
        int nextMove;
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a1");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "a2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "b2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c2");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c3");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "c4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d4");
        myGame.board.grid.set(nextMove, 1);
        nextMove = myGame.inputHandler.getNextMove(myGame.board, "d5");
        myGame.board.grid.set(nextMove, 1);

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
        myGame.endConditionChecker.getBoardConfiguration(myGame.board);
        assertEquals(true, myGame.endConditionChecker.checkConditionWhite());
    }
}

