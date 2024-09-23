package org.example.app;

import org.example.board.Computer;
import org.example.board.Human;
import org.example.endgame.CompletePathCondition;
import org.example.endgame.GUIEndGame;
import org.example.input.GUIInputHandler;
import java.awt.*;
import javax.swing.*;


public class QuentinGUI extends JPanel {
    protected Game newGame = new Game(13, new GUIInputHandler(this), new CompletePathCondition(), new GUIEndGame(this),
                                      new Human(true), new Computer(false));

    public final int size = newGame.board.sideLength;
    public int cellDimension;
    private Color boardColor = new Color(34, 139, 34); // Default background color of the board
    
    public QuentinGUI(int cell_dim) {
        this.cellDimension = cell_dim;
        setBackground(boardColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calculate the top-left position to center the board
        int boardWidth = (size-1) * cellDimension;
        int boardHeight = (size-1) * cellDimension;

        // Center the board in the JPanel
        int startX = (getWidth() - boardWidth) / 2;
        int startY = (getHeight() - boardHeight) / 2;

        // Draw grid
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        for (int i = 0; i < size; i++) {
            g2d.drawLine(startX + i * cellDimension, startY, startX + i * cellDimension, startY + boardHeight);  // Vertical lines
            g2d.drawLine(startX, startY + i * cellDimension, startX + boardWidth, startY + i * cellDimension);  // Horizontal lines
        }

        // Thicker borders
        g2d.setStroke(new BasicStroke(3f));
        //// Vertical
        g2d.drawLine(startX, startY, startX, startY + boardHeight);  
        g2d.drawLine(startX + (size-1) * cellDimension, startY, startX + (size-1) * cellDimension, startY + boardHeight); 
        //// Horizontal 
        g2d.drawLine(startX, startY, startX + boardWidth, startY);
        g2d.drawLine(startX, startY + (size-1) * cellDimension, startX + boardWidth, startY + (size-1) * cellDimension);
        
        // Colored players sides
        g2d.setStroke(new BasicStroke(10f));
        //// Black: Top and bottom 
        g2d.drawLine(startX, startY - (int) Math.ceil(0.5 * cellDimension), 
                     startX + boardWidth, startY - (int) Math.ceil(0.5 * cellDimension));
        g2d.drawLine(startX, startY + (size-1) * cellDimension + (int) Math.ceil(0.5 * cellDimension), 
                     startX + boardWidth, startY + (size-1) * cellDimension + (int) Math.ceil(0.5 * cellDimension));
        //// White: Left and right
        g2d.setColor(Color.WHITE);
        g2d.drawLine(startX - (int) Math.ceil(0.5 * cellDimension), startY, 
                     startX - (int) Math.ceil(0.5 * cellDimension), startY + boardHeight);  
        g2d.drawLine(startX + (size-1) * cellDimension + (int) Math.ceil(0.5 * cellDimension), startY, 
                               startX + (size-1) * cellDimension + (int) Math.ceil(0.5 * cellDimension), startY + boardHeight); 

        // Draw the pieces
        for (int i = 0; i < size * size; i++) {
            int col = i % size;
            int row = i / size;
            int value = newGame.board.grid.get(i);
            if (value != -1) {
                Color color = (value == 0) ? Color.BLACK : Color.WHITE;
                g2d.setColor(color);
                g2d.fillOval(startX + col * cellDimension - (int) Math.ceil(0.25 * cellDimension),
                             startY + row * cellDimension - (int) Math.ceil(0.25 * cellDimension),
                             (int) Math.ceil(0.5 * cellDimension),
                             (int) Math.ceil(0.5 * cellDimension));
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Set preferred size based on the board size to ensure proper window size
        return new Dimension(size * cellDimension + 2 * cellDimension, size * cellDimension + 2 * cellDimension);
    }


    public static void main(String[] args) {
        
        JFrame frame = new JFrame("QUENTIN");
        QuentinGUI panel = new QuentinGUI(30);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            try {
                Thread.sleep(100);
                panel.newGame.makeMove(panel.newGame.blackPlayer);
                panel.repaint();
                if (panel.newGame.isGameover()) 
                    break;

                Thread.sleep(100);
                panel.newGame.makeMove(panel.newGame.whitePlayer);
                panel.repaint();
                if (panel.newGame.isGameover()) 
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
