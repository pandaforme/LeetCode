package _152;

class Solution {
//    // brute force
//    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int w = nums.length; w >= 1; w--) {
//            for (int i = 0; i <= nums.length - w; i++) {
//                int tmp = nums[i];
//                for (int j = i + 1; j < i + w; j++) {
//                    tmp *= nums[j];
//                }
//                max = Math.max(tmp, max);
//            }
//        }
//
//        return max;
//    }

    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {
            int prod1 = max * num;
            int prod2 = min * num;
            max = Math.max(num, Math.max(prod1, prod2));
            min = Math.min(num, Math.min(prod1, prod2));
            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 7}));
        System.out.println(new Solution().maxProduct(new int[]{2}));
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4, -4}));
    }
}
