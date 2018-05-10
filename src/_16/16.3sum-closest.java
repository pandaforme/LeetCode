package _16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int closestValue = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = nums[i] + twoSumClosest(nums, target - nums[i], i + 1, nums.length - 1);
            int diff = Math.abs(target - sum);

            if (diff < min) {
                min = diff;
                closestValue = sum;
            }
        }

        return closestValue;
    }

    private int twoSumClosest(int[] nums, int target, int start, int end) {
        int min = Integer.MAX_VALUE;
        int closestValue = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            int diff = Math.abs(target - sum);

            if (diff < min) {
                min = diff;
                closestValue = sum;
            }

            if (sum == target)
                return target;
            else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return closestValue;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(new Solution().threeSumClosest(new int[]{-2, -1, 0, 1, 2, 3, 4}, -4));
        System.out.println(new Solution().threeSumClosest(new int[]{0, 1, 1, 4, 4}, 10));
    }
}
