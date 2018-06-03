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

        if (target > nums[middle]) {
            int tmp = middle;
            while (tmp + 1 <= end && nums[tmp] < nums[tmp + 1]) {
                tmp++;
            }

            if (target <= nums[tmp])
                return helper(nums, target, middle + 1, tmp);
            else if (tmp != end)
                return helper(nums, target, tmp + 1, end);
            else
                return helper(nums, target, start, middle - 1);
        } else {
            int tmp = middle;
            while (tmp - 1 >= start && nums[tmp - 1] < nums[tmp]) {
                tmp--;
            }

            if (target >= nums[tmp])
                return helper(nums, target, tmp, middle - 1);
            else if (tmp != start)
                return helper(nums, target, start, tmp - 1);
            else
                return helper(nums, target, middle + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
