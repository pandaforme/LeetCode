package _419;

class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        if (rows == 0)
            return 0;
        int columns = board[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'X') {
                    if ((j - 1 < 0 || board[i][j - 1] == '.') && (i - 1 < 0 || board[i - 1][j] == '.'))
                        // I don't need to check board[i][j] isFirstElement
                        // because battleships can only be placed horizontally or vertically.
                        //if (isFirstElement(board, i, j))
                        count++;
                }
            }
        }

        return count;
    }

    private boolean isFirstElement(char[][] board, int i, int j) {
        int rows = board.length;
        int columns = board[0].length;

        if ((i + 1 >= rows || board[i + 1][j] == '.') && (j + 1 >= columns || board[i][j + 1] == '.'))
            return true;

        if (i + 1 < rows && j + 1 < columns && board[i + 1][j] == 'X' && board[i][j + 1] == 'X')
            return false;

        // N x 1
        if (i + 1 < rows && board[i + 1][j] == 'X') {
            while (i + 1 < rows && board[i + 1][j] != '.') {
                // right
                if (j + 1 < columns && board[i + 1][j + 1] == 'X')
                    return false;

                // left
                if (j - 1 >= 0 && board[i + 1][j - 1] == 'X')
                    return false;

                i++;
            }

            return true;
        }

        // 1 x N
        if (j + 1 < columns && board[i][j + 1] == 'X') {
            while (j + 1 < columns && board[i][j + 1] != '.') {
                // down
                if (i + 1 < rows && board[i + 1][j + 1] == 'X')
                    return false;

                // up
                if (i - 1 >= 0 && board[i - 1][j + 1] == 'X')
                    return false;

                j++;
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBattleships(new char[][]{
                new char[]{'.', '.', '.', '.', 'X'},
                new char[]{'.', '.', '.', '.', 'X'},
                new char[]{'X', 'X', 'X', 'X', 'X'},
                new char[]{'.', '.', '.', '.', 'X'}
        }));
    }

}
