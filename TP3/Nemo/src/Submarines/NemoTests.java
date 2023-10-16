package Submarines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class NemoTests {

public Direction EAST;
public Direction WEST;
public Direction NORTH;
public Direction SOUTH;

    @Test
    public void test00InitialConditionsAreZero() {
        Nemo nemo = new Nemo();
        assertEquals(0, nemo.getDepth());
        assertEquals(EAST, nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test01MoveWithNoParametersDoesNotMove() {
        Nemo nemo = new Nemo();
        nemo.comand("");
        assertEquals(0, nemo.getDepth());
        assertEquals(EAST, nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test02MovesDown() {
        Nemo nemo = new Nemo();
        nemo.comand("d");
        assertEquals(-1, nemo.getDepth());
    }

    @Test
    public void test03MovesUp() {
        Nemo nemo = new Nemo();
        nemo.comand("u");
        assertEquals(1, nemo.getDepth());
    }

    @Test
    public void test04MoveWithOneParameterMovesForward() {
        Nemo nemo = new Nemo();
        nemo.comand("f");
        assertEquals(0, nemo.getDepth());
        assertEquals(EAST, nemo.getDirection());
        assertEquals(1, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test05MoveWithOppositeParametersStaysTheSame() {
        Nemo nemo = new Nemo();
        nemo.comand("fllf");
        assertEquals(0, nemo.getDepth());
        assertEquals(WEST, nemo.getDirection());
        assertEquals(0, nemo.getX());
        assertEquals(0, nemo.getY());
    }

    @Test
    public void test06NemoThrowsCapsuleCorrectly() {
        Nemo nemo = new Nemo();
        nemo.comand("u");
        nemo.comand("m");
        assertTrue(nemo.CapsulaIsThrown);
    }
    @Test public void test07NemoCantShotCapsuleatAnyDepth() {
        Nemo nemo = new Nemo();
        assertEquals( Nemo.CantThrowCapsule,
                assertThrows( RuntimeException.class, () -> nemo.comand("m")).getMessage() );
    }
}
    /*@Test public void test0NSubmarineCantAscendMore() {
        Nemo nemo = new Nemo();
        assertEquals( Nemo.CantAscendMore,
                assertThrows( RuntimeException.class, () -> nemo.comand("uu")).getMessage() );
    }
*/
