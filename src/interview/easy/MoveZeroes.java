package interview.easy;

import java.util.Arrays;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right;

        // move left pointer to 0 position
        while (nums[left] != 0 && left < nums.length) {
            left++;
            if (left == nums.length)
                return;
        }

        right = left;
        while (left < nums.length && right < nums.length) {
            // move right pointer to non-0 position
            while (nums[right] == 0) {
                right++;
                if (right == nums.length)
                    return;
            }

            nums[left] = nums[right];
            nums[right] = 0;
            left++;
            right++;

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 0, 0};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
