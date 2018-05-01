class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        if (coins.length == 0)
            return -1;

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0 || dp[i - coin] == -1)
                    continue;
                min = Math.min(dp[i - coin], min);
            }

            if (min == Integer.MAX_VALUE)
                continue;

            dp[i] = (min + 1);
        }

        return dp[amount];
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
