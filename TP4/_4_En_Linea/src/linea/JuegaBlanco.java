package linea;

public class JuegaBlanco extends TurnosState{
    public char quienJuega() {
        return 'B';
    }
    @Override
    public TurnosState swichPlayer() {
        return new JuegaNegro();

    }

}
