package _53;

class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 0;

        for (int num : nums) {
            max += num;
            if (max <= 0)
                max = 0;

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
