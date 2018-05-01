package _300;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // brute force: v1
//    public int lengthOfLIS(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int tmp = helper(nums[i], i + 1, nums.length - 1, nums) + 1;
//            max = Math.max(max, tmp);
//        }
//
//        return max;
//    }
//
//    private Integer helper(int current, int start, int end, int[] nums) {
//        if (start > end) {
//            return 0;
//        }
//
//        int max = 0;
//        for (int i = start; i <= end; i++) {
//            if (nums[i] > current) {
//                max = Math.max(max, 1 + helper(nums[i], i, end, nums));
//            }
//        }
//
//        return max;
//    }

    // brute force: v2
//    public int lengthOfLIS(int[] nums) {
//        return helper(Integer.MIN_VALUE, 0, nums);
//    }
//
//    private Integer helper(int previous, int start, int[] nums) {
//        if (start >= nums.length) {
//            return 0;
//        }
//
//        int pickOne = 0;
//        if (nums[start] > previous)
//            pickOne = helper(nums[start], start + 1, nums) + 1;
//        int notPickOne = helper(previous, start + 1, nums);
//        return Math.max(pickOne, notPickOne);
//    }

    // brut force: v3
//    public int lengthOfLIS(int[] nums) {
//        return helper(new HashMap<>(), Integer.MIN_VALUE, 0, nums);
//    }
//
//    private Integer helper(Map<String, Integer> map, int previous, int start, int[] nums) {
//        if (start >= nums.length) {
//            return 0;
//        }
//
//        String key = String.format("%s%s", previous, start);
//        if (map.containsKey(key)) {
//            return map.get(key);
//        }
//
//        int pickOne = 0;
//        if (nums[start] > previous)
//            pickOne = helper(map, nums[start], start + 1, nums) + 1;
//        int notPickOne = helper(map, previous, start + 1, nums);
//        int max = Math.max(pickOne, notPickOne);
//        map.put(key, max);
//
//        return max;
//    }

    // dp[i]: the LIS which contains nums[i]
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//
//        int result = 1;
//        for (int i = 1; i < nums.length; i++) {
//
//            int max = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i])
//                    max = Math.max(dp[j], max);
//            }
//
//            dp[i] = max + 1;
//            result = Math.max(result, dp[i]);
//        }
//
//        return result;
//    }

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (dp.isEmpty() || dp.get(dp.size() - 1) < num)
                dp.add(num);
            else {
                int search = Collections.binarySearch(dp, num);
                int index = search < 0 ? -search - 1 : search;
                dp.set(index, num);
            }
        }
        System.out.println(dp);
        return dp.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{3, 4, 5, 6, 7, 1, 2}));
        System.out.println(new Solution().lengthOfLIS(new int[]{5, 19, 5, 81, 50, 28, 29, 1, 83, 23}) == 5);
        System.out.println(new Solution().lengthOfLIS(new int[]{1, 0, 2, 6, 3, 4, 5, 11, 12, 13}) == 8);
        System.out.println(new Solution().lengthOfLIS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}) == 6);
    }
}
