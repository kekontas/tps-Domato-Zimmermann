package linea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class Game_test {

    private Linea game;
    @BeforeEach
    public void setUp() {
        game = new Linea(10, 10, 'C');
    }
    @Test
    public void test00CantCreateBoardWithWrongDimension() {
        assertThrowsLike( () -> new Linea(4, 3, 'C'), "Dimensiones invalidas, deben ser ambas mayores a 3" );
    }
    @Test
    public void test00CantAcceptInvalidGameMode() {
        assertThrowsLike( () -> new Linea(4, 4, 'D'), "Modo de juego invalido" );
    }
    @Test
    public void test00ShowNewBoard() {

        assertEquals("|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|\n" +
                "|\0|\0|\0|\0|\0|\0|\0|\0|\0|\0|", game.show());
    }

    @Test
    public void test01playNegroAt() {

        game.playNegroAt(5);
        assertEquals('R', game.isPlayerAt(5, 9));
    }
    @Test
    public void test02playBlancoAt() {

        game.playNegroAt(5);
        game.playBlancoAt(5);
        assertEquals('B', game.isPlayerAt(5, 8));
    }
    @Test
    public void test03RedCantPlay2InARow() {
        game.playNegroAt(5);
        assertThrowsLike( () -> game.playNegroAt(5), "No es el turno de las negras");
    }

    @Test
    public void test04BlueCantPlay2InARow() {
        game.playNegroAt(5);
        game.playBlancoAt(5);
        assertThrowsLike( () -> game.playBlancoAt(5), "No es el turno de las blancas");
    }
    @Test
    public void test05RedCantPlayOutOfBoard() {
        assertThrowsLike( () -> game.playNegroAt(10), "Columna invalida, fuera de rango");
    }

    @Test
    public void test06BlueCantPlayOutOfBoard() {
        game.playNegroAt(5);
        assertThrowsLike( () -> game.playBlancoAt(10), "Columna invalida, fuera de rango");
    }
    @Test
    public void test07canWinvertical() {
        game.playNegroAt(0);
        game.playBlancoAt(0);
        game.playNegroAt(1);
        game.playBlancoAt(1);
        game.playNegroAt(2);
        game.playBlancoAt(2);
        game.playNegroAt(3);
        assertTrue(game.checkWin());
    }
    @Test
    public void test08canWinHorizontal() {
        game.playNegroAt(0);
        game.playBlancoAt(0);
        game.playNegroAt(1);
        game.playBlancoAt(1);
        game.playNegroAt(2);
        game.playBlancoAt(2);
        game.playNegroAt(3);
        assertTrue(game.checkWin());
    }
    @Test
    public void test09canWinDiagonal() {
        game.playNegroAt(0);
        game.playBlancoAt(1);
        game.playNegroAt(1);
        game.playBlancoAt(2);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        game.playNegroAt(3);
        game.playBlancoAt(4);
        assertTrue(game.checkWin());
    }
    @Test
    public void test10cantplayWhenGameIsFinished() {
        game.playNegroAt(0);
        game.playBlancoAt(1);
        game.playNegroAt(1);
        game.playBlancoAt(2);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        game.playNegroAt(3);
        game.playBlancoAt(4);
        assertTrue(game.checkWin());
        assertThrowsLike( () -> game.playNegroAt(0), "El juego ya termino" );
    }
    @Test
    public void test11canPlayWhenGameIsNotFinished() {
        game.playNegroAt(0);
        game.playBlancoAt(1);
        game.playNegroAt(1);
        game.playBlancoAt(2);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        assertFalse(game.finished());
        game.playNegroAt(8);
    }
    private void assertThrowsLike( Executable executable, String message ) {

        assertEquals( message,
                assertThrows( Exception.class, executable).getMessage() );
    }
}


