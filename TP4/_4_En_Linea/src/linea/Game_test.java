package linea;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class Game_test {
    @Test
    public void test00CreatNewBoard() {
        Linea game = new Linea( 10, 10, 'C' );
        assertEquals( 10, game.numRows );
        assertEquals( 10, game.numCols );
    }
    @Test
    public void test01PlayRedAt() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playRedAt( 5 );
        assertEquals( 'C', game.isPlayerAt( 5, 9 ) );
    }
    @Test
    public void test02PlayBlueAt() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playBlueAt( 5 );
        assertEquals( 'B', game.isPlayerAt( 5, 9 ) );
    }
    @Test
    public void test03RedCantPlay2InARow() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playRedAt( 5 );
        assertThrows( RuntimeException.class, () -> game.playRedAt( 5 ) );
    }
    @Test
    public void test04BlueCantPlay2InARow() {
        Linea game = new Linea( 10, 10, 'C' );
        game.playBlueAt( 5 );
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 5 ) );

    }
    @Test
    public void test05RedCantPlayOutOfBoard() {
        Linea game = new Linea( 10, 10, 'C' );
        assertThrows( RuntimeException.class, () -> game.playRedAt( 10 ) );

    }
    @Test
    public void test06BlueCantPlayOutOfBoard() {
        Linea game = new Linea( 10, 10, 'C' );
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 10 ) );

    }
}
