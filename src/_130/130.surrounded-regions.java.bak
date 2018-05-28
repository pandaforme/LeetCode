package _130;

import java.util.Arrays;

class Solution {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            mark(board, i, 0);
            mark(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            mark(board, 0, i);
            mark(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if (board[i][j] == 'O')
            board[i][j] = '#';
        else
            return;

        mark(board, i - 1, j);
        mark(board, i + 1, j);
        mark(board, i, j - 1);
        mark(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}
        };

        new Solution().solve(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'O', 'X'}
        };

        new Solution().solve(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][]{
                new char[]{'O', 'O'},
                new char[]{'O', 'O'}
        };

        new Solution().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
