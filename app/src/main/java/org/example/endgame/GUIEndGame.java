package org.example.endgame;

import javax.swing.*;
import java.awt.*;

public class GUIEndGame extends EndGameDealer {
    
    private final JPanel panel; // Now we use a JPanel instead of a JFrame
    
    public GUIEndGame(JPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void signalEndGame() {
        String winnerMessage = (isWinnerBlack ? "BLACK" : "WHITE") + " wins!";
        
        // Show the message using the JPanel as the parent
        JOptionPane.showMessageDialog(panel, winnerMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        
        // Get the parent window (likely a JFrame) and close it after 2 seconds
        Window window = SwingUtilities.getWindowAncestor(panel);
        if (window != null) {
            Timer timer = new Timer(2000, e -> window.dispose());
            timer.setRepeats(false); // Ensure the timer only triggers once
            timer.start();
        }
    }
}
