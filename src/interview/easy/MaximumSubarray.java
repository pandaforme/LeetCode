package interview.easy;

public class MaximumSubarray {
    // this question is a tricky one and you need to remember this algorithm to solve it efficiently
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println((new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6));
    }
}
