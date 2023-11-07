package linea.gamemodes;

public class GameModeB extends GameMode {
    @Override
    public boolean equalsType(char gameModeInput) {
        return gameModeInput == 'B';
    }
    @Override
    public boolean checkWin(linea.Linea linea) {
        return linea.checkDiagonalWin();
    }
}
