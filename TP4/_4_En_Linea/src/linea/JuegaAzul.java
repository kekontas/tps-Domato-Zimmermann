package linea;

public class JuegaAzul extends GameController {
    public JuegaAzul(){}
    @Override
    public char quienJuega() {
        return 'B';
    }
    @Override
    public GameController swichPlayer() {
        return new JuegaRojo();
    }
    @Override
    public void juegaAzul(Linea linea, int col){
        linea.playAt(col, new JuegaAzul());
    }
    @Override
    public void juegaRojo(Linea linea, int col){
        throw new RuntimeException("No es el turno de las Rojas");
    }
}
