package _75;

import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;

        int i = 0;
        while (i <= twoPointer) {
            if (zeroPointer <= i && nums[i] == 0) {
                swap(nums, zeroPointer, i);
                zeroPointer++;
            } else if (twoPointer >= i && nums[i] == 2) {
                swap(nums, twoPointer, i);
                twoPointer--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
