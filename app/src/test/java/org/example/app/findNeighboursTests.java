package org.example.app;

import org.example.app.Quentin.Game;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class findNeighboursTests {

    @Test
    public void findNeighboursTopLeftTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(1,13)), myBoard.findNeighbours(0));
    }

    @Test
    public void findNeighboursTopRightTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(11,25)), myBoard.findNeighbours(12));
    }

    @Test
    public void findNeighboursBottomLeftTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(143,157)), myBoard.findNeighbours(156));
    }

    @Test
    public void findNeighboursBottomRightTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(155,167)), myBoard.findNeighbours(168));
    }

    @Test
    public void findNeighboursUpperEdgeTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(5,7,19)), myBoard.findNeighbours(6));
    }

    @Test
    public void findNeighboursLowerEdgeTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(149,161,163)), myBoard.findNeighbours(162));
    }

    @Test
    public void findNeighboursLeftEdgeTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(65,79,91)), myBoard.findNeighbours(78));
    }

    @Test
    public void findNeighboursRightEdgeTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(77,89,103)), myBoard.findNeighbours(90));
    }

    @Test
    public void findNeighboursBoardCenterTest() {
        Game myBoard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(71,83,85,97)), myBoard.findNeighbours(84));
    }

}

