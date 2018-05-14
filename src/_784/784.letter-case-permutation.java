package _784;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        helper(S, 0, "", result);

        return result;
    }

    private void helper(String S, int start, String tmp, List<String> result) {
        if (start >= S.length()) {
            result.add(tmp);
            return;
        }

        helper(S, start + 1, tmp + S.charAt(start), result);

        if (Character.getType(S.charAt(start)) == Character.LOWERCASE_LETTER) {
            helper(S, start + 1, tmp + Character.toUpperCase(S.charAt(start)), result);
        } else if (Character.getType(S.charAt(start)) == Character.UPPERCASE_LETTER) {
            helper(S, start + 1, tmp + Character.toLowerCase(S.charAt(start)), result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
        System.out.println(new Solution().letterCasePermutation("3z4"));
        System.out.println(new Solution().letterCasePermutation("12345"));
    }
}
