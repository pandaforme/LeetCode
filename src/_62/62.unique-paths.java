package _62;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;
        if (n == 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                int up = i - 1 < 0 ? 0 : dp[i - 1][j];
                int left = j - 1 < 0 ? 0 : dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }
}
