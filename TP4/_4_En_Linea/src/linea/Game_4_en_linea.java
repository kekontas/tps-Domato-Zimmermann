package linea;
import java.util.Scanner;
public class Game_4_en_linea {

    public static void main( String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println( "Dimensiones?");

        Linea game = new Linea( prompt( "Base? " ), prompt( "Altura? " ), 'C' );



        System.out.println( game.show() );



        while ( !game.finished() ) {

            game.playNegroAt( prompt( "Negras? " ) );

            System.out.println( game.show() );



            if ( !game.finished() ) {

                game.playBlancoAt( prompt( "Blancas? " ) );

                System.out.println( game.show() );

            }

        }



    }
    private static int prompt( String message ) {

        System.out.print( message );

        return Integer.parseInt( System.console().readLine() );

    }

}

