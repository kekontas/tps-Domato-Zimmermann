package Submarines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class NemoTests {
    @Test public void test00InitialConditionsAreZero() {
        Nemo nemo = new Nemo();
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }
    @Test public void test01MoveWithNoParametersDoesNotMove() {
        Nemo nemo = new Nemo();
        nemo.move("");
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }
    @Test public void test02MovesDown(){
        Nemo nemo = new Nemo();
        nemo.move("d");
        assertEquals(-1, nemo.getDepth());
    }
    @Test public void test03MoveWithOneParameterMovesForward() {
        Nemo nemo = new Nemo();
        nemo.move("f");
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(1, nemo.getX());
        assertEquals(0, nemo.getY());
    }
    @Test public void test04MoveWithOppositeParametersStaysTheSame() {
        Nemo nemo = new Nemo();
        nemo.move("fllf");
        assertEquals(0, nemo.getDepth());
        assertEquals("west", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }
}
