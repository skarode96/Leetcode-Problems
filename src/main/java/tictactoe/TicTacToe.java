package tictactoe;

public class TicTacToe {

    private char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {
        this.board = new char[3][3];
        this.currentPlayerMark = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == '-') {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public boolean checkForWin() {
        return checkColumnsForWin() || checkRowsForWin() || checkDiagonalsForWin();
    }

    public boolean checkRowsForWin() {
        for (int i = 0; i < board.length; i++) {
            if(checkRowCol(board[i][0], board[i][1], board[i][1]))
                return true;
        }
        return false;
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return c1 == c2 && c2 == c3 && c1 != '-';
    }


    public boolean checkColumnsForWin() {
        for (int i = 0; i < board[0].length; i++) {
            if(checkRowCol(board[0][i], board[1][i], board[2][i]))
                return true;
        }
        return false;
    }


    public boolean checkDiagonalsForWin() {
        return checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    public void changePlayer() {
        if(this.currentPlayerMark == 'X') {
            this.currentPlayerMark = 'O';
        } else
            this.currentPlayerMark = 'X';
    }

    public boolean placeMark(char[][] board, int row, int col) {
        if( row >= 0 && row <3 && col >=0 && col <3) {
            if(board[row][col] == '-') {
                board[row][col] = currentPlayerMark;
                return true;
            }
        }
        return false;
    }
}
