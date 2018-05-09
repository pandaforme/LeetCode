package _300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int index = Collections.binarySearch(list, num);
                if (index < 0)
                    list.set(-index - 1, num);
                else
                    list.set(index, num);
            }
        }

        return list.size();
    }
}
