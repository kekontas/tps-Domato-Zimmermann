package linea;

public class Linea {
    char[][] board;
    int numRows;
    int numCols;
    private char currentPlayer;

    public Linea(int numRows, int numCols, char startPlayer) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new char[numRows][numCols];
        this.currentPlayer = startPlayer;
    }
    public String show() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                sb.append(board[row][col]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    public boolean finished() {

        // Horizontal
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols - 3; col++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }

        // Vertical
        for (int row = 0; row < numRows - 3; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col] &&
                        board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }

        // Diagonal
        for (int row = 0; row < numRows - 3; row++) {
            for (int col = 0; col < numCols - 3; col++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] &&
                        board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        // Diagonal
        for (int row = 0; row < numRows - 3; row++) {
            for (int col = 3; col < numCols; col++) {
                if (board[row][col] != 0 &&
                        board[row][col] == board[row + 1][col - 1] &&
                        board[row][col] == board[row + 2][col - 2] &&
                        board[row][col] == board[row + 3][col - 3]) {
                    return true;
                }
            }
        }

        return false;
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

        if (board[0][col] != 0) {
            throw new IllegalArgumentException("Column is full: " + col);
        }

        for (int row = numRows - 1; row >= 0; row--) {
            if (board[row][col] == 0) {
                board[row][col] = player;
                switchPlayer();
                return;
            }
        }
    }

    public Boolean casilleroIsEmpty(int col, int row) {
        if (board[row][col] == 0) {
            return true;
        }
        return false;
    }
    public int isPlayerAt(int col, int row) {
        return board[row][col];
    }
    private void switchPlayer () {
        if (currentPlayer == 'R') {
            currentPlayer = 'B';
        } else {
            currentPlayer = 'R';
        }
    }
}



