package _238;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < result.length; i++) {
            if (i - 1 >= 0)
                p = p * nums[i - 1];

            result[i] = p;
        }

        p = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            if (i + 1 < result.length)
                p = p * nums[i + 1];

            result[i] = result[i] * p;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
