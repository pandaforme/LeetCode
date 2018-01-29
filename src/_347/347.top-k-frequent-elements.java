package _347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<>();
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && result.size() < k; i--) {
            if (bucket[i] != null)
                result.addAll(bucket[i]);
        }

        return result.size() > k ? result.subList(0, k) : result;
    }
}
