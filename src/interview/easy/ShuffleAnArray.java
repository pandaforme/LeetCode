package interview.easy;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // I think that I shouldn't use `shuffle` function to solve it
        // I need to implement it...

        Random random = new Random();
        int[] clone = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(i + 1);
            final int tmp = clone[i];
            clone[i] = clone[r];
            clone[r] = tmp;
        }

        return clone;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShuffleAnArray(new int[]{1, 2, 3}).shuffle()));
    }
}
