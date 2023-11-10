package linea;

public class JuegaRojo extends GameController {
    public char quienJuega() {
        return 'B';
    }
    @Override
    public GameController swichPlayer() {
        return new JuegaAzul();

    }

}
