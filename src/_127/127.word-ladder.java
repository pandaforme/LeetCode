package _127;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0)
            return 0;
        if (endWord == null || endWord.length() == 0)
            return 0;
        if (wordList == null || wordList.size() == 0)
            return 0;

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int result = 0;
        while (!queue.isEmpty()) {
            Boolean isFind = false;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                for (int j = 0; j < poll.length(); j++) {
                    StringBuilder stringBuilder = new StringBuilder(poll);

                    for (char c = 'a'; c <= 'z'; c++) {
                        stringBuilder.setCharAt(j, c);

                        String s = stringBuilder.toString();
                        if (set.contains(s) && !s.equals(poll)) {
                            queue.offer(s);
                            set.remove(s);
                        }

                        if (s.equals(endWord))
                            isFind = true;
                    }
                }
            }

            if (queue.size() > 0)
                result++;

            if (isFind)
                break;
        }

        return result == 0 ? 0 : result + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
