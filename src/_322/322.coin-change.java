package _322;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        if (coins == null || coins.length == 0 || amount == 0)
            return 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }

            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        }

        return dp[amount] ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 7));
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
        System.out.println(new Solution().coinChange(new int[]{4}, 3));
        System.out.println(new Solution().coinChange(new int[]{3}, 6));
        System.out.println(new Solution().coinChange(new int[]{1}, 0));
    }
}
