package interview.easy;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        // check all columns
        for (int i = 0; i < 9; i++) {
            if (!check(board, i, 0, i + 1, 9))
                return false;
        }

        // check all rows
        for (int i = 0; i < 9; i++) {
            if (!check(board, 0, i, 9, i + 1))
                return false;
        }

        // check all cubes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check(board, i, j, i + 3, j + 3))
                    return false;
            }
        }

        return true;
    }

    private boolean check(char[][] board, int startRow, int startColumn, int endRow, int endColumn) {
        Set<Integer> set = new HashSet<>();

        for (int i = startRow; i < endRow; i++) {
            for (int j = startColumn; j < endColumn; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;

                if (set.contains(Character.getNumericValue(c)))
                    return false;
                else
                    set.add(Character.getNumericValue(c));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                new char[]{'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
