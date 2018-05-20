package _289;

import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = getNeighbors(board, i, j);

                if (board[i][j] == 1 && (neighbors == 2 || neighbors == 3))
                    board[i][j] += 2;

                if (board[i][j] == 0 && neighbors == 3)
                    board[i][j] += 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int getNeighbors(int[][] board, int a, int b) {
        int count = 0;

        for (int i = a - 1; i <= a + 1; i++) {
            for (int j = b - 1; j <= b + 1; j++) {
                if (0 <= i && i < board.length && 0 <= j && j < board[0].length) {
                    if(i == a && j == b)
                        continue;
                    count += (board[i][j] & 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {new int[]{1}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));

        board = new int[][]{new int[]{1, 1}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));

        board = new int[][]{
                new int[]{1, 1},
                new int[]{1, 0}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
