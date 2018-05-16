package _300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (i - j >= 0 && nums[i - j] < nums[i]) {
                    max = Math.max(max, dp[i - j]);
                }
            }

            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
