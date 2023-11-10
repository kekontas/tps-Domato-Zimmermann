package linea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class Game_test {

    private Linea game;
    @BeforeEach
    public void setUp() {
        game = new Linea(4, 4, 'C');
    }
    @Test
    public void test00CantCreateBoardWithWrongDimension() {
        assertThrowsLike( () -> new Linea(4, 3, 'C'), "Dimensiones invalidas, deben ser ambas mayores a 3" );
    }
    @Test
    public void test00CantAcceptInvalidGameMode() {
        assertThrowsLike( () -> new Linea(4, 4, 'D'), "Modo de juego invalido, tienen que ser A, B o C" );
    }
    @Test
    public void test00ShowNewBoard() {
        String expectedBoard = "\n" +
                               "||            ||\n" +
                               "||            ||\n" +
                               "||            ||\n" +
                               "||            ||\n" +
                               "   0  1  2  3   ";
        assertEquals(expectedBoard, game.show());
    }

    @Test
    public void test01playRedAt() {

        game.playRedAt(3);
        assertEquals('R', game.isPlayerAt(3, 3));
    }
    @Test
    public void test02playBlancoAt() {

        game.playRedAt(3);
        game.playBlueAt(3);
        assertEquals('B', game.isPlayerAt(2, 3));
    }
    @Test
    public void test03RedCantPlay2InARow() {
        game.playRedAt(3);
        assertThrowsLike( () -> game.playRedAt(3), "No es el turno de las Rojas");
    }

    @Test
    public void test04BlueCantPlay2InARow() {
        game.playRedAt(3);
        game.playBlueAt(3);
        assertThrowsLike( () -> game.playBlueAt(3), "No es el turno de las azules");
    }
    @Test
    public void test05RedCantPlayOutOfBoard() {
        assertThrowsLike( () -> game.playRedAt(5), "Columna invalida, fuera de rango");
    }

    @Test
    public void test06BlueCantPlayOutOfBoard() {
        game.playRedAt(3);
        assertThrowsLike( () -> game.playBlueAt(5), "Columna invalida, fuera de rango");
    }
    @Test
    public void test07canWinvertical() {
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.checkWin());
    }
    @Test
    public void test08canWinHorizontal() {
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.checkWin());
    }
    @Test
    public void test09canWinDiagonal() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(0);
        game.playRedAt(3);
        assertTrue(game.checkWin());
    }
    @Test
    public void test10cantplayWhenGameIsFinished() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(0);
        game.playRedAt(3);
        assertTrue(game.checkWin());
        assertThrowsLike( () -> game.playBlueAt(0), "El juego ya termino" );
    }
    @Test
    public void test11canPlayWhenGameIsNotFinished() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        assertFalse(game.finished());
        game.playRedAt(3);
        assertTrue(game.isPlayerAt(2, 3) == 'R');
    }
    private void assertThrowsLike( Executable executable, String message ) {

        assertEquals( message,
                assertThrows( Exception.class, executable).getMessage() );
    }
}


