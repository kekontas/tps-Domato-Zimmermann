package Submarines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class NemoTests {
    @Test
    public void test00InitialConditionsAreZeroAndEast() {
        Nemo nemo = new Nemo();
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }

    @Test
    public void test01aMoveWithNoParametersDoesNotMove() {
        Nemo nemo = newNemoWithCommands("");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }

    @Test
    public void test01bInvalidParametersAreIgnored() {
        Nemo nemo = newNemoWithCommands("DUFLRMx");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }

    @Test
    public void test02aCommandLChangesDirection() {
        Nemo nemo = newNemoWithCommands("l");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "north");
    }

    @Test
    public void test02bCommandRChangesDirection() {
        Nemo nemo = newNemoWithCommands("r");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "south");
    }
    @Test void test02bCommandRLDoesNotChangeDirection() {
        Nemo nemo = newNemoWithCommands("rl");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }
    @Test
    public void test03aMovesDown() {
        Nemo nemo = newNemoWithCommands("d");
        evaluateExpectedDirectionAndCoordinates(nemo, -1, 0, 0, "east");
    }

    @Test
    public void test03bCantBeAboveSurface() {
        Nemo nemo = newNemoWithCommands("du");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }

    @Test
    public void test04aMovesForwardWithoutChangeInDirection() {
        Nemo nemo = newNemoWithCommands("f");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 1, 0, "east");
    }
    @Test
    public void test04bMovesForwardWithChangeInDirection() {
        Nemo nemo = newNemoWithCommands("frf");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 1, -1, "south");
    }
    @Test
    public void test04cMovesForwardWithChangeInDirection() {
        Nemo nemo = newNemoWithCommands("flffrflf");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 2, 3, "north");
    }

    @Test
    public void test05NoChangeWhenMovingWithOppositeParameters() {
        Nemo nemo = newNemoWithCommands("fllf");
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "west");
    }

    @Test
    public void test06aNemoThrowsCapsuleCorrectlyAt0() {
        Nemo nemo = newNemoWithCommands("m");
        assertTrue(nemo.isCapsuleThrown());
        evaluateExpectedDirectionAndCoordinates(nemo, 0, 0, 0, "east");
    }

    @Test
    public void test06bNemoThrowsCapsuleCorrectlyAtNegative1() {
        Nemo nemo = newNemoWithCommands("dm");
        assertTrue(nemo.isCapsuleThrown());
        evaluateExpectedDirectionAndCoordinates(nemo, -1, 0, 0, "east");
    }

    @Test
    public void test07NemoCantThrowCapsuleAtAnyDepth() {
        Nemo nemo = new Nemo();
        assertEquals( Nemo.CantThrowCapsule,
                assertThrows( RuntimeException.class, () -> nemo.command("ddm")).getMessage() );
    }

    @Test
    public void test08aExtensiveParameterWork(){
        Nemo nemo = newNemoWithCommands("dflrufdddd");
        evaluateExpectedDirectionAndCoordinates(nemo, -4, 2, 0, "east");
        assertFalse(nemo.isCapsuleThrown());
    }
    @Test
    public void test08bExtensiveParameterWork(){
        Nemo nemo = newNemoWithCommands("dflrufflffrfrfrfdddduuum");
        evaluateExpectedDirectionAndCoordinates(nemo, -1, 3, 1, "west");
        assertTrue(nemo.isCapsuleThrown());
    }

    private Nemo newNemoWithCommands(String commands) {
        Nemo nemo = new Nemo();
        nemo.command(commands);
        return nemo;
    }
    private void evaluateExpectedDirectionAndCoordinates(Nemo nemo, int expectedDepth, int expectedX, int expectedY, String expectedDirection) {
        assertEquals(expectedDepth, nemo.getDepth());
        assertEquals(expectedX, nemo.getX());
        assertEquals(expectedY, nemo.getY());
        assertEquals(expectedDirection, nemo.getDirection());
    }
}
