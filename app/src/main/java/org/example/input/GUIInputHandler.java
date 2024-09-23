package org.example.input;

import org.example.app.QuentinGUI;
import org.example.board.Board;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUIInputHandler implements InputHandler {
    private QuentinGUI panel;
    private int clickedCell = -1;  // Default invalid value, updated when a cell is clicked

    public GUIInputHandler(QuentinGUI panel) {
        this.panel = panel;
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickedCell = getCellFromClick(e.getX(), e.getY()); // Get the clicked cell index
            }
        });
    }

    // This method will block until a valid move is clicked by the user
    @Override
    public int getNextMove(Board board, String move) {
        clickedCell = -1; // Reset click each time before waiting for a new move
        while (clickedCell == -1) {
            try {
                Thread.sleep(100); // Sleep and wait for a click
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return clickedCell; // Return the clicked cell as the move
    }

    // Calculate the clicked cell based on the board's centered position
    private int getCellFromClick(int x, int y) {
        // Get the starting coordinates of the board
        int gridStartX = panel.getWidth() / 2 - (panel.size * panel.cellDimension) / 2;
        int gridStartY = panel.getHeight() / 2 - (panel.size * panel.cellDimension) / 2;

        // Adjust for clicks outside the board
        if (x < gridStartX || x > gridStartX + panel.size * panel.cellDimension ||
            y < gridStartY || y > gridStartY + panel.size * panel.cellDimension) {
            return -1; // Click is outside the board
        }

        // Calculate row and column based on the click location
        int col = (x - gridStartX) / panel.cellDimension;
        int row = (y - gridStartY) / panel.cellDimension;

        // Return the corresponding cell index
        return row * panel.size + col;
    }
}
