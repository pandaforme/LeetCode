package _34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int[] helper(int[] nums, int target, int start, int end) {
        if (start > end)
            return new int[]{-1, -1};

        int[] result = new int[2];

        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            int tmp = middle;
            while (tmp >= start && nums[tmp] == target)
                tmp--;

            result[0] = tmp + 1;

            tmp = middle;
            while (tmp <= end && nums[tmp] == target)
                tmp++;

            result[1] = tmp - 1;

            return result;

        }

        if (nums[middle] < target)
            return helper(nums, target, middle + 1, end);
        else
            return helper(nums, target, start, middle - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
