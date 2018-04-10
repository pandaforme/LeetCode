package _221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length;

        int result = Integer.MIN_VALUE;
        int[][] dp = new int[height + 1][width + 1];
        // dp(i, j) represents the length of the square is filled with 1s
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i - 1, j - 1), dp(i - 1, j), dp(i, j - 1) } + 1
        // it is easy to understand this rule, if you draw a picture
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

    // brute solution
//    public int maximalSquare(char[][] matrix) {
//        int height = matrix.length;
//        if (height == 0) return 0;
//        int width = matrix[0].length;
//
//        int length = Math.min(height, width);
//
//        for (int l = length; l >= 1; l--) {
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    if (isAllOne(i, j, l, matrix)) {
//                        return l * l;
//                    }
//                }
//            }
//        }
//
//        return 0;
//    }

    private boolean isAllOne(int x, int y, int length, char[][] matrix) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (i >= matrix.length || j >= matrix[0].length)
                    return false;

                if (matrix[i][j] != '1')
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
    }
}
