package _348;

public class TicTacToe {
    private int n;
    private int[] rows;
    private int[] columns;
    private int diagonal;
    private int antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        columns = new int[n];
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
                if (row == col) {
                    diagonal++;
                }

                if ((row + col) == n - 1) {
                    antiDiagonal++;
                }

                rows[row]++;
                columns[col]++;

                if (rows[row] == n || columns[col] == n || antiDiagonal == n || diagonal == n)
                    return 1;
                return 0;
            case 2:
                if (row == col) {
                    diagonal--;
                }

                if ((row + col) == n - 1) {
                    antiDiagonal--;
                }

                rows[row]--;
                columns[col]--;

                if (rows[row] == -n || columns[col] == -n || antiDiagonal == -n || diagonal == -n)
                    return 2;
                return 0;
            default:
                return -1;
        }
    }

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
