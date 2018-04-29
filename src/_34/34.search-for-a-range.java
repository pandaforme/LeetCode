package _34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return helper(0, nums.length - 1, nums, target);
    }

    private int[] helper(int start, int end, int[] nums, int target) {
        if (start > end)
            return new int[]{-1, -1};

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            int before = middle;
            while (before >= start && nums[before] == target) {
                before--;
            }

            int after = middle;
            while (after <= end && nums[after] == target) {
                after++;
            }

            before = (before + 1 < start) ? -1 : before + 1;
            after = (after - 1 > end) ? -1 : after - 1;
            return new int[]{before, after};
        }

        if (nums[middle] > target) {
            int tmp = middle;
            while (tmp >= start && nums[tmp] == nums[middle]) {
                tmp--;
            }
            return helper(start, tmp, nums, target);
        } else {
            int tmp = middle;
            while (tmp <= end && nums[tmp] == nums[middle]) {
                tmp++;
            }
            return helper(tmp, end, nums, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5}, 5)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 6, 7, 8, 8, 9, 9, 10, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 6, 7, 8, 8, 9, 9, 9, 10, 10}, 9)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 5, 5, 5, 5, 5, 6, 7, 8, 8, 9, 9, 9, 10, 10}, 5)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 5, 5, 5, 5, 5, 6, 7, 8, 8, 9, 9, 9, 10, 10}, 13)));
    }
}
