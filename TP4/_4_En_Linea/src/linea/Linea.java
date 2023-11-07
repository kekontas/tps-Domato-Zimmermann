package linea;
import linea.gamemodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Linea {
    private List<List<Character>> board;
    char emptyChar = '\0';
    int numRows;
    int numCols;
    private TurnosState currentPlayer;
    GameMode gameMode;
    public List<GameMode> gameModes = new ArrayList<>();


    public Linea(int numRows, int numCols, char gameMode) {

        setGameMode(gameMode);
        this.currentPlayer = new JuegaNegro();
        if (numCols < 4 || numRows < 4) {
            throw new IllegalArgumentException("Dimensiones invalidas, deben ser ambas mayores a 3");
        }
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = IntStream.range(0, this.numCols)
                .mapToObj(i -> IntStream.range(0, this.numRows)
                        .mapToObj(j -> emptyChar)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public void setGameMode(char gameModeInput) {
        gameModes.add(new GameModeA());
        gameModes.add(new GameModeB());
        gameModes.add(new GameModeC());
        gameModes.add(new InvalidGameMode());
        gameModes
                .stream()
                .filter(gm -> gm.equalsType(gameModeInput))
                .forEach(gm -> this.gameMode = gm);
    }

    public boolean finished() {
        return checkWin() || isBoardFull();
    }
    public char isPlayerAt(int col, int row) {
        return board.get(col).get(row);
    }

    boolean checkWin() {
        return gameMode.checkWin(this);
    }

    public boolean checkHorizontalWin() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= numCols - 4; col++) {
                char cell = board.get(col).get(row);
                if (cell != '\0' &&
                        cell == board.get(col + 1).get(row) &&
                        cell == board.get(col + 2).get(row) &&
                        cell == board.get(col + 3).get(row)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVerticalWin() {
        for (int row = 0; row <= numRows - 4; row++) {
            for (int col = 0; col < numCols; col++) {
                char cell = board.get(col).get(row);
                if (cell != '\0' &&
                        cell == board.get(col).get(row + 1) &&
                        cell == board.get(col).get(row + 2) &&
                        cell == board.get(col).get(row + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalWin() {
        for (int row = 0; row <= numRows - 4; row++) {
            for (int col = 0; col <= numCols - 4; col++) {
                char cell = board.get(col).get(row);
                if (cell != '\0' &&
                        cell == board.get(col + 1).get(row + 1) &&
                        cell == board.get(col + 2).get(row + 2) &&
                        cell == board.get(col + 3).get(row + 3)) {
                    return true;
                }
            }
        }

        for (int row = 0; row <= numRows - 4; row++) {
            for (int col = 3; col < numCols; col++) {
                char cell = board.get(col).get(row);
                if (cell != '\0' &&
                        cell == board.get(col - 1).get(row + 1) &&
                        cell == board.get(col - 2).get(row + 2) &&
                        cell == board.get(col - 3).get(row + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void playNegroAt(int col) {
        if (currentPlayer.quienJuega() == 'R')
            playAt(col, new JuegaNegro());
        else{
            throw new IllegalArgumentException("No es el turno de las negras");
        }

    }
    public void playBlancoAt(int col) {
        if (currentPlayer.quienJuega() == 'B')
            playAt(col, new JuegaBlanco());
        else {
            throw new IllegalArgumentException("No es el turno de las blancas");
        }
    }

    private void playAt(int col, TurnosState player) {
        if (col < 0 || col >= numCols) {
            throw new IllegalArgumentException("Columna invalida, fuera de rango");
        }
        if (finished()){
            throw new IllegalArgumentException("El juego ya termino");
        }
        List<Character> column = board.get(col);

        if (!column.contains('\0')) {
            throw new IllegalArgumentException("Column is full: " + col);
        }

        for (int row = numRows - 1; row >= 0; row--) {
            if (column.get(row) == '\0') {
                column.set(row, player.quienJuega());
                currentPlayer = player.swichPlayer();
                return;
            }
        }
    }

    private boolean isBoardFull() {
        for (int col = 0; col < numCols; col++) {
            if (board.get(col).contains('\0')) {
                return false;
            }
        }
        return true;
    }

    public String show() {

        StringBuilder mostrar = new StringBuilder();
        IntStream.iterate(0, row -> row + 1).limit(numRows)
                .forEach(row -> {
                    mostrar.append("|");
                    board.forEach(column -> mostrar.append("-").append(column.get(row)).append("-"));
                    mostrar.append("|\n|").append("---".repeat(numCols)).append("|\n");
                });


        return mostrar.toString();
    }



}




