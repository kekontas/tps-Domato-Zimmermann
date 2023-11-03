package linea;
import java.util.ArrayList;
import java.util.List;

public class Linea {
    private List<List<Character>> board;
    int numRows;
    int numCols;
    private char currentPlayer;

    public Linea(int numRows, int numCols, char gameMode) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new ArrayList<>();

        for (int i = 0; i < numCols; i++) {
            List<Character> column = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                column.add('\0'); // Inicializa con caracteres nulos
            }
            this.board.add(column);
        }

        if (gameMode == 'c') {
            // Decide quién comienza el juego en función del modo
            this.currentPlayer = 'R'; // Por ejemplo, 'R' para jugador rojo, 'B' para jugador azul
        } else {
            throw new IllegalArgumentException("Modo de juego no válido");
        }
    }


    public String show() {
        StringBuilder mostrar = new StringBuilder();
        for (int i = numRows -1; i >= 0; i--) {
            mostrar.append("|");
            for (int j = 0; j < numCols; j++) {
                if (board.get(j).size() > i) {
                    mostrar.append(board.get(j).get(i));
                } else {
                    mostrar.append(" ");
                }
                mostrar.append("|");
            }
            mostrar.append("\n");
        }

        mostrar.delete(mostrar.length() - 1, mostrar.length());

        return mostrar.toString();
}
    public boolean finished() {
        return checkWin() || isBoardFull();
    }

    private boolean checkWin() {
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
    }

    private boolean checkHorizontalWin() {
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

    private boolean checkVerticalWin() {
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

    private boolean checkDiagonalWin() {
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

    private boolean isBoardFull() {
        for (int col = 0; col < numCols; col++) {
            if (board.get(col).contains('\0')) {
                return false; // Todavía hay casillas vacías
            }
        }
        return true; // El tablero está lleno, empate
    }

    public void playRedAt(int col) {
        playAt(col, 'R');
    }

    public void playBlueAt(int col) {
        playAt(col, 'B');
    }

    private void playAt(int col, char player) {
        if (col < 0 || col >= numCols) {
            throw new IllegalArgumentException("Invalid column: " + col);
        }

        List<Character> column = board.get(col);

        if (!column.contains('\0')) {
            throw new IllegalArgumentException("Column is full: " + col);
        }

        for (int row = numRows - 1; row >= 0; row--) {
            if (column.get(row) == '\0') {
                column.set(row, player);
                switchPlayer();
                return;
            }
        }
    }

    public boolean casilleroIsEmpty(int col, int row) {
        return board.get(col).get(row) == '\0';
    }

    public char isPlayerAt(int col, int row) {
        return board.get(col).get(row);
    }

    private void switchPlayer() {
        if (currentPlayer == 'R') {
            currentPlayer = 'B';
        } else {
            currentPlayer = 'R';
        }
    }

    public char winner() {
        return currentPlayer;
    }
}




