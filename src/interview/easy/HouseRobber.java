package interview.easy;

import java.util.Arrays;

public class HouseRobber {

    // dp solution
    // dp[n] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length + 2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return Arrays.stream(dp).max().orElse(0);
    }

//    public int rob(int[] nums) {
//        return helper(0, nums.length - 1, nums);
//    }

//    // recursive solution
//    private int helper(int start, int end, int[] nums) {
//        if (start > end)
//            return 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = start; i <= end; i++) {
//            int remains = helper(i + 2, end, nums);
//            max = Math.max(max, nums[i] + remains);
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 3, 1, 3, 100}));
        System.out.println(new HouseRobber().rob(new int[]{1, 3, 1}));
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new HouseRobber().rob(new int[]{0, 0, 1}));
    }
}
