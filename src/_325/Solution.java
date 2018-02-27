package _325;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // key: sum
        // value: index
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                result = Math.max(result, i + 1);
            else if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(new Solution().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }
}
