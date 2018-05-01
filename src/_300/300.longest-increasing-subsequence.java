package _300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // a tricky solution...
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (result.isEmpty())
                result.add(num);

            if (num > result.get(result.size() - 1))
                result.add(num);

            int search = Collections.binarySearch(result, num);
            if (search >= 0)
                result.set(search, num);
            else {
                result.set(-search - 1, num);
            }
        }

        return result.size();
    }

//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//
//        int[] dp = new int[nums.length];
//
//        int result = 0;
//        for (int i = 0; i < dp.length; i++) {
//            int max = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] < nums[i])
//                    max = Math.max(max, dp[j]);
//            }
//
//            dp[i] = max + 1;
//            result = Math.max(result, dp[i]);
//        }
//
//        return result;
//    }


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{10}));
        System.out.println(new Solution().lengthOfLIS(new int[]{}));
    }
}
