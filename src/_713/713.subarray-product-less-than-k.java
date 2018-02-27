package _713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;

        int left = 0;
        int right = 0;

        int tmp = 1;
        int result = 0;
        while (right < nums.length) {
            tmp *= nums[right];

            if (tmp >= k) {
                while (left <= right && tmp >= k) {
                    tmp /= nums[left];
                    left++;
                }
            }

            result += (right - left + 1);
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
