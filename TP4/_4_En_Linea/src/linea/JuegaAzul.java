package linea;

public class JuegaAzul extends GameController {
    @Override
    public char quienJuega() {
        return 'R';
    }
    @Override
    public GameController swichPlayer() {
        return new JuegaRojo();
    }
    public static void JuegaAzul(Linea linea, int col){
        linea.playAt(col, new JuegaAzul());
    }
}
