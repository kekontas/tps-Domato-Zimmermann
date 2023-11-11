package linea;

public abstract class GameController {
    public abstract char quienJuega();
    public abstract GameController swichPlayer();
    public abstract void  juegaRojo(Linea linea, int col);
    public abstract void juegaAzul(Linea linea, int col);

}
