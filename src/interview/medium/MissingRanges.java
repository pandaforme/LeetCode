package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
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
}
