package _36;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                if (!set.add(board[i][j]))
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;

                if (!set.add(board[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {

                HashSet<Character> set = new HashSet<>();
                for (int a = i; a < i + 3; a++) {
                    for (int b = j; b < j + 3; b++) {
                        if (board[a][b] == '.')
                            continue;
                        if (!set.add(board[a][b]))
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(new char[][]{
                new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
