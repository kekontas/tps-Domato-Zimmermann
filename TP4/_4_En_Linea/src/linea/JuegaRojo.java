package linea;

public class JuegaRojo extends GameController {
    public JuegaRojo(){}
    public char quienJuega() {
        return 'R';
    }
    @Override
    public GameController swichPlayer() {
        return new JuegaAzul();

    }
    @Override
    public void juegaRojo(Linea linea, int col) {
        linea.playAt(col, new JuegaRojo());
    }
    @Override
    public void juegaAzul(Linea linea, int col){
       throw new RuntimeException("No es el turno de las azules");
    }

}
