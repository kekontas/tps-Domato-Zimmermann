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
    private GameController currentPlayer;
    GameMode gameMode;



    public Linea(int numRows, int numCols, char gameMode) {

        this.gameMode = GameMode.setGameMode(gameMode);
        this.currentPlayer = new JuegaRojo();
        if (numCols < 4 || numRows < 4) {
            throw new RuntimeException("Dimensiones invalidas, deben ser ambas mayores a 3");
        }
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = IntStream.range(0, this.numCols)
                .mapToObj(i -> IntStream.range(0, this.numRows)
                        .mapToObj(j -> emptyChar)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }



    public boolean finished() {
        if (checkWin()){
            System.out.println("Ganador: " + currentPlayer.swichPlayer().quienJuega());
        }

        return checkWin() || isBoardFull();
    }
    public char isPlayerAt(int row, int col) {
        if (isPlayerOutOfBounds(row -1, col-1)) {
            return emptyChar;
        }
        return board.get(col -1 ).get(row - 1);
    }

    public boolean isPlayerOutOfBounds( int row , int col) {
        return col < 0 || col >= numCols || row < 0 || row >= numRows;
    }


    boolean checkWin() {
        return gameMode.checkWin(this);
    }

    public boolean checkHorizontalWin() {
        return IntStream.range(0, numRows)
                .anyMatch(row ->
                        IntStream.range(0, numCols - 3)
                                .anyMatch(col ->
                                        board.get(col).get(row) != '\0' &&
                                        board.get(col).get(row) == board.get(col + 1).get(row) &&
                                        board.get(col).get(row) == board.get(col + 2).get(row) &&
                                        board.get(col).get(row) == board.get(col + 3).get(row)
                                )
                );
    }

    public boolean checkVerticalWin() {
        return IntStream.range(0, numRows - 3)
                .anyMatch(row ->
                        IntStream.range(0, numCols)
                                .anyMatch(col ->
                                        board.get(col).get(row) != '\0' &&
                                        board.get(col).get(row) == board.get(col).get(row + 1) &&
                                        board.get(col).get(row) == board.get(col).get(row + 2) &&
                                        board.get(col).get(row) == board.get(col).get(row + 3)
                                )
                );
    }


    public boolean checkDiagonalWin() {
        return IntStream.range(0, numRows - 3)
                       .anyMatch(row ->
                               IntStream.range(0, numCols - 3)
                                       .anyMatch(col ->
                                               board.get(col).get(row) != '\0' &&
                                               board.get(col).get(row) == board.get(col + 1).get(row + 1) &&
                                               board.get(col).get(row) == board.get(col + 2).get(row + 2) &&
                                               board.get(col).get(row) == board.get(col + 3).get(row + 3)
                                       ))
                        ||
               IntStream.range(0, numRows - 3)
                       .anyMatch(row -> IntStream.range(3, numCols)
                                       .anyMatch(col ->
                                               board.get(col).get(row) != '\0' &&
                                               board.get(col).get(row) == board.get(col - 1).get(row + 1) &&
                                               board.get(col).get(row) == board.get(col - 2).get(row + 2) &&
                                               board.get(col).get(row) == board.get(col - 3).get(row + 3)));


    }

    public void playRedAt(int col) {
        currentPlayer.juegaRojo(this, col);
    }
    public void playBlueAt(int col) {
        currentPlayer.juegaAzul(this, col);
    }

    void playAt(int col, GameController player) {
        if (col < 1 || col > numCols) {
            throw new IllegalArgumentException("Columna invalida, fuera de rango");
        }
        if (finished()){
            throw new IllegalArgumentException("El juego ya termino");
        }
        List<Character> column = board.get(col - 1);

        if (!column.contains('\0')) {
            throw new IllegalArgumentException("Column is full: " + col);
        }


        IntStream.range(0, numRows )
                .mapToObj(row -> numRows -1 - row)  // Iterate in reverse order
                .filter(row -> column.get(row) == '\0')
                .findFirst()
                .ifPresent(row -> {
                    column.set(row, player.quienJuega());
                    this.currentPlayer = player.swichPlayer();
                });
    }

    private boolean isBoardFull() {
        boolean isFull = IntStream.range(0, numCols)
                .noneMatch(col -> board.get(col).contains('\0'));

        if (isFull) {
            System.out.println("Tablero lleno");
        }

        return isFull;
    }

    public String show() {

        StringBuilder mostrar = new StringBuilder().append("\n");
        IntStream.iterate(0, row -> row + 1).limit(numRows)
                .forEach(row -> {
                    mostrar.append("||");
                    board.forEach(column -> mostrar.append(" ").append(selectChar(row, column)).append(" "));
                    mostrar.append("||\n");
                });
        mostrar.append("  ");
        IntStream.iterate(1, col -> col + 1).limit(numCols)
                .forEach(col -> mostrar.append(" ").append(col).append(" "));
        mostrar.append("  ");

        return mostrar.toString();
    }

    private Character selectChar(int row, List<Character> column) {
        if (column.get(row) == '\0') {
            return ' ';
        }
        return column.get(row);
    }


}




