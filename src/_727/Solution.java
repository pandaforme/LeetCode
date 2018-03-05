package _727;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;

        while (left < nums.length && right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                result++;
            }
        }

        if (left < nums.length && right >= nums.length) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 1, 2, 2, 3, 3};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
