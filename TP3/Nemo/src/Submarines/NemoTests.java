package Submarines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class NemoTests {
    @Test
    public void test00InitialConditionsAreZero() {
        Nemo nemo = new Nemo();
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test01MoveWithNoParametersDoesNotMove() {
        Nemo nemo = new Nemo();
        nemo.command("");
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test02MovesDown() {
        Nemo nemo = new Nemo();
        nemo.command("d");
        assertEquals(-1, nemo.getDepth());
    }

    @Test
    public void test03CantBeAboveSurface() {
        Nemo nemo = new Nemo();
        nemo.command("u");
        assertEquals(0, nemo.getDepth());
    }

    @Test
    public void test04MoveWithOneParameterMovesForward() {
        Nemo nemo = new Nemo();
        nemo.command("f");
        assertEquals(0, nemo.getDepth());
        assertEquals("east", nemo.getDirection());
        assertEquals(1, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test05MoveWithOppositeParametersStaysTheSame() {
        Nemo nemo = new Nemo();
        nemo.command("fllf");
        assertEquals(0, nemo.getDepth());
        assertEquals("west", nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test06NemoThrowsCapsuleCorrectly() {
        Nemo nemo = new Nemo();
        nemo.command("um");
        assertTrue(nemo.isCapsuleThrown());
    }
    @Test public void test07NemoCantThrowCapsuleAtAnyDepth() {
        Nemo nemo = new Nemo();
        assertEquals( Nemo.CantThrowCapsule,
                assertThrows( RuntimeException.class, () -> nemo.command("ddm")).getMessage() );
    }
}
