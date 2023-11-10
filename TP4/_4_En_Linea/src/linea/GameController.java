package linea;

public abstract class GameController {
    public abstract char quienJuega();
    public abstract GameController swichPlayer();
    public static void  JuegaRojo(Linea linea, int col){
        new RuntimeException("No es el turno de las rojas");
    }
    public static void JuegaAzul(Linea linea, int col){
        new RuntimeException("No es el turno de las azules");
    }

}
