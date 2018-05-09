package _153;

class Solution {
    public int findMin(int[] nums) {
        int pivot = nums.length / 2;

        while (pivot - 1 >= 0 && nums[pivot - 1] <= nums[pivot]) {
            pivot--;
        }


        if (pivot == 0) {
            int tmp = nums.length / 2;
            while (tmp + 1 < nums.length && nums[tmp] <= nums[tmp + 1]) {
                tmp++;
            }

            return (tmp + 1) >= nums.length ? nums[0] : Math.min(nums[0], nums[tmp + 1]);
        } else
            return Math.min(nums[0], nums[pivot]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{1}));
        System.out.println(new Solution().findMin(new int[]{1, 2, 3}));
        System.out.println(new Solution().findMin(new int[]{7, 8, 4, 5, 6}));
        System.out.println(new Solution().findMin(new int[]{1, 8, 4, 5, 6}));
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
