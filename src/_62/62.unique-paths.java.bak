package _62;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                int left = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                int up = (i - 1 >= 0) ? dp[i - 1][j] : 0;

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(1, 1));
        System.out.println(new Solution().uniquePaths(1, 5));
        System.out.println(new Solution().uniquePaths(5, 1));
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
    }

}
