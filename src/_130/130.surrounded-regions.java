package _130;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                fill(board, m, n, i, 0);

            if (board[i][n - 1] == 'O')
                fill(board, m, n, i, n - 1);
        }

        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O')
                fill(board, m, n, 0, i);

            if (board[m - 1][i] == 'O')
                fill(board, m, n, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }

    }

    private void fill(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;

        if (board[i][j] == 'O') {
            board[i][j] = '*';

            fill(board, m, n, i + 1, j);
            fill(board, m, n, i - 1, j);
            fill(board, m, n, i, j + 1);
            fill(board, m, n, i, j - 1);
        }
    }
}
