package linea.gamemodes;

public class GameModeC extends GameMode {
    @Override
    public boolean equalsType(char gameModeInput) {
        return gameModeInput == 'C';
    }
    @Override
    public boolean checkWin(linea.Linea linea) {
        return linea.checkHorizontalWin() || linea.checkVerticalWin() || linea.checkDiagonalWin();
    }
}
