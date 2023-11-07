package linea.gamemodes;

public class GameModeA extends GameMode {
    @Override
    public boolean equalsType(char gameModeInput) {
        return gameModeInput == 'A';
    }
    @Override
    public boolean checkWin(linea.Linea linea) {
        return linea.checkHorizontalWin() || linea.checkVerticalWin();
    }
}
