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
}
