package org.example.app;

import javax.swing.*;
import java.awt.*;


public class QuentinGUI extends JPanel {
    private Game newGame = new Game();
    final int size = newGame.board.sideLength;
    private final int cellDimension;
    private final int offset;
    private Color boardColor = new Color(34, 139, 34); // Default background color of the board
    

    public QuentinGUI(int cell_dim, int offset) {
        this.cellDimension = cell_dim;
        this.offset = offset;
        setPreferredSize(new Dimension(size * cellDimension, size * cellDimension));
        setBackground(boardColor);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw grid
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        for (int i = 1; i <= size; i++) {
            g2d.drawLine(i * cellDimension + offset, cellDimension + offset, i * cellDimension + offset, size * cellDimension + offset); // Vertical lines
            g2d.drawLine(cellDimension + offset, i * cellDimension + offset, size * cellDimension + offset, i * cellDimension + offset); // Horizontal lines
        }
        
        // Borders
        g2d.setStroke(new BasicStroke(3f));
        //// Horizontal
        g2d.drawLine(cellDimension + offset, cellDimension + offset, size * cellDimension + offset, cellDimension + offset);
        g2d.drawLine(cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset); 
        //// Vertical 
        g2d.drawLine(cellDimension + offset, cellDimension + offset, cellDimension + offset, size * cellDimension + offset); 
        g2d.drawLine(size * cellDimension + offset, cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset);

        // Color players sides
        g2d.setStroke(new BasicStroke(10f));
        //// Black: Top and bottom
        g2d.drawLine(cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset, size * cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset);
        g2d.drawLine(cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, size * cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset); 
        //// White: Left and right
        g2d.setColor(Color.WHITE);
        g2d.drawLine((int) Math.ceil(0.4*cellDimension) + offset, cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset, size * cellDimension + offset);
        g2d.drawLine(size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, size * cellDimension + offset);    

        // Draw the pieces
        for (int i = 0 ; i < size*size ; i++) {
            int col = i % size;
            int row = i / size;
            int value = newGame.board.grid.get(i);
            // System.out.println("board(" + i + ") = \t" + value);
            if (value != -1) {
                System.out.println("I am coloring entry " + i);
                Color color = (value == 0) ? Color.BLACK : Color.WHITE;
                g2d.setColor(color);
                g2d.fillOval((col+1) * cellDimension - (int) Math.ceil(0.25*cellDimension) + offset, (row+1) * cellDimension - (int) Math.ceil(0.25*cellDimension) + offset, 
                (int) Math.ceil(0.5*cellDimension), (int) Math.ceil(0.5*cellDimension));
            }
        }
        
    }

    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("QUENTIN");
        QuentinGUI panel = new QuentinGUI(30, 30);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // while (true) {
        //     // Black
        //     panel.newGame.makeMove(panel.newGame.blackPlayer);
        //     panel.revalidate();
        //     panel.repaint();
        //     if (panel.newGame.isGameover()) 
        //         break;
            
        //     // White
        //     panel.newGame.makeMove(panel.newGame.whitePlayer);
        //     panel.revalidate();
        //     panel.repaint();
        //     if (panel.newGame.isGameover()) 
        //         break;
        // }        
    }
}

