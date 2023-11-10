package linea;

public class JuegaRojo extends GameController {
    public char quienJuega() {
        return 'B';
    }
    @Override
    public GameController swichPlayer() {
        return new JuegaAzul();

    }
    public static void JuegaRojo(Linea linea, int col) {
        linea.playAt(col, new JuegaRojo());
    }

}
