package _163;

import java.util.ArrayList;
import java.util.List;

// an easy question, but the description is not clear. I need to handle a lot of overflow cases
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        long longLower = lower;
        long longUpper = upper;

        if (nums.length == 0) {
            addString(list, longLower - 1, longUpper + 1);
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                long diff = nums[0] - longLower;
                if (diff >= 1)
                    addString(list, longLower - 1, nums[0]);
            } else {
                long diff = (long) nums[i] - (long) nums[i - 1];
                if (diff > 1)
                    addString(list, nums[i - 1], nums[i]);
            }
        }

        long diff = longUpper - (long) nums[nums.length - 1];
        if (diff >= 1)
            addString(list, nums[nums.length - 1], longUpper + 1);

        return list;
    }

    private void addString(List<String> list, long start, long end) {
        if (start + 1 == end - 1)
            list.add(String.valueOf(start + 1));
        else
            list.add(String.format("%s->%s", start + 1, end - 1));
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
