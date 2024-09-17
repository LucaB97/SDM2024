package org.example.app;

import org.example.app.Quentin.Game;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class neighbours_test {

    @Test
    public void neighbours_test_topleft() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(1,13)), myboard.neighbours(0));
    }

    @Test
    public void neighbours_test_topright() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(11,25)), myboard.neighbours(12));
    }

    @Test
    public void neighbours_test_bottomleft() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(143,157)), myboard.neighbours(156));
    }

    @Test
    public void neighbours_test_bottomright() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(155,167)), myboard.neighbours(168));
    }

    @Test
    public void neighbours_test_upperedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(5,7,19)), myboard.neighbours(6));
    }

    @Test
    public void neighbours_test_loweredge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(149,161,163)), myboard.neighbours(162));
    }

    @Test
    public void neighbours_test_leftedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(65,79,91)), myboard.neighbours(78));
    }

    @Test
    public void neighbours_test_rightedge() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(77,89,103)), myboard.neighbours(90));
    }

    @Test
    public void neighbours_test_center() {
        Game myboard = new Game(13);
        assertEquals(new ArrayList<>(Arrays.asList(71,83,85,97)), myboard.neighbours(84));
    }

}

