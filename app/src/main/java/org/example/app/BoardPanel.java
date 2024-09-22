// package org.example.app;

// import javax.swing.*;

// // import org.example.app.Quentin.Game;

// import java.awt.*;
// import java.util.List;
// import java.util.ArrayList;

// import exceptions.*;


// public class BoardPanel extends JPanel {
//     private final int size;
//     private Game newGame;
//     private final int cellDimension;
//     private final int offset;
//     private Color boardColor = new Color(34, 139, 34); // Default background color of the board
    

//     public BoardPanel(int size, int cell_dim, int offset) {
//         this.size = size;
//         this.newGame = new Game(size);
//         this.cellDimension = cell_dim;
//         this.offset = offset;
//         setPreferredSize(new Dimension(size * cellDimension, size * cellDimension));
//         setBackground(boardColor);
//     }



//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         Graphics2D g2d = (Graphics2D) g;

//         // Draw grid
//         g2d.setColor(Color.BLACK);
//         g2d.setStroke(new BasicStroke(1));
//         for (int i = 1; i <= size; i++) {
//             g2d.drawLine(i * cellDimension + offset, cellDimension + offset, i * cellDimension + offset, size * cellDimension + offset); // Vertical lines
//             g2d.drawLine(cellDimension + offset, i * cellDimension + offset, size * cellDimension + offset, i * cellDimension + offset); // Horizontal lines
//         }
        
//         // Borders
//         g2d.setStroke(new BasicStroke(3f));
//         //// Horizontal
//         g2d.drawLine(cellDimension + offset, cellDimension + offset, size * cellDimension + offset, cellDimension + offset);
//         g2d.drawLine(cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset); 
//         //// Vertical 
//         g2d.drawLine(cellDimension + offset, cellDimension + offset, cellDimension + offset, size * cellDimension + offset); 
//         g2d.drawLine(size * cellDimension + offset, cellDimension + offset, size * cellDimension + offset, size * cellDimension + offset);

//         // Color players sides
//         g2d.setStroke(new BasicStroke(10f));
//         //// Black: Top and bottom
//         g2d.drawLine(cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset, size * cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset);
//         g2d.drawLine(cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, size * cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset); 
//         //// White: Left and right
//         g2d.setColor(Color.WHITE);
//         g2d.drawLine((int) Math.ceil(0.4*cellDimension) + offset, cellDimension + offset, (int) Math.ceil(0.4*cellDimension) + offset, size * cellDimension + offset);
//         g2d.drawLine(size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + offset, size * cellDimension + offset); 

//         // Draw numbers on the top and bottom
//         g2d.setColor(Color.BLACK);
//         for (int i = 0; i < size; i++) {
//             g2d.drawString(String.valueOf(i+1), (i+1) * cellDimension + offset, offset); // Bottom side
//             g2d.drawString(String.valueOf(i+1), (i+1) * cellDimension + offset, size * cellDimension + (int) Math.ceil(0.6*cellDimension) + (int) Math.ceil(1.5*offset)); // Top side
//         }

//         // Draw letters on the left and right
//         g2d.setColor(Color.BLACK);
//         for (int i = 0; i < size; i++) {
//             char letter = (char) ('A' + i);
//             g2d.drawString(String.valueOf(letter), (int) Math.ceil(0.4*cellDimension) + (int) Math.ceil(0.5*offset), (i+1) * cellDimension + offset); // Left side
//             g2d.drawString(String.valueOf(letter), size * cellDimension + (int) Math.ceil(0.6*cellDimension) + + (int) Math.ceil(1.5*offset), (i+1) * cellDimension + offset); // Right side
//         }        

//         // Draw the pieces
//         for (int i = 0 ; i < size*size ; i++) {
//             int col = i % size;
//             int row = i / size;
//             int value = newGame.board.get(i);
//             System.out.println("board(" + i + ") = \t" + value);
//             if (value != -1) {
//                 Color color = (value == 0) ? Color.BLACK : Color.WHITE;
//                 g2d.setColor(color);
//                 g2d.fillOval((col+1) * cellDimension - (int) Math.ceil(0.25*cellDimension) + offset, (row+1) * cellDimension - (int) Math.ceil(0.25*cellDimension) + offset, 
//                 (int) Math.ceil(0.5*cellDimension), (int) Math.ceil(0.5*cellDimension));
//             }
//         }
        
//     }


    
//     public static void main(String[] args) throws IncorrectFormatException, OutOfRangeLocationException, OccupiedLocationException {
        
//         int size = 13; // Example size
//         JFrame frame = new JFrame("QUENTIN");
//         BoardPanel panel = new BoardPanel(size, 30, 30);
//         frame.add(panel);
//         frame.pack();
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);

//         int lastMove;
//         List<Integer> blackMoves = new ArrayList<>();
//         List<Integer> whiteMoves = new ArrayList<>();
        
//         // System.out.println(panel.newGame);
//         do {
//             // Black
//             blackMoves = panel.newGame.findAvailableMoves(true);
//             if (!blackMoves.isEmpty()) {
//                 System.out.println("BLACK MOVES");                
//                 while (!blackMoves.contains(lastMove = panel.newGame.getNextMove(true))) {System.out.println("Illegal move. Try again!\n");}
//                 panel.newGame.updateBoard(true, lastMove);
//                 panel.repaint();
//             } 

//             // White
//             if (!panel.newGame.isGameover()) {
//                 whiteMoves = panel.newGame.findAvailableMoves(false);
//                 if (!whiteMoves.isEmpty()) {
//                     System.out.println("WHITE MOVES");                
//                     while (!whiteMoves.contains(lastMove = panel.newGame.getNextMove(false))) {System.out.println("Illegal move. Try again!\n");}
//                     panel.newGame.updateBoard(false, lastMove);
//                     panel.repaint();
//                 }    
//             }
            
//         } while (!panel.newGame.isGameover());
        
//     }
// }

