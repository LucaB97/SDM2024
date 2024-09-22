package org.example.endgame;

import org.example.app.Board;

public interface EndConditionChecker {
    
    public void getBoardConfiguration(Board currentBoard);
    boolean checkConditionBlack();
    boolean checkConditionWhite();
}
