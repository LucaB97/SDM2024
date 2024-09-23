package org.example.endgame;

public abstract class EndGameDealer {
    
    public boolean isWinnerBlack;
    
    public void getWinner(boolean isBlackPlayer) {
        isWinnerBlack = isBlackPlayer;
    }

    public abstract void signalEndGame();

}
