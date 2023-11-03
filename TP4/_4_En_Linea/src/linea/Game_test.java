package linea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Game_test {
    @Test
    public void test00CreateNewBoard() {
        Linea game = new Linea(10, 10, 'c');
        assertEquals(10, game.numRows);
        assertEquals(10, game.numCols);
    }
    @Test
    public void test00ShowNewBoard() {
        Linea game = new Linea(10, 10, 'c');
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
    public void test01PlayRedAt() {
        Linea game = new Linea(10, 10, 'c');
        game.playRedAt(5);
        assertEquals('R', game.isPlayerAt(5, 9));
    }

    @Test
    public void test02PlayBlueAt() {
        Linea game = new Linea(10, 10, 'c');
        game.playBlueAt(5);
        assertEquals('B', game.isPlayerAt(5, 9));
    }

    @Test
    public void test03RedCantPlay2InARow() {
        Linea game = new Linea(10, 10, 'c');
        game.playRedAt(5);
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playRedAt(5));
    }

    @Test
    public void test04BlueCantPlay2InARow() {
        Linea game = new Linea(10, 10, 'c');
        game.playBlueAt(5);
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playBlueAt(5));
    }

    @Test
    public void test05RedCantPlayOutOfBoard() {
        Linea game = new Linea(10, 10, 'c');
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playRedAt(10));
    }

    @Test
    public void test06BlueCantPlayOutOfBoard() {
        Linea game = new Linea(10, 10, 'c');
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playBlueAt(10));
    }
}

   /* @Test
    // testea que un jugador puede ganar en horizontal
    public void test07RedWinHorizontal() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playRedAt( 0 );
        game.playRedAt( 1 );
        game.playRedAt( 2 );
        game.playRedAt( 3 );
        assertTrue( game.finished() );
        assertEquals( 'R', game.winner() );
    }
    @Test
    // testea que un jugador puede ganar en vertical
    public void test08RedWinVertical() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playRedAt( 0 );
        game.playRedAt( 0 );
        game.playRedAt( 0 );
        game.playRedAt( 0 );
        assertTrue( game.finished() );
        assertEquals( 'R', game.winner() );
    }
    @Test
    // testea que un jugador puede ganar en diagonal
    public void test09RedWinDiagonal() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playRedAt( 0 );
        game.playBlueAt( 1 );
        game.playRedAt( 1 );
        game.playBlueAt( 2 );
        game.playBlueAt( 2 );
        game.playRedAt( 2 );
        game.playBlueAt( 3 );
        game.playBlueAt( 3 );
        game.playBlueAt( 3 );
        game.playRedAt( 3 );
        assertTrue( game.finished() );
        assertEquals( 'R', game.winner() );
    }*/

