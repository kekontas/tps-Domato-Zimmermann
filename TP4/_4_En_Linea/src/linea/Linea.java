package linea;
import java.util.ArrayList;
import java.util.List;

public class Linea {
    private List<List<Character>> board;
    int numRows;
    int numCols;
    private TurnosState currentPlayer;

    public Linea(int numRows, int numCols, char gameMode) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new ArrayList<>();
        this.currentPlayer = new JuegaNegro();

        for (int i = 0; i < numCols; i++) {
            List<Character> column = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                column.add('\0');
            }
            this.board.add(column);
        }

    }


    public boolean finished() {
        return checkWin() || isBoardFull();
    }
    public char isPlayerAt(int col, int row) {
        return board.get(col).get(row);
    }

    boolean checkWin() {
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
            throw new IllegalArgumentException("Invalid column: " + col);
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



}




