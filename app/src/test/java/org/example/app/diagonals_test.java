package org.example.app;

import org.example.app.Quentin.Game;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class diagonals_test {

    @Test
    public void neighbours_test_topleft() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(14)), myboard.diagonals(0));
    }

    @Test
    public void neighbours_test_topright() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(24)), myboard.diagonals(12));
    }

    @Test
    public void neighbours_test_bottomleft() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(144)), myboard.diagonals(156));
    }

    @Test
    public void neighbours_test_bottomright() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(154)), myboard.diagonals(168));
    }

    @Test
    public void neighbours_test_upperedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(18,20)), myboard.diagonals(6));
    }

    @Test
    public void neighbours_test_loweredge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(148,150)), myboard.diagonals(162));
    }

    @Test
    public void neighbours_test_leftedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(66,92)), myboard.diagonals(78));
    }

    @Test
    public void neighbours_test_rightedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(76,102)), myboard.diagonals(90));
    }

    @Test
    public void neighbours_test_center() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(70,72,96,98)), myboard.diagonals(84));
    }

}

