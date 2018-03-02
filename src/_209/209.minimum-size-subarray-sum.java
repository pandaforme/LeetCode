package _209;

import java.util.Arrays;

class Solution {
//    // O(n) solution
//    public int minSubArrayLen(int s, int[] nums) {
//        int result = Integer.MAX_VALUE;
//        int left = 0;
//        int right = 0;
//        int sum = 0;
//
//        while (right < nums.length) {
//            sum += nums[right];
//            right++;
//
//            if (sum >= s) {
//                result = Math.min(result, right - left);
//
//                while (sum >= s) {
//                    sum -= nums[left];
//                    left++;
//                    if (sum >= s)
//                        result = Math.min(result, right - left);
//                }
//            }
//
//        }
//
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }

    // O(nlogn) solution
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        int tmp = 0;
        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            sum[i] = tmp;
        }

        int result = Integer.MAX_VALUE;
        for (int from = -1; from < nums.length; from++) {
            int target = (from == -1 ? 0 : sum[from]) + s;

            int search = Arrays.binarySearch(sum, target);
            int to = search < 0 ? -search - 1 : search;
            if (to < sum.length) {
                result = Math.min(result, to - from);
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}
