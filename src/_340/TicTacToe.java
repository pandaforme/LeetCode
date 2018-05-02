package _340;

public class TicTacToe {
    private char[][] board;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new char[n][n];
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        switch (player) {
            case 1:
                board[row][col] = 'X';
                return isWin(row, col, 'X') ? 1 : 0;
            case 2:
                board[row][col] = 'O';
                return isWin(row, col, 'O') ? 2 : 0;
            default:
                return -1;
        }
    }

    private boolean isWin(int row, int col, char mark) {
        boolean isAll = true;

        // check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] != mark)
                isAll = false;
        }

        if (isAll)
            return true;

        // check column
        isAll = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != mark)
                isAll = false;
        }

        if (isAll)
            return true;

        // check diagonal row
        if (row == col) {
            isAll = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != mark)
                    isAll = false;
            }

            if (isAll)
                return true;
        }

        if (row + col == n - 1) {
            isAll = true;
            int tmp = n;
            for (int i = 0; i < n; i++) {
                if (board[i][--tmp] != mark)
                    isAll = false;
            }

            if (isAll)
                return true;
        }

        return false;
    }

    // brute force solution
//    private boolean isWin(int row, int col, char mark) {
//        // check horizontal row
//        for (int i = 0; i < board.length; i++) {
//            boolean isAll = true;
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] != mark)
//                    isAll = false;
//            }
//
//            if (isAll)
//                return true;
//        }
//
//        // check vertical column
//        for (int j = 0; j < board[0].length; j++) {
//            boolean isAll = true;
//            for (int i = 0; i < board.length; i++) {
//                if (board[i][j] != mark)
//                    isAll = false;
//            }
//
//            if (isAll)
//                return true;
//        }
//
//        // check diagonal row
//        boolean isAll = true;
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][i] != mark)
//                isAll = false;
//        }
//        if (isAll)
//            return true;
//
//
//        int j = board[0].length - 1;
//        isAll = true;
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][j] != mark)
//                isAll = false;
//            j--;
//        }
//        if (isAll)
//            return true;
//
//        return false;
//    }

    public static void main(String[] args) {
        final TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(ticTacToe.move(0, 0, 1));
        System.out.println(ticTacToe.move(0, 2, 2));
        System.out.println(ticTacToe.move(2, 2, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
        System.out.println(ticTacToe.move(2, 0, 1));
        System.out.println(ticTacToe.move(1, 0, 2));
        System.out.println(ticTacToe.move(2, 1, 1));
    }
}
