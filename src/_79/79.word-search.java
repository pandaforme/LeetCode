package _79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0)
            return false;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, 0, i, j, m, n, new boolean[m][n])) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int current, int i, int j, int m, int n, boolean[][] visited) {
        if (current >= word.length())
            return true;

        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if (visited[i][j])
            return false;

        if (board[i][j] == word.charAt(current)) {
            visited[i][j] = true;

            boolean result = helper(board, word, current + 1, i + 1, j, m, n, visited) ||
                    helper(board, word, current + 1, i - 1, j, m, n, visited) ||
                    helper(board, word, current + 1, i, j + 1, m, n, visited) ||
                    helper(board, word, current + 1, i, j - 1, m, n, visited);

            visited[i][j] = false;

            return result;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                new char[]{'C', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'B', 'C', 'D'}
        }, "AAB"));
    }
}
