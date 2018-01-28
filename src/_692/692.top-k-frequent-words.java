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
//                return o1.getKey().compareTo(o2.getKey());
//            else
//                return o2.getValue().compareTo(o1.getValue());
//        });
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            queue.offer(entry);
//            if (queue.size() > k)
//                queue.poll();
//        }
//
//        return queue.stream().map(Map.Entry::getKey).collect(Collectors.toList());
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

                for (String s : bucket[i]) {
                    if (result.size() < k)
                        result.add(s);
                    else
                        return result;
                }
            }
        }
        return result;
    }
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//
//        sort(map, words, 0, words.length - 1, k);
//
//        return Arrays.asList(words).subList(0, k);
//    }
//
//    private void sort(Map<String, Integer> map, String[] words, int start, int end, int k) {
//        if (k <= 0)
//            return;
//        if (start > end)
//            return;
//
//        int pivotIndex = start + (end - start) / 2;
//
//        swap(words, pivotIndex, end);
//
//        int leftIndex = start;
//        for (int i = start; i < end; i++) {
//            if (map.get(words[i]) > map.get(words[pivotIndex])) {
//                swap(words, i, leftIndex);
//                ++leftIndex;
//            } else if (map.get(words[i]).equals(map.get(words[pivotIndex]))) {
//                if (words[i].compareTo(words[pivotIndex]) < 0) {
//                    swap(words, i, leftIndex);
//                    ++leftIndex;
//                }
//            }
//        }
//
//        swap(words, leftIndex, end);
//
//        if (pivotIndex - start + 1 == k) {
//            sort(map, words, start, pivotIndex - 1, k - 1);
//        } else if (pivotIndex - start + 1 < k) {
//            // left
//            sort(map, words, start, pivotIndex - 1, k - pivotIndex + start);
//            // right
//            sort(map, words, pivotIndex + 1, end, pivotIndex - start);
//        } else {
//            // left
//            sort(map, words, start, pivotIndex - 1, k);
//        }
//    }
//
//    private void swap(String[] s, int a, int b) {
//        String tmp = s[a];
//        s[a] = s[b];
//        s[b] = tmp;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(new Solution().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
