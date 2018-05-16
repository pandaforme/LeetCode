package _64;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[j];
                int left = (j - 1 < 0) ? Integer.MAX_VALUE : dp[j - 1];
                int min = Math.min(up, left);
                dp[j] = grid[i][j] + min;
            }
        }

        return dp[n - 1];
    }
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        if (m == 0)
//            return 0;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//        dp[0][0] = grid[0][0];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0)
//                    continue;
//
//                int up = (i - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1][j];
//                int left = (j - 1 < 0) ? Integer.MAX_VALUE : dp[i][j - 1];
//                int min = Math.min(up, left);
//                dp[i][j] = grid[i][j] + min;
//            }
//        }
//
//        return dp[m - 1][n - 1];
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));

        System.out.println(new Solution().minPathSum(new int[][]{
                {1}}));
    }
}
