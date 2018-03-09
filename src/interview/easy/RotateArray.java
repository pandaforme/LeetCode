package interview.easy;

import java.util.Arrays;

// Rotate an array of n elements to the right by k steps.
//
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int count = 0;

        for (int i = 0; count < nums.length; i++) {
            int previousValue = nums[i];
            int start = i;

            do {
                int next = (start + k) % nums.length;
                int tmp = nums[next];
                nums[next] = previousValue;
                previousValue = tmp;
                start = next;
                count++;
            } while (start != i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        new RotateArray().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
