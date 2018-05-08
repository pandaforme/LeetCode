package _49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            List<Integer> vector = toVector(strs[i]);

            if (map.containsKey(vector)) {
                map.get(vector).add(strs[i]);
            } else {
                List<String> set = new ArrayList<>();
                set.add(strs[i]);
                map.put(vector, set);
            }
        }


        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String>> entry : map.entrySet()) {
            results.add(entry.getValue());
        }

        return results;
    }

    private List<Integer> toVector(String s) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            list.set(index, list.get(index) + 1);
        }

        return list;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new Solution().groupAnagrams(new String[]{"", ""}));
    }
}