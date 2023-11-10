package linea.gamemodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class GameMode {
    GameMode foundGM;
    public static List<GameMode> gameModes = new ArrayList<>(Arrays.asList(new GameModeA(), new GameModeB(), new GameModeC()));
    public static GameMode setGameMode(char desiredGM){
        return gameModes.stream()
                .filter(gm -> gm.equalsType(desiredGM))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Modo de juego invalido, tienen que ser A, B o C"));
    }
    public abstract boolean equalsType(char gameModeInput);
    public abstract boolean checkWin(linea.Linea linea);


}
