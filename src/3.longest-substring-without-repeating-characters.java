//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
//    }
//
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        int left = 0;
//        int max = 0;
//        for (int right = 0; right < s.length(); right++) {
//            // move left to the correct position
//            if (map.containsKey(s.charAt(right))) {
//                left = Math.max(left, map.get(s.charAt(right)) + 1);
//            }
//
//            map.put(s.charAt(right), right);
//
//            // store the length of substring without repeating characters
//            max = Math.max(max, right - left + 1);
//        }
//
//        return max;
//    }
//
////    public int lengthOfLongestSubstring(String s) {
////        int unique = findUnique(s);
////        if (unique < s.length())
////            return find(s, unique);
////        else
////            return s.length();
////    }
//
//    private int find(String s, int size) {
//        if (s == null || s.length() == 0)
//            return 0;
//        if (size == 1)
//            return 1;
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i <= s.length() - size; i++) {
//            String tmp = s.substring(i, i + size);
//            int unique = findUnique(tmp);
//            if (unique == size)
//                return tmp.length();
//            max = Math.max(unique, max);
//        }
//
//        return find(s, max);
//    }
//
//    private int findUnique(String s) {
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            set.add(s.charAt(i));
//        }
//
//        return set.size();
//    }
//}