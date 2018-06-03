package _279;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int k = 1;
            int min = Integer.MAX_VALUE;
            while (i - (k * k) >= 0) {
                min = Math.min(dp[i - (k * k)], min);
                k++;
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));
        System.out.println(new Solution().numSquares(0));
        System.out.println(new Solution().numSquares(1));
    }
}
