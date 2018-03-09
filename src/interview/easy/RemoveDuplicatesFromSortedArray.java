package interview.easy;

import java.util.Arrays;

//Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//        Example:
//
//        Given nums = [1,1,2],
//
//        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//        It doesn't matter what you leave beyond the new length.

public class RemoveDuplicatesFromSortedArray {
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
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 1, 2, 2, 3, 3};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
