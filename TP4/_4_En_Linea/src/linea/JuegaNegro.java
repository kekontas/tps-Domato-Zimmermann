package linea;

public class JuegaNegro extends TurnosState{
    @Override
    public char quienJuega() {
        return 'R';
    }
    @Override
    public TurnosState swichPlayer() {
        return new JuegaBlanco();
    }
}
