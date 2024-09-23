package org.example.endgame;


public class ConsoleEndGame extends EndGameDealer {

    @Override
    public void signalEndGame() {
        System.out.println((isWinnerBlack ? "BLACK" : "WHITE") + "wins");
    };

}
