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

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0; i--) {
            if (!buckets.get(i).isEmpty()) {
                list.addAll(buckets.get(i));
            }

            if (list.size() >= k)
                break;
        }

        return list.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
