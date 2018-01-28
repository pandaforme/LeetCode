package _763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
//    public List<Integer> partitionLabels(String S) {
//        if (S.length() == 0)
//            return new ArrayList<>();
//
//        List<Integer> result = new ArrayList<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(S);
//
//        while (!queue.isEmpty()) {
//            String e = queue.poll();
//            List<String> splits = split(e);
//
//            if (splits.size() == 1)
//                result.add(e.length());
//            else
//                queue.addAll(splits);
//        }
//
//        return result;
//    }
//
//    private List<String> split(String s) {
//        Set<Character> set = new HashSet<>();
//        List<String> result = new ArrayList<>();
//
//
//        for (int i = 1; i <= s.length(); i++) {
//            String s1 = s.substring(0, i);
//            result.add(s1);
//            for (int c = 0; c < s1.toCharArray().length; c++) {
//                set.add(s1.toCharArray()[c]);
//            }
//
//            if (i < s.length()) {
//                String s2 = s.substring(i);
//                result.add(s2);
//                for (int c = 0; c < s2.toCharArray().length; c++) {
//                    if (set.contains(s2.toCharArray()[c])) {
//                        result.clear();
//                        break;
//                    }
//                }
//            }
//
//            if (!result.isEmpty())
//                return result;
//        }
//
//        return result;
//    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.toCharArray().length; i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (!count.containsKey(S.charAt(i))) {
                count.put(S.charAt(i), map.get(S.charAt(i)));
            }

            count.put(S.charAt(i), count.get(S.charAt(i)) - 1);
            if ((count.get(S.charAt(i)) == 0)) {
                count.remove(S.charAt(i));
            }

            if (count.isEmpty()) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
