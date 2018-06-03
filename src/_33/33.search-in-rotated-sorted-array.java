package _33;

class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;

        int middle = (start + end) / 2;

        if (nums[middle] == target)
            return middle;

        if (target < nums[middle]) {
            int i;
            for (i = middle; i >= start; i--) {
                if (i - 1 < start || nums[i - 1] > nums[i])
                    break;
            }

            if (nums[i] <= target) {
                return helper(nums, target, start, middle - 1);
            }

            if (i == start) {
                return helper(nums, target, middle + 1, end);
            } else {
                return helper(nums, target, start, i - 1);
            }
        } else {
            int i;
            for (i = middle; i <= end; i++) {
                if (i + 1 > end || nums[i] > nums[i + 1])
                    break;
            }

            if (target <= nums[i]) {
                return helper(nums, target, middle + 1, i);
            }

            if (i == end) {
                return helper(nums, target, start, middle - 1);
            } else {
                return helper(nums, target, i + 1, end);
            }
        }
    }
}
