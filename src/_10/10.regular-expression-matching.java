package _10;

class Solution {
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null)
//            return false;
//
//        if (p.isEmpty())
//            return s.isEmpty();
//
//        boolean firstMatch = (!s.isEmpty()) && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
//
//        if (p.length() >= 2 && p.charAt(1) == '*') {
//            boolean zero = isMatch(s, p.substring(2));
//            boolean more = firstMatch && isMatch(s.substring(1), p);
//
//            return zero || more;
//        } else {
//            return firstMatch && isMatch(s.substring(1), p.substring(1));
//        }
//    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        if (p.isEmpty())
            return s.isEmpty();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // s is empty and p is empty
        dp[s.length()][p.length()] = true;

        // s is empty and p is not empty
        for (int j = p.length() - 1; j >= 0; j--) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                dp[s.length()][j] = dp[s.length()][j + 2];
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    boolean zero = dp[i][j + 2];
                    boolean more = firstMatch && dp[i + 1][j];

                    dp[i][j] = zero || more;
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("ab", ".*"));
        System.out.println(new Solution().isMatch("aab", "c*a*b"));
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
    }
}
