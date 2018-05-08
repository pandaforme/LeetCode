package _49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<Integer> stats = getStats(str);

            if (map.containsKey(stats)) {
                map.get(stats).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(stats, tmp);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private List<Integer> getStats(String s) {
        List<Integer> stats = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            stats.add(0);
        }

        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            stats.set(key, stats.get(key) + 1);
        }

        return stats;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
