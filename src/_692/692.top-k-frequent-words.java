package _692;

import java.util.*;

class Solution {
    // naive solution
    // time complexity: O(n) + O(n * log n)
    // space complexity: O(n) + O(k)
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//
//        return map.entrySet().stream().sorted((o1, o2) -> {
//            if (o1.getValue().equals(o2.getValue()))
//                return o1.getKey().compareTo(o2.getKey());
//            else
//                return o2.getValue().compareTo(o1.getValue());
//        }).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
//    }

    // using priority queue
    // time complexity: O(n) + O(n * log k)
    // space complexity: O(n) + O(k)
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//
//        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
//            if (o1.getValue().equals(o2.getValue()))
//                return o2.getKey().compareTo(o1.getKey());
//            else
//                return o1.getValue().compareTo(o2.getValue());
//        });
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            queue.offer(entry);
//            if (queue.size() > k)
//                queue.poll();
//        }
//
//        List<String> result = new ArrayList<>();
//        while (!queue.isEmpty()){
//            result.add(0, queue.poll().getKey());
//        }
//
//        return result;
//    }


    // using bucket sort
    // time complexity: O(n)
    // space complexity: O(n) + O(k)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String>[] bucket = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<>();

            bucket[entry.getValue()].add(entry.getKey());
        }

        List<String> result = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                bucket[i].sort(Comparator.naturalOrder());
                result.addAll(bucket[i]);
            }
        }

        return result.size() > k ? result.subList(0, k) : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(new Solution().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
