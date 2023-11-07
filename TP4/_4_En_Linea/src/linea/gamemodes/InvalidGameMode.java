package linea.gamemodes;

public class InvalidGameMode extends GameMode{
    @Override
    public boolean equalsType(char gameModeInput) {
        if (gameModeInput == 'A' || gameModeInput == 'B' || gameModeInput == 'C') {
            return false;
        }
        throw new IllegalArgumentException("Modo de juego invalido");
    }

    @Override
    public boolean checkWin(linea.Linea linea) {
        return false;
    }
}
