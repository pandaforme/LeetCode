package _238;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length + 1];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int tmp = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j == nums.length - 1)
                tmp = nums[j];
            else {
                result[j] *= tmp;
                tmp *= nums[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
