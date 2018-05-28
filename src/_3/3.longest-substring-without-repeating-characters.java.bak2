package _3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                if (map.get(s.charAt(i)) >= start) {
                    start = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i), i);
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
