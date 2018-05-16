package _55;


class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j >= 0 && dp[i - j] && nums[i - j] >= j) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{0}));
        System.out.println(new Solution().canJump(new int[]{2, 5, 0, 0}));
        System.out.println(new Solution().canJump(new int[]{1, 1, 1, 1}));
        System.out.println(new Solution().canJump(new int[]{2, 0}));
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
