package org.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class findDiagonalsTests {

    @Test
    public void findDiagonalsTopLeftTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(14)), myBoard.findDiagonals(0));
    }

    @Test
    public void findDiagonalsTopRightTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(24)), myBoard.findDiagonals(12));
    }

    @Test
    public void findDiagonalsBottomLeftTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(144)), myBoard.findDiagonals(156));
    }

    @Test
    public void findDiagonalsBottomRightTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(154)), myBoard.findDiagonals(168));
    }

    @Test
    public void findDiagonalsUpperEdgeTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(18,20)), myBoard.findDiagonals(6));
    }

    @Test
    public void findDiagonalsLowerEdgeTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(148,150)), myBoard.findDiagonals(162));
    }

    @Test
    public void findDiagonalsLeftEdgeTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(66,92)), myBoard.findDiagonals(78));
    }

    @Test
    public void findDiagonalsRightEdgeTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(76,102)), myBoard.findDiagonals(90));
    }

    @Test
    public void findDiagonalsBoardCenterTest() {
        Board myBoard = new Board(13);
        assertEquals(new ArrayList<>(Arrays.asList(70,72,96,98)), myBoard.findDiagonals(84));
    }

}

