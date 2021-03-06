package _163;

import java.util.ArrayList;
import java.util.List;

// an easy question, but the description is not clear. I need to handle a lot of overflow cases
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long lowerl = Long.valueOf(lower);
        long upperl = Long.valueOf(upper);

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(getString(lowerl - 1, upperl + 1));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                long diff = Long.valueOf(nums[0]) - lowerl;
                if (diff >= 1)
                    result.add(getString(lowerl - 1, nums[0]));
            }

            if (i > 0) {
                long diff = Long.valueOf(nums[i]) - Long.valueOf(nums[i - 1]);
                if (diff > 1)
                    result.add(getString(nums[i - 1], nums[i]));
            }


            if (i == nums.length - 1) {
                long diff = upperl - Long.valueOf(nums[i]);
                if (diff >= 1)
                    result.add(getString(nums[i], upperl + 1));
            }

        }

        return result;
    }

    private String getString(long s, long e) {
        if (s + 1 == e - 1)
            return String.valueOf(s + 1);

        return String.format("%s->%s", s + 1, e - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMissingRanges(new int[]{}, -1, 5));
        System.out.println(new Solution().findMissingRanges(new int[]{-1}, -1, -1));
        System.out.println(new Solution().findMissingRanges(new int[]{-1}, -2, 0));
        System.out.println(new Solution().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new Solution().findMissingRanges(new int[]{-2147483648, 2147483647}, -2147483648, 2147483647));
        System.out.println(new Solution().findMissingRanges(new int[]{2147483647}, -2147483648, 2147483647));
    }
}
