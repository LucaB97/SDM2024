package org.example.endgame;

import org.example.board.Board;

public interface EndConditionChecker {
    
    public void getBoardConfiguration(Board currentBoard);
    boolean checkConditionBlack();
    boolean checkConditionWhite();
}
