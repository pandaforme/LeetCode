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

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.size() - 1; result.size() < k; i--) {
            if (!bucket.get(i).isEmpty())
                result.addAll(bucket.get(i));
        }

        return result.size() > k ? result.subList(0, k) : result;
    }

    // time: O(n * klog k)
    // space: O(k)
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Integer, Integer>> maxQueue = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//        PriorityQueue<Map.Entry<Integer, Integer>> minQueue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (maxQueue.size() == k) {
//                if (entry.getValue() > minQueue.peek().getValue()) {
//                    maxQueue.remove(minQueue.poll());
//                } else {
//                    continue;
//                }
//            }
//
//            maxQueue.offer(entry);
//            minQueue.offer(entry);
//        }
//
//        List<Integer> result = new ArrayList<>();
//        while (!maxQueue.isEmpty()) {
//            result.add(maxQueue.poll().getKey());
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 5, 6}, 3));
    }
}
