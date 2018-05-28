package _5;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = extend(s, i, i);
            String even = (i + 1 < s.length()) ? extend(s, i, i + 1) : "";

            if (odd.length() > max) {
                result = odd;
                max = odd.length();
            }

            if (even.length() > max) {
                result = even;
                max = even.length();
            }
        }

        return result;
    }

    private String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }

        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
