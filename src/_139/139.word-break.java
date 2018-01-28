//import java.util.*;
//
//class Solution {
////    public boolean wordBreak(String s, List<String> wordDict) {
////        Deque<String> deque = new ArrayDeque<>();
////        deque.offer(s);
////
////        while (!deque.isEmpty()) {
////            String tmp = deque.poll();
////
////            for (int i = 0; i < wordDict.size(); i++) {
////                String word = wordDict.get(i);
////                if (tmp.equals(word))
////                    return true;
////
////                if (tmp.startsWith(word)) {
////                    deque.offer(tmp.substring(word.length()));
////                }
////            }
////        }
////
////        return false;
////    }
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        // store index of s
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.offer(0);
//
//        // store visited index
//        Set<Integer> set = new HashSet<>();
//
//        while (!deque.isEmpty()) {
//            Integer index = deque.poll();
//            for (int i = index + 1; i <= s.length(); i++) {
//                if (set.contains(i))
//                    continue;
//
//                String tmp = s.substring(index, i);
//                if (wordDict.contains(tmp)) {
//                    if (i == s.length())
//                        return true;
//                    deque.offer(i);
//                    set.add(i);
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().
//                wordBreak("abcdefghix",
//                        Arrays.asList("abcde", "fghi", "fg", "hi", "x")));
////        System.out.println(new Solution().
////                wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
////                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
////
////        System.out.println(
////                new Solution().wordBreak(
////                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
////                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
//    }
//}