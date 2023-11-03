package linea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

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
    public void test01playNegroAt() {
        Linea game = new Linea(10, 10, 'c');
        game.playNegroAt(5);
        assertEquals('R', game.isPlayerAt(5, 9));
    }
    @Test
    public void test02playBlancoAt() {
        Linea game = new Linea(10, 10, 'c');
        game.playNegroAt(5);
        game.playBlancoAt(5);
        assertEquals('B', game.isPlayerAt(5, 8));
    }
    @Test
    public void test03RedCantPlay2InARow() {
        Linea game = new Linea(10, 10, 'c');
        game.playNegroAt(5);
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playNegroAt(5));
    }

    @Test
    public void test04BlueCantPlay2InARow() {
        Linea game = new Linea(10, 10, 'c');
        game.playNegroAt(5);
        game.playBlancoAt(5);
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playBlancoAt(5));
    }
    @Test
    public void test05RedCantPlayOutOfBoard() {
        Linea game = new Linea(10, 10, 'c');
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playNegroAt(10));
    }

    @Test
    public void test06BlueCantPlayOutOfBoard() {
        Linea game = new Linea(10, 10, 'c');
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playBlancoAt(10));
    }
    @Test
    public void test07canWinvertical() {
        Linea game = new Linea(10, 10, 'c');
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
        Linea game = new Linea(10, 10, 'c');
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
        Linea game = new Linea(10, 10, 'c');
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
        Linea game = new Linea(10, 10, 'c');
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
        assertThrows(IllegalArgumentException.class, (Executable) () -> game.playBlancoAt(5));
    }
    @Test
    public void test11canPlayWhenGameIsNotFinished() {
        Linea game = new Linea(10, 10, 'c');
        game.playNegroAt(0);
        game.playBlancoAt(1);
        game.playNegroAt(1);
        game.playBlancoAt(2);
        game.playNegroAt(2);
        game.playBlancoAt(3);
        assertFalse(game.finished());
        game.playNegroAt(8);
    }

}


