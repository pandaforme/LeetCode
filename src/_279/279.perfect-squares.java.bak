package _279;

class Solution {
    public int numSquares(int n) {
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; (i - (j * j)) >= 0; j++) {
                min = Math.min(dp[i - (j * j)], min);
            }

            dp[i] = (min == Integer.MAX_VALUE) ? 0 : min + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
        System.out.println(new Solution().numSquares(2));
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));
    }
}
