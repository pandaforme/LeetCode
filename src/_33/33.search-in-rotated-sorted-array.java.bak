package _33;

class Solution {
    public int search(int[] nums, int target) {
        return helper(0, nums.length - 1, nums, target);
    }

    private int helper(int start, int end, int[] nums, int target) {
        if (start > end)
            return -1;

        int middle = (start + end) / 2;

        if (nums[middle] == target)
            return middle;


        if (target < nums[middle]) {
            int tmp = middle;
            while (tmp - 1 >= start && nums[tmp - 1] <= nums[tmp]) {
                tmp--;
            }

            if (nums[tmp] <= target)
                return helper(tmp, middle - 1, nums, target);
            else if (tmp != start)
                return helper(start, tmp - 1, nums, target);
            else
                return helper(middle + 1, end, nums, target);
        } else {
            int tmp = middle;
            while (tmp + 1 <= end && nums[tmp] <= nums[tmp + 1]) {
                tmp++;
            }

            if (nums[tmp] >= target)
                return helper(middle + 1, tmp, nums, target);
            else if (tmp != end)
                return helper(tmp + 1, end, nums, target);
            else
                return helper(start, middle - 1, nums, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1}, 1));
        System.out.println(new Solution().search(new int[]{1}, 0));
        System.out.println(new Solution().search(new int[]{1, 3}, 2));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
