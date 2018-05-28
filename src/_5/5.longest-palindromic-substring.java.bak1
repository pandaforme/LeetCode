package _5;

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int odd = helper(s, i, i);
            int even = helper(s, i, i + 1);

            max = Math.max(Math.max(odd, even), max);
            if (max == odd)
                result = s.substring(i - ((odd - 1) / 2), i - ((odd - 1) / 2) + odd);
            else if (max == even)
                result = s.substring(i - ((even - 2) / 2), i - ((even - 2) / 2) + even);
        }

        return result;
    }

    private int helper(String s, int a, int b) {
        while (a >= 0 && b < s.length()) {
            if (s.charAt(a) != s.charAt(b))
                return b - a - 1;
            a--;
            b++;
        }

        return b - a - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
