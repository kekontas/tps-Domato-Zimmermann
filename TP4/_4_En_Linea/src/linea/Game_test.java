package linea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.IntStream;

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
    public void test01playRedAt() {

        game.playRedAt(3);
        game.show();
        assertEquals('R', game.isPlayerAt(4, 3));
    }
    @Test
    public void test02playBlancoAt() {
        playChips(List.of(3,3));
        assertEquals('B', game.isPlayerAt(3, 3));
    }
    @Test
    public void test03RedCantPlay2InARow() {
        game.playRedAt(3);
        assertThrowsLike( () -> game.playRedAt(3), "No es el turno de las Rojas");
    }

    @Test
    public void test04BlueCantPlay2InARow() {
        playChips(List.of(3,3));
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
        playChips(List.of(1, 2 , 1 , 2, 1, 2, 1));
        assertTrue(game.checkWin());
    }
    @Test
    public void test08canWinHorizontal() {
        playChips(List.of(1, 1 , 2 , 2, 3, 3, 4));
        assertTrue(game.checkWin());
    }
    @Test
    public void test09canWinDiagonal() {
        playChips(List.of(1, 2 , 2 , 3, 3, 4, 3, 4, 4, 1, 4));
        assertTrue(game.checkWin());
    }
    @Test
    public void test10gameStopsWithFilledBoard(){
        playChips(List.of(1, 1, 1, 1, 3, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4));
        assertTrue(game.finished());


    }
    @Test
    public void test10cantplayWhenGameIsFinished() {
        playChips(List.of(1, 2 , 2 , 3, 3, 4, 3, 4, 4, 1, 4));
        assertTrue(game.checkWin());
        assertThrowsLike( () -> game.playBlueAt(1), "El juego ya termino" );
    }
    @Test
    public void test11canPlayWhenGameIsNotFinished() {
        playChips(List.of(1, 2, 2, 3, 3, 4));
        assertFalse(game.finished());
        game.playRedAt(4);
        assertTrue(game.isPlayerAt(3, 4) == 'R');
    }
    private void playChips(List<Integer> plays) {
        IntStream.range(0, plays.size())
                .forEach(i -> {
                    if (i % 2 == 0) {
                        game.playRedAt(plays.get(i));
                    } else {
                        game.playBlueAt(plays.get(i));
                    }
                });
    }
    private void assertThrowsLike( Executable executable, String message ) {

        assertEquals( message,
                assertThrows( Exception.class, executable).getMessage() );
    }
}


