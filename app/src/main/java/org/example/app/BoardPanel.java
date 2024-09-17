package org.example.app;

import javax.swing.*;
import java.awt.*;
import exceptions.*;


public class BoardPanel extends JPanel {
    private final int size;
    private Quentin.Game new_game;
    private final int cell_dimension;
    private final int offset;
    private Color boardColor = new Color(34, 139, 34); // Default background color of the board
    

    public BoardPanel(int size, int cell_dim, int offset) {
        this.size = size;
        this.new_game = new Quentin.Game(size);
        this.cell_dimension = cell_dim;
        this.offset = offset;
        setPreferredSize(new Dimension(size * cell_dimension, size * cell_dimension));
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
            g2d.drawLine(i * cell_dimension + offset, cell_dimension + offset, i * cell_dimension + offset, size * cell_dimension + offset); // Vertical lines
            g2d.drawLine(cell_dimension + offset, i * cell_dimension + offset, size * cell_dimension + offset, i * cell_dimension + offset); // Horizontal lines
        }
        
        // Borders
        g2d.setStroke(new BasicStroke(3f));
        //// Horizontal
        g2d.drawLine(cell_dimension + offset, cell_dimension + offset, size * cell_dimension + offset, cell_dimension + offset);
        g2d.drawLine(cell_dimension + offset, size * cell_dimension + offset, size * cell_dimension + offset, size * cell_dimension + offset); 
        //// Vertical 
        g2d.drawLine(cell_dimension + offset, cell_dimension + offset, cell_dimension + offset, size * cell_dimension + offset); 
        g2d.drawLine(size * cell_dimension + offset, cell_dimension + offset, size * cell_dimension + offset, size * cell_dimension + offset);

        // Color players sides
        g2d.setStroke(new BasicStroke(10f));
        //// Black: Top and bottom
        g2d.drawLine(cell_dimension + offset, (int) Math.ceil(0.4*cell_dimension) + offset, size * cell_dimension + offset, (int) Math.ceil(0.4*cell_dimension) + offset);
        g2d.drawLine(cell_dimension + offset, size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + offset, size * cell_dimension + offset, size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + offset); 
        //// White: Left and right
        g2d.setColor(Color.WHITE);
        g2d.drawLine((int) Math.ceil(0.4*cell_dimension) + offset, cell_dimension + offset, (int) Math.ceil(0.4*cell_dimension) + offset, size * cell_dimension + offset);
        g2d.drawLine(size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + offset, cell_dimension + offset, size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + offset, size * cell_dimension + offset); 

        // Draw numbers on the top and bottom
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < size; i++) {
            g2d.drawString(String.valueOf(i+1), (i+1) * cell_dimension + offset, offset); // Bottom side
            g2d.drawString(String.valueOf(i+1), (i+1) * cell_dimension + offset, size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + (int) Math.ceil(1.5*offset)); // Top side
        }

        // Draw letters on the left and right
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < size; i++) {
            char letter = (char) ('A' + i);
            g2d.drawString(String.valueOf(letter), (int) Math.ceil(0.4*cell_dimension) + (int) Math.ceil(0.5*offset), (i+1) * cell_dimension + offset); // Left side
            g2d.drawString(String.valueOf(letter), size * cell_dimension + (int) Math.ceil(0.6*cell_dimension) + + (int) Math.ceil(1.5*offset), (i+1) * cell_dimension + offset); // Right side
        }        

        // Draw the pieces
        for (int i = 0 ; i < size*size ; i++) {
            int col = i % size;
            int row = i / size;
            int value = new_game.board.get(i);
            if (value != -1) {
                Color color = (value == 0) ? Color.BLACK : Color.WHITE;
                g2d.setColor(color);
                g2d.fillOval((col+1) * cell_dimension - (int) Math.ceil(0.25*cell_dimension) + offset, (row+1) * cell_dimension - (int) Math.ceil(0.25*cell_dimension) + offset, 
                (int) Math.ceil(0.5*cell_dimension), (int) Math.ceil(0.5*cell_dimension));
            }
        }
        
    }


    
    public static void main(String[] args) throws IncorrectFormatException, InvalidLocationException, OccupiedLocationException {
        
        int size = 13; // Example size
        JFrame frame = new JFrame("QUENTIN");
        BoardPanel panel = new BoardPanel(size, 30, 30);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        do {
            System.out.println("BLACK MOVES");
            panel.new_game.update_board(true);
            panel.repaint();
            if (!panel.new_game.gameover()) {
                System.out.println("WHITE MOVES");
                panel.new_game.update_board(false);
                panel.repaint();
            }
        } while (!panel.new_game.gameover());
        panel.new_game.update_board(false);
        
    }
}

