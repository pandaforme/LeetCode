package interview.medium;

import java.util.Comparator;
import java.util.stream.Stream;

public class LongestPalindromicSubstring {
    public String longestPalindromeDp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        if (s.length() == 0)
            return "";

        String max = String.valueOf(s.charAt(0));
        for (int d = 1; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                int j = i + d;

                if (s.charAt(i) == s.charAt(j)) {
                    // dp[i][j] depends on dp[i + 1][j - 1]

                    if (i + 1 > j - 1) {
                        dp[i][j] = true;
                        max = Stream.of(max, s.substring(i, j + 1)).max(Comparator.comparingInt(String::length)).orElse("");
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            max = Stream.of(max, s.substring(i, j + 1)).max(Comparator.comparingInt(String::length)).orElse("");
                        }
                    }
                }
            }
        }

        return max;
    }

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            final String odd = expand(s, i, i);
            final String even = expand(s, i, i + 1);

            max = Stream.of(odd, even, max).max(Comparator.comparingInt(String::length)).orElse("");
        }

        return max;
    }

    private String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp(""));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("abb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("bba"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("a"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("cbbd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeDp("abcda"));

        System.out.println(new LongestPalindromicSubstring().longestPalindrome(""));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bba"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }
}
