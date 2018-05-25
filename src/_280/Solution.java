package _280;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i])
                    swap(nums, i - 1, i);
            } else {
                if (nums[i - 1] < nums[i])
                    swap(nums, i - 1, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 2, 2, 6};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 1};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 5, 2, 1, 6, 4};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
