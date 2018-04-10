package _238;

import java.util.Arrays;

class Solution {

    // O(n^2)
//    public int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = 1;
//        }
//
//        int j;
//        for (int i = 0; i < nums.length; i++) {
//            j = (i + 1) % nums.length;
//            while (i != j) {
//                result[i] *= nums[j];
//                j = (j + 1) % nums.length;
//            }
//        }
//        return result;
//    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int tmp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }

//    public int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        result[0] = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            result[i] = nums[i - 1] * result[i - 1];
//        }
//
//        int tmp = 1;
//        for (int j = nums.length - 1; j >= 0; j--) {
//            if (j == nums.length - 1)
//                tmp = nums[j];
//            else {
//                result[j] *= tmp;
//                tmp *= nums[j];
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
