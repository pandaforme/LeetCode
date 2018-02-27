package _209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            if (sum >= s) {
                result = Math.min(result, right - left);

                while (sum >= s) {
                    sum -= nums[left];
                    left++;
                    if (sum >= s)
                        result = Math.min(result, right - left);
                }
            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
