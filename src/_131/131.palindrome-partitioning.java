package _131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(String s, int start, List<String> current, List<List<String>> result) {
        if (s == null && s.isEmpty())
            return;

        if (!current.isEmpty() && start >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String part = s.substring(start, i);

            if (isPalindrome(part)) {
                current.add(part);
                helper(s, i, current, result);
                current.remove(current.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaa"));
    }
}
